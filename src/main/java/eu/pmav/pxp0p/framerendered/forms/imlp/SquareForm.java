package eu.pmav.pxp0p.framerendered.forms.imlp;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.Form;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.framerendered.model.ObjectConfiguration;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;

public class SquareForm extends Form
{
    public SquareForm()
    {
        super();
    }

    public void draw(PApplet applet, FrameConfiguration frameConfiguration, ObjectConfiguration objectConfiguration)
    {
        // Get initial X position variation
        final int xVariation = frameConfiguration.getxVariationFunction() != null
                ? frameConfiguration.getxVariationFunction().run(0)
                : 0;

        // Get initial Y position variation
        final int yVariation = frameConfiguration.getyVariationFunction() != null
                ? frameConfiguration.getyVariationFunction().run(0)
                : 0;

        final int x = objectConfiguration.getX()
                + Math.round((Utils.getRandomFloat(-1, 1) * xVariation))
                - (frameConfiguration.getSize() / 2);

        final int y = objectConfiguration.getY()
                + Math.round((Utils.getRandomFloat(-1, 1) * yVariation))
                - (frameConfiguration.getSize() / 2);

        final int size = (int)(
                frameConfiguration.isHaveSizeTransform()
                        ? frameConfiguration.getSize() * Utils.getRandomFloat(frameConfiguration.getMinSizeTransform(), frameConfiguration.getMaxSizeTransform())
                        : frameConfiguration.getSize());

        final boolean cut1 = frameConfiguration.isHaveCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final boolean cut2 = frameConfiguration.isHaveCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final boolean cut3 = frameConfiguration.isHaveCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final boolean cut4 = frameConfiguration.isHaveCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final int cutSize = Math.round(size * frameConfiguration.getCutSize());

        final boolean haveCenterObject = frameConfiguration.haveCenterObject();
        final int centerObjectSize = Math.round(size * frameConfiguration.getCenterObjectSize());

        final int alpha = frameConfiguration.isHaveAlpha()
                ? frameConfiguration.getAlphaFunction().run(objectConfiguration.getFrameIndex())
                : 255;

        applet.pushMatrix();

        int[] colors = frameConfiguration.getColorsForm().get(FormType.SQUARE);
        applet.fill(colors[Utils.getRandomInt(colors.length)], alpha);

        applet.square(x, y, size);

        if (cut1)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.square(x, y, cutSize);
        }

        if (cut2)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.square(x + size - cutSize, y, cutSize);
        }

        if (cut3)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.square(x, y + size - cutSize, cutSize);
        }

        if (cut4)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.square(x + size - cutSize, y + size - cutSize, cutSize);
        }

        if (haveCenterObject)
        {
            int[] centerColors = frameConfiguration.getColorsCenterObject();
            applet.fill(centerColors[Utils.getRandomInt(centerColors.length)]);
            applet.square((x + size / 2f) - (centerObjectSize / 2f), (y + size / 2f) - (centerObjectSize / 2f), centerObjectSize);
        }

        applet.popMatrix();
    }
}
