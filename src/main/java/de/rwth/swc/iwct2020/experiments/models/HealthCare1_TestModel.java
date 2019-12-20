package de.rwth.swc.iwct2020.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;

import static de.rwth.swc.iwct2020.experiments.util.ParametersFactory.parameters;
import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;

public class HealthCare1_TestModel {

    public static InputParameterModel buildModel_HealthCare1_Correct(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(3, 1, 2, 1, 6, 1, 3, 1, 2, 1, 2, 1, 5, 1, 2, 1, 2, 1, 2, 1)
                )
                .errorConstraint(constrain("p0", "p1")
                        .withName("c1")
                        .by((Integer p0, Integer p1) -> {
                    return ( p1!=0 || p0!=2) &&
                            ( p0!=1 || p1!=0);
                }))
                .errorConstraint(constrain("p0", "p5")
                        .withName("c2")
                        .by((Integer p0, Integer p5) -> {
                    return ( p5!=1 || p0!=0);
                }))
                .errorConstraint(constrain("p2", "p3", "p4")
                        .withName("c3")
                        .by((Integer p2, Integer p3, Integer p4) -> {
                    return  ( p2!=2 || p3!=2 || p4!=0) &&
                            ( p2!=4 || p3!=1 || p4!=0) &&
                            ( p3!=2 || p4!=1 || p2!=5) &&
                            ( p2!=2 || p3!=0 || p4!=1) &&
                            ( p2!=4 || p3!=0 || p4!=0) &&
                            ( p2!=2 || p3!=1 || p4!=1) &&
                            ( p2!=4 || p3!=2 || p4!=0) &&
                            ( p3!=2 || p4!=1 || p2!=1) &&
                            ( p2!=0 || p3!=1 || p4!=1) &&
                            ( p2!=0 || p3!=2 || p4!=1) &&
                            ( p3!=2 || p4!=0 || p2!=3) &&
                            ( p3!=0 || p4!=1 || p2!=3) &&
                            ( p3!=0 || p4!=1 || p2!=5) &&
                            ( p3!=1 || p4!=1 || p2!=1) &&
                            ( p3!=0 || p2!=0 || p4!=1) &&
                            ( p3!=0 || p4!=1 || p2!=1) &&
                            ( p3!=1 || p4!=1 || p2!=3) &&
                            ( p3!=1 || p4!=1 || p2!=5);
                }))
                .build();
     }

    public static InputParameterModel buildModel_HealthCare1_Incorrect(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(3, 1, 2, 1, 6, 1, 3, 1, 2, 1, 2, 1, 5, 1, 2, 1, 2, 1, 2, 1)
                )
                .errorConstraint(constrain("p0", "p1")
                        .withName("c1")
                        .by((Integer p0, Integer p1) -> {
                            return ( p1!=0 || p0!=2) &&
                                    ( p0!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p0", "p5")
                        .withName("c2")
                        .by((Integer p0, Integer p5) -> {
                            return ( p5!=1 || p0!=0);
                        }))
                .errorConstraint(constrain("p2", "p3", "p4")
                        .withName("c3")
                        .by((Integer p2, Integer p3, Integer p4) -> {
                            return  ( p2!=2 || p3!=2 || p4!=0) &&
                                    ( p2!=4 || p3!=1 || p4!=0) &&
                                    ( p3!=2 || p4!=1 || p2!=5) &&
                                    ( p2!=2 || p3!=0 || p4!=1) &&
                                    ( p2!=4 || p3!=0 || p4!=0) &&
                                    ( p2!=2 || p3!=1 || p4!=1) &&
                                    ( p2!=4 || p3!=2 || p4!=0) &&
                                    ( p3!=2 || p4!=1 || p2!=1) &&
                                    ( p2!=0 || p3!=1 || p4!=1) &&
                                    ( p2!=0 || p3!=2 || p4!=1) &&
                                    ( p3!=2 || p4!=0 || p2!=3) &&
                                    ( p3!=0 || p4!=1 || p2!=3) &&
                                    ( p3!=0 || p4!=1 || p2!=5) &&
                                    ( p3!=1 || p4!=1 || p2!=1) &&
                                    ( p3!=0 || p2!=0 || p4!=1) &&
                                    ( p3!=0 || p4!=1 || p2!=1) &&
                                    ( p3!=1 || p4!=1 || p2!=3) &&
                                    ( p3!=1 || p4!=1 || p2!=5);
                        }))
                .errorConstraint(constrain("p3")
                        .withName("c4")
                        .by((Integer p3) -> {
                            return (p3!=2);
                        }))
                .errorConstraint(constrain("p0")
                        .withName("c5")
                        .by((Integer p0) -> {
                            return ( p0!=0 );
                        }))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare1_Repair1(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(3, 1, 2, 1, 6, 1, 3, 1, 2, 1, 2, 1, 5, 1, 2, 1, 2, 1, 2, 1)
                )
                .errorConstraint(constrain("p0", "p1")
                        .withName("c1")
                        .by((Integer p0, Integer p1) -> {
                            return ( p1!=0 || p0!=2) &&
                                    ( p0!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p0", "p5")
                        .withName("c2")
                        .by((Integer p0, Integer p5) -> {
                            return ( p5!=1 || p0!=0);
                        }))
                .errorConstraint(constrain("p2", "p3", "p4")
                        .withName("c3")
                        .by((Integer p2, Integer p3, Integer p4) -> {
                            return  ( p2!=2 || p3!=2 || p4!=0) &&
                                    ( p2!=4 || p3!=1 || p4!=0) &&
                                    ( p3!=2 || p4!=1 || p2!=5) &&
                                    ( p2!=2 || p3!=0 || p4!=1) &&
                                    ( p2!=4 || p3!=0 || p4!=0) &&
                                    ( p2!=2 || p3!=1 || p4!=1) &&
                                    ( p2!=4 || p3!=2 || p4!=0) &&
                                    ( p3!=2 || p4!=1 || p2!=1) &&
                                    ( p2!=0 || p3!=1 || p4!=1) &&
                                    ( p2!=0 || p3!=2 || p4!=1) &&
                                    ( p3!=2 || p4!=0 || p2!=3) &&
                                    ( p3!=0 || p4!=1 || p2!=3) &&
                                    ( p3!=0 || p4!=1 || p2!=5) &&
                                    ( p3!=1 || p4!=1 || p2!=1) &&
                                    ( p3!=0 || p2!=0 || p4!=1) &&
                                    ( p3!=0 || p4!=1 || p2!=1) &&
                                    ( p3!=1 || p4!=1 || p2!=3) &&
                                    ( p3!=1 || p4!=1 || p2!=5);
                        }))
//                .errorConstraint(constrain("p3")
//                        .withName("c4")
//                        .by((Integer p3) -> {
//                            return (p3!=2);
//                        }))
//                .errorConstraint(constrain("p0")
//                        .withName("c5")
//                        .by((Integer p0) -> {
//                            return ( p0!=0 );
//                        }))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare1_Repair2(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(3, 1, 2, 1, 6, 1, 3, 1, 2, 1, 2, 1, 5, 1, 2, 1, 2, 1, 2, 1)
                )
                .errorConstraint(constrain("p0", "p1")
                        .withName("c1")
                        .by((Integer p0, Integer p1) -> {
                            return ( p1!=0 || p0!=2) &&
                                    ( p0!=1 || p1!=0);
                        }))
                .errorConstraint(constrain("p0", "p5")
                        .withName("c2")
                        .by((Integer p0, Integer p5) -> {
                            return ( p5!=1 || p0!=0);
                        }))
                .errorConstraint(constrain("p2", "p3", "p4")
                        .withName("c3")
                        .by((Integer p2, Integer p3, Integer p4) -> {
                            return  //( p2!=2 || p3!=2 || p4!=0) &&
                                    ( p2!=4 || p3!=1 || p4!=0) &&
                                    //( p3!=2 || p4!=1 || p2!=5) &&
                                    ( p2!=2 || p3!=0 || p4!=1) &&
                                    ( p2!=4 || p3!=0 || p4!=0) &&
                                    ( p2!=2 || p3!=1 || p4!=1) &&
                                    //( p2!=4 || p3!=2 || p4!=0) &&
                                    //( p3!=2 || p4!=1 || p2!=1) &&
                                    ( p2!=0 || p3!=1 || p4!=1) &&
                                    //( p2!=0 || p3!=2 || p4!=1) &&
                                    //( p3!=2 || p4!=0 || p2!=3) &&
                                    ( p3!=0 || p4!=1 || p2!=3) &&
                                    ( p3!=0 || p4!=1 || p2!=5) &&
                                    ( p3!=1 || p4!=1 || p2!=1) &&
                                    ( p3!=0 || p2!=0 || p4!=1) &&
                                    ( p3!=0 || p4!=1 || p2!=1) &&
                                    ( p3!=1 || p4!=1 || p2!=3) &&
                                    ( p3!=1 || p4!=1 || p2!=5);
                        }))
                .errorConstraint(constrain("p3")
                        .withName("c4")
                        .by((Integer p3) -> {
                            return (p3!=2);
                        }))
//                .errorConstraint(constrain("p0")
//                        .withName("c5")
//                        .by((Integer p0) -> {
//                            return ( p0!=0 );
//                        }))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare1_Repair3(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(3, 1, 2, 1, 6, 1, 3, 1, 2, 1, 2, 1, 5, 1, 2, 1, 2, 1, 2, 1)
                )
                .errorConstraint(constrain("p0", "p1")
                        .withName("c1")
                        .by((Integer p0, Integer p1) -> {
                            return ( p1!=0 || p0!=2) &&
                                    ( p0!=1 || p1!=0);
                        }))
//                .errorConstraint(constrain("p0", "p5")
//                        .withName("c2")
//                        .by((Integer p0, Integer p5) -> {
//                            return ( p5!=1 || p0!=0);
//                        }))
                .errorConstraint(constrain("p2", "p3", "p4")
                        .withName("c3")
                        .by((Integer p2, Integer p3, Integer p4) -> {
                            return  ( p2!=2 || p3!=2 || p4!=0) &&
                                    ( p2!=4 || p3!=1 || p4!=0) &&
                                    ( p3!=2 || p4!=1 || p2!=5) &&
                                    ( p2!=2 || p3!=0 || p4!=1) &&
                                    ( p2!=4 || p3!=0 || p4!=0) &&
                                    ( p2!=2 || p3!=1 || p4!=1) &&
                                    ( p2!=4 || p3!=2 || p4!=0) &&
                                    ( p3!=2 || p4!=1 || p2!=1) &&
                                    ( p2!=0 || p3!=1 || p4!=1) &&
                                    ( p2!=0 || p3!=2 || p4!=1) &&
                                    ( p3!=2 || p4!=0 || p2!=3) &&
                                    ( p3!=0 || p4!=1 || p2!=3) &&
                                    ( p3!=0 || p4!=1 || p2!=5) &&
                                    ( p3!=1 || p4!=1 || p2!=1) &&
                                    ( p3!=0 || p2!=0 || p4!=1) &&
                                    ( p3!=0 || p4!=1 || p2!=1) &&
                                    ( p3!=1 || p4!=1 || p2!=3) &&
                                    ( p3!=1 || p4!=1 || p2!=5);
                        }))
//                .errorConstraint(constrain("p3")
//                        .withName("c4")
//                        .by((Integer p3) -> {
//                            return (p3!=2);
//                        }))
                .errorConstraint(constrain("p0")
                        .withName("c5")
                        .by((Integer p0) -> {
                            return ( p0!=0 );
                        }))
                .build();
    }

    public static InputParameterModel buildModel_HealthCare1_Repair4(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        parameters(3, 1, 2, 1, 6, 1, 3, 1, 2, 1, 2, 1, 5, 1, 2, 1, 2, 1, 2, 1)
                )
                .errorConstraint(constrain("p0", "p1")
                        .withName("c1")
                        .by((Integer p0, Integer p1) -> {
                            return ( p1!=0 || p0!=2) &&
                                    ( p0!=1 || p1!=0);
                        }))
//                .errorConstraint(constrain("p0", "p5")
//                        .withName("c2")
//                        .by((Integer p0, Integer p5) -> {
//                            return ( p5!=1 || p0!=0);
//                        }))
                .errorConstraint(constrain("p2", "p3", "p4")
                        .withName("c3")
                        .by((Integer p2, Integer p3, Integer p4) -> {

                            if(p2==0 && p4==1 && p3==2) return true; //} from Constraint {name=c3, parameterNames=(p2, p3, p4)}.
                            if(p2==1 && p4==1 && p3==2) return true; //} from Constraint {name=c3, parameterNames=(p2, p3, p4)}.
                            if(p2==2 && p4==0 && p3==2) return true; //} from Constraint {name=c3, parameterNames=(p2, p3, p4)}.
                            if(p2==3 && p4==0 && p3==2) return true; //} from Constraint {name=c3, parameterNames=(p2, p3, p4)}.
                            if(p2==4 && p4==0 && p3==2) return true; //} from Constraint {name=c3, parameterNames=(p2, p3, p4)}.
                            if(p2==5 && p4==1 && p3==2) return true; //} from Constraint {name=c3, parameterNames=(p2, p3, p4)}.

                            return  ( p2!=2 || p3!=2 || p4!=0) &&
                                    ( p2!=4 || p3!=1 || p4!=0) &&
                                    ( p3!=2 || p4!=1 || p2!=5) &&
                                    ( p2!=2 || p3!=0 || p4!=1) &&
                                    ( p2!=4 || p3!=0 || p4!=0) &&
                                    ( p2!=2 || p3!=1 || p4!=1) &&
                                    ( p2!=4 || p3!=2 || p4!=0) &&
                                    ( p3!=2 || p4!=1 || p2!=1) &&
                                    ( p2!=0 || p3!=1 || p4!=1) &&
                                    ( p2!=0 || p3!=2 || p4!=1) &&
                                    ( p3!=2 || p4!=0 || p2!=3) &&
                                    ( p3!=0 || p4!=1 || p2!=3) &&
                                    ( p3!=0 || p4!=1 || p2!=5) &&
                                    ( p3!=1 || p4!=1 || p2!=1) &&
                                    ( p3!=0 || p2!=0 || p4!=1) &&
                                    ( p3!=0 || p4!=1 || p2!=1) &&
                                    ( p3!=1 || p4!=1 || p2!=3) &&
                                    ( p3!=1 || p4!=1 || p2!=5);
                        }))
                .errorConstraint(constrain("p3")
                        .withName("c4")
                        .by((Integer p3) -> {
                            return (p3!=2);
                        }))
                .errorConstraint(constrain("p0")
                        .withName("c5")
                        .by((Integer p0) -> {
                            return ( p0!=0 );
                        }))
                .build();
    }

}
