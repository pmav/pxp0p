package eu.pmav.pxp0p.framerendered.forms.imlp;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.Form;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.framerendered.model.ObjectConfiguration;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;

public class CircleForm extends Form
{
    public CircleForm()
    {
        super();
    }

    public void draw(PApplet applet, FrameConfiguration frameConfiguration, ObjectConfiguration objectConfiguration)
    {
        int x = frameConfiguration.getxVariation() != 0
                ? objectConfiguration.getX() + Math.round((Utils.getRandomFloat(-1, 1) * frameConfiguration.getxVariation()))
                : objectConfiguration.getX();

        int y = frameConfiguration.getyVariation() != 0
                ? objectConfiguration.getY() + Math.round((Utils.getRandomFloat(-1, 1) * frameConfiguration.getyVariation()))
                : objectConfiguration.getY();

        final int size = (int)(
                frameConfiguration.hasSizeTransform()
                        ? frameConfiguration.getSize() * Utils.getRandomFloat(frameConfiguration.getMinSizeTransform(), frameConfiguration.getMaxSizeTransform())
                        : frameConfiguration.getSize());

        x = x - (frameConfiguration.getSize() / 2);
        y = y - (frameConfiguration.getSize() / 2);

        final boolean cut1 = frameConfiguration.hasCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final boolean cut2 = frameConfiguration.hasCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final boolean cut3 = frameConfiguration.hasCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final boolean cut4 = frameConfiguration.hasCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final int cutSize = Math.round(size * frameConfiguration.getCutSize());

        final boolean haveCenterObject = frameConfiguration.hasCenterObject();
        final int centerObjectSize = Math.round(size * frameConfiguration.getCenterObjectSize());

        final int alpha = frameConfiguration.hasAlpha() ? (int)(Utils.getRandomFloat(frameConfiguration.getMinAlpha(), frameConfiguration.getMaxAlpha())) : 255;

        applet.pushMatrix();
        int[] colors = frameConfiguration.getColorsForm().get(FormType.CIRCLE);
        applet.fill(colors[Utils.getRandomInt(colors.length)], alpha);
        applet.circle(x + size / 2f, y + size / 2f, size);

        if (cut1)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.circle(x + size / 2f, y + cutSize / 2f, cutSize);
        }
        else if (cut2)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.circle(x + size - cutSize / 2f, y + size / 2f, cutSize);
        }
        else if (cut3)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.circle(x + size / 2f, y + size - cutSize / 2f, cutSize);
        }
        else if (cut4)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.circle(x + cutSize / 2f, y + size / 2f, cutSize);
        }

        if (haveCenterObject)
        {
            int[] centerColors = frameConfiguration.getColorsCenterObject();
            applet.fill(centerColors[Utils.getRandomInt(centerColors.length)]);
            applet.circle(x + size / 2f, y + size / 2f, centerObjectSize);
        }

        applet.popMatrix();
    }
}
