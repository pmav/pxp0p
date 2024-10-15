package eu.pmav.pxp0p.configuration;

import eu.pmav.pxp0p.app.model.Configuration;
import eu.pmav.pxp0p.app.forms.FormType;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class DevelopmentCombinatorGenerator extends CombinatorGenerator
{
    public static List<Configuration> generateConfigurations() throws IOException, ClassNotFoundException
    {
        // Set colors
        int colorWhite = 0xffDCDCDC;
        int colorBlack = 0xff101010;

        int[] colorsBlack = {colorBlack};
        int[] colorsWhite = {colorWhite};
        int[] colorsBasePale = {0xffB30000, 0xff5199FF, 0xffFFEB7F};
        int[] colorsApple = {0xff61ba46, 0xfffcb829, 0xfff8811d, 0xffe03a3e, 0xff963d97, 0xff059ddc, 0xffDCDCDC, 0xff101010};
        int[] colorsGoogle = {0xff4285F4,0xffDB4437,0xffF4B400,0xff0F9D58};
        int[] colorsInstagram = {0xff405DE6,0xff5B51D8,0xff833AB4,0xffC13584,0xffE1306C,0xffFD1D1D,0xffF56040,0xffF77737,0xffFCAF45,0xffFFDC80};
        int[] colorsSlack = {0xff36C5F0, 0xff2EB67D, 0xffE01E5A, 0xffECB22E};
        int[] colorsWhatsApp = {0xff128C7E,0xff075E54,0xff25D366,0xff34B7F1};
        int[] colorsTwitter = {0xff1DA1F2, 0xff14171A, 0xff657786, 0xffAAB8C2, 0xffE1E8ED, 0xffF5F8FA};
        int[] colorsMicrosoft = {0xffF25022,0xff7FBA00,0xff00A4EF,0xffFFB900,0xff737373};
        int[] colorsAirbnb = {0xffFF5A5F,0xff00A699,0xffFC642D,0xff484848,0xff767676};

        int[] colorsRed = {0xffF6522E, 0xffFF6E4E, 0xffFF6A61, 0xffE20338, 0xffB40A1B, 0xffEE3D48, 0xff460000, 0xff922D25};
        int[] colorsBlue = {0xff5199FF, 0xff1771F1, 0xff0260E8, 0xff0351C1, 0xff0043A4, 0xff002D6D, 0xff052555, 0xff01142F};
        int[] colorsYellow = {0xffFFD600, 0xffF5E027, 0xffD6C21A, 0xffFBFF00, 0xffFFC11E, 0xffEAE114, 0xffFFF851, 0xffFFE55E};
        int[] colorsGreen = {0xff5BFF62, 0xff41B619, 0xff117243, 0xff116315, 0xff4BB462, 0xff008736, 0xff4D8802, 0xff1E3C00};
        int[] colorsBeige = {0xffFFC46B, 0xffFFAF50, 0xffFFAD32, 0xffDF8600, 0xffFE634E, 0xffF39629};

        int[] colorsRedStrong = {0xffFF0000, 0xffBC0022, 0xffB40A1B, 0xffE20338, 0xffB30000};
        int[] colorsGrey = {0xffDCDCDC, 0xffD3D3D3, 0xffC0C0C0, 0xffA9A9A9, 0xff808080, 0xff696969, 0xff778899, 0xff708090, 0xff2F4F4F, 0xff000000};

        List<Object> colorsStroke = List.of(colorBlack);
        List<Object> colorsBackground = List.of(colorBlack);

        // Initial configuration
        List<Configuration> configurations = Collections.singletonList(new Configuration());

        // Layout
        configurations = applyParameter(configurations, List.of(4), (c, v) -> c.setObjectColumns((int) v));
        configurations = applyParameter(configurations, List.of(4), (c, v) -> c.setObjectLines((int) v));
        configurations = applyParameter(configurations, List.of(8), (c, v) -> c.setObjectSpacing((int) v));

        configurations = applyParameter(configurations, colorsBackground, (c, v) -> c.setColorBackground((int) v));
        configurations = applyParameter(configurations, List.of(0.6f), (c, v) -> c.setBlurValue((float) v));
        configurations = applyParameter(configurations, Collections.singletonList(new FormType[]{FormType.SQUARE, FormType.CIRCLE}), (c, v) -> c.setObjectTypes((FormType[]) v));

        // Object Colors
        configurations = applyParameter(configurations, List.of(colorsInstagram), (c, v) -> c.setColorsCircle((int[]) v));
        configurations = applyParameter(configurations, List.of(colorsInstagram), (c, v) -> c.setColorsSquare((int[]) v));
        configurations = applyParameter(configurations, List.of(colorsInstagram), (c, v) -> c.setColorsTriangle((int[]) v));

        // Size
        configurations = applyParameter(configurations, List.of(true), (c, v) -> c.setHaveSizeTransform((boolean) v));
        configurations = applyParameter(configurations, List.of(1.0f), (c, v) -> c.setMinSizeTransform((float) v));
        configurations = applyParameter(configurations, List.of(1.2f), (c, v) -> c.setMaxSizeTransform((float) v));

        // Alpha
        configurations = applyParameter(configurations, List.of(false), (c, v) -> c.setHaveAlpha((boolean) v));
        configurations = applyParameter(configurations, List.of(0), (c, v) -> c.setMinAlpha((int) v));
        configurations = applyParameter(configurations, List.of(150), (c, v) -> c.setMaxAlpha((int) v));

        // Variation
        configurations = applyParameter(configurations, List.of(10), (c, v) -> c.setxVariation((int) v));
        configurations = applyParameter(configurations, List.of(10), (c, v) -> c.setyVariation((int) v));

        // Stroke
        configurations = applyParameter(configurations, List.of(true), (c, v) -> c.setHaveStroke((boolean) v));
        configurations = applyParameter(configurations, List.of(8), (c, v) -> c.setStrokeSize((int) v));
        configurations = applyParameter(configurations, colorsStroke, (c, v) -> c.setStrokeColor((int) v));

        // Center Object
        configurations = applyParameter(configurations, List.of(false), (c, v) -> c.setHaveCenterObject((boolean) v));
        configurations = applyParameter(configurations, List.of(0.5f), (c, v) -> c.setCenterObjectSize((float) v));
        configurations = applyParameter(configurations, List.of(colorsBlue), (c, v) -> c.setColorsCenterObject((int[]) v));

        // Cuts
        configurations = applyParameter(configurations, List.of(false), (c, v) -> c.setHaveCuts((boolean) v));
        configurations = applyParameter(configurations, List.of(0.8f), (c, v) -> c.setCutSize((float) v));

        configurations = applyParameter(configurations, List.of(colorsBlue), (c, v) -> c.setColorsCutCircle((int[]) v));
        configurations = applyParameter(configurations, List.of(colorsBlue), (c, v) -> c.setColorsCutSquare((int[]) v));
        configurations = applyParameter(configurations, List.of(colorsBlue), (c, v) -> c.setColorsCutTriangle((int[]) v));

        System.out.printf("Generated %s configurations...%n", configurations.size());

        return configurations;
    }
}
