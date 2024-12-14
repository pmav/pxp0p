package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.configuration.Configuration;
import eu.pmav.pxp0p.render.forms.FormType;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;

public class CircleForm extends Form
{
    public CircleForm()
    {
        super();
    }

    public void draw(int x, int y, int frameIndex, Configuration configuration, int objectSize, PApplet applet)
    {
        final int size = PApplet.parseInt(
                configuration.isHaveSizeTransform()
                        ? objectSize * applet.random(configuration.getMinSizeTransform(), configuration.getMaxSizeTransform())
                        : objectSize);

        final boolean cut1 = configuration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut2 = configuration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut3 = configuration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut4 = configuration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final int cutSize = Math.round(size * configuration.getCutSize());

        final boolean haveCenterObject = configuration.haveCenterObject();
        final int centerObjectSize = Math.round(size * configuration.getCenterObjectSize());

        final int alpha = configuration.isHaveAlpha() ? PApplet.parseInt(applet.random(configuration.getMinAlpha(), configuration.getMaxAlpha())) : 255;

        applet.pushMatrix();
        applet.fill(Utils.getRandomColor(applet, configuration.getColorsForm().get(FormType.CIRCLE)), alpha);
        applet.circle(x + size / 2f, y + size / 2f, size);

        if (cut1)
        {
            applet.fill(Utils.getRandomColor(applet, configuration.getColorsCutCircle()));
            applet.circle(x + size / 2f, y + cutSize / 2f, cutSize);
        }
        else if (cut2)
        {
            applet.fill(Utils.getRandomColor(applet, configuration.getColorsCutCircle()));
            applet.circle(x + size - cutSize / 2f, y + size / 2f, cutSize);
        }
        else if (cut3)
        {
            applet.fill(Utils.getRandomColor(applet, configuration.getColorsCutCircle()));
            applet.circle(x + size / 2f, y + size - cutSize / 2f, cutSize);
        }
        else if (cut4)
        {
            applet.fill(Utils.getRandomColor(applet, configuration.getColorsCutCircle()));
            applet.circle(x + cutSize / 2f, y + size / 2f, cutSize);
        }

        if (haveCenterObject)
        {
            applet.fill(Utils.getRandomColor(applet, configuration.getColorsCenterObject()));
            applet.circle(x + size / 2f, y + size / 2f, centerObjectSize);
        }

        applet.popMatrix();
    }
}
