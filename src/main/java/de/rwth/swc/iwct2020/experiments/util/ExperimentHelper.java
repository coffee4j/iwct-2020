package de.rwth.swc.iwct2020.experiments.util;

import de.rwth.swc.coffee4j.engine.TestModel;
import de.rwth.swc.coffee4j.engine.TupleList;
import de.rwth.swc.coffee4j.engine.conflict.ConflictDetectionConfiguration;
import de.rwth.swc.coffee4j.engine.constraint.ConstraintCheckerFactory;
import de.rwth.swc.coffee4j.engine.constraint.DiagnosticConstraintCheckerFactory;
import de.rwth.swc.coffee4j.engine.constraint.HardConstraintCheckerFactory;
import de.rwth.swc.coffee4j.engine.constraint.SoftConstraintCheckerFactory;
import de.rwth.swc.coffee4j.engine.generator.ipogneg.IpogNeg;
import de.rwth.swc.coffee4j.engine.manager.BasicCombinatorialTestManager;
import de.rwth.swc.coffee4j.engine.manager.CombinatorialTestConfiguration;
import de.rwth.swc.coffee4j.model.Combination;
import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.coffee4j.model.Parameter;
import de.rwth.swc.coffee4j.model.Value;
import de.rwth.swc.coffee4j.model.converter.IndexBasedModelConverter;
import de.rwth.swc.coffee4j.model.converter.ModelConverter;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static de.rwth.swc.iwct2020.experiments.util.InputParameterModelUtil.shuffle;

public class ExperimentHelper {

    private static int SEEDS = 30;
    private static int WARMUP = 50;
    private static int REPETITIONS = 50;

    public static void runPerformance(String name, InputParameterModel correctModel) {
        final double timeHCH = executePerformance(correctModel, new HardConstraintCheckerFactory());
        final double timeBSCH = executePerformance(correctModel, new SoftConstraintCheckerFactory());
        final double timeDSCH = executePerformance(correctModel, new DiagnosticConstraintCheckerFactory());

        System.out.print("Name | HCH | B-SCH | D-SCH ");
        System.out.println();
        System.out.println(name + " | " + timeHCH + " | " + timeBSCH + " | " + timeDSCH);
    }

    private static double executePerformance(InputParameterModel model, ConstraintCheckerFactory factory) {
        final CombinatorialTestConfiguration configuration = new CombinatorialTestConfiguration(
                null,
                new ConflictDetectionConfiguration(false, false, false, null, false, null),
                Collections.singletonList(new IpogNeg(factory)),
                null
        );
        final ModelConverter converter = new IndexBasedModelConverter(model);
        final TestModel testModel = converter.getConvertedModel();

        final BasicCombinatorialTestManager manager = new BasicCombinatorialTestManager(configuration, testModel);

        System.out.println("EXPERIMENT: begin warmup");

        for(int i = 0; i < WARMUP; i++) {
            manager.generateInitialTests();
        }

        System.out.println("EXPERIMENT: finish warmup");
        System.out.println("EXPERIMENT: begin execution");

        final long times[] = new long[REPETITIONS];

        for(int i = 0; i < REPETITIONS; i++) {
            final long begin = System.nanoTime();

            manager.generateInitialTests();

            final long end = System.nanoTime() - begin;

            times[i] = TimeUnit.MILLISECONDS.convert(end, TimeUnit.NANOSECONDS);
        }

        System.out.println("EXPERIMENT: finish execution");

        return Arrays.stream(times).average().orElse(Double.NaN);
    }

    public static void runExperiment(String name,
                                     InputParameterModel correctModel,
                                     InputParameterModel incorrectModel) {
        printHeader();
        runOriginal(name, correctModel);

        for(int i = 0; i < SEEDS; i++) {
            runSingleExperiment(name, correctModel, incorrectModel, i);
        }
    }

    private static void printHeader() {
        System.out.print("Name | Seed | Strategy | # InvTI | # NPIT | # RIT | # NS InvTI | ");
        System.out.println();
    }

    private static void runOriginal(String name, InputParameterModel correctModel) {
        final List<Combination> testSuiteOrig = generateTestSuite(correctModel, new HardConstraintCheckerFactory());

        System.out.println(name + " | 0 | Orig | " + testSuiteOrig.size() + " | 0 | 0 | 0 |");
    }

    private static void runSingleExperiment(String name,
                                            InputParameterModel correctModel,
                                            InputParameterModel incorrectModel,
                                            int seed) {
        final InputParameterModel correctModelShuffled = shuffle(correctModel, seed);
        final InputParameterModel incorrectModelShuffled = shuffle(incorrectModel, seed);

        final List<Combination> testSuiteHCH = generateTestSuite(incorrectModelShuffled, new HardConstraintCheckerFactory());
        final List<Combination> testSuiteBSCH = generateTestSuite(incorrectModelShuffled, new SoftConstraintCheckerFactory());
        final List<Combination> testSuiteDSCH = generateTestSuite(incorrectModelShuffled, new DiagnosticConstraintCheckerFactory());

        evaluateTestSuite(name + " | " + seed + " | HCH ", correctModelShuffled, testSuiteHCH);
        evaluateTestSuite(name + " | " + seed + " | BSCH", correctModelShuffled, testSuiteBSCH);
        evaluateTestSuite(name + " | " + seed + " | DSCH", correctModelShuffled, testSuiteDSCH);
    }

    public static void runRepairExperiment(String name,
                                           InputParameterModel correctModel,
                                           List<InputParameterModel> repairedModels) {
        printHeader();
        runOriginal(name, correctModel);

        for(int i = 0; i < repairedModels.size(); i++) {
            for (int j = 0; j < SEEDS; j++) {
                runSingleRepair(name + "(repair=" + i + ")", correctModel, repairedModels.get(i), j);
            }

            System.out.println();
        }
    }

