package de.rwth.swc.iwct2020.experiments.util;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.coffee4j.model.Parameter;
import de.rwth.swc.coffee4j.model.Value;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.MathArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InputParameterModelUtil {

    private InputParameterModelUtil() {
    }

    public static InputParameterModel shuffle(InputParameterModel model) {
        final RandomGenerator randomGenerator = new Well19937c();

        return shuffle(model, randomGenerator);
    }

    public static InputParameterModel shuffle(InputParameterModel model, int seed) {
        if(seed == 0) {
            return model;
        }

        final RandomGenerator randomGenerator = new Well19937c(seed);

        return shuffle(model, randomGenerator);
    }

    private static InputParameterModel shuffle(InputParameterModel model, RandomGenerator randomGenerator) {
        final int[] parameterOrder = createRandomOrder(model.getParameters().size(), randomGenerator);

        final List<Parameter> parameters = new ArrayList<>();

        for (final int parameterIndex : parameterOrder) {
            final Parameter parameter = model.getParameters().get(parameterIndex);

            parameters.add(cloneAndShuffle(parameter, randomGenerator));
        }

        return new InputParameterModel(model.getStrength(), model.getName(), parameters,
                model.getExclusionConstraints(), model.getErrorConstraints());
    }

    private static Parameter cloneAndShuffle(Parameter parameter, RandomGenerator randomGenerator) {
        final List<Value> shuffledValues = new ArrayList<>(parameter.getValues().size());
        final int[] valueOrder = createRandomOrder(parameter.getValues().size(), randomGenerator);

        for (final int valueIndex : valueOrder) {
            final Value value = parameter.getValues().get(valueIndex);

            shuffledValues.add(value);
        }

        return new Parameter(parameter.getName(), shuffledValues);
    }

    private static int[] createRandomOrder(int elements, RandomGenerator randomGenerator) {
        int[] indices  = IntStream.range(0, elements).toArray();
        MathArrays.shuffle(indices, randomGenerator);

        return indices;
    }
}
