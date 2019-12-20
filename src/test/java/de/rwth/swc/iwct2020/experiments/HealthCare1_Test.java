package de.rwth.swc.iwct2020.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static de.rwth.swc.iwct2020.experiments.models.HealthCare1_TestModel.*;
import static de.rwth.swc.iwct2020.experiments.util.ExperimentHelper.*;

class HealthCare1_Test {

    @Test
    void testAddressing() {
        final InputParameterModel correctModel = buildModel_HealthCare1_Correct(0);
        final InputParameterModel incorrectModel = buildModel_HealthCare1_Incorrect(0);

        runExperiment("HealthCare-1", correctModel, incorrectModel);
    }

    @Test
    void testAddressing_Repairs() {
        final InputParameterModel correctModel = buildModel_HealthCare1_Correct(0);
        final List<InputParameterModel> repairedModels = Arrays.asList(
                buildModel_HealthCare1_Repair1(0),
                buildModel_HealthCare1_Repair2(0),
                buildModel_HealthCare1_Repair3(0),
                buildModel_HealthCare1_Repair4(0)        );

        runRepairExperiment("HealthCare-1", correctModel, repairedModels);
    }

    @Disabled
    @Test
    void testPerformance() {
        final InputParameterModel model = buildModel_HealthCare1_Correct(1);

        runPerformance("HealthCare-1", model);
    }

    @Disabled
    @Test
    void testPerformanceIncorrect() {
        final InputParameterModel model = buildModel_HealthCare1_Incorrect(1);

        runPerformance("HealthCare-1 (I)", model);
    }
}
