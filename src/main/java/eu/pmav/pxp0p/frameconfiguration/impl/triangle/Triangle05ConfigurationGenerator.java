package eu.pmav.pxp0p.frameconfiguration.impl.triangle;

import eu.pmav.pxp0p.frameconfiguration.FrameConfigurationGenerator;
import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.utils.Utils;

import java.util.Collections;
import java.util.List;

public class Triangle05ConfigurationGenerator extends FrameConfigurationGenerator
{
    private final String ID = "Triangle_05_position";

    public List<FrameConfiguration> generateConfigurations() throws Exception {
        // Set colors
        int colorWhite = 0xffDCDCDC;
        int colorBlack = 0xff101010;
        int colorRed = 0xffff0000;
        
        // Initial configuration
        List<FrameConfiguration> fc = Collections.singletonList(new FrameConfiguration(ID));

        // Canvas and grid
        fc = applyParameter(fc, List.of(1000), (c, v) -> c.setCanvasWidth((int) v));
        fc = applyParameter(fc, List.of(1000), (c, v) -> c.setCanvasHeight((int) v));

        fc = applyParameter(fc, List.of(800), (c, v) -> c.setGridWidth((int) v));
        fc = applyParameter(fc, List.of(800), (c, v) -> c.setGridHeight((int) v));

        // Layout
        fc = applyParameter(fc, List.of(4), (c, v) -> c.setObjectColumns((int) v));
        fc = applyParameter(fc, List.of(4), (c, v) -> c.setObjectLines((int) v));
        fc = applyParameter(fc, List.of(8), (c, v) -> c.setObjectSpacing((int) v));

        // Background color
        fc = applyParameter(fc, List.of(colorBlack), (c, v) -> c.setColorBackground((int) v));

        // Blur value
        fc = applyParameter(fc, List.of(0.6f), (c, v) -> c.setBlurValue((float) v));

        // Object and colors
        List<FormType> l1 = List.of(FormType.TRIANGLE);

        fc = applyParameter(fc, List.of(l1), (c, v) -> c.setFormTypes((List<FormType>) v));
        fc = applyParameter(fc, List.of(new int[]{colorWhite}), (c, v) -> c.addColorsForm(FormType.TRIANGLE, (int[]) v));

        // Stroke
        fc = applyParameter(fc, List.of(true), (c, v) -> c.setStroke((boolean) v));
        fc = applyParameter(fc, List.of(2), (c, v) -> c.setStrokeSize((int) v));
        fc = applyParameter(fc, List.of(colorRed), (c, v) -> c.setStrokeColor((int) v));

        // Size
        FrameConfiguration.FloatFunction sizeTransformFunction = (frameIndex) -> Utils.getRandomFloat(0.8f, 1.2f);
        fc = applyParameter(fc, List.of(sizeTransformFunction), (c, v) -> c.setSizeTransformFunction((FrameConfiguration.FloatFunction) v));

        // Position
        FrameConfiguration.IntFunction xVariationFunction = (frameIndex) -> Math.round((Utils.getRandomFloat(-20, 20)));
        fc = applyParameter(fc, List.of(xVariationFunction), (c, v) -> c.setxVariationFunction((FrameConfiguration.IntFunction) v));

        FrameConfiguration.IntFunction yVariationFunction = (frameIndex) -> Math.round((Utils.getRandomFloat(-20, 20)));
        fc = applyParameter(fc, List.of(yVariationFunction), (c, v) -> c.setyVariationFunction((FrameConfiguration.IntFunction) v));

        System.out.printf("Generated %s Frame configurations...%n", fc.size());
        fc.forEach(c -> System.out.printf(c.toString()));

        return fc;
    }
}
