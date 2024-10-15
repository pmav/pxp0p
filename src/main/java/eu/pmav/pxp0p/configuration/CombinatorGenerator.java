package eu.pmav.pxp0p.configuration;

import eu.pmav.pxp0p.app.model.Configuration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public abstract class CombinatorGenerator
{

    protected static List<Configuration> applyParameter(List<Configuration> configurations, List<Object> parameterValues, BiConsumer<Configuration, Object> c) throws IOException, ClassNotFoundException
    {
        List<Configuration> newConfigurations = new ArrayList<>();

        for (Configuration configuration : configurations)
        {
            for (Object parameterValue : parameterValues)
            {
                Configuration newConfiguration = configuration.copy();

                // Update parameter
                c.accept(newConfiguration, parameterValue);

                // Compute initial conditions for each configuration
                newConfiguration.calculate();

                newConfigurations.add(newConfiguration);
            }
        }

        return newConfigurations;
    }
}
