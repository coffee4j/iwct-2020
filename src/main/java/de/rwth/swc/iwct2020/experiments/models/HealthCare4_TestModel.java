package de.rwth.swc.iwct2020.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;

import static de.rwth.swc.iwct2020.experiments.util.ParametersFactory.parameters;
import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;

public class HealthCare4_TestModel {

    public static InputParameterModel buildModel_HealthCare4_Correct(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                                ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                                ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) &&
                                ( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                                ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                                ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                                ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                                ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                                ( p3 != 1 || p4 != 3) &&
                                ( p3 != 3 || p4 != 3) &&
                                ( p3 != 2 || p4 != 3)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Incorrect(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                                ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                                ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) &&
                                ( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                                ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                                ( p3 != 1 || p4 != 3) &&
                                ( p3 != 3 || p4 != 3) &&
                                ( p3 != 2 || p4 != 3)
                ))
                .errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                        (p4 != 3)
                ))
                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                        ( p3 != 4 || p19 != 0)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair1(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                                ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) //&&
                                //( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) &&
                                ( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                        ( p3 != 1 || p4 != 3) &&
                                ( p3 != 3 || p4 != 3) &&
                                ( p3 != 2 || p4 != 3)
                ))
                //.errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                //        (p4 != 3)
                //))
                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                        ( p3 != 4 || p19 != 0)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair2(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                                ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                //( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) &&
                                ( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                        ( p3 != 1 || p4 != 3) &&
                                ( p3 != 3 || p4 != 3) &&
                                ( p3 != 2 || p4 != 3)
                ))
                //.errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                //        (p4 != 3)
                //))
                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                        ( p3 != 4 || p19 != 0)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair3(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                        ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) &&
                                ( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                //.errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                //        ( p19 != 0 || p1 != 5) &&
                //                ( p19 != 0 || p1 != 4) &&
                //                ( p19 != 0 || p1 != 0) &&
                //                ( p19 != 0 || p1 != 3) &&
                //                ( p19 != 0 || p1 != 2)
                //))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                        ( p3 != 1 || p4 != 3) &&
                                ( p3 != 3 || p4 != 3) &&
                                ( p3 != 2 || p4 != 3)
                ))
                //.errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                //        (p4 != 3)
                //))
                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                        ( p3 != 4 || p19 != 0)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair4(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                        ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) //&&
                                //( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                        ( p3 != 1 || p4 != 3) &&
                                ( p3 != 3 || p4 != 3) &&
                                ( p3 != 2 || p4 != 3)
                ))
                //.errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                //        (p4 != 3)
                //))
                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                        ( p3 != 4 || p19 != 0)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair5(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                        ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) &&
                                ( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                        ( p3 != 1 || p4 != 3) &&
                                //( p3 != 3 || p4 != 3) &&
                                ( p3 != 2 || p4 != 3)
                ))
                //.errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                //        (p4 != 3)
                //))
                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                        ( p3 != 4 || p19 != 0)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair6(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                        ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) &&
                                ( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                        ( p3 != 1 || p4 != 3) &&
                                ( p3 != 3 || p4 != 3) &&
                                ( p3 != 2 || p4 != 3)
                ))
                //.errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                //        (p4 != 3)
                //))
                //.errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                //        ( p3 != 4 || p19 != 0)
                //))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair7(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                        ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) &&
                                ( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                        //( p3 != 1 || p4 != 3) &&
                                ( p3 != 3 || p4 != 3) &&
                                ( p3 != 2 || p4 != 3)
                ))
                //.errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                //        (p4 != 3)
                //))
                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                        ( p3 != 4 || p19 != 0)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair8(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                        ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) &&
                                ( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                        ( p3 != 1 || p4 != 3) &&
                                ( p3 != 3 || p4 != 3) //&&
                                //( p3 != 2 || p4 != 3)
                ))
                //.errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                //        (p4 != 3)
                //))
                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                        ( p3 != 4 || p19 != 0)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair9(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                        ( p19 != 2 || p4 != 3) &&
                                ( p19 != 1 || p4 != 3) &&
                                //( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) &&
                                ( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                        ( p3 != 1 || p4 != 3) &&
                                ( p3 != 3 || p4 != 3) &&
                                ( p3 != 2 || p4 != 3)
                ))
                //.errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                //        (p4 != 3)
                //))
                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                        ( p3 != 4 || p19 != 0)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair10(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                        //( p19 != 2 || p4 != 3) &&
                                //( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) //&&
                                //( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) //&&
                                //( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                //.errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                //        ( p3 != 1 || p4 != 3) &&
                //                ( p3 != 3 || p4 != 3) &&
                //                ( p3 != 2 || p4 != 3)
                //))
                .errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                        (p4 != 3)
                ))
                //.errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                //        ( p3 != 4 || p19 != 0)
                //))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair11(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                                //( p19 != 2 || p4 != 3) &&
                                //( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) //&&
                                //( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                //( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) //&&
                                //( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                //.errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                //        ( p3 != 1 || p4 != 3) &&
                //                ( p3 != 3 || p4 != 3) &&
                //                ( p3 != 2 || p4 != 3)
                //))
                .errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                        (p4 != 3)
                ))
                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                        ( p3 != 4 || p19 != 0)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair12(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                        //( p19 != 2 || p4 != 3) &&
                                //( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                //( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) //&&
                                //( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                //.errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                //        ( p3 != 1 || p4 != 3) &&
                //                ( p3 != 3 || p4 != 3) &&
                //                ( p3 != 2 || p4 != 3)
                //))
                .errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                        (p4 != 3)
                ))
                //.errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                //        ( p3 != 4 || p19 != 0)
                //))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair13(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                                //( p19 != 2 || p4 != 3) &&
                                //( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                //( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) //&&
                                //( p4 != 1 || p3 != 4) &&
                                //( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
                //.errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
                //        ( p3 != 1 || p4 != 3) &&
                //                ( p3 != 3 || p4 != 3) &&
                //                ( p3 != 2 || p4 != 3)
                //))
                .errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                        (p4 != 3)
                ))
                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
                        ( p3 != 4 || p19 != 0)
                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair14(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                                //( p19 != 2 || p4 != 3) &&
                                //( p19 != 1 || p4 != 3) &&
                                ( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) //&&
                                //( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
//                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
//                        ( p19 != 0 || p1 != 5) &&
//                                ( p19 != 0 || p1 != 4) &&
//                                ( p19 != 0 || p1 != 0) &&
//                                ( p19 != 0 || p1 != 3) &&
//                                ( p19 != 0 || p1 != 2)
//                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
//                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
//                        ( p3 != 1 || p4 != 3) &&
//                                ( p3 != 3 || p4 != 3) &&
//                                ( p3 != 2 || p4 != 3)
//                ))
                .errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                        (p4 != 3)
                ))
