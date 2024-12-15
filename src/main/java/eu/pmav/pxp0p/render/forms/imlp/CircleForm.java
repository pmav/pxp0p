package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.configuration.FrameConfiguration;
import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.render.forms.FormType;
import eu.pmav.pxp0p.render.model.ObjectConfiguration;
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
        final int x = objectConfiguration.getX();
        final int y = objectConfiguration.getY();
        final int objectSize = frameConfiguration.getSize();

        final int size = PApplet.parseInt(
                frameConfiguration.isHaveSizeTransform()
                        ? objectSize * applet.random(frameConfiguration.getMinSizeTransform(), frameConfiguration.getMaxSizeTransform())
                        : objectSize);

        final boolean cut1 = frameConfiguration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut2 = frameConfiguration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut3 = frameConfiguration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final boolean cut4 = frameConfiguration.isHaveCuts() && PApplet.parseInt(applet.random(0, 2)) == 1;
        final int cutSize = Math.round(size * frameConfiguration.getCutSize());

        final boolean haveCenterObject = frameConfiguration.haveCenterObject();
        final int centerObjectSize = Math.round(size * frameConfiguration.getCenterObjectSize());

        final int alpha = frameConfiguration.isHaveAlpha() ? PApplet.parseInt(applet.random(frameConfiguration.getMinAlpha(), frameConfiguration.getMaxAlpha())) : 255;

        applet.pushMatrix();
        applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsForm().get(FormType.CIRCLE)), alpha);
        applet.circle(x + size / 2f, y + size / 2f, size);

        if (cut1)
        {
            applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutCircle()));
            applet.circle(x + size / 2f, y + cutSize / 2f, cutSize);
        }
        else if (cut2)
        {
            applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutCircle()));
            applet.circle(x + size - cutSize / 2f, y + size / 2f, cutSize);
        }
        else if (cut3)
        {
            applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutCircle()));
            applet.circle(x + size / 2f, y + size - cutSize / 2f, cutSize);
        }
        else if (cut4)
        {
            applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutCircle()));
            applet.circle(x + cutSize / 2f, y + size / 2f, cutSize);
        }

        if (haveCenterObject)
        {
            applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCenterObject()));
            applet.circle(x + size / 2f, y + size / 2f, centerObjectSize);
        }

        applet.popMatrix();
    }
}
