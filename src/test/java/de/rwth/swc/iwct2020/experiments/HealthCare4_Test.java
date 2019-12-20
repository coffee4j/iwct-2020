package de.rwth.swc.iwct2020.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static de.rwth.swc.iwct2020.experiments.models.HealthCare4_TestModel.*;
import static de.rwth.swc.iwct2020.experiments.util.ExperimentHelper.*;

class HealthCare4_Test {
    @Test
    void testAddressing() {
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(0);
        final InputParameterModel incorrectModel = buildModel_HealthCare4_Incorrect(0);

        runExperiment("HealthCare-4", correctModel, incorrectModel);
    }

    @Test
    void testAddressing_Repairs() {
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(0);
        final List<InputParameterModel> repairedModels = Arrays.asList(
                buildModel_HealthCare4_Repair1(0),
                buildModel_HealthCare4_Repair2(0),
                buildModel_HealthCare4_Repair3(0),
                buildModel_HealthCare4_Repair4(0),
                buildModel_HealthCare4_Repair5(0),
                buildModel_HealthCare4_Repair6(0),
                buildModel_HealthCare4_Repair7(0),
                buildModel_HealthCare4_Repair8(0),
                buildModel_HealthCare4_Repair9(0),
                buildModel_HealthCare4_Repair10(0),
                buildModel_HealthCare4_Repair11(0),
                buildModel_HealthCare4_Repair12(0),
                buildModel_HealthCare4_Repair13(0),
                buildModel_HealthCare4_Repair14(0),
                buildModel_HealthCare4_Repair15(0),
                buildModel_HealthCare4_Repair16(0)
        );

        runRepairExperiment("HealthCare-4", correctModel, repairedModels);
    }

    @Disabled
    @Test
    void testPerformance() {
        final InputParameterModel model = buildModel_HealthCare4_Correct(1);

        runPerformance("HealthCare-4", model);
    }

    @Disabled
    @Test
    void testPerformanceIncorrect() {
        final InputParameterModel model = buildModel_HealthCare4_Incorrect(1);

        runPerformance("HealthCare-4 (I)", model);
    }
}