    private static void runSingleRepair(String name,
                                        InputParameterModel correctModel,
                                        InputParameterModel incorrectModel,
                                        int seed) {
        final InputParameterModel correctModelShuffled = shuffle(correctModel, seed);
        final InputParameterModel incorrectModelShuffled = shuffle(incorrectModel, seed);

        final List<Combination> testSuiteHCH = generateTestSuite(incorrectModelShuffled, new HardConstraintCheckerFactory());

        evaluateTestSuite(name + " | " + seed + " | HCH ", correctModelShuffled, testSuiteHCH);
    }

    private static void evaluateTestSuite(String name, InputParameterModel correctModel, List<Combination> testSuite) {
        final List<Combination> expectedInvalidTuples = getExpectedInvalidTupleLists(correctModel);
        final long npit = countNotPresentInvalidTuples(expectedInvalidTuples, testSuite);
        final long rit = countRedundantInvalidTuples(expectedInvalidTuples, testSuite);
        final long nsit = countNotStrongInvalidTestInputs(expectedInvalidTuples, testSuite);

        System.out.print(name + " | ");
        System.out.print(testSuite.size() + " | ");
        System.out.print(npit + " | ");
        System.out.print(rit + " | ");
        System.out.print(nsit + " | ");
        System.out.println();
    }

    private static long countNotStrongInvalidTestInputs(List<Combination> expectedInvalidTuples, List<Combination> testSuite) {

        final List<Combination> nsitis = testSuite.stream()
                .filter(testInput -> expectedInvalidTuples.stream().filter(testInput::contains).count() > 1)
                .collect(Collectors.toList());

        if(nsitis.size() > 0) {
            //System.out.println("INFO: not strong invalid inputs found");
            //nsitis.forEach(System.out::println);
        }

        return nsitis.size();
    }

    private static long countRedundantInvalidTuples(List<Combination> expectedInvalidTuples, List<Combination> testSuite) {
        return expectedInvalidTuples.stream()
                .mapToLong(expectedInvalidTuple -> computeAppearancesOfInvalidTuple(expectedInvalidTuple, testSuite))
                .filter(count -> count > 1)
                .count();
    }

    private static long computeAppearancesOfInvalidTuple(Combination expectedInvalidTuple, List<Combination> testSuite) {
        final List<Combination> testInputs = testSuite.stream()
                .filter(testInput -> testInput.contains(expectedInvalidTuple))
                .collect(Collectors.toList());

        final long count = testInputs.size();

        if(count > 1) {
            //System.out.println("INFO: redundant invalid tuple " + expectedInvalidTuple);
            //testInputs.forEach(System.out::println);
        }

        return count;
    }

    private static long countNotPresentInvalidTuples(List<Combination> expectedInvalidTuples, List<Combination> testSuite) {
        return expectedInvalidTuples.stream()
                .filter(expectedInvalidTuple ->
                        isInvalidTupleNotPresent(expectedInvalidTuple, testSuite))
                .count();
    }

    private static boolean isInvalidTupleNotPresent(Combination invalidTuple, List<Combination> testSuite) {
        if(!isInvalidTuplePresent(invalidTuple, testSuite)) {
            //System.out.println("INFO: not present invalid tuple " + invalidTuple);

            return true;
        }

        return false;
    }

    private static boolean isInvalidTuplePresent(Combination invalidTuple, List<Combination> testSuite) {
        return testSuite.stream()
                .anyMatch(testInput -> coversInvalidTuple(invalidTuple, testInput));
    }

    private static boolean coversInvalidTuple(Combination invalidTuple, Combination testInput) {
        return testInput.contains(invalidTuple);
    }

    private static List<Combination> getExpectedInvalidTupleLists(InputParameterModel correctModel) {
        final ModelConverter converter = new IndexBasedModelConverter(correctModel);
        final TestModel testModel = converter.getConvertedModel();

        return testModel.getErrorTupleLists().stream()
                .flatMap(errorTupleList -> convertInvalidTupleListToCombinations(converter, errorTupleList))
                .collect(Collectors.toList());
    }

    private static Stream<Combination> convertInvalidTupleListToCombinations(ModelConverter converter, TupleList invalidTupleList) {
        return invalidTupleList.getTuples().stream()
                .map(invalidTuple -> convertInvalidTupleToCombination(converter, invalidTupleList.getInvolvedParameters(), invalidTuple))
                ;
    }

    private static Combination convertInvalidTupleToCombination(ModelConverter converter, int[] involvedParameters, int[] invalidTuple) {
        final Map<Parameter, Value> parameterValueMap = new HashMap<>();

        for(int i = 0; i < involvedParameters.length; i++) {
            final int parameter = involvedParameters[i];
            final int value = invalidTuple[i];

            parameterValueMap.put(converter.convertParameter(parameter),
                    converter.convertValue(parameter, value));
        }

        return new Combination(parameterValueMap);
    }

    private static List<Combination> generateTestSuite(InputParameterModel ipm, ConstraintCheckerFactory factory) {
        final CombinatorialTestConfiguration configuration = new CombinatorialTestConfiguration(
                null,
                new ConflictDetectionConfiguration(false, false, false, null, false, null),
                Collections.singletonList(new IpogNeg(factory)),
                null
        );
        final ModelConverter converter = new IndexBasedModelConverter(ipm);
        final TestModel testModel = converter.getConvertedModel();

        final BasicCombinatorialTestManager manager = new BasicCombinatorialTestManager(configuration, testModel);
        final List<int[]> initialTests = manager.generateInitialTests();

        return initialTests.stream()
                .map(converter::convertCombination)
                .collect(Collectors.toList());
    }
}
