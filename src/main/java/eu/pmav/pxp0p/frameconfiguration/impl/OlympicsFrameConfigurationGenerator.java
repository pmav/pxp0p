package eu.pmav.pxp0p.frameconfiguration.impl;

import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.frameconfiguration.FrameConfigurationGenerator;
import eu.pmav.pxp0p.utils.Utils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class OlympicsFrameConfigurationGenerator extends FrameConfigurationGenerator
{
    public List<FrameConfiguration> generateConfigurations() throws Exception
    {
        // Set colors
        int colorWhite = 0xffDCDCDC;
        int colorBlack = 0xff101010;

        int[] colorsBlack = {colorBlack};
        int[] colorsWhite = {colorWhite};

        int[] colorsOlympics = {0xff0085c7, 0xfff4c300, 0xff000000, 0xff009f3d, 0xffdf0024};


        List<Object> colorsStroke = List.of(colorBlack);
        List<Object> colorsBackground = List.of(colorWhite);

        // Initial configuration
        List<FrameConfiguration> frameConfigurations = Collections.singletonList(new FrameConfiguration());

        // Layout
        frameConfigurations = applyParameter(frameConfigurations, List.of(5), (c, v) -> c.setObjectColumns((int) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(1), (c, v) -> c.setObjectLines((int) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(8), (c, v) -> c.setObjectSpacing((int) v));

        frameConfigurations = applyParameter(frameConfigurations, colorsBackground, (c, v) -> c.setColorBackground((int) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0.6f), (c, v) -> c.setBlurValue((float) v));
        frameConfigurations = applyParameter(frameConfigurations, Collections.singletonList(Set.of(FormType.CIRCLE)), (c, v) -> c.setFormTypes((List<Set<FormType>>) v));

        // Object Colors
        //configurations = applyParameter(configurations, List.of(colorsOlympics), (c, v) -> c.setColorsCircle((int[]) v));
        //configurations = applyParameter(configurations, List.of(colorsOlympics), (c, v) -> c.setColorsSquare((int[]) v));
        //configurations = applyParameter(configurations, List.of(colorsOlympics), (c, v) -> c.setColorsTriangle((int[]) v));

        // Size
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
        frameConfigurations = applyParameter(frameConfigurations, List.of(true), (c, v) -> c.setStroke((boolean) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(8, 16), (c, v) -> c.setStrokeSize((int) v));
        frameConfigurations = applyParameter(frameConfigurations, colorsStroke, (c, v) -> c.setStrokeColor((int) v));

        // Center Object
        frameConfigurations = applyParameter(frameConfigurations, List.of(true, false), (c, v) -> c.setCenterObject((boolean) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0.7f), (c, v) -> c.setCenterObjectSize((float) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(colorsWhite), (c, v) -> c.setColorsCenterObject((int[]) v));

        // Cuts
        frameConfigurations = applyParameter(frameConfigurations, List.of(true, false), (c, v) -> c.setCuts((boolean) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(0.8f), (c, v) -> c.setCutSize((float) v));

        frameConfigurations = applyParameter(frameConfigurations, List.of(colorsOlympics), (c, v) -> c.setColorsCutCircle((int[]) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(colorsOlympics), (c, v) -> c.setColorsCutSquare((int[]) v));
        frameConfigurations = applyParameter(frameConfigurations, List.of(colorsOlympics), (c, v) -> c.setColorsCutTriangle((int[]) v));

        System.out.printf("Generated %s configurations...%n", frameConfigurations.size());

        return frameConfigurations;
    }
}
