package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.configuration.Configuration;
import eu.pmav.pxp0p.render.forms.FormType;
import processing.core.PApplet;

public class SquareForm extends Form
{
    public SquareForm(PApplet pApplet)
    {
        super(pApplet);
    }

    public void draw(int x, int y, int frameIndex, Configuration configuration)
    {
        final int size = PApplet.parseInt(
                configuration.isHaveSizeTransform()
                        ? configuration.getObjectSize() * applet.random(configuration.getMinSizeTransform(), configuration.getMaxSizeTransform())
                        : configuration.getObjectSize());

        int offset = configuration.getObjectSize() - size;
        x = x + offset / 2;
        y = y + offset / 2;

        final boolean cut1 = configuration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut2 = configuration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut3 = configuration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut4 = configuration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final int cutSize = Math.round(size * configuration.getCutSize());

        final boolean haveCenterObject = configuration.haveCenterObject();
        final int centerObjectSize = Math.round(size * configuration.getCenterObjectSize());

        final int alpha = configuration.isHaveAlpha()
                ? PApplet.parseInt(applet.random(configuration.getMinAlpha(), configuration.getMaxAlpha()))
                : 255;

        applet.pushMatrix();

        applet.fill(getRandomColor(configuration.getColorsForm().get(FormType.SQUARE)), alpha);
        applet.square(x, y, size);

        if (cut1)
        {
            applet.fill(getRandomColor(configuration.getColorsCutSquare()));
            applet.square(x, y, cutSize);
        }

        if (cut2)
        {
            applet.fill(getRandomColor(configuration.getColorsCutSquare()));
            applet.square(x + size - cutSize, y, cutSize);
        }

        if (cut3)
        {
            applet.fill(getRandomColor(configuration.getColorsCutSquare()));
            applet.square(x, y + size - cutSize, cutSize);
        }

        if (cut4)
        {
            applet.fill(getRandomColor(configuration.getColorsCutSquare()));
            applet.square(x + size - cutSize, y + size - cutSize, cutSize);
        }

        if (haveCenterObject)
        {
            applet.fill(getRandomColor(configuration.getColorsCenterObject()), alpha);
            applet.square((x + size / 2f) - (centerObjectSize / 2f), (y + size / 2f) - (centerObjectSize / 2f), centerObjectSize);
        }

        applet.popMatrix();
    }
}
