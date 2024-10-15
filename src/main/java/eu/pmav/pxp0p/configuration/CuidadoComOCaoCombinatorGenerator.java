package eu.pmav.pxp0p.configuration;

import eu.pmav.pxp0p.app.helpers.SerializableFunction;
import eu.pmav.pxp0p.app.forms.FormType;
import eu.pmav.pxp0p.app.model.Configuration;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class CuidadoComOCaoCombinatorGenerator extends CombinatorGenerator {
    public static List<Configuration> generateConfigurations() throws IOException, ClassNotFoundException {
        // Set colors
        int colorYellow = 0xffFFD742;
        int colorCyan = 0xff01ACB7;
        int colorWhite = 0xffFEFCFE;

        // Initial configuration
        List<Configuration> configurations = Collections.singletonList(new Configuration());

        // Layout
        configurations = applyParameter(configurations, List.of(1), (c, v) -> c.setObjectColumns((int) v));
        configurations = applyParameter(configurations, List.of(1), (c, v) -> c.setObjectLines((int) v));
        configurations = applyParameter(configurations, List.of(0), (c, v) -> c.setObjectSpacing((int) v));

        configurations = applyParameter(configurations, List.of(colorCyan), (c, v) -> c.setColorBackground((int) v));
        configurations = applyParameter(configurations, List.of(0.6f), (c, v) -> c.setBlurValue((float) v));
        configurations = applyParameter(configurations, Collections.singletonList(new FormType[]{FormType.SQUARE}), (c, v) -> c.setObjectTypes((FormType[]) v));

        // Direction
        configurations = applyParameter(configurations, List.of(true), (c, v) -> c.setHaveDirection((boolean) v));
        SerializableFunction<Integer, Integer> f = (Integer i) -> {return 1;};
        configurations = applyParameter(configurations, List.of(f), (c, v) -> c.setCalculateDirection((Function<Integer, Integer>) v));

        // Object Colors
        configurations = applyParameter(configurations, List.of(new int[]{colorWhite}), (c, v) -> c.setColorsCircle((int[]) v));
        configurations = applyParameter(configurations, List.of(new int[]{colorWhite}), (c, v) -> c.setColorsSquare((int[]) v));
        configurations = applyParameter(configurations, List.of(new int[]{colorWhite}), (c, v) -> c.setColorsTriangle((int[]) v));

        // Size Transform
        configurations = applyParameter(configurations, List.of(true), (c, v) -> c.setHaveSizeTransform((boolean) v));
        configurations = applyParameter(configurations, List.of(0.5f), (c, v) -> c.setMinSizeTransform((float) v));
        configurations = applyParameter(configurations, List.of(0.5f), (c, v) -> c.setMaxSizeTransform((float) v));

        // Alpha
        configurations = applyParameter(configurations, List.of(false), (c, v) -> c.setHaveAlpha((boolean) v));
        configurations = applyParameter(configurations, List.of(0), (c, v) -> c.setMinAlpha((int) v));
        configurations = applyParameter(configurations, List.of(150), (c, v) -> c.setMaxAlpha((int) v));

        // Variation
        configurations = applyParameter(configurations, List.of(0), (c, v) -> c.setxVariation((int) v));
        configurations = applyParameter(configurations, List.of(0), (c, v) -> c.setyVariation((int) v));

        // Stroke
        configurations = applyParameter(configurations, List.of(false), (c, v) -> c.setHaveStroke((boolean) v));
        configurations = applyParameter(configurations, List.of(16), (c, v) -> c.setStrokeSize((int) v));
        configurations = applyParameter(configurations, List.of(colorWhite), (c, v) -> c.setStrokeColor((int) v));

        // Center Object
        configurations = applyParameter(configurations, List.of(false), (c, v) -> c.setHaveCenterObject((boolean) v));
        configurations = applyParameter(configurations, List.of(0.6f), (c, v) -> c.setCenterObjectSize((float) v));
        configurations = applyParameter(configurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCenterObject((int[]) v));

        // Cuts
        configurations = applyParameter(configurations, List.of(true), (c, v) -> c.setHaveCuts((boolean) v));
        configurations = applyParameter(configurations, List.of(0.4f), (c, v) -> c.setCutSize((float) v));

        configurations = applyParameter(configurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCutCircle((int[]) v));
        configurations = applyParameter(configurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCutSquare((int[]) v));
        configurations = applyParameter(configurations, List.of(new int[]{colorYellow}), (c, v) -> c.setColorsCutTriangle((int[]) v));

        System.out.printf("Generated %s configurations...%n", configurations.size());

        return configurations;
    }
}
