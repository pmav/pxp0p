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
        List<FrameConfiguration> fc = Collections.singletonList(new FrameConfiguration(this.getClass().getSimpleName()));

        // Canvas and grid
        fc = applyParameter(fc, List.of(1000), (c, v) -> c.setCanvasWidth((int) v));
        fc = applyParameter(fc, List.of(1000), (c, v) -> c.setCanvasHeight((int) v));

        fc = applyParameter(fc, List.of(800), (c, v) -> c.setGridWidth((int) v));
        fc = applyParameter(fc, List.of(800), (c, v) -> c.setGridHeight((int) v));

        // Layout
        fc = applyParameter(fc, List.of(5), (c, v) -> c.setObjectColumns((int) v));
        fc = applyParameter(fc, List.of(1), (c, v) -> c.setObjectLines((int) v));
        fc = applyParameter(fc, List.of(8), (c, v) -> c.setObjectSpacing((int) v));

        fc = applyParameter(fc, colorsBackground, (c, v) -> c.setColorBackground((int) v));
        fc = applyParameter(fc, List.of(0.6f), (c, v) -> c.setBlurValue((float) v));

        List<FormType> l1 = List.of(FormType.CIRCLE);
        fc = applyParameter(fc, List.of(l1), (c, v) -> c.setFormTypes((List<FormType>) v));

        // Object Colors
        fc = applyParameter(fc, List.of(colorsOlympics), (c, v) -> c.addColorsForm(FormType.CIRCLE, (int[]) v));

        // Size
        FrameConfiguration.FloatFunction sizeTransformFunction = (frameIndex) -> Utils.getRandomFloat(1.0f, 2.5f);
        fc = applyParameter(fc, List.of(sizeTransformFunction), (c, v) -> c.setSizeTransformFunction((FrameConfiguration.FloatFunction) v));

        // Alpha
        FrameConfiguration.IntFunction alphaFunction = (frameIndex) -> (int) Utils.getRandomFloat(0, 150);
        fc = applyParameter(fc, List.of(alphaFunction), (c, v) -> c.setAlphaFunction((FrameConfiguration.IntFunction) v));

        // Variation
        FrameConfiguration.IntFunction xVariationFunction = (v) -> 0;
        fc = applyParameter(fc, List.of(xVariationFunction), (c, v) -> c.setxVariationFunction((FrameConfiguration.IntFunction) v));

        FrameConfiguration.IntFunction yVariationFunction = (v) -> 0;
        fc = applyParameter(fc, List.of(yVariationFunction), (c, v) -> c.setyVariationFunction((FrameConfiguration.IntFunction) v));

        // Stroke
        fc = applyParameter(fc, List.of(true), (c, v) -> c.setStroke((boolean) v));
        fc = applyParameter(fc, List.of(8, 16), (c, v) -> c.setStrokeSize((int) v));
        fc = applyParameter(fc, colorsStroke, (c, v) -> c.setStrokeColor((int) v));

        // Center Object
        fc = applyParameter(fc, List.of(true, false), (c, v) -> c.setCenterObject((boolean) v));
        fc = applyParameter(fc, List.of(0.7f), (c, v) -> c.setCenterObjectSize((float) v));
        fc = applyParameter(fc, List.of(colorsWhite), (c, v) -> c.setColorsCenterObject((int[]) v));

        // Cuts
        fc = applyParameter(fc, List.of(true, false), (c, v) -> c.setCuts((boolean) v));
        fc = applyParameter(fc, List.of(0.8f), (c, v) -> c.setCutSize((float) v));

        fc = applyParameter(fc, List.of(colorsOlympics), (c, v) -> c.setColorsCutCircle((int[]) v));
        fc = applyParameter(fc, List.of(colorsOlympics), (c, v) -> c.setColorsCutSquare((int[]) v));
        fc = applyParameter(fc, List.of(colorsOlympics), (c, v) -> c.setColorsCutTriangle((int[]) v));

        // Blur value
        fc = applyParameter(fc, List.of(0.6f), (c, v) -> c.setBlurValue((float) v));

        System.out.printf("Generated %s configurations...%n", fc.size());
        fc.forEach(c -> System.out.printf(c.toString()));

        return fc;
    }
}
