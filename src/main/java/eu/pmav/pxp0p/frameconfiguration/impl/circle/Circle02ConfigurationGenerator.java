package eu.pmav.pxp0p.frameconfiguration.impl.circle;

import eu.pmav.pxp0p.frameconfiguration.FrameConfigurationGenerator;
import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.FormType;

import java.util.Collections;
import java.util.List;

public class Circle02ConfigurationGenerator extends FrameConfigurationGenerator
{
    private final String ID = "Circle_02_multiple";

    public List<FrameConfiguration> generateConfigurations() throws Exception {
        // Set colors
        int colorWhite = 0xffDCDCDC;
        int colorBlack = 0xff101010;
        
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
        List<FormType> l1 = List.of(FormType.CIRCLE);

        fc = applyParameter(fc, List.of(l1), (c, v) -> c.setFormTypes((List<FormType>) v));
        fc = applyParameter(fc, List.of(new int[]{colorWhite}), (c, v) -> c.addColorsForm(FormType.CIRCLE, (int[]) v));

        System.out.printf("Generated %s Frame configurations...%n", fc.size());
        fc.forEach(c -> System.out.printf(c.toString()));

        return fc;
    }
}
