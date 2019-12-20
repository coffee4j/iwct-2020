package de.rwth.swc.iwct2020.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static de.rwth.swc.iwct2020.experiments.models.HealthCare3_TestModel.*;
import static de.rwth.swc.iwct2020.experiments.util.ExperimentHelper.*;

class HealthCare3_Test {

    @Test
    void testAddressing() {
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(0);
        final InputParameterModel incorrectModel = buildModel_HealthCare3_Incorrect(0);

        runExperiment("HealthCare-3", correctModel, incorrectModel);
    }

    @Test
    void testAddressing_Repairs() {
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(0);
        final List<InputParameterModel> repairedModels = Arrays.asList(
                buildModel_HealthCare3_Repair1(0),
                buildModel_HealthCare3_Repair2(0),
                buildModel_HealthCare3_Repair3(0),
                buildModel_HealthCare3_Repair4(0),
                buildModel_HealthCare3_Repair5(0),
                buildModel_HealthCare3_Repair6(0),
                buildModel_HealthCare3_Repair7(0),
                buildModel_HealthCare3_Repair8(0),
                buildModel_HealthCare3_Repair9(0),
                buildModel_HealthCare3_Repair10(0)
        );

        runRepairExperiment("HealthCare-3", correctModel, repairedModels);
    }

    @Disabled
    @Test
    void testPerformance() {
        final InputParameterModel model = buildModel_HealthCare3_Correct(1);

        runPerformance("HealthCare-3", model);
    }

    @Disabled
    @Test
    void testPerformanceIncorrect() {
        final InputParameterModel model = buildModel_HealthCare3_Incorrect(1);

        runPerformance("HealthCare-3 (I)", model);
    }
}
