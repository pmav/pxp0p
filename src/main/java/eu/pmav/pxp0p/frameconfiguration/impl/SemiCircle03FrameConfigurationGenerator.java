package eu.pmav.pxp0p.frameconfiguration.impl;

import eu.pmav.pxp0p.frameconfiguration.FrameConfigurationGenerator;
import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.utils.Utils;

import java.util.Collections;
import java.util.List;

public class SemiCircle03FrameConfigurationGenerator extends FrameConfigurationGenerator
{
    private final String ID = "Semi_Circle_tests";

    public List<FrameConfiguration> generateConfigurations() throws Exception {
        // Set colors
        int colorWhite = 0xffDCDCDC;
        int colorBlack = 0xff101010;

        // Rainbow
        //int[] formColors = {0xff9400D3, 0xff4B0082, 0xff0000FF, 0xff00FF00, 0xffFFFF00, 0xffFF7F00, 0xffFF0000};

        // Grey
        //int[] formColors = {0xffDCDCDC, 0xffD3D3D3, 0xffC0C0C0, 0xffA9A9A9, 0xff808080, 0xff696969, 0xff778899, 0xff708090, 0xff2F4F4F, 0xff000000};

        //int[] formColors = {0xffDCDCDC};

        // colorsBasePale
        // int[] formColors = {0xffB30000, 0xff5199FF, 0xffFFEB7F};

        // colorsBlue
        // int[] formColors = {0xff5199FF, 0xff1771F1, 0xff0260E8, 0xff0351C1, 0xff0043A4, 0xff002D6D, 0xff052555, 0xff01142F};

        // colorsRedStrong
        // int[] formColors = {0xffFF0000, 0xffBC0022, 0xffB40A1B, 0xffE20338, 0xffB30000};

        // colorsBeige
        //int[] formColors = {0xffFFC46B, 0xffFFAF50, 0xffFFAD32, 0xffDF8600, 0xffFE634E, 0xffF39629};

        // watermelon
        int[] formColors = {0xffFD9F9A, 0xffED6665, 0xffBBC877, 0xff899853};

        List<Object> colorsStroke = List.of(colorBlack);
        List<Object> colorsBackground = List.of(colorBlack);

        // Initial configuration
        List<FrameConfiguration> fc = Collections.singletonList(new FrameConfiguration(ID));

        // Canvas and grid
        fc = applyParameter(fc, List.of(1000), (c, v) -> c.setCanvasWidth((int) v));
        fc = applyParameter(fc, List.of(1000), (c, v) -> c.setCanvasHeight((int) v));

        fc = applyParameter(fc, List.of(800), (c, v) -> c.setGridWidth((int) v));
        fc = applyParameter(fc, List.of(800), (c, v) -> c.setGridHeight((int) v));

        // Layout
        fc = applyParameter(fc, List.of(6), (c, v) -> c.setObjectColumns((int) v));
        fc = applyParameter(fc, List.of(6), (c, v) -> c.setObjectLines((int) v));
        fc = applyParameter(fc, List.of(0), (c, v) -> c.setObjectSpacing((int) v));

        // Background color
        fc = applyParameter(fc, colorsBackground, (c, v) -> c.setColorBackground((int) v));

        // Blur value
        fc = applyParameter(fc, List.of(0.6f), (c, v) -> c.setBlurValue((float) v));

        // Object and colors
        List<FormType> l1 = List.of(FormType.SEMICIRCLE);

        fc = applyParameter(fc, List.of(l1), (c, v) -> c.setFormTypes((List<FormType>) v));
        fc = applyParameter(fc, List.of(formColors), (c, v) -> c.addColorsForm(FormType.SEMICIRCLE, (int[]) v));

        // Size
        //FrameConfiguration.FloatFunction sizeTransformFunction = (frameIndex) -> 1.0f;
        FrameConfiguration.FloatFunction sizeTransformFunction = (frameIndex) -> Utils.getRandomFloat(1.0f, 2.0f);
        fc = applyParameter(fc, List.of(sizeTransformFunction), (c, v) -> c.setSizeTransformFunction((FrameConfiguration.FloatFunction) v));

        // Rotation
        //FrameConfiguration.FloatFunction rotationFunction = (frameIndex) -> 2f * (frameIndex-15);
        FrameConfiguration.FloatFunction rotationFunction = (frameIndex) -> 45f + Math.round((Utils.getRandomFloat(-5, 5)));
        fc = applyParameter(fc, List.of(rotationFunction), (c, v) -> c.setRotateFunction((FrameConfiguration.FloatFunction) v));

        // Alpha
        FrameConfiguration.IntFunction alphaFunction1 = (frameIndex) -> (int) Utils.getRandomFloat(0, 150);
        FrameConfiguration.IntFunction alphaFunction2 = (frameIndex) -> 255;
        fc = applyParameter(fc, List.of(alphaFunction2), (c, v) -> c.setAlphaFunction((FrameConfiguration.IntFunction) v));

        // Variation (0 means no variation on the x,y position of the object)
        FrameConfiguration.IntFunction xVariationFunction = (frameIndex) -> Math.round((Utils.getRandomFloat(-20, 20)));
        fc = applyParameter(fc, List.of(xVariationFunction), (c, v) -> c.setxVariationFunction((FrameConfiguration.IntFunction) v));

        FrameConfiguration.IntFunction yVariationFunction = (frameIndex) -> Math.round((Utils.getRandomFloat(-20, 20)));
        fc = applyParameter(fc, List.of(yVariationFunction), (c, v) -> c.setyVariationFunction((FrameConfiguration.IntFunction) v));

        // Stroke
        fc = applyParameter(fc, List.of(true), (c, v) -> c.setStroke((boolean) v));
        fc = applyParameter(fc, List.of(2), (c, v) -> c.setStrokeSize((int) v));
        fc = applyParameter(fc, colorsStroke, (c, v) -> c.setStrokeColor((int) v));

        // Center Object
        fc = applyParameter(fc, List.of(true), (c, v) -> c.setCenterObject((boolean) v));
        fc = applyParameter(fc, List.of(0.8f), (c, v) -> c.setCenterObjectSize((float) v));
        fc = applyParameter(fc, List.of(formColors), (c, v) -> c.setColorsCenterObject((int[]) v));

        // Direction (triangles and semicircles only)
        //FrameConfiguration.IntFunction directionFunction = (frameIndex) -> (frameIndex % 2) * 2; // Utils.getRandomInt(4)
        FrameConfiguration.IntFunction directionFunction = (frameIndex) -> 2;
        fc = applyParameter(fc, List.of(directionFunction), (c, v) -> c.setDirectionFunction((FrameConfiguration.IntFunction) v));

        System.out.printf("Generated %s Frame configurations...%n", fc.size());
        fc.forEach(c -> System.out.printf(c.toString()));

        return fc;
    }
}
