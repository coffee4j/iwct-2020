package de.rwth.swc.iwct2020.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static de.rwth.swc.iwct2020.experiments.models.Registration_TestModel.*;
import static de.rwth.swc.iwct2020.experiments.util.ExperimentHelper.*;

class Registration_Test {

    @Test
    void testAddressing() {
        final InputParameterModel correctModel = buildModel_Registration_Correct(0);
        final InputParameterModel incorrectModel = buildModel_Registration_Incorrect(0);

        runExperiment("Registration", correctModel, incorrectModel);
    }

    @Test
    void testAddressing_Repairs() {
        final InputParameterModel correctModel = buildModel_Registration_Correct(0);
        final List<InputParameterModel> repairedModels = Arrays.asList(
                buildModel_Registration_Repair1(0),
                buildModel_Registration_Repair2(0),
                buildModel_Registration_Repair3(0),
                buildModel_Registration_Repair4(0),
                buildModel_Registration_Repair5(0),
                buildModel_Registration_Repair6(0),
                buildModel_Registration_Repair7(0),
                buildModel_Registration_Repair8(0),
                buildModel_Registration_Repair9(0),
                buildModel_Registration_Repair10(0),
                buildModel_Registration_Repair11(0),
                buildModel_Registration_Repair12(0),
                buildModel_Registration_Repair13(0),
                buildModel_Registration_Repair14(0),
                buildModel_Registration_Repair15(0),
                buildModel_Registration_Repair16(0),
                buildModel_Registration_Repair17(0),
                buildModel_Registration_Repair18(0),
                buildModel_Registration_Repair19(0),
                buildModel_Registration_Repair20(0),
                buildModel_Registration_Repair21(0),
                buildModel_Registration_Repair22(0),
                buildModel_Registration_Repair23(0),
                buildModel_Registration_Repair24(0),
                buildModel_Registration_Repair25(0),
                buildModel_Registration_Repair26(0),
                buildModel_Registration_Repair27(0),
                buildModel_Registration_Repair28(0),
                buildModel_Registration_Repair29(0),
                buildModel_Registration_Repair30(0),
                buildModel_Registration_Repair31(0),
                buildModel_Registration_Repair32(0)
        );

        runRepairExperiment("Registration", correctModel, repairedModels);
    }

    @Disabled
    @Test
    void testPerformance() {
        final InputParameterModel model = buildModel_Registration_Correct(1);

        runPerformance("Registration", model);
    }

    @Disabled
    @Test
    void testPerformanceIncorrect() {
        final InputParameterModel model = buildModel_Registration_Incorrect(1);

        runPerformance("Registration (I)", model);
    }
}
