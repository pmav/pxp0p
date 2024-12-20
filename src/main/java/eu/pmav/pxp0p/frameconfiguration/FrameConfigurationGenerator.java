package eu.pmav.pxp0p.frameconfiguration;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public abstract class FrameConfigurationGenerator
{
    protected abstract List<FrameConfiguration> generateConfigurationsInternal() throws Exception;

    public List<FrameConfiguration> generateConfigurations() throws Exception
    {
        List<FrameConfiguration> frameConfigurations = this.generateConfigurationsInternal();

        frameConfigurations.forEach(fc -> {
            // Size of the object in the grid
            final int objectSizeInGrid = Math.min(fc.getGridWidth() / fc.getObjectColumns(), fc.getGridHeight() / fc.getObjectLines());

            // Actual object size, if spacing is zero the objects will fill the grid
            fc.setSize(objectSizeInGrid - fc.getObjectSpacing());
        });

        return frameConfigurations;
    }

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
