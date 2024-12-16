package eu.pmav.pxp0p.frameconfiguration.manual.impl;

import eu.pmav.pxp0p.frameconfiguration.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.frameconfiguration.helpers.SerializableFunction;
import eu.pmav.pxp0p.frameconfiguration.manual.FrameConfigurationGenerator;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class CuidadoComOCaoFrameConfigurationGenerator extends FrameConfigurationGenerator
{
    protected List<FrameConfiguration> generateConfigurationsInternal() throws Exception
    {
        // Set colors
        int colorYellow = 0xffFFD742;
        int colorCyan = 0xff01ACB7;
        int colorWhite = 0xffFEFCFE;

        // Initial configuration
        List<FrameConfiguration> frameConfigurations = Collections.singletonList(new FrameConfiguration());

        // Layout
        frameConfigurations = applyParameter(frameConfigurations, List.of(1), (c, v) -> c.setObjectColumns((int) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(1), (c, v) -> c.setObjectLines((int) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0), (c, v) -> c.setObjectSpacing((int) v));

        frameConfigurations = applyParameter(frameConfigurations, List.of(colorCyan), (c, v) -> c.setColorBackground((int) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0.6f), (c, v) -> c.setBlurValue((float) v));
        frameConfigurations = applyParameter(frameConfigurations, Collections.singletonList(new FormType[]{FormType.SQUARE}), (c, v) -> c.setObjectTypes((FormType[]) v));

        // Direction
        frameConfigurations = applyParameter(frameConfigurations, List.of(true), (c, v) -> c.setHaveDirection((boolean) v));
        SerializableFunction<Integer, Integer> f = (Integer i) ->
        {
            return 1;
        };
        frameConfigurations = applyParameter(frameConfigurations, List.of(f), (c, v) -> c.setCalculateDirection((Function<Integer, Integer>) v));

        // Object Colors
        //configurations = applyParameter(configurations, List.of(new int[]{colorWhite}), (c, v) -> c.setColorsCircle((int[]) v));
        //configurations = applyParameter(configurations, List.of(new int[]{colorWhite}), (c, v) -> c.setColorsSquare((int[]) v));
        //configurations = applyParameter(configurations, List.of(new int[]{colorWhite}), (c, v) -> c.setColorsTriangle((int[]) v));

        // Size Transform
        frameConfigurations = applyParameter(frameConfigurations, List.of(true), (c, v) -> c.setHaveSizeTransform((boolean) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0.5f), (c, v) -> c.setMinSizeTransform((float) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0.5f), (c, v) -> c.setMaxSizeTransform((float) v));

        // Alpha
        frameConfigurations = applyParameter(frameConfigurations, List.of(false), (c, v) -> c.setHaveAlpha((boolean) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0), (c, v) -> c.setMinAlpha((int) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(150), (c, v) -> c.setMaxAlpha((int) v));

        // Variation
        frameConfigurations = applyParameter(frameConfigurations, List.of(0), (c, v) -> c.setxVariation((int) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0), (c, v) -> c.setyVariation((int) v));

        // Stroke
        frameConfigurations = applyParameter(frameConfigurations, List.of(false), (c, v) -> c.setHaveStroke((boolean) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(16), (c, v) -> c.setStrokeSize((int) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(colorWhite), (c, v) -> c.setStrokeColor((int) v));

        // Center Object
        frameConfigurations = applyParameter(frameConfigurations, List.of(false), (c, v) -> c.setHaveCenterObject((boolean) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0.6f), (c, v) -> c.setCenterObjectSize((float) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCenterObject((int[]) v));

        // Cuts
        frameConfigurations = applyParameter(frameConfigurations, List.of(true), (c, v) -> c.setHaveCuts((boolean) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0.4f), (c, v) -> c.setCutSize((float) v));

        frameConfigurations = applyParameter(frameConfigurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCutCircle((int[]) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCutSquare((int[]) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCutTriangle((int[]) v));

        System.out.printf("Generated %s configurations...%n", frameConfigurations.size());

        return frameConfigurations;
    }
}
