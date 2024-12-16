package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.configuration.FrameConfiguration;
import eu.pmav.pxp0p.render.forms.FormType;
import eu.pmav.pxp0p.render.model.ObjectConfiguration;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;
import processing.core.PConstants;

public class SemiCircleForm extends Form
{
    public SemiCircleForm()
    {
        super();
    }

    public void draw(PApplet applet, FrameConfiguration frameConfiguration, ObjectConfiguration objectConfiguration)
    {
        final int x = frameConfiguration.getxVariation() != 0
                ? objectConfiguration.getX() + Math.round((applet.random(-1, 1) * frameConfiguration.getxVariation()))
                : objectConfiguration.getX();

        final int y = frameConfiguration.getyVariation() != 0
                ? objectConfiguration.getY() + Math.round((applet.random(-1, 1) * frameConfiguration.getyVariation()))
                : objectConfiguration.getY();

        final int objectSize = frameConfiguration.getSize();

        final int size = PApplet.parseInt(
                frameConfiguration.isHaveSizeTransform()
                        ? objectSize * applet.random(frameConfiguration.getMinSizeTransform(), frameConfiguration.getMaxSizeTransform())
                        : objectSize);

        applet.pushMatrix();

        applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsForm().get(FormType.SQUARE)));
        applet.arc(x + size / 2f, y + size / 2f, size, size, 0, PConstants.PI, PConstants.CHORD);

        applet.popMatrix();
    }
}
