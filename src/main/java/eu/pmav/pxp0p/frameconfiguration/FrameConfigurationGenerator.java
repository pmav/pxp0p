package eu.pmav.pxp0p.frameconfiguration;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public abstract class FrameConfigurationGenerator
{
    public abstract List<FrameConfiguration> generateConfigurations() throws Exception;

    protected static List<FrameConfiguration> applyParameter(List<FrameConfiguration> frameConfigurations, List<Object> parameterValues, BiConsumer<FrameConfiguration, Object> c) throws Exception
    {
        List<FrameConfiguration> newFrameConfigurations = new ArrayList<>();

        for (FrameConfiguration frameConfiguration : frameConfigurations)
        {
            for (Object parameterValue : parameterValues)
            {
                FrameConfiguration newFrameConfiguration = frameConfiguration.copy();

                // Update parameter
                c.accept(newFrameConfiguration, parameterValue);

                newFrameConfigurations.add(newFrameConfiguration);
            }
        }

        return newFrameConfigurations;
    }
}
