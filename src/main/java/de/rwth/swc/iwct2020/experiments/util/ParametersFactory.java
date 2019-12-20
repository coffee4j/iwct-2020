package de.rwth.swc.iwct2020.experiments.util;

import de.rwth.swc.coffee4j.engine.util.Preconditions;
import de.rwth.swc.coffee4j.model.Parameter;

import java.util.*;

import static de.rwth.swc.coffee4j.model.Parameter.parameter;

public class ParametersFactory {
    
    private ParametersFactory() {
    }

    public static Parameter[] parameters(int... configuration) {
        Preconditions.check(configuration.length % 2 == 0);

        int counter = 0;

        final List<Parameter> parameters = new ArrayList<>();

        for(int i = 0; i < configuration.length; i += 2) {
            final int valueSize = configuration[i];
            final int parameterSize = configuration[i + 1];

            final List<Object> values = new LinkedList<Object>();
            for (int v = 0; v < valueSize; v++) {
                values.add(v);
            }

            for(int j = 0; j < parameterSize; j++) {
                parameters.add(parameter("p" + counter++)
                        .values(values.toArray(new Object[0]))
                        .build());
            }
        }

        return parameters.toArray(new Parameter[0]);
    }
}
