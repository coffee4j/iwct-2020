package de.rwth.swc.iwct2020.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static de.rwth.swc.iwct2020.experiments.models.HealthCare2_TestModel.*;
import static de.rwth.swc.iwct2020.experiments.util.ExperimentHelper.*;

class HealthCare2_Test {

    @Test
    void testAddressing() {
        final InputParameterModel correctModel = buildModel_HealthCare2_Correct(0);
        final InputParameterModel incorrectModel = buildModel_HealthCare2_Incorrect(0);

        runExperiment("HealthCare-2", correctModel, incorrectModel);
    }

    @Test
    void testAddressing_Repairs() {
        final InputParameterModel correctModel = buildModel_HealthCare2_Correct(0);
        final List<InputParameterModel> repairedModels = Arrays.asList(
                buildModel_HealthCare2_Repair1(0),
                buildModel_HealthCare2_Repair2(0),
                buildModel_HealthCare2_Repair3(0),
                buildModel_HealthCare2_Repair4(0),
                buildModel_HealthCare2_Repair5(0),
                buildModel_HealthCare2_Repair6(0),
                buildModel_HealthCare2_Repair7(0),
                buildModel_HealthCare2_Repair8(0)
        );

        runRepairExperiment("HealthCare-2", correctModel, repairedModels);
    }

    @Disabled
    @Test
    void testPerformance() {
        final InputParameterModel model = buildModel_HealthCare2_Correct(1);

        runPerformance("HealthCare-2", model);
    }

    @Disabled
    @Test
    void testPerformanceIncorrect() {
        final InputParameterModel model = buildModel_HealthCare2_Incorrect(1);

        runPerformance("HealthCare-2 (I)", model);
    }
}
