package de.rwth.swc.iwct2020.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;

import static de.rwth.swc.iwct2020.experiments.util.ParametersFactory.parameters;
import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;

public class HealthCare2_TestModel {

    public static InputParameterModel buildModel_HealthCare2_Correct(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(2, 1, 3, 1, 2, 1, 2, 1, 3, 1, 3, 1, 3, 1, 3, 1, 2, 1, 3, 1, 4, 1, 2, 1)
                )
                .errorConstraint(constrain("p2", "p3").withName("c1")
                        .by((Integer p2, Integer p3) -> {
                        // 3, 4
                        return  ( p3!=0 || p2!=1);
                }))
                .errorConstraint(constrain("p4", "p5", "p11").withName("c2")
                        .by((Integer p4, Integer p5, Integer p11) -> {
                        // 5, 6, 12
                        return  ( p4!=0 || p11!=0 || p5!=2) &&
                                ( p4!=0 || p11!=1 || p5!=1);
                }))
                .errorConstraint(constrain("p4", "p6", "p11").withName("c3")
                        .by((Integer p4, Integer p6, Integer p11) -> {
                        // 5, 7, 12
                        return ( p6!=1 || p11!=1 || p4!=1) &&
                                ( p6!=2 || p11!=0 || p4!=1);
                }))
                .errorConstraint(constrain("p4", "p7", "p11").withName("c4")
                        .by((Integer p4, Integer p7, Integer p11) -> {
                        // 5, 8, 12
                        return  ( p11!=1 || p4!=2 || p7!=1) &&
                                ( p11!=0 || p7!=2 || p4!=2);
                }))
                .errorConstraint(constrain("p1", "p3", "p4", "p5", "p11")
                        .withName("c5")
                        .by((Integer p1, Integer p3, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 4, 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p1!=2 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p1!=1 || p11!=0 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p11!=1 || p1!=2 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p1!=1 || p11!=1 || p5!=0);
                }))
                .errorConstraint(constrain("p1", "p3", "p4", "p6", "p11")
                        .withName("c6")
                        .by((Integer p1, Integer p3, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 4, 5, 7, 12
                            return  ( p6!=0 || p1!=1 || p11!=0 || p4!=1 || p3!=1) &&
                                    ( p6!=0 || p3!=0 || p1!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=0 || p3!=0 || p11!=1 || p4!=1 || p1!=2) &&
                                    ( p6!=0 || p11!=0 || p4!=1 || p1!=2 || p3!=1);
                }))
                .errorConstraint(constrain("p1", "p3", "p4", "p7", "p11")
                        .withName("c7")
                        .by((Integer p1, Integer p3, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 4, 5, 8, 12
                            return ( p7!=0 || p11!=0 || p1!=2 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p1!=1 || p7!=0 || p11!=1 || p4!=2) &&
                                    ( p1!=1 || p7!=0 || p11!=0 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p7!=0 || p11!=1 || p1!=2 || p4!=2);
                }))
                .errorConstraint(constrain("p1", "p2", "p4", "p5", "p11")
                        .withName("c8")
                        .by((Integer p1, Integer p2, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 3, 5, 6, 12
                            return  ( p4!=0 || p2!=0 || p11!=1 || p1!=0 || p5!=0) &&
                                    ( p4!=0 || p2!=1 || p11!=0 || p1!=0 || p5!=0);
                }))
                .errorConstraint(constrain("p1", "p2", "p4", "p6", "p11")
                        .withName("c9")
                        .by((Integer p1, Integer p2, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 3, 5, 7, 12
                            return  ( p6!=0 || p2!=0 || p11!=1 || p4!=1 || p1!=0) &&
                                    ( p6!=0 || p2!=1 || p11!=0 || p4!=1 || p1!=0);
                }))
                .errorConstraint(constrain("p1", "p2", "p4", "p7", "p11")
                        .withName("c10")
                        .by((Integer p1, Integer p2, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 3, 5, 8, 12
                            return  ( p7!=0 || p2!=0 || p11!=1 || p1!=0 || p4!=2) &&
                                    ( p7!=0 || p2!=1 || p11!=0 || p1!=0 || p4!=2);
                }))
                .build();
     }

    public static InputParameterModel buildModel_HealthCare2_Incorrect(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(2, 1, 3, 1, 2, 1, 2, 1, 3, 1, 3, 1, 3, 1, 3, 1, 2, 1, 3, 1, 4, 1, 2, 1)
                )
                .errorConstraint(constrain("p2", "p3").withName("c1")
                        .by((Integer p2, Integer p3) -> {
                            // 3, 4
                            return  ( p3!=0 || p2!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p11").withName("c2")
                        .by((Integer p4, Integer p5, Integer p11) -> {
                            // 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p5!=2) &&
                                    ( p4!=0 || p11!=1 || p5!=1);
                        }))
                .errorConstraint(constrain("p4", "p6", "p11").withName("c3")
                        .by((Integer p4, Integer p6, Integer p11) -> {
                            // 5, 7, 12
                            return ( p6!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=2 || p11!=0 || p4!=1);
                        }))
                .errorConstraint(constrain("p4", "p7", "p11").withName("c4")
                        .by((Integer p4, Integer p7, Integer p11) -> {
                            // 5, 8, 12
                            return  ( p11!=1 || p4!=2 || p7!=1) &&
                                    ( p11!=0 || p7!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p5", "p11")
                        .withName("c5")
                        .by((Integer p1, Integer p3, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 4, 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p1!=2 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p1!=1 || p11!=0 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p11!=1 || p1!=2 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p1!=1 || p11!=1 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p6", "p11")
                        .withName("c6")
                        .by((Integer p1, Integer p3, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 4, 5, 7, 12
                            return  ( p6!=0 || p1!=1 || p11!=0 || p4!=1 || p3!=1) &&
                                    ( p6!=0 || p3!=0 || p1!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=0 || p3!=0 || p11!=1 || p4!=1 || p1!=2) &&
                                    ( p6!=0 || p11!=0 || p4!=1 || p1!=2 || p3!=1);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p7", "p11")
                        .withName("c7")
                        .by((Integer p1, Integer p3, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 4, 5, 8, 12
                            return  ( p7!=0 || p11!=0 || p1!=2 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p1!=1 || p7!=0 || p11!=1 || p4!=2) &&
                                    ( p1!=1 || p7!=0 || p11!=0 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p7!=0 || p11!=1 || p1!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p5", "p11")
                        .withName("c8")
                        .by((Integer p1, Integer p2, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 3, 5, 6, 12
                            return  ( p4!=0 || p2!=0 || p11!=1 || p1!=0 || p5!=0) &&
                                    ( p4!=0 || p2!=1 || p11!=0 || p1!=0 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p6", "p11")
                        .withName("c9")
                        .by((Integer p1, Integer p2, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 3, 5, 7, 12
                            return  ( p6!=0 || p2!=0 || p11!=1 || p4!=1 || p1!=0) &&
                                    ( p6!=0 || p2!=1 || p11!=0 || p4!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p7", "p11")
                        .withName("c10")
                        .by((Integer p1, Integer p2, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 3, 5, 8, 12
                            return  ( p7!=0 || p2!=0 || p11!=1 || p1!=0 || p4!=2) &&
                                    ( p7!=0 || p2!=1 || p11!=0 || p1!=0 || p4!=2);
                        }))
                .errorConstraint(constrain("p3", "p6", "p11")
                        .withName("c11")
                        .by((Integer p3, Integer p6, Integer p11) -> {
                            return  ( p6!=0 || p3!=0 || p11!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p6","p11")
                        .withName("c12")
                        .by((Integer p4, Integer p5, Integer p6, Integer p11) -> {
                            return  ( p4!=1 || p11!=0 || p5!=2) &&
                                    ( p4!=1 || p11!=1 || p5!=1);
                        }))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare2_Repair1(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(2, 1, 3, 1, 2, 1, 2, 1, 3, 1, 3, 1, 3, 1, 3, 1, 2, 1, 3, 1, 4, 1, 2, 1)
                )
                .errorConstraint(constrain("p2", "p3").withName("c1")
                        .by((Integer p2, Integer p3) -> {
                            // 3, 4
                            return  ( p3!=0 || p2!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p11").withName("c2")
                        .by((Integer p4, Integer p5, Integer p11) -> {
                            // 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p5!=2) &&
                                    ( p4!=0 || p11!=1 || p5!=1);
                        }))
//                .errorConstraint(constrain("p4", "p6", "p11").withName("c3")
//                        .by((Integer p4, Integer p6, Integer p11) -> {
//                            // 5, 7, 12
//                            return ( p6!=1 || p11!=1 || p4!=1) &&
//                                    ( p6!=2 || p11!=0 || p4!=1);
//                        }))
                .errorConstraint(constrain("p4", "p7", "p11").withName("c4")
                        .by((Integer p4, Integer p7, Integer p11) -> {
                            // 5, 8, 12
                            return  ( p11!=1 || p4!=2 || p7!=1) &&
                                    ( p11!=0 || p7!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p5", "p11")
                        .withName("c5")
                        .by((Integer p1, Integer p3, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 4, 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p1!=2 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p1!=1 || p11!=0 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p11!=1 || p1!=2 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p1!=1 || p11!=1 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p6", "p11")
                        .withName("c6")
                        .by((Integer p1, Integer p3, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 4, 5, 7, 12
                            return  ( p6!=0 || p1!=1 || p11!=0 || p4!=1 || p3!=1) &&
                                    ( p6!=0 || p3!=0 || p1!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=0 || p3!=0 || p11!=1 || p4!=1 || p1!=2) &&
                                    ( p6!=0 || p11!=0 || p4!=1 || p1!=2 || p3!=1);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p7", "p11")
                        .withName("c7")
                        .by((Integer p1, Integer p3, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 4, 5, 8, 12
                            return  ( p7!=0 || p11!=0 || p1!=2 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p1!=1 || p7!=0 || p11!=1 || p4!=2) &&
                                    ( p1!=1 || p7!=0 || p11!=0 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p7!=0 || p11!=1 || p1!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p5", "p11")
                        .withName("c8")
                        .by((Integer p1, Integer p2, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 3, 5, 6, 12
                            return  ( p4!=0 || p2!=0 || p11!=1 || p1!=0 || p5!=0) &&
                                    ( p4!=0 || p2!=1 || p11!=0 || p1!=0 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p6", "p11")
                        .withName("c9")
                        .by((Integer p1, Integer p2, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 3, 5, 7, 12
                            return  ( p6!=0 || p2!=0 || p11!=1 || p4!=1 || p1!=0) &&
                                    ( p6!=0 || p2!=1 || p11!=0 || p4!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p7", "p11")
                        .withName("c10")
                        .by((Integer p1, Integer p2, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 3, 5, 8, 12
                            return  ( p7!=0 || p2!=0 || p11!=1 || p1!=0 || p4!=2) &&
                                    ( p7!=0 || p2!=1 || p11!=0 || p1!=0 || p4!=2);
                        }))
//                .errorConstraint(constrain("p3", "p6", "p11")
//                        .withName("c11")
//                        .by((Integer p3, Integer p6, Integer p11) -> {
//                            return  ( p6!=0 || p3!=0 || p11!=1);
//                        }))
                .errorConstraint(constrain("p4", "p5", "p6","p11")
                        .withName("c12")
                        .by((Integer p4, Integer p5, Integer p6, Integer p11) -> {
                            return  ( p4!=1 || p11!=0 || p5!=2) &&
                                    ( p4!=1 || p11!=1 || p5!=1);
                        }))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare2_Repair2(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(2, 1, 3, 1, 2, 1, 2, 1, 3, 1, 3, 1, 3, 1, 3, 1, 2, 1, 3, 1, 4, 1, 2, 1)
                )
                .errorConstraint(constrain("p2", "p3").withName("c1")
                        .by((Integer p2, Integer p3) -> {
                            // 3, 4
                            return  ( p3!=0 || p2!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p11").withName("c2")
                        .by((Integer p4, Integer p5, Integer p11) -> {
                            // 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p5!=2) &&
                                    ( p4!=0 || p11!=1 || p5!=1);
                        }))
                .errorConstraint(constrain("p4", "p6", "p11").withName("c3")
                        .by((Integer p4, Integer p6, Integer p11) -> {
                            // 5, 7, 12
                            return ( p6!=1 || p11!=1 || p4!=1) ; //&&
                                    //( p6!=2 || p11!=0 || p4!=1);
                        }))
                .errorConstraint(constrain("p4", "p7", "p11").withName("c4")
                        .by((Integer p4, Integer p7, Integer p11) -> {
                            // 5, 8, 12
                            return  ( p11!=1 || p4!=2 || p7!=1) &&
                                    ( p11!=0 || p7!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p5", "p11")
                        .withName("c5")
                        .by((Integer p1, Integer p3, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 4, 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p1!=2 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p1!=1 || p11!=0 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p11!=1 || p1!=2 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p1!=1 || p11!=1 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p6", "p11")
                        .withName("c6")
                        .by((Integer p1, Integer p3, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 4, 5, 7, 12
                            return  ( p6!=0 || p1!=1 || p11!=0 || p4!=1 || p3!=1) &&
                                    ( p6!=0 || p3!=0 || p1!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=0 || p3!=0 || p11!=1 || p4!=1 || p1!=2) &&
                                    ( p6!=0 || p11!=0 || p4!=1 || p1!=2 || p3!=1);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p7", "p11")
                        .withName("c7")
                        .by((Integer p1, Integer p3, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 4, 5, 8, 12
                            return  ( p7!=0 || p11!=0 || p1!=2 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p1!=1 || p7!=0 || p11!=1 || p4!=2) &&
                                    ( p1!=1 || p7!=0 || p11!=0 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p7!=0 || p11!=1 || p1!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p5", "p11")
                        .withName("c8")
                        .by((Integer p1, Integer p2, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 3, 5, 6, 12
                            return  ( p4!=0 || p2!=0 || p11!=1 || p1!=0 || p5!=0) &&
                                    ( p4!=0 || p2!=1 || p11!=0 || p1!=0 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p6", "p11")
                        .withName("c9")
                        .by((Integer p1, Integer p2, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 3, 5, 7, 12
                            return  ( p6!=0 || p2!=0 || p11!=1 || p4!=1 || p1!=0) &&
                                    ( p6!=0 || p2!=1 || p11!=0 || p4!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p7", "p11")
                        .withName("c10")
                        .by((Integer p1, Integer p2, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 3, 5, 8, 12
                            return  ( p7!=0 || p2!=0 || p11!=1 || p1!=0 || p4!=2) &&
                                    ( p7!=0 || p2!=1 || p11!=0 || p1!=0 || p4!=2);
                        }))
//                .errorConstraint(constrain("p3", "p6", "p11")
//                        .withName("c11")
//                        .by((Integer p3, Integer p6, Integer p11) -> {
//                            return  ( p6!=0 || p3!=0 || p11!=1);
//                        }))
                .errorConstraint(constrain("p4", "p5", "p6","p11")
                        .withName("c12")
                        .by((Integer p4, Integer p5, Integer p6, Integer p11) -> {
                            if(p11==1 && p6==1 && p5==1 && p4==1) return true;
                            return  ( p4!=1 || p11!=0 || p5!=2) &&
                                    ( p4!=1 || p11!=1 || p5!=1);
                        }))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare2_Repair3(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(2, 1, 3, 1, 2, 1, 2, 1, 3, 1, 3, 1, 3, 1, 3, 1, 2, 1, 3, 1, 4, 1, 2, 1)
                )
                .errorConstraint(constrain("p2", "p3").withName("c1")
                        .by((Integer p2, Integer p3) -> {
                            // 3, 4
                            return  ( p3!=0 || p2!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p11").withName("c2")
                        .by((Integer p4, Integer p5, Integer p11) -> {
                            // 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p5!=2) &&
                                    ( p4!=0 || p11!=1 || p5!=1);
                        }))
                .errorConstraint(constrain("p4", "p6", "p11").withName("c3")
                        .by((Integer p4, Integer p6, Integer p11) -> {
                            // 5, 7, 12
                            return //( p6!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=2 || p11!=0 || p4!=1);
                        }))
                .errorConstraint(constrain("p4", "p7", "p11").withName("c4")
                        .by((Integer p4, Integer p7, Integer p11) -> {
                            // 5, 8, 12
                            return  ( p11!=1 || p4!=2 || p7!=1) &&
                                    ( p11!=0 || p7!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p5", "p11")
                        .withName("c5")
                        .by((Integer p1, Integer p3, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 4, 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p1!=2 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p1!=1 || p11!=0 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p11!=1 || p1!=2 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p1!=1 || p11!=1 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p6", "p11")
                        .withName("c6")
                        .by((Integer p1, Integer p3, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 4, 5, 7, 12
                            return  ( p6!=0 || p1!=1 || p11!=0 || p4!=1 || p3!=1) &&
                                    ( p6!=0 || p3!=0 || p1!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=0 || p3!=0 || p11!=1 || p4!=1 || p1!=2) &&
                                    ( p6!=0 || p11!=0 || p4!=1 || p1!=2 || p3!=1);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p7", "p11")
                        .withName("c7")
                        .by((Integer p1, Integer p3, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 4, 5, 8, 12
                            return  ( p7!=0 || p11!=0 || p1!=2 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p1!=1 || p7!=0 || p11!=1 || p4!=2) &&
                                    ( p1!=1 || p7!=0 || p11!=0 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p7!=0 || p11!=1 || p1!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p5", "p11")
                        .withName("c8")
                        .by((Integer p1, Integer p2, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 3, 5, 6, 12
                            return  ( p4!=0 || p2!=0 || p11!=1 || p1!=0 || p5!=0) &&
                                    ( p4!=0 || p2!=1 || p11!=0 || p1!=0 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p6", "p11")
                        .withName("c9")
                        .by((Integer p1, Integer p2, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 3, 5, 7, 12
                            return  ( p6!=0 || p2!=0 || p11!=1 || p4!=1 || p1!=0) &&
                                    ( p6!=0 || p2!=1 || p11!=0 || p4!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p7", "p11")
                        .withName("c10")
                        .by((Integer p1, Integer p2, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 3, 5, 8, 12
                            return  ( p7!=0 || p2!=0 || p11!=1 || p1!=0 || p4!=2) &&
                                    ( p7!=0 || p2!=1 || p11!=0 || p1!=0 || p4!=2);
                        }))
//                .errorConstraint(constrain("p3", "p6", "p11")
//                        .withName("c11")
//                        .by((Integer p3, Integer p6, Integer p11) -> {
//                            return  ( p6!=0 || p3!=0 || p11!=1);
//                        }))
                .errorConstraint(constrain("p4", "p5", "p6","p11")
                        .withName("c12")
                        .by((Integer p4, Integer p5, Integer p6, Integer p11) -> {
                            if(p11==0 && p6==2 && p5==2 && p4==1) return true;

                            return  ( p4!=1 || p11!=0 || p5!=2) &&
                                    ( p4!=1 || p11!=1 || p5!=1);
                        }))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare2_Repair4(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(2, 1, 3, 1, 2, 1, 2, 1, 3, 1, 3, 1, 3, 1, 3, 1, 2, 1, 3, 1, 4, 1, 2, 1)
                )
                .errorConstraint(constrain("p2", "p3").withName("c1")
                        .by((Integer p2, Integer p3) -> {
                            // 3, 4
                            return  ( p3!=0 || p2!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p11").withName("c2")
                        .by((Integer p4, Integer p5, Integer p11) -> {
                            // 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p5!=2) &&
                                    ( p4!=0 || p11!=1 || p5!=1);
                        }))
                .errorConstraint(constrain("p4", "p6", "p11").withName("c3")
                        .by((Integer p4, Integer p6, Integer p11) -> {
                            // 5, 7, 12
                            return ( p6!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=2 || p11!=0 || p4!=1);
                        }))
                .errorConstraint(constrain("p4", "p7", "p11").withName("c4")
                        .by((Integer p4, Integer p7, Integer p11) -> {
                            // 5, 8, 12
                            return  ( p11!=1 || p4!=2 || p7!=1) &&
                                    ( p11!=0 || p7!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p5", "p11")
                        .withName("c5")
                        .by((Integer p1, Integer p3, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 4, 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p1!=2 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p1!=1 || p11!=0 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p11!=1 || p1!=2 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p1!=1 || p11!=1 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p6", "p11")
                        .withName("c6")
                        .by((Integer p1, Integer p3, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 4, 5, 7, 12
                            return  ( p6!=0 || p1!=1 || p11!=0 || p4!=1 || p3!=1) &&
                                    ( p6!=0 || p3!=0 || p1!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=0 || p3!=0 || p11!=1 || p4!=1 || p1!=2) &&
                                    ( p6!=0 || p11!=0 || p4!=1 || p1!=2 || p3!=1);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p7", "p11")
                        .withName("c7")
                        .by((Integer p1, Integer p3, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 4, 5, 8, 12
                            return  ( p7!=0 || p11!=0 || p1!=2 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p1!=1 || p7!=0 || p11!=1 || p4!=2) &&
                                    ( p1!=1 || p7!=0 || p11!=0 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p7!=0 || p11!=1 || p1!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p5", "p11")
                        .withName("c8")
                        .by((Integer p1, Integer p2, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 3, 5, 6, 12
                            return  ( p4!=0 || p2!=0 || p11!=1 || p1!=0 || p5!=0) &&
                                    ( p4!=0 || p2!=1 || p11!=0 || p1!=0 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p6", "p11")
                        .withName("c9")
                        .by((Integer p1, Integer p2, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 3, 5, 7, 12
                            return  ( p6!=0 || p2!=0 || p11!=1 || p4!=1 || p1!=0) &&
                                    ( p6!=0 || p2!=1 || p11!=0 || p4!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p7", "p11")
                        .withName("c10")
                        .by((Integer p1, Integer p2, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 3, 5, 8, 12
                            return  ( p7!=0 || p2!=0 || p11!=1 || p1!=0 || p4!=2) &&
                                    ( p7!=0 || p2!=1 || p11!=0 || p1!=0 || p4!=2);
                        }))
//                .errorConstraint(constrain("p3", "p6", "p11")
//                        .withName("c11")
//                        .by((Integer p3, Integer p6, Integer p11) -> {
//                            return  ( p6!=0 || p3!=0 || p11!=1);
//                        }))
//                .errorConstraint(constrain("p4", "p5", "p6","p11")
//                        .withName("c12")
//                        .by((Integer p4, Integer p5, Integer p6, Integer p11) -> {
//                            return  ( p4!=1 || p11!=0 || p5!=2) &&
//                                    ( p4!=1 || p11!=1 || p5!=1);
//                        }))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare2_Repair5(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(2, 1, 3, 1, 2, 1, 2, 1, 3, 1, 3, 1, 3, 1, 3, 1, 2, 1, 3, 1, 4, 1, 2, 1)
                )
                .errorConstraint(constrain("p2", "p3").withName("c1")
                        .by((Integer p2, Integer p3) -> {
                            // 3, 4
                            return  ( p3!=0 || p2!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p11").withName("c2")
                        .by((Integer p4, Integer p5, Integer p11) -> {
                            // 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p5!=2) &&
                                    ( p4!=0 || p11!=1 || p5!=1);
                        }))
//                .errorConstraint(constrain("p4", "p6", "p11").withName("c3")
//                        .by((Integer p4, Integer p6, Integer p11) -> {
//                            // 5, 7, 12
//                            return ( p6!=1 || p11!=1 || p4!=1) &&
//                                    ( p6!=2 || p11!=0 || p4!=1);
//                        }))
                .errorConstraint(constrain("p4", "p7", "p11").withName("c4")
                        .by((Integer p4, Integer p7, Integer p11) -> {
                            // 5, 8, 12
                            return  ( p11!=1 || p4!=2 || p7!=1) &&
                                    ( p11!=0 || p7!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p5", "p11")
                        .withName("c5")
                        .by((Integer p1, Integer p3, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 4, 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p1!=2 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p1!=1 || p11!=0 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p11!=1 || p1!=2 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p1!=1 || p11!=1 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p6", "p11")
                        .withName("c6")
                        .by((Integer p1, Integer p3, Integer p4, Integer p6, Integer p11) -> {
                            if(p11==1 && p6==0 && p3==0 && p1==1 && p4==1) return true;
                            if(p11==1 && p6==0 && p3==0 && p1==2 && p4==1) return true;

                            // 2, 4, 5, 7, 12
                            return  ( p6!=0 || p1!=1 || p11!=0 || p4!=1 || p3!=1) &&
                                    ( p6!=0 || p3!=0 || p1!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=0 || p3!=0 || p11!=1 || p4!=1 || p1!=2) &&
                                    ( p6!=0 || p11!=0 || p4!=1 || p1!=2 || p3!=1);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p7", "p11")
                        .withName("c7")
                        .by((Integer p1, Integer p3, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 4, 5, 8, 12
                            return  ( p7!=0 || p11!=0 || p1!=2 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p1!=1 || p7!=0 || p11!=1 || p4!=2) &&
                                    ( p1!=1 || p7!=0 || p11!=0 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p7!=0 || p11!=1 || p1!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p5", "p11")
                        .withName("c8")
                        .by((Integer p1, Integer p2, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 3, 5, 6, 12
                            return  ( p4!=0 || p2!=0 || p11!=1 || p1!=0 || p5!=0) &&
                                    ( p4!=0 || p2!=1 || p11!=0 || p1!=0 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p6", "p11")
                        .withName("c9")
                        .by((Integer p1, Integer p2, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 3, 5, 7, 12
                            return  ( p6!=0 || p2!=0 || p11!=1 || p4!=1 || p1!=0) &&
                                    ( p6!=0 || p2!=1 || p11!=0 || p4!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p7", "p11")
                        .withName("c10")
                        .by((Integer p1, Integer p2, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 3, 5, 8, 12
                            return  ( p7!=0 || p2!=0 || p11!=1 || p1!=0 || p4!=2) &&
                                    ( p7!=0 || p2!=1 || p11!=0 || p1!=0 || p4!=2);
                        }))
                .errorConstraint(constrain("p3", "p6", "p11")
                        .withName("c11")
                        .by((Integer p3, Integer p6, Integer p11) -> {
                            return  ( p6!=0 || p3!=0 || p11!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p6","p11")
                        .withName("c12")
                        .by((Integer p4, Integer p5, Integer p6, Integer p11) -> {
                            return  ( p4!=1 || p11!=0 || p5!=2) &&
                                    ( p4!=1 || p11!=1 || p5!=1);
                        }))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare2_Repair6(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(2, 1, 3, 1, 2, 1, 2, 1, 3, 1, 3, 1, 3, 1, 3, 1, 2, 1, 3, 1, 4, 1, 2, 1)
                )
                .errorConstraint(constrain("p2", "p3").withName("c1")
                        .by((Integer p2, Integer p3) -> {
                            // 3, 4
                            return  ( p3!=0 || p2!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p11").withName("c2")
                        .by((Integer p4, Integer p5, Integer p11) -> {
                            // 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p5!=2) &&
                                    ( p4!=0 || p11!=1 || p5!=1);
                        }))
                .errorConstraint(constrain("p4", "p6", "p11").withName("c3")
                        .by((Integer p4, Integer p6, Integer p11) -> {
                            // 5, 7, 12
                            return ( p6!=1 || p11!=1 || p4!=1); // && ( p6!=2 || p11!=0 || p4!=1);
                        }))
                .errorConstraint(constrain("p4", "p7", "p11").withName("c4")
                        .by((Integer p4, Integer p7, Integer p11) -> {
                            // 5, 8, 12
                            return  ( p11!=1 || p4!=2 || p7!=1) &&
                                    ( p11!=0 || p7!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p5", "p11")
                        .withName("c5")
                        .by((Integer p1, Integer p3, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 4, 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p1!=2 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p1!=1 || p11!=0 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p11!=1 || p1!=2 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p1!=1 || p11!=1 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p6", "p11")
                        .withName("c6")
                        .by((Integer p1, Integer p3, Integer p4, Integer p6, Integer p11) -> {
                            if(p11==1&& p6==0&& p3==0&& p1==1&& p4==1) return true;
                            if(p11==1 && p6==0&& p3==0&& p1==2&& p4==1) return true;

                            // 2, 4, 5, 7, 12
                            return  ( p6!=0 || p1!=1 || p11!=0 || p4!=1 || p3!=1) &&
                                    ( p6!=0 || p3!=0 || p1!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=0 || p3!=0 || p11!=1 || p4!=1 || p1!=2) &&
                                    ( p6!=0 || p11!=0 || p4!=1 || p1!=2 || p3!=1);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p7", "p11")
                        .withName("c7")
                        .by((Integer p1, Integer p3, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 4, 5, 8, 12
                            return  ( p7!=0 || p11!=0 || p1!=2 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p1!=1 || p7!=0 || p11!=1 || p4!=2) &&
                                    ( p1!=1 || p7!=0 || p11!=0 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p7!=0 || p11!=1 || p1!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p5", "p11")
                        .withName("c8")
                        .by((Integer p1, Integer p2, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 3, 5, 6, 12
                            return  ( p4!=0 || p2!=0 || p11!=1 || p1!=0 || p5!=0) &&
                                    ( p4!=0 || p2!=1 || p11!=0 || p1!=0 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p6", "p11")
                        .withName("c9")
                        .by((Integer p1, Integer p2, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 3, 5, 7, 12
                            return  ( p6!=0 || p2!=0 || p11!=1 || p4!=1 || p1!=0) &&
                                    ( p6!=0 || p2!=1 || p11!=0 || p4!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p7", "p11")
                        .withName("c10")
                        .by((Integer p1, Integer p2, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 3, 5, 8, 12
                            return  ( p7!=0 || p2!=0 || p11!=1 || p1!=0 || p4!=2) &&
                                    ( p7!=0 || p2!=1 || p11!=0 || p1!=0 || p4!=2);
                        }))
                .errorConstraint(constrain("p3", "p6", "p11")
                        .withName("c11")
                        .by((Integer p3, Integer p6, Integer p11) -> {
                            return  ( p6!=0 || p3!=0 || p11!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p6","p11")
                        .withName("c12")
                        .by((Integer p4, Integer p5, Integer p6, Integer p11) -> {
                            if(p11==1&& p6==1&& p5==1&& p4==1) return true;

                            return  ( p4!=1 || p11!=0 || p5!=2) &&
                                    ( p4!=1 || p11!=1 || p5!=1);
                        }))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare2_Repair7(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(2, 1, 3, 1, 2, 1, 2, 1, 3, 1, 3, 1, 3, 1, 3, 1, 2, 1, 3, 1, 4, 1, 2, 1)
                )
                .errorConstraint(constrain("p2", "p3").withName("c1")
                        .by((Integer p2, Integer p3) -> {
                            // 3, 4
                            return  ( p3!=0 || p2!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p11").withName("c2")
                        .by((Integer p4, Integer p5, Integer p11) -> {
                            // 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p5!=2) &&
                                    ( p4!=0 || p11!=1 || p5!=1);
                        }))
                .errorConstraint(constrain("p4", "p6", "p11").withName("c3")
                        .by((Integer p4, Integer p6, Integer p11) -> {
                            // 5, 7, 12
                            return //( p6!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=2 || p11!=0 || p4!=1);
                        }))
                .errorConstraint(constrain("p4", "p7", "p11").withName("c4")
                        .by((Integer p4, Integer p7, Integer p11) -> {
                            // 5, 8, 12
                            return  ( p11!=1 || p4!=2 || p7!=1) &&
                                    ( p11!=0 || p7!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p5", "p11")
                        .withName("c5")
                        .by((Integer p1, Integer p3, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 4, 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p1!=2 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p1!=1 || p11!=0 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p11!=1 || p1!=2 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p1!=1 || p11!=1 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p6", "p11")
                        .withName("c6")
                        .by((Integer p1, Integer p3, Integer p4, Integer p6, Integer p11) -> {
                            if(p11==1&& p6==0&& p3==0&& p1==1&& p4==1) return true;
                            if(p11==1 && p6==0&& p3==0&& p1==2&& p4==1) return true;

                            // 2, 4, 5, 7, 12
                            return  ( p6!=0 || p1!=1 || p11!=0 || p4!=1 || p3!=1) &&
                                    ( p6!=0 || p3!=0 || p1!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=0 || p3!=0 || p11!=1 || p4!=1 || p1!=2) &&
                                    ( p6!=0 || p11!=0 || p4!=1 || p1!=2 || p3!=1);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p7", "p11")
                        .withName("c7")
                        .by((Integer p1, Integer p3, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 4, 5, 8, 12
                            return  ( p7!=0 || p11!=0 || p1!=2 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p1!=1 || p7!=0 || p11!=1 || p4!=2) &&
                                    ( p1!=1 || p7!=0 || p11!=0 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p7!=0 || p11!=1 || p1!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p5", "p11")
                        .withName("c8")
                        .by((Integer p1, Integer p2, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 3, 5, 6, 12
                            return  ( p4!=0 || p2!=0 || p11!=1 || p1!=0 || p5!=0) &&
                                    ( p4!=0 || p2!=1 || p11!=0 || p1!=0 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p6", "p11")
                        .withName("c9")
                        .by((Integer p1, Integer p2, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 3, 5, 7, 12
                            return  ( p6!=0 || p2!=0 || p11!=1 || p4!=1 || p1!=0) &&
                                    ( p6!=0 || p2!=1 || p11!=0 || p4!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p7", "p11")
                        .withName("c10")
                        .by((Integer p1, Integer p2, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 3, 5, 8, 12
                            return  ( p7!=0 || p2!=0 || p11!=1 || p1!=0 || p4!=2) &&
                                    ( p7!=0 || p2!=1 || p11!=0 || p1!=0 || p4!=2);
                        }))
                .errorConstraint(constrain("p3", "p6", "p11")
                        .withName("c11")
                        .by((Integer p3, Integer p6, Integer p11) -> {
                            return  ( p6!=0 || p3!=0 || p11!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p6","p11")
                        .withName("c12")
                        .by((Integer p4, Integer p5, Integer p6, Integer p11) -> {
                            if(p11==0&& p6==2&& p5==2&& p4==1) return true;

                            return  ( p4!=1 || p11!=0 || p5!=2) &&
                                    ( p4!=1 || p11!=1 || p5!=1);
                        }))
                .build();
    }
    public static InputParameterModel buildModel_HealthCare2_Repair8(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(2, 1, 3, 1, 2, 1, 2, 1, 3, 1, 3, 1, 3, 1, 3, 1, 2, 1, 3, 1, 4, 1, 2, 1)
                )
                .errorConstraint(constrain("p2", "p3").withName("c1")
                        .by((Integer p2, Integer p3) -> {
                            // 3, 4
                            return  ( p3!=0 || p2!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p11").withName("c2")
                        .by((Integer p4, Integer p5, Integer p11) -> {
                            // 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p5!=2) &&
                                    ( p4!=0 || p11!=1 || p5!=1);
                        }))
                .errorConstraint(constrain("p4", "p6", "p11").withName("c3")
                        .by((Integer p4, Integer p6, Integer p11) -> {
                            // 5, 7, 12
                            return ( p6!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=2 || p11!=0 || p4!=1);
                        }))
                .errorConstraint(constrain("p4", "p7", "p11").withName("c4")
                        .by((Integer p4, Integer p7, Integer p11) -> {
                            // 5, 8, 12
                            return  ( p11!=1 || p4!=2 || p7!=1) &&
                                    ( p11!=0 || p7!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p5", "p11")
                        .withName("c5")
                        .by((Integer p1, Integer p3, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 4, 5, 6, 12
                            return  ( p4!=0 || p11!=0 || p1!=2 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p1!=1 || p11!=0 || p3!=1 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p11!=1 || p1!=2 || p5!=0) &&
                                    ( p4!=0 || p3!=0 || p1!=1 || p11!=1 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p6", "p11")
                        .withName("c6")
                        .by((Integer p1, Integer p3, Integer p4, Integer p6, Integer p11) -> {
                            if(p11==1&& p6==0&& p3==0&& p1==1&& p4==1) return true;
                            if(p11==1 && p6==0&& p3==0&& p1==2&& p4==1) return true;

                            // 2, 4, 5, 7, 12
                            return  ( p6!=0 || p1!=1 || p11!=0 || p4!=1 || p3!=1) &&
                                    ( p6!=0 || p3!=0 || p1!=1 || p11!=1 || p4!=1) &&
                                    ( p6!=0 || p3!=0 || p11!=1 || p4!=1 || p1!=2) &&
                                    ( p6!=0 || p11!=0 || p4!=1 || p1!=2 || p3!=1);
                        }))
                .errorConstraint(constrain("p1", "p3", "p4", "p7", "p11")
                        .withName("c7")
                        .by((Integer p1, Integer p3, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 4, 5, 8, 12
                            return  ( p7!=0 || p11!=0 || p1!=2 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p1!=1 || p7!=0 || p11!=1 || p4!=2) &&
                                    ( p1!=1 || p7!=0 || p11!=0 || p3!=1 || p4!=2) &&
                                    ( p3!=0 || p7!=0 || p11!=1 || p1!=2 || p4!=2);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p5", "p11")
                        .withName("c8")
                        .by((Integer p1, Integer p2, Integer p4, Integer p5, Integer p11) -> {
                            // 2, 3, 5, 6, 12
                            return  ( p4!=0 || p2!=0 || p11!=1 || p1!=0 || p5!=0) &&
                                    ( p4!=0 || p2!=1 || p11!=0 || p1!=0 || p5!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p6", "p11")
                        .withName("c9")
                        .by((Integer p1, Integer p2, Integer p4, Integer p6, Integer p11) -> {
                            // 2, 3, 5, 7, 12
                            return  ( p6!=0 || p2!=0 || p11!=1 || p4!=1 || p1!=0) &&
                                    ( p6!=0 || p2!=1 || p11!=0 || p4!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p1", "p2", "p4", "p7", "p11")
                        .withName("c10")
                        .by((Integer p1, Integer p2, Integer p4, Integer p7, Integer p11) -> {
                            // 2, 3, 5, 8, 12
                            return  ( p7!=0 || p2!=0 || p11!=1 || p1!=0 || p4!=2) &&
                                    ( p7!=0 || p2!=1 || p11!=0 || p1!=0 || p4!=2);
                        }))
                .errorConstraint(constrain("p3", "p6", "p11")
                        .withName("c11")
                        .by((Integer p3, Integer p6, Integer p11) -> {
                            return  ( p6!=0 || p3!=0 || p11!=1);
                        }))
                .errorConstraint(constrain("p4", "p5", "p6","p11")
                        .withName("c12")
                        .by((Integer p4, Integer p5, Integer p6, Integer p11) -> {
                            if(p11==1&& p6==1&& p5==1&& p4==1) return true;
                            if(p11==0&& p6==2&& p5==2&& p4==1) return true;

                            return  ( p4!=1 || p11!=0 || p5!=2) &&
                                    ( p4!=1 || p11!=1 || p5!=1);
                        }))
                .build();
    }
}
