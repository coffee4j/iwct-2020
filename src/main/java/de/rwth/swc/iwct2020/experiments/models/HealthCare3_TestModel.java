package de.rwth.swc.iwct2020.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;
import static de.rwth.swc.iwct2020.experiments.util.ParametersFactory.parameters;

public class HealthCare3_TestModel {

    public static InputParameterModel buildModel_HealthCare3_Correct(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                                ( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                ( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) &&
                                ( p1 != 3 || p10 != 0) &&
                                ( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                                (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                                ( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                .errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                                ( p10 != 1 ||  p6 != 3) &&
                                ( p6 != 1 ||  p10 != 0) &&
                                ( p10 != 2 ||  p6 != 3) &&
                                ( p10 != 0 ||  p6 != 0) &&
                                ( p6 != 2 ||  p10 != 0)
                ))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                                ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                                ( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) &&
                                ( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                                ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                                ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                                ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                                ( p28 != 0 ||  p10 != 2)
                )).build();
     }

    public static InputParameterModel buildModel_HealthCare3_Incorrect(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                        ( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                ( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) &&
                                ( p1 != 3 || p10 != 0) &&
                                ( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                        (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                        ( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                .errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                        ( p10 != 1 ||  p6 != 3) &&
                                ( p6 != 1 ||  p10 != 0) &&
                                ( p10 != 2 ||  p6 != 3) &&
                                ( p10 != 0 ||  p6 != 0) &&
                                ( p6 != 2 ||  p10 != 0)
                ))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                        ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                        ( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) &&
                                ( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                        ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                        ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                        ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                        ( p28 != 0 ||  p10 != 2)
                ))
                .errorConstraint(constrain("p10").withName("c11").by((Integer p10) ->
                                ( p10 != 0 )
                ))
                .errorConstraint(constrain("p5", "p6", "p10").withName("c12")
                        .by((Integer p5, Integer p6, Integer p10) ->
                                   ( p5 != 0 ||  p6 != 3 || p10 != 1 )
                                && ( p5 != 0 ||  p6 != 3 || p10 != 2 )
                        )).build();
    }

    public static InputParameterModel buildModel_HealthCare3_Repair1(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                        ( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                ( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) &&
                                ( p1 != 3 || p10 != 0) &&
                                ( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                        (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                       // ( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                .errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                        ( p10 != 1 ||  p6 != 3) &&
                                ( p6 != 1 ||  p10 != 0) &&
                                //( p10 != 2 ||  p6 != 3) &&
                                ( p10 != 0 ||  p6 != 0) &&
                                ( p6 != 2 ||  p10 != 0)
                ))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                        ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                        ( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) &&
                                ( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                        ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                        ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                        ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                        ( p28 != 0 ||  p10 != 2)
                ))
                //.errorConstraint(constrain("p10").withName("c11").by((Integer p10) ->
                //        ( p10 != 0 )
                //))
                .errorConstraint(constrain("p5", "p6", "p10").withName("c12")
                        .by((Integer p5, Integer p6, Integer p10) ->
                                //( p5 != 0 ||  p6 != 3 || p10 != 1 )
                                //        &&
                                ( p5 != 0 ||  p6 != 3 || p10 != 2 )
                        )).build();
    }

    public static InputParameterModel buildModel_HealthCare3_Repair2(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                        ( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                ( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) &&
                                ( p1 != 3 || p10 != 0) &&
                                ( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                        (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                        ( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                .errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                        ( p10 != 1 ||  p6 != 3) &&
                                ( p6 != 1 ||  p10 != 0) &&
                                ( p10 != 2 ||  p6 != 3) &&
                                ( p10 != 0 ||  p6 != 0) &&
                                ( p6 != 2 ||  p10 != 0)
                ))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                        ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                        ( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) &&
                                ( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                        ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                        ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                        ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                        ( p28 != 0 ||  p10 != 2)
                ))
                //.errorConstraint(constrain("p10").withName("c11").by((Integer p10) ->
                //        ( p10 != 0 )
                //))
                //.errorConstraint(constrain("p5", "p6", "p10").withName("c12")
                //        .by((Integer p5, Integer p6, Integer p10) ->
                //                ( p5 != 0 ||  p6 != 3 || p10 != 1 )
                //                        && ( p5 != 0 ||  p6 != 3 || p10 != 2 )
                //        ))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare3_Repair3(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                        ( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                ( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) &&
                                ( p1 != 3 || p10 != 0) &&
                                ( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                        (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                        // ( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                .errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                        //( p10 != 1 ||  p6 != 3) &&
                                ( p6 != 1 ||  p10 != 0) &&
                                //( p10 != 2 ||  p6 != 3) &&
                                ( p10 != 0 ||  p6 != 0) &&
                                ( p6 != 2 ||  p10 != 0)
                ))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                        ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                        ( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) &&
                                ( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                        ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                        ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                        ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                        ( p28 != 0 ||  p10 != 2)
                ))
                //.errorConstraint(constrain("p10").withName("c11").by((Integer p10) ->
                //        ( p10 != 0 )
                //))
                .errorConstraint(constrain("p5", "p6", "p10").withName("c12")
                        .by((Integer p5, Integer p6, Integer p10) ->
                                ( p5 != 0 ||  p6 != 3 || p10 != 1 )
                                        && ( p5 != 0 ||  p6 != 3 || p10 != 2 )
                        )).build();
    }

    public static InputParameterModel buildModel_HealthCare3_Repair4(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                        //( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                //( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) //&&
                                //( p1 != 3 || p10 != 0) &&
                                //( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                        (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                        //( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                .errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                        ( p10 != 1 ||  p6 != 3) &&
                                //( p6 != 1 ||  p10 != 0) &&
                                ( p10 != 2 ||  p6 != 3) //&&
                                //( p10 != 0 ||  p6 != 0) &&
                                //( p6 != 2 ||  p10 != 0)
                ))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                        ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                        //( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) //&&
                                //( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                        ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                        ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                        ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                        ( p28 != 0 ||  p10 != 2)
                ))
                .errorConstraint(constrain("p10").withName("c11").by((Integer p10) ->
                        ( p10 != 0 )
                ))
                //.errorConstraint(constrain("p5", "p6", "p10").withName("c12")
                //        .by((Integer p5, Integer p6, Integer p10) ->
                //                ( p5 != 0 ||  p6 != 3 || p10 != 1 )
                //                        && ( p5 != 0 ||  p6 != 3 || p10 != 2 )
                //        ))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare3_Repair5(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                        //( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                //( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) //&&
                                //( p1 != 3 || p10 != 0) &&
                                //( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                        (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                        //( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                .errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                        ( p10 != 1 ||  p6 != 3) &&
                                //( p6 != 1 ||  p10 != 0) &&
                                ( p10 != 2 ||  p6 != 3) //&&
                                //( p10 != 0 ||  p6 != 0) &&
                                //( p6 != 2 ||  p10 != 0)
                ))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                        ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                        //( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) //&&
                               // ( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                        ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                        ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                        ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                        ( p28 != 0 ||  p10 != 2)
                ))
                .errorConstraint(constrain("p10").withName("c11").by((Integer p10) ->
                        ( p10 != 0 )
                ))
                //.errorConstraint(constrain("p5", "p6", "p10").withName("c12")
                //        .by((Integer p5, Integer p6, Integer p10) ->
                //                ( p5 != 0 ||  p6 != 3 || p10 != 1 )
                //                        && ( p5 != 0 ||  p6 != 3 || p10 != 2 )
                //        ))
               .build();
    }

    public static InputParameterModel buildModel_HealthCare3_Repair6(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                        //( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                //( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) //&&
                                //( p1 != 3 || p10 != 0) &&
                                //( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                        (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                        //( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                //.errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                //        ( p10 != 1 ||  p6 != 3) &&
                //                ( p6 != 1 ||  p10 != 0) &&
                //                ( p10 != 2 ||  p6 != 3) &&
                //                ( p10 != 0 ||  p6 != 0) &&
                //                ( p6 != 2 ||  p10 != 0)
                //))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                        ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                        ( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) &&
                                ( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                        ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                        ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                        ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                        ( p28 != 0 ||  p10 != 2)
                ))
                .errorConstraint(constrain("p10").withName("c11").by((Integer p10) ->
                        ( p10 != 0 )
                ))
                .errorConstraint(constrain("p5", "p6", "p10").withName("c12")
                        .by((Integer p5, Integer p6, Integer p10) ->
                                ( p5 != 0 ||  p6 != 3 || p10 != 1 )
                                        && ( p5 != 0 ||  p6 != 3 || p10 != 2 )
                        )).build();
    }

    public static InputParameterModel buildModel_HealthCare3_Repair7(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                        //( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                //( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) //&&
                                //( p1 != 3 || p10 != 0) &&
                                //( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                        (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                        //( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                .errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                        //( p10 != 1 ||  p6 != 3) &&
                                //( p6 != 1 ||  p10 != 0) &&
                                ( p10 != 2 ||  p6 != 3) //&&
                                //( p10 != 0 ||  p6 != 0) &&
                                //( p6 != 2 ||  p10 != 0)
                ))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                        ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                        ( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) &&
                                ( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                        ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                        ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                        ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                        ( p28 != 0 ||  p10 != 2)
                ))
                .errorConstraint(constrain("p10").withName("c11").by((Integer p10) ->
                        ( p10 != 0 )
                ))
                .errorConstraint(constrain("p5", "p6", "p10").withName("c12")
                        .by((Integer p5, Integer p6, Integer p10) ->
                                ( p5 != 0 ||  p6 != 3 || p10 != 1 )
                                        //&& ( p5 != 0 ||  p6 != 3 || p10 != 2 )
                        )).build();
    }

    public static InputParameterModel buildModel_HealthCare3_Repair8(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                                //( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                //( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) //&&
                                //( p1 != 3 || p10 != 0) &&
                                //( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                        (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                        //( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                .errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                        ( p10 != 1 ||  p6 != 3) //&&
                                //( p6 != 1 ||  p10 != 0) &&
                                //( p10 != 2 ||  p6 != 3) &&
                                //( p10 != 0 ||  p6 != 0) &&
                                //( p6 != 2 ||  p10 != 0)
                ))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                        ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                        ( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) &&
                                ( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                        ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                        ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                        ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                        ( p28 != 0 ||  p10 != 2)
                ))
                .errorConstraint(constrain("p10").withName("c11").by((Integer p10) ->
                        ( p10 != 0 )
                ))
                .errorConstraint(constrain("p5", "p6", "p10").withName("c12")
                        .by((Integer p5, Integer p6, Integer p10) ->
                                //( p5 != 0 ||  p6 != 3 || p10 != 1 ) &&
                                ( p5 != 0 ||  p6 != 3 || p10 != 2 )
                        ))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare3_Repair9(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                        //( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                //( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) //&&
                                //( p1 != 3 || p10 != 0) &&
                                //( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                        (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                        ( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                .errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                                ( p10 != 1 ||  p6 != 3) //&&
                                //( p6 != 1 ||  p10 != 0) &&
                                //( p10 != 2 ||  p6 != 3) &&
                                //( p10 != 0 ||  p6 != 0) &&
                                //( p6 != 2 ||  p10 != 0)
                ))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                        ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                        ( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) &&
                                ( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                        ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                        ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                        ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                        ( p28 != 0 ||  p10 != 2)
                ))
                .errorConstraint(constrain("p10").withName("c11").by((Integer p10) ->
                        ( p10 != 0 )
                ))
                //.errorConstraint(constrain("p5", "p6", "p10").withName("c12")
                //        .by((Integer p5, Integer p6, Integer p10) ->
                //                ( p5 != 0 ||  p6 != 3 || p10 != 1 )
                //                        && ( p5 != 0 ||  p6 != 3 || p10 != 2 )
                //        ))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare3_Repair10(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(6, 1, 5, 1, 4, 5, 3, 6, 2, 16)
                )
                .errorConstraint(constrain("p1", "p10").withName("c1").by((Integer p1, Integer p10) ->
                        //( p10 != 0 ||  p1 != 2) &&
                                ( p10  !=  1 || p1 != 2) &&
                                ( p10 != 1 || p1 != 4) &&
                                //( p1 != 1 || p10 != 0) &&
                                ( p1 != 3 || p10 != 1) //&&
                                //( p1 != 3 || p10 != 0) &&
                                //( p10 != 0 || p1 != 4)
                ))
                .errorConstraint(constrain("p21", "p25").withName("c2").by((Integer p21, Integer p25) ->
                        (p21 != 0 ||  p25 != 1) &&
                                (p21 != 1 || p25 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c3").by((Integer p5, Integer p6) ->
                        ( p5 != 0 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 2)
                ))
                .errorConstraint(constrain("p6", "p10").withName("c4").by((Integer p6, Integer p10) ->
                        //( p10 != 1 ||  p6 != 3) &&
                                //( p6 != 1 ||  p10 != 0) &&
                                ( p10 != 2 ||  p6 != 3) //&&
                                //( p10 != 0 ||  p6 != 0) &&
                                //( p6 != 2 ||  p10 != 0)
                ))
                .errorConstraint(constrain("p9", "p15").withName("c5").by((Integer p9, Integer p15) ->
                        ( p9 != 0 ||  p15 != 1) &&
                                ( p9 != 1 ||  p15 != 0) &&
                                ( p9 != 2 ||  p15 != 0)
                ))
                .errorConstraint(constrain("p5", "p6").withName("c6").by((Integer p5, Integer p6) ->
                        ( p5 != 2 ||  p6 != 3) &&
                                ( p5 != 3 ||  p6 != 0) &&
                                ( p6 != 1 ||  p5 != 3) &&
                                ( p5 != 1 ||  p6 != 3)
                ))
                .errorConstraint(constrain("p0", "p7").withName("c7").by((Integer p0, Integer p7) ->
                        ( p0 != 0 ||  p7 != 1) &&
                                ( p0 != 0 || p7 != 2) &&
                                ( p0 != 1 ||  p7 != 2) &&
                                ( p7 != 2 ||  p0 != 3)
                ))
                .errorConstraint(constrain("p15", "p28").withName("c8").by((Integer p15, Integer p28) ->
                        ( p28 != 0 ||  p15 != 1)
                ))
                .errorConstraint(constrain("p10", "p19").withName("c9").by((Integer p10, Integer p19) ->
                        ( p19 != 1 ||  p10 != 2) &&
                                ( p19 != 1 ||  p10 != 1)
                ))
                .errorConstraint(constrain("p10", "p28").withName("c10").by((Integer p10, Integer p28) ->
                        ( p28 != 0 ||  p10 != 2)
                ))
                .errorConstraint(constrain("p10").withName("c11").by((Integer p10) ->
                        ( p10 != 0 )
                ))
                //.errorConstraint(constrain("p5", "p6", "p10").withName("c12")
                //        .by((Integer p5, Integer p6, Integer p10) ->
                //                ( p5 != 0 ||  p6 != 3 || p10 != 1 )
                //                        && ( p5 != 0 ||  p6 != 3 || p10 != 2 )
                //        ))
                .build();
    }
}
