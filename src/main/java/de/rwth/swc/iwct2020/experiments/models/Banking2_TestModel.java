package de.rwth.swc.iwct2020.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.iwct2020.experiments.util.ParametersFactory;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;

public class Banking2_TestModel {

    private static InputParameterModel.Builder buildBaseModel(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        ParametersFactory.parameters(4, 1, 2, 14)
                );
    }

    public static InputParameterModel buildModel_Banking2_Correct(int strength) {
        return buildBaseModel(strength)
                .errorConstraint(constrain("p0", "p9").withName("c1").by((Integer p0, Integer p9) ->
                        (p0 != 2 || p9 != 1) && (p0 != 1 || p9 != 1) && (p0 != 3 || p9 != 1)))
                .build();
    }

    public static InputParameterModel buildModel_Banking2_Incorrect(int strength) {
        return buildBaseModel(strength)
                .errorConstraint(constrain("p0", "p9").withName("c1").by((Integer p0, Integer p9) ->
                        (p0 != 2 || p9 != 1) && (p0 != 1 || p9 != 1) && (p0 != 3 || p9 != 1)))
                .errorConstraint(constrain("p0").withName("c2").by((Integer p0) ->
                        (p0 != 2)))
                .errorConstraint(constrain("p0", "p8", "p9").withName("c3").by((Integer p0, Integer p8, Integer p9) ->
                        (p0 != 1 || p8 != 0 || p9 != 1)))
                .errorConstraint(constrain("p0", "p8", "p9").withName("c4").by((Integer p0, Integer p8, Integer p9) ->
                        (p0 != 1 || p8 != 1 || p9 != 1)))
                .build();
    }

    public static InputParameterModel buildModel_Banking2_Repair1(int strength) {
        System.out.println("INFO: building model 'Banking2+1' with strength t=" + strength);

        return buildBaseModel(strength)
                .errorConstraint(constrain("p0", "p9").withName("c1").by((Integer p0, Integer p9) ->
                        (p0 != 2 || p9 != 1) /* && (p0 != 1 || p9 != 1) */ && (p0 != 3 || p9 != 1)))
                //.errorConstraint(constrain("p0").withName("c2").by((Integer p0) ->
                //        (p0 != 2)))
                .errorConstraint(constrain("p0", "p8", "p9").withName("c3").by((Integer p0, Integer p8, Integer p9) ->
                        (p0 != 1 || p8 != 0 || p9 != 1)))
                .errorConstraint(constrain("p0", "p8", "p9").withName("c4").by((Integer p0, Integer p8, Integer p9) ->
                        (p0 != 1 || p8 != 1 || p9 != 1)))
                .build();
    }

    public static InputParameterModel buildModel_Banking2_Repair2(int strength) {
        return buildBaseModel(strength)
                .errorConstraint(constrain("p0", "p9").withName("c1").by((Integer p0, Integer p9) ->
                        /* (p0 != 2 || p9 != 1) && (p0 != 1 || p9 != 1) && */ (p0 != 3 || p9 != 1)))
                .errorConstraint(constrain("p0").withName("c2").by((Integer p0) ->
                        (p0 != 2)))
                .errorConstraint(constrain("p0", "p8", "p9").withName("c3").by((Integer p0, Integer p8, Integer p9) ->
                        (p0 != 1 || p8 != 0 || p9 != 1)))
                .errorConstraint(constrain("p0", "p8", "p9").withName("c4").by((Integer p0, Integer p8, Integer p9) ->
                        (p0 != 1 || p8 != 1 || p9 != 1)))
                .build();
    }

    public static InputParameterModel buildModel_Banking2_Repair3(int strength) {
        return buildBaseModel(strength)
                .errorConstraint(constrain("p0", "p9").withName("c1").by((Integer p0, Integer p9) ->
                        (p0 != 2 || p9 != 1) && (p0 != 1 || p9 != 1) && (p0 != 3 || p9 != 1)))
                //.errorConstraint(constrain("p0").withName("c2").by((Integer p0) ->
                //        (p0 != 2)))
                //.errorConstraint(constrain("p0", "p8", "p9").withName("c3").by((Integer p0, Integer p8, Integer p9) ->
                //        (p0 != 1 || p8 != 0 || p9 != 1)))
                //.errorConstraint(constrain("p0", "p8", "p9").withName("c4").by((Integer p0, Integer p8, Integer p9) ->
                //        (p0 != 1 || p8 != 1 || p9 != 1)))
                .build();
    }

    public static InputParameterModel buildModel_Banking2_Repair4(int strength) {
        return buildBaseModel(strength)
                .errorConstraint(constrain("p0", "p9").withName("c1").by((Integer p0, Integer p9) ->
                        /* (p0 != 2 || p9 != 1) && */ (p0 != 1 || p9 != 1) && (p0 != 3 || p9 != 1)))
                .errorConstraint(constrain("p0").withName("c2").by((Integer p0) ->
                        (p0 != 2)))
                //.errorConstraint(constrain("p0", "p8", "p9").withName("c3").by((Integer p0, Integer p8, Integer p9) ->
                //        (p0 != 1 || p8 != 0 || p9 != 1)))
                //.errorConstraint(constrain("p0", "p8", "p9").withName("c4").by((Integer p0, Integer p8, Integer p9) ->
                //        (p0 != 1 || p8 != 1 || p9 != 1)))
                .build();
    }
}
