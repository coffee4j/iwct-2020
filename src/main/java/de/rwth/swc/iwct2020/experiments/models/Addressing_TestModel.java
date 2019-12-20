package de.rwth.swc.iwct2020.experiments.models;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.iwct2020.experiments.util.ParametersFactory;

import static de.rwth.swc.iwct2020.experiments.util.ConstraintsHelper.implies;
import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;

public class Addressing_TestModel {

    public static InputParameterModel buildModel_Addressing_Correct(int strength) {
        return inputParameterModel("")
            .strength(strength)
            .parameters(
                ParametersFactory.parameters(3, 3)
            )
            .errorConstraint(constrain("p0").withName("c1")
                    .by((Integer title) -> title != 2))
            .errorConstraint(constrain("p1").withName("c2")
                    .by((Integer given) -> given != 2))
            .errorConstraint(constrain("p2").withName("c3")
                    .by((Integer family) -> family != 2))
            .errorConstraint(constrain("p0", "p1").withName("c4")
                    .by((Integer title, Integer given) -> implies(() -> title == 0, () -> given != 1)))
            .errorConstraint(constrain("p0", "p1").withName("c5")
                    .by((Integer title, Integer given) -> implies(() -> title == 1, () -> given != 0)))
            .build();
    }

    public static InputParameterModel buildModel_Addressing_Incorrect(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        ParametersFactory.parameters(3, 3)
                )
                .errorConstraint(constrain("p0").withName("c1")
                        .by((Integer title) -> title != 2))
                .errorConstraint(constrain("p1").withName("c2")
                        .by((Integer given) -> given != 2))
                .errorConstraint(constrain("p2").withName("c3")
                        .by((Integer family) -> family != 2))
                .errorConstraint(constrain("p0", "p1").withName("c4")
                        .by((Integer title, Integer given) -> implies(() -> title == 0, () -> given == 0)))
                .errorConstraint(constrain("p0", "p1").withName("c5")
                        .by((Integer title, Integer given) -> implies(() -> title == 1, () -> given == 1)))
                .build();
    }

    public static InputParameterModel buildModel_Addressing_Repair1(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        ParametersFactory.parameters(3, 3)
                )
                .errorConstraint(constrain("p0").withName("c1")
                        .by((Integer title) -> title != 2))
                //.errorConstraint(constrain("p1").withName("c2")
                //        .by((Integer given) -> given != 2))
                .errorConstraint(constrain("p2").withName("c3")
                        .by((Integer family) -> family != 2))
                .errorConstraint(constrain("p0", "p1").withName("c4")
                        .by((Integer title, Integer given) -> implies(() -> title == 0, () -> given == 0)))
                .errorConstraint(constrain("p0", "p1").withName("c5")
                        .by((Integer title, Integer given) -> implies(() -> title == 1, () -> given == 1)))
                .build();
    }

    public static InputParameterModel buildModel_Addressing_Repair2(int strength) {
        return inputParameterModel("")
                .strength(strength)
                .parameters(
                        ParametersFactory.parameters(3, 3)
                )
                .errorConstraint(constrain("p0").withName("c1")
                        .by((Integer title) -> title != 2))
                .errorConstraint(constrain("p1").withName("c2")
                        .by((Integer given) -> given != 2))
                .errorConstraint(constrain("p2").withName("c3")
                        .by((Integer family) -> family != 2))
                .errorConstraint(constrain("p0", "p1").withName("c4")
                        .by((Integer title, Integer given) -> implies(() -> title == 0, () -> given != 1)))
                .errorConstraint(constrain("p0", "p1").withName("c5")
                        .by((Integer title, Integer given) -> implies(() -> title == 1, () -> given != 0)))
                .build();
    }
}
