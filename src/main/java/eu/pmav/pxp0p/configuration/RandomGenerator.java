package eu.pmav.pxp0p.configuration;

import eu.pmav.pxp0p.app.forms.FormType;
import eu.pmav.pxp0p.app.model.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    private final Random r = new Random(0);

//    private final int[] colorsPool = {
//            0xffDCDCDC, 0xff101010, 0xffB30000, 0xff5199FF, 0xffFFEB7F, 0xff61ba46, 0xfffcb829, 0xfff8811d, 0xffe03a3e, 0xff963d97, 0xff059ddc, 0xffDCDCDC, 0xff101010, 0xff4285F4, 0xffDB4437, 0xffF4B400, 0xff0F9D58, 0xff405DE6, 0xff5B51D8, 0xff833AB4, 0xffC13584, 0xffE1306C, 0xffFD1D1D, 0xffF56040, 0xffF77737, 0xffFCAF45, 0xffFFDC80, 0xff36C5F0, 0xff2EB67D, 0xffE01E5A, 0xffECB22E, 0xff128C7E, 0xff075E54, 0xff25D366, 0xff34B7F1, 0xff1DA1F2, 0xff14171A, 0xff657786, 0xffAAB8C2, 0xffE1E8ED, 0xffF5F8FA, 0xffF25022, 0xff7FBA00, 0xff00A4EF, 0xffFFB900, 0xff737373, 0xffFF5A5F, 0xff00A699, 0xffFC642D, 0xff484848, 0xff767676, 0xffF6522E, 0xffFF6E4E, 0xffFF6A61, 0xffE20338, 0xffB40A1B, 0xffEE3D48, 0xff460000, 0xff922D25, 0xff5199FF, 0xff1771F1, 0xff0260E8, 0xff0351C1, 0xff0043A4, 0xff002D6D, 0xff052555, 0xff01142F, 0xffFFD600, 0xffF5E027, 0xffD6C21A, 0xffFBFF00, 0xffFFC11E, 0xffEAE114, 0xffFFF851, 0xffFFE55E, 0xff5BFF62, 0xff41B619, 0xff117243, 0xff116315, 0xff4BB462, 0xff008736, 0xff4D8802, 0xff1E3C00, 0xffFFC46B, 0xffFFAF50, 0xffFFAD32, 0xffDF8600, 0xffFE634E, 0xffF39629, 0xffFF0000, 0xffBC0022, 0xffB40A1B, 0xffE20338, 0xffB30000, 0xffDCDCDC, 0xffD3D3D3, 0xffC0C0C0, 0xffA9A9A9, 0xff808080, 0xff696969, 0xff778899, 0xff708090, 0xff2F4F4F, 0xff000000
//    };

//    private final int[] colorsPool = {
//            0xffDCDCDC, 0xffD3D3D3, 0xffC0C0C0, 0xffA9A9A9, 0xff808080, 0xff696969, 0xff778899, 0xff708090, 0xff2F4F4F, 0xff000000
//    };

    private final int[] colorsPool = {
            0xffDCDCDC,0xff101010
    };

    public List<Configuration> generateConfigurations(int count) {
        List<Configuration> configurations = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {

            int[] colors = getRandomColors(8);
            int backgroundColor = getRandomColor();
            int strokeColor = getRandomColor();

            Configuration configuration = new Configuration();

            configuration.setObjectColumns(getRandomInt(1, 16));
            configuration.setObjectLines(getRandomInt(1, 16));
            configuration.setObjectSpacing(getRandomInt(0, 32));

            configuration.setColorBackground(backgroundColor);
            configuration.setBlurValue(geRandomFloat(0, 1));
            configuration.setObjectTypes(getRandomFormTypes());

            // Object Colors
            configuration.setColorsCircle(colors);
            configuration.setColorsSquare(colors);
            configuration.setColorsTriangle(colors);

            // Size
            configuration.setHaveSizeTransform(getRandomBoolean());
            configuration.setMinSizeTransform(geRandomFloat(0, 1));
            configuration.setMaxSizeTransform(geRandomFloat(1, 2));

            // Alpha
            configuration.setHaveAlpha(getRandomBoolean());
            configuration.setMinAlpha(getRandomInt(0, 127));
            configuration.setMaxAlpha(getRandomInt(128, 255));

            // Variation
            configuration.setxVariation(getRandomInt(0, 10));
            configuration.setyVariation(getRandomInt(0, 10));

            // Stroke
            configuration.setHaveStroke(getRandomBoolean());
            configuration.setStrokeSize(getRandomInt(0, 16));
            configuration.setStrokeColor(strokeColor);

            // Center Object
            configuration.setHaveCenterObject(getRandomBoolean());
            configuration.setCenterObjectSize(geRandomFloat(0, 1));
            configuration.setColorsCenterObject(colors);

            // Cuts
            configuration.setHaveCuts(getRandomBoolean());
            configuration.setCutSize(geRandomFloat(0, 1));

            configuration.setColorsCutCircle(colors);
            configuration.setColorsCutSquare(colors);
            configuration.setColorsCutTriangle(colors);

            configuration.calculate();

            configurations.add(configuration);
        }

        return configurations;
    }

    private FormType[] getRandomFormTypes() {
        int count = getRandomInt(1, 3);
        FormType[] formsTypes = new FormType[count];

        for (int i = 0; i < formsTypes.length; i++) {
            formsTypes[i] = getRandomFormType();
        }

        return formsTypes;
    }

    private FormType getRandomFormType() {
        int x = r.nextInt(FormType.class.getEnumConstants().length);
        return FormType.class.getEnumConstants()[x];
    }

    private int getRandomInt(int min, int max) {
        return r.nextInt((max - min) + 1) + min;
    }

    private float geRandomFloat(float min, float max) {
        return min + r.nextFloat() * (max - min);
    }

    private boolean getRandomBoolean() {
        return r.nextBoolean();
    }

    private int getRandomColor() {
        return colorsPool[getRandomInt(0, colorsPool.length - 1)];

//        return (int) ((r.nextFloat() * Math.pow(2, 8)) // blue
//                + (r.nextFloat() * Math.pow(2, 16)) // green
//                + (r.nextFloat() * Math.pow(2, 24)))  // red
//                + 0xff000000;
    }

    private int[] getRandomColors(int count) {
        int[] colors = new int[count];

        for (int i = 0; i < colors.length; i++) {
            colors[i] = getRandomColor();
        }

        return colors;
    }
}
