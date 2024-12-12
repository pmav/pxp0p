package eu.pmav.pxp0p.configuration.manual;

import eu.pmav.pxp0p.configuration.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public abstract class ManualGenerator
{
    public abstract List<Configuration> generateConfigurations() throws IOException, ClassNotFoundException;

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

                newConfigurations.add(newConfiguration);
            }
        }

        return newConfigurations;
    }
}
