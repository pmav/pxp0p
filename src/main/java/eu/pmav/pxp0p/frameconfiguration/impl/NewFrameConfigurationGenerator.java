package eu.pmav.pxp0p.frameconfiguration.impl;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.frameconfiguration.FrameConfigurationGenerator;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class NewFrameConfigurationGenerator extends FrameConfigurationGenerator
{
    public List<FrameConfiguration> generateConfigurations() throws Exception {
        // Set colors
        int colorWhite = 0xffDCDCDC;
        int colorBlack = 0xff101010;
        //int colorBlack = 0xff000000;

        int[] colorsBlack = {colorBlack};
        int[] colorsWhite = {colorWhite};
        int[] colorsBasePale = {0xffB30000, 0xff5199FF, 0xffFFEB7F};
        int[] colorsApple = {0xff61ba46, 0xfffcb829, 0xfff8811d, 0xffe03a3e, 0xff963d97, 0xff059ddc, 0xffDCDCDC, 0xff101010};
        int[] colorsGoogle = {0xff4285F4, 0xffDB4437, 0xffF4B400, 0xff0F9D58};
        int[] colorsInstagram = {0xff405DE6, 0xff5B51D8, 0xff833AB4, 0xffC13584, 0xffE1306C, 0xffFD1D1D, 0xffF56040, 0xffF77737, 0xffFCAF45, 0xffFFDC80};
        int[] colorsSlack = {0xff36C5F0, 0xff2EB67D, 0xffE01E5A, 0xffECB22E};
        int[] colorsWhatsApp = {0xff128C7E, 0xff075E54, 0xff25D366, 0xff34B7F1};
        int[] colorsTwitter = {0xff1DA1F2, 0xff14171A, 0xff657786, 0xffAAB8C2, 0xffE1E8ED, 0xffF5F8FA};
        int[] colorsMicrosoft = {0xffF25022, 0xff7FBA00, 0xff00A4EF, 0xffFFB900, 0xff737373};
        int[] colorsAirbnb = {0xffFF5A5F, 0xff00A699, 0xffFC642D, 0xff484848, 0xff767676};

        int[] colorsRed = {0xffF6522E, 0xffFF6E4E, 0xffFF6A61, 0xffE20338, 0xffB40A1B, 0xffEE3D48, 0xff460000, 0xff922D25};
        int[] colorsBlue = {0xff5199FF, 0xff1771F1, 0xff0260E8, 0xff0351C1, 0xff0043A4, 0xff002D6D, 0xff052555, 0xff01142F};
        int[] colorsYellow = {0xffFFD600, 0xffF5E027, 0xffD6C21A, 0xffFBFF00, 0xffFFC11E, 0xffEAE114, 0xffFFF851, 0xffFFE55E};
        int[] colorsGreen = {0xff5BFF62, 0xff41B619, 0xff117243, 0xff116315, 0xff4BB462, 0xff008736, 0xff4D8802, 0xff1E3C00};
        int[] colorsBeige = {0xffFFC46B, 0xffFFAF50, 0xffFFAD32, 0xffDF8600, 0xffFE634E, 0xffF39629};

        int[] colorsRedStrong = {0xffFF0000, 0xffBC0022, 0xffB40A1B, 0xffE20338, 0xffB30000};
        int[] colorsGrey = {0xffDCDCDC, 0xffD3D3D3, 0xffC0C0C0, 0xffA9A9A9, 0xff808080, 0xff696969, 0xff778899, 0xff708090, 0xff2F4F4F, 0xff000000};

        List<Object> colorsStroke = List.of(colorWhite);
        List<Object> colorsBackground = List.of(colorBlack);

        // Initial configuration
        List<FrameConfiguration> fc = Collections.singletonList(new FrameConfiguration(this.getClass().getSimpleName()));

        // Canvas and grid
        fc = applyParameter(fc, List.of(1000), (c, v) -> c.setCanvasWidth((int) v));
        fc = applyParameter(fc, List.of(1000), (c, v) -> c.setCanvasHeight((int) v));

        fc = applyParameter(fc, List.of(800), (c, v) -> c.setGridWidth((int) v));
        fc = applyParameter(fc, List.of(800), (c, v) -> c.setGridHeight((int) v));

        // Layout
        fc = applyParameter(fc, List.of(4), (c, v) -> c.setObjectColumns((int) v));
        fc = applyParameter(fc, List.of(4), (c, v) -> c.setObjectLines((int) v));
        fc = applyParameter(fc, List.of(8), (c, v) -> c.setObjectSpacing((int) v));

        fc = applyParameter(fc, colorsBackground, (c, v) -> c.setColorBackground((int) v));
        fc = applyParameter(fc, List.of(0.6f), (c, v) -> c.setBlurValue((float) v));

        // Object and colors
        //fc = applyParameter(fc, Collections.singletonList(new FormType[]{FormType.SQUARE}), (c, v) -> c.setFormTypes((FormType[]) v));
        //fc = applyParameter(fc, List.of(colorsRedStrong), (c, v) -> c.addColorsForm(FormType.SQUARE, (int[]) v));

        //fc = applyParameter(fc, Collections.singletonList(new FormType[]{FormType.CIRCLE}), (c, v) -> c.setFormTypes((FormType[]) v));
        //fc = applyParameter(fc, List.of(colorsRedStrong), (c, v) -> c.addColorsForm(FormType.CIRCLE, (int[]) v));

        //fc = applyParameter(fc, Collections.singletonList(new FormType[]{FormType.TRIANGLE}), (c, v) -> c.setFormTypes((FormType[]) v));
        //fc = applyParameter(fc, List.of(colorsRedStrong), (c, v) -> c.addColorsForm(FormType.TRIANGLE, (int[]) v));

        //fc = applyParameter(fc, Collections.singletonList(new FormType[]{FormType.DEBUG}), (c, v) -> c.setFormTypes((FormType[]) v));
        //fc = applyParameter(fc, List.of(colorsRedStrong), (c, v) -> c.addColorsForm(FormType.DEBUG, (int[]) v));

        List<FormType> l1 = new ArrayList<>();
        l1.add(FormType.SQUARE);
        l1.add(FormType.CIRCLE);

        List<FormType> l2 = new ArrayList<>();
        l2.add(FormType.SQUARE);

        fc = applyParameter(fc, List.of(l1, l2), (c, v) -> c.setFormTypes((List<FormType>) v));
        fc = applyParameter(fc, List.of(colorsRedStrong), (c, v) -> c.addColorsForm(FormType.CIRCLE, (int[]) v));
        fc = applyParameter(fc, List.of(colorsBlue), (c, v) -> c.addColorsForm(FormType.SQUARE, (int[]) v));

        //fc = applyParameter(fc, Collections.singletonList(new FormType[]{FormType.SEMICIRCLE}), (c, v) -> c.setFormTypes((FormType[]) v));
        //fc = applyParameter(fc, List.of(colorsRedStrong), (c, v) -> c.addColorsForm(FormType.SEMICIRCLE, (int[]) v));

        // Size
        //FrameConfiguration.FloatFunction sizeTransformFunction = (frameIndex) -> Utils.getRandomFloat(1.0f, 2.5f);
        //fc = applyParameter(fc, List.of(sizeTransformFunction), (c, v) -> c.setSizeTransformFunction((FrameConfiguration.FloatFunction) v));

        // Rotation
        FrameConfiguration.FloatFunction rotationFunction = (frameIndex) -> 1f * frameIndex;
        fc = applyParameter(fc, List.of(rotationFunction), (c, v) -> c.setRotateFunction((FrameConfiguration.FloatFunction) v));

        // Alpha
        //FrameConfiguration.IntFunction alphaFunction = (frameIndex) -> (int) Utils.getRandomFloat(0, 150);
        //fc = applyParameter(fc, List.of(alphaFunction), (c, v) -> c.setAlphaFunction((FrameConfiguration.IntFunction) v));

        // Variation (0 means no variation on the x,y position of the object)
        FrameConfiguration.IntFunction xVariationFunction = (frameIndex) -> 0; // Math.round((Utils.getRandomFloat(-1, 1) * ))
        fc = applyParameter(fc, List.of(xVariationFunction), (c, v) -> c.setxVariationFunction((FrameConfiguration.IntFunction) v));

        FrameConfiguration.IntFunction yVariationFunction = (frameIndex) -> 0;
        fc = applyParameter(fc, List.of(yVariationFunction), (c, v) -> c.setyVariationFunction((FrameConfiguration.IntFunction) v));

        // Stroke
        fc = applyParameter(fc, List.of(true), (c, v) -> c.setStroke((boolean) v));
        fc = applyParameter(fc, List.of(4), (c, v) -> c.setStrokeSize((int) v));
        fc = applyParameter(fc, colorsStroke, (c, v) -> c.setStrokeColor((int) v));

        // Center Object
        fc = applyParameter(fc, List.of(true), (c, v) -> c.setCenterObject((boolean) v));
        fc = applyParameter(fc, List.of(0.6f), (c, v) -> c.setCenterObjectSize((float) v));
        fc = applyParameter(fc, List.of(colorsBlue), (c, v) -> c.setColorsCenterObject((int[]) v));

        // Cuts
        fc = applyParameter(fc, List.of(true), (c, v) -> c.setCuts((boolean) v));
        fc = applyParameter(fc, List.of(0.2f), (c, v) -> c.setCutSize((float) v));

        fc = applyParameter(fc, List.of(colorsBlue), (c, v) -> c.setColorsCutCircle((int[]) v));
        fc = applyParameter(fc, List.of(colorsBlue), (c, v) -> c.setColorsCutSquare((int[]) v));
        fc = applyParameter(fc, List.of(colorsBlue), (c, v) -> c.setColorsCutTriangle((int[]) v));

        // Direction (triangles and semicircles only)
        //FrameConfiguration.IntFunction directionFunction = (frameIndex) -> Utils.getRandomInt(4);
        FrameConfiguration.IntFunction directionFunction = (frameIndex) -> 0;
        fc = applyParameter(fc, List.of(directionFunction), (c, v) -> c.setDirectionFunction((FrameConfiguration.IntFunction) v));

        System.out.printf("Generated %s Frame configurations...%n", fc.size());

        fc.forEach(c -> {
            System.out.printf(c.toString());
        });

        return fc;
    }
}