//                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
//                        ( p3 != 4 || p19 != 0)
//                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair15(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                                //( p19 != 2 || p4 != 3) &&
                                //( p19 != 1 || p4 != 3) &&
                                //( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) //&&
                                //( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
//                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
//                        ( p3 != 1 || p4 != 3) &&
//                                ( p3 != 3 || p4 != 3) &&
//                                ( p3 != 2 || p4 != 3)
//                ))
                .errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                        (p4 != 3)
                ))
//                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
//                        ( p3 != 4 || p19 != 0)
//                ))
                .build()
                ;
    }

    public static InputParameterModel buildModel_HealthCare4_Repair16(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(7, 1, 6, 1, 5, 2, 4, 6, 3, 12, 2, 13)
                )
                .errorConstraint(constrain("p4", "p19").withName("c1").by((Integer p4, Integer p19) ->
                                //( p19 != 2 || p4 != 3) &&
                                //( p19 != 1 || p4 != 3) &&
                                //( p19 != 0 || p4 != 2) &&
                                ( p19 != 0 || p4 != 1) &&
                                ( p19 != 0 || p4 != 0)
                ))
                .errorConstraint(constrain("p3", "p4").withName("c2").by((Integer p3, Integer p4) ->
                        ( p4 != 2 || p3 != 4) &&
                                ( p3 != 4 || p4 != 0) &&
                                ( p4 != 1 || p3 != 4) //&&
                                //( p3 != 0 || p4 != 3)
                ))
                .errorConstraint(constrain("p6", "p34").withName("c3").by((Integer p6, Integer p34) ->
                        ( p6 != 1 || p34 != 0) &&
                                ( p34 != 0 || p6 != 2)
                ))
                .errorConstraint(constrain("p19", "p34").withName("c4").by((Integer p19, Integer p34) ->
                        ( p19 != 2 || p34  != 0)
                ))
                .errorConstraint(constrain("p1", "p19").withName("c5").by((Integer p1, Integer p19) ->
                        ( p19 != 0 || p1 != 5) &&
                                ( p19 != 0 || p1 != 4) &&
                                ( p19 != 0 || p1 != 0) &&
                                ( p19 != 0 || p1 != 3) &&
                                ( p19 != 0 || p1 != 2)
                ))
                .errorConstraint(constrain("p6", "p17").withName("c6").by((Integer p6, Integer p17) ->
                        ( p6 != 0 || p17 != 2) &&
                                ( p6 != 0 || p17 != 1)
                ))
//                .errorConstraint(constrain("p3", "p4").withName("c7").by((Integer p3, Integer p4) ->
//                        ( p3 != 1 || p4 != 3) &&
//                                ( p3 != 3 || p4 != 3) &&
//                                ( p3 != 2 || p4 != 3)
//                ))
                .errorConstraint(constrain("p4").withName("c8").by((Integer p4) ->
                        (p4 != 3)
                ))
//                .errorConstraint(constrain("p3", "p19").withName("c9").by((Integer p3, Integer p19) ->
//                        ( p3 != 4 || p19 != 0)
//                ))
                .build()
                ;
    }
}
