package eu.pmav.pxp0p.frameconfiguration.impl;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.frameconfiguration.FrameConfigurationGenerator;
import eu.pmav.pxp0p.utils.Utils;

import java.util.Collections;
import java.util.List;

public class CuidadoComOCaoFrameConfigurationGenerator extends FrameConfigurationGenerator
{
    public List<FrameConfiguration> generateConfigurations() throws Exception
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

        // Change direction (triangles and semicircles only)
        //FrameConfiguration.IntFunction directionFunction = (frameIndex) -> Utils.getRandomInt(4);
        FrameConfiguration.IntFunction directionFunction = (frameIndex) -> 2;
        frameConfigurations = applyParameter(frameConfigurations, List.of(directionFunction), (c, v) -> c.setDirectionFunction((FrameConfiguration.IntFunction) v));

        // Object Colors
        //configurations = applyParameter(configurations, List.of(new int[]{colorWhite}), (c, v) -> c.setColorsCircle((int[]) v));
        //configurations = applyParameter(configurations, List.of(new int[]{colorWhite}), (c, v) -> c.setColorsSquare((int[]) v));
        //configurations = applyParameter(configurations, List.of(new int[]{colorWhite}), (c, v) -> c.setColorsTriangle((int[]) v));

        // Size Transform
        FrameConfiguration.FloatFunction sizeTransformFunction = (frameIndex) -> Utils.getRandomFloat(1.0f, 2.5f);
        frameConfigurations = applyParameter(frameConfigurations, List.of(sizeTransformFunction), (c, v) -> c.setSizeTransformFunction((FrameConfiguration.FloatFunction) v));

        // Alpha
        FrameConfiguration.IntFunction alphaFunction = (frameIndex) -> (int) Utils.getRandomFloat(0, 150);
        frameConfigurations = applyParameter(frameConfigurations, List.of(alphaFunction), (c, v) -> c.setAlphaFunction((FrameConfiguration.IntFunction) v));

        // Variation
        FrameConfiguration.IntFunction xVariationFunction = (v) -> 0;
        frameConfigurations = applyParameter(frameConfigurations, List.of(xVariationFunction), (c, v) -> c.setxVariationFunction((FrameConfiguration.IntFunction) v));

        FrameConfiguration.IntFunction yVariationFunction = (v) -> 0;
        frameConfigurations = applyParameter(frameConfigurations, List.of(yVariationFunction), (c, v) -> c.setyVariationFunction((FrameConfiguration.IntFunction) v));

        // Stroke
        frameConfigurations = applyParameter(frameConfigurations, List.of(false), (c, v) -> c.setStroke((boolean) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(16), (c, v) -> c.setStrokeSize((int) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(colorWhite), (c, v) -> c.setStrokeColor((int) v));

        // Center Object
        frameConfigurations = applyParameter(frameConfigurations, List.of(false), (c, v) -> c.setCenterObject((boolean) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0.6f), (c, v) -> c.setCenterObjectSize((float) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCenterObject((int[]) v));

        // Cuts
        frameConfigurations = applyParameter(frameConfigurations, List.of(true), (c, v) -> c.setCuts((boolean) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0.4f), (c, v) -> c.setCutSize((float) v));

        frameConfigurations = applyParameter(frameConfigurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCutCircle((int[]) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCutSquare((int[]) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCutTriangle((int[]) v));

        System.out.printf("Generated %s configurations...%n", frameConfigurations.size());

        return frameConfigurations;
    }
}
