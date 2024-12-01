package eu.pmav.pxp0p.configuration.manual.impl;

import eu.pmav.pxp0p.render.forms.FormType;
import eu.pmav.pxp0p.render.model.Configuration;
import eu.pmav.pxp0p.configuration.manual.ManualGenerator;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class OlympicsManualGenerator extends ManualGenerator
{
    public List<Configuration> generateConfigurations() throws IOException, ClassNotFoundException
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
        List<Configuration> configurations = Collections.singletonList(new Configuration());

        // Layout
        configurations = applyParameter(configurations, List.of(5), (c, v) -> c.setObjectColumns((int) v));
        configurations = applyParameter(configurations, List.of(1), (c, v) -> c.setObjectLines((int) v));
        configurations = applyParameter(configurations, List.of(8), (c, v) -> c.setObjectSpacing((int) v));

        configurations = applyParameter(configurations, colorsBackground, (c, v) -> c.setColorBackground((int) v));
        configurations = applyParameter(configurations, List.of(0.6f), (c, v) -> c.setBlurValue((float) v));
        configurations = applyParameter(configurations, Collections.singletonList(new FormType[]{FormType.CIRCLE}), (c, v) -> c.setObjectTypes((FormType[]) v));

        // Object Colors
        configurations = applyParameter(configurations, List.of(colorsOlympics), (c, v) -> c.setColorsCircle((int[]) v));
        configurations = applyParameter(configurations, List.of(colorsOlympics), (c, v) -> c.setColorsSquare((int[]) v));
        configurations = applyParameter(configurations, List.of(colorsOlympics), (c, v) -> c.setColorsTriangle((int[]) v));

        // Size
        configurations = applyParameter(configurations, List.of(true, false), (c, v) -> c.setHaveSizeTransform((boolean) v));
        configurations = applyParameter(configurations, List.of(1.0f), (c, v) -> c.setMinSizeTransform((float) v));
        configurations = applyParameter(configurations, List.of(2.0f), (c, v) -> c.setMaxSizeTransform((float) v));

        // Alpha
        configurations = applyParameter(configurations, List.of(false), (c, v) -> c.setHaveAlpha((boolean) v));
        configurations = applyParameter(configurations, List.of(0), (c, v) -> c.setMinAlpha((int) v));
        configurations = applyParameter(configurations, List.of(150), (c, v) -> c.setMaxAlpha((int) v));

        // Variation
        configurations = applyParameter(configurations, List.of(0), (c, v) -> c.setxVariation((int) v));
        configurations = applyParameter(configurations, List.of(0), (c, v) -> c.setyVariation((int) v));

        // Stroke
        configurations = applyParameter(configurations, List.of(true), (c, v) -> c.setHaveStroke((boolean) v));
        configurations = applyParameter(configurations, List.of(8, 16), (c, v) -> c.setStrokeSize((int) v));
        configurations = applyParameter(configurations, colorsStroke, (c, v) -> c.setStrokeColor((int) v));

        // Center Object
        configurations = applyParameter(configurations, List.of(true, false), (c, v) -> c.setHaveCenterObject((boolean) v));
        configurations = applyParameter(configurations, List.of(0.7f), (c, v) -> c.setCenterObjectSize((float) v));
        configurations = applyParameter(configurations, List.of(colorsWhite), (c, v) -> c.setColorsCenterObject((int[]) v));

        // Cuts
        configurations = applyParameter(configurations, List.of(true, false), (c, v) -> c.setHaveCuts((boolean) v));
        configurations = applyParameter(configurations, List.of(0.8f), (c, v) -> c.setCutSize((float) v));

        configurations = applyParameter(configurations, List.of(colorsOlympics), (c, v) -> c.setColorsCutCircle((int[]) v));
        configurations = applyParameter(configurations, List.of(colorsOlympics), (c, v) -> c.setColorsCutSquare((int[]) v));
        configurations = applyParameter(configurations, List.of(colorsOlympics), (c, v) -> c.setColorsCutTriangle((int[]) v));

        System.out.printf("Generated %s configurations...%n", configurations.size());

        return configurations;
    }
}
