package eu.pmav.pxp0p.frameconfiguration.impl;

import eu.pmav.pxp0p.frameconfiguration.FrameConfigurationGenerator;
import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.utils.Utils;

import java.util.Collections;
import java.util.List;

public class SemiCircleFrameConfigurationGenerator extends FrameConfigurationGenerator
{
    public List<FrameConfiguration> generateConfigurations() throws Exception {
        // Set colors
        int colorWhite = 0xffDCDCDC;
        int colorBlack = 0xff101010;

        int[] colorsRainbow = {0xff9400D3, 0xff4B0082, 0xff0000FF, 0xff00FF00, 0xffFFFF00, 0xffFF7F00, 0xffFF0000};
        int[] colorsGrey = {0xffDCDCDC, 0xffD3D3D3, 0xffC0C0C0, 0xffA9A9A9, 0xff808080, 0xff696969, 0xff778899, 0xff708090, 0xff2F4F4F, 0xff000000};

        List<Object> colorsStroke = List.of(colorBlack);
        List<Object> colorsBackground = List.of(colorBlack);

        // Initial configuration
        List<FrameConfiguration> fc = Collections.singletonList(new FrameConfiguration());

        // Canvas and grid
        fc = applyParameter(fc, List.of(1000), (c, v) -> c.setCanvasWidth((int) v));
        fc = applyParameter(fc, List.of(1000), (c, v) -> c.setCanvasHeight((int) v));

        fc = applyParameter(fc, List.of(800), (c, v) -> c.setGridWidth((int) v));
        fc = applyParameter(fc, List.of(800), (c, v) -> c.setGridHeight((int) v));

        // Layout
        fc = applyParameter(fc, List.of(12), (c, v) -> c.setObjectColumns((int) v));
        fc = applyParameter(fc, List.of(4), (c, v) -> c.setObjectLines((int) v));
        fc = applyParameter(fc, List.of(8), (c, v) -> c.setObjectSpacing((int) v));

        // Background color
        fc = applyParameter(fc, colorsBackground, (c, v) -> c.setColorBackground((int) v));

        // Blur value
        fc = applyParameter(fc, List.of(0.6f), (c, v) -> c.setBlurValue((float) v));

        // Object and colors
        List<FormType> l1 = List.of(FormType.SEMICIRCLE);

        fc = applyParameter(fc, List.of(l1), (c, v) -> c.setFormTypes((List<FormType>) v));
        fc = applyParameter(fc, List.of(colorsGrey, colorsRainbow), (c, v) -> c.addColorsForm(FormType.SEMICIRCLE, (int[]) v));

        // Size
        FrameConfiguration.FloatFunction sizeTransformFunction = (frameIndex) -> 1.8f; // Utils.getRandomFloat(1.0f, 1.2f)
        fc = applyParameter(fc, List.of(sizeTransformFunction), (c, v) -> c.setSizeTransformFunction((FrameConfiguration.FloatFunction) v));

        // Rotation
        //FrameConfiguration.FloatFunction rotationFunction = (frameIndex) -> 1f * frameIndex;
        //fc = applyParameter(fc, List.of(rotationFunction), (c, v) -> c.setRotateFunction((FrameConfiguration.FloatFunction) v));

        // Alpha
        FrameConfiguration.IntFunction alphaFunction1 = (frameIndex) -> (int) Utils.getRandomFloat(0, 150);
        FrameConfiguration.IntFunction alphaFunction2 = (frameIndex) -> 255;
        fc = applyParameter(fc, List.of(alphaFunction1, alphaFunction2), (c, v) -> c.setAlphaFunction((FrameConfiguration.IntFunction) v));

        // Variation (0 means no variation on the x,y position of the object)
        FrameConfiguration.IntFunction xVariationFunction = (frameIndex) -> 0; // Math.round((Utils.getRandomFloat(-1, 1) * ))
        fc = applyParameter(fc, List.of(xVariationFunction), (c, v) -> c.setxVariationFunction((FrameConfiguration.IntFunction) v));

        FrameConfiguration.IntFunction yVariationFunction = (frameIndex) -> 0;
        fc = applyParameter(fc, List.of(yVariationFunction), (c, v) -> c.setyVariationFunction((FrameConfiguration.IntFunction) v));

        // Stroke
        fc = applyParameter(fc, List.of(true, false), (c, v) -> c.setStroke((boolean) v));
        fc = applyParameter(fc, List.of(2, 4, 8), (c, v) -> c.setStrokeSize((int) v));
        fc = applyParameter(fc, colorsStroke, (c, v) -> c.setStrokeColor((int) v));

        // Center Object
        fc = applyParameter(fc, List.of(true), (c, v) -> c.setCenterObject((boolean) v));
        fc = applyParameter(fc, List.of(0.6f), (c, v) -> c.setCenterObjectSize((float) v));
        fc = applyParameter(fc, List.of(colorsGrey, colorsRainbow), (c, v) -> c.setColorsCenterObject((int[]) v));

        // Direction (triangles and semicircles only)
        FrameConfiguration.IntFunction directionFunction = (frameIndex) -> 2; // Utils.getRandomInt(4)
        fc = applyParameter(fc, List.of(directionFunction), (c, v) -> c.setDirectionFunction((FrameConfiguration.IntFunction) v));

        System.out.printf("Generated %s Frame configurations...%n", fc.size());
        fc.forEach(c -> System.out.printf(c.toString()));

        return fc;
    }
}
