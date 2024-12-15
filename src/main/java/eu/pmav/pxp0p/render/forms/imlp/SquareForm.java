package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.configuration.FrameConfiguration;
import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.render.forms.FormType;
import eu.pmav.pxp0p.render.model.ObjectConfiguration;
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
        int x = objectConfiguration.getX();
        int y = objectConfiguration.getY();
        final int objectSize = frameConfiguration.getSize();

        final int size = PApplet.parseInt(
                frameConfiguration.isHaveSizeTransform()
                        ? objectSize * applet.random(frameConfiguration.getMinSizeTransform(), frameConfiguration.getMaxSizeTransform())
                        : objectSize);

        int offset = objectSize - size;
        x = x + offset / 2;
        y = y + offset / 2;

        final boolean cut1 = frameConfiguration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut2 = frameConfiguration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut3 = frameConfiguration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut4 = frameConfiguration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final int cutSize = Math.round(size * frameConfiguration.getCutSize());

        final boolean haveCenterObject = frameConfiguration.haveCenterObject();
        final int centerObjectSize = Math.round(size * frameConfiguration.getCenterObjectSize());

        final int alpha = frameConfiguration.isHaveAlpha()
                ? PApplet.parseInt(applet.random(frameConfiguration.getMinAlpha(), frameConfiguration.getMaxAlpha()))
                : 255;

        applet.pushMatrix();

        applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsForm().get(FormType.SQUARE)), alpha);
        applet.square(x, y, size);

        if (cut1)
        {
            applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutSquare()));
            applet.square(x, y, cutSize);
        }

        if (cut2)
        {
            applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutSquare()));
            applet.square(x + size - cutSize, y, cutSize);
        }

        if (cut3)
        {
            applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutSquare()));
            applet.square(x, y + size - cutSize, cutSize);
        }

        if (cut4)
        {
            applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutSquare()));
            applet.square(x + size - cutSize, y + size - cutSize, cutSize);
        }

        if (haveCenterObject)
        {
            applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCenterObject()), alpha);
            applet.square((x + size / 2f) - (centerObjectSize / 2f), (y + size / 2f) - (centerObjectSize / 2f), centerObjectSize);
        }

        applet.popMatrix();
    }
}
