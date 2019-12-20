package de.rwth.swc.iwct2020.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static de.rwth.swc.iwct2020.experiments.models.Banking1_TestModel.*;
import static de.rwth.swc.iwct2020.experiments.util.ExperimentHelper.*;
import static de.rwth.swc.iwct2020.experiments.util.ExperimentHelper.runPerformance;

class Banking1_Test {

    @Test
    void testAddressing() {
        final InputParameterModel correctModel = buildModel_Banking1_Correct(0);
        final InputParameterModel incorrectModel = buildModel_Banking1_Incorrect(0);

        runExperiment("Banking-1", correctModel, incorrectModel);
    }

    @Test
    void testAddressing_Repairs() {
        final InputParameterModel correctModel = buildModel_Banking1_Correct(0);
        final List<InputParameterModel> repairedModels = Arrays.asList(
                buildModel_Banking1_Repair1(0),
                buildModel_Banking1_Repair2(0),
                buildModel_Banking1_Repair3(0),
                buildModel_Banking1_Repair4(0),
                buildModel_Banking1_Repair5(0),
                buildModel_Banking1_Repair6(0),
                buildModel_Banking1_Repair7(0),
                buildModel_Banking1_Repair8(0),
                buildModel_Banking1_Repair9(0),
                buildModel_Banking1_Repair10(0),
                buildModel_Banking1_Repair11(0),
                buildModel_Banking1_Repair12(0),
                buildModel_Banking1_Repair13(0),
                buildModel_Banking1_Repair14(0),
                buildModel_Banking1_Repair15(0),
                buildModel_Banking1_Repair16(0)
        );

        runRepairExperiment("Banking-1", correctModel, repairedModels);
    }

    @Disabled
    @Test
    void testPerformance() {
        final InputParameterModel model = buildModel_Banking1_Correct(1);

        runPerformance("Banking-1", model);
    }

    @Disabled
    @Test
    void testPerformanceIncorrect() {
        final InputParameterModel model = buildModel_Banking1_Incorrect(1);

        runPerformance("Banking-1 (I)", model);
    }
}
