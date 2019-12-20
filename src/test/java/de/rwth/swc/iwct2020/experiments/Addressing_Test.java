package de.rwth.swc.iwct2020.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static de.rwth.swc.iwct2020.experiments.models.Addressing_TestModel.*;
import static de.rwth.swc.iwct2020.experiments.util.ExperimentHelper.*;
import static de.rwth.swc.iwct2020.experiments.util.ExperimentHelper.runPerformance;

class Addressing_Test {

    @Test
    void testAddressing() {
        final InputParameterModel correctModel = buildModel_Addressing_Correct(0);
        final InputParameterModel incorrectModel = buildModel_Addressing_Incorrect(0);

        runExperiment("Addressing", correctModel, incorrectModel);
    }

    @Test
    void testAddressing_Repairs() {
        final InputParameterModel correctModel = buildModel_Addressing_Correct(0);
        final List<InputParameterModel> repairedModels = Arrays.asList(
                buildModel_Addressing_Repair1(0),
                buildModel_Addressing_Repair2(0)
        );

        runRepairExperiment("Addressing", correctModel, repairedModels);
    }

    @Disabled
    @Test
    void testPerformance() {
        final InputParameterModel model = buildModel_Addressing_Correct(1);

        runPerformance("Addressing", model);
    }

    @Disabled
    @Test
    void testPerformanceIncorrect() {
        final InputParameterModel model = buildModel_Addressing_Incorrect(1);

        runPerformance("Addressing (I)", model);
    }
}
