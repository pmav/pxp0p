package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.configuration.Configuration;
import eu.pmav.pxp0p.render.forms.FormType;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;
import processing.core.PConstants;

public class SemiCircleForm extends Form
{
    public SemiCircleForm()
    {
        super();
    }

    public void draw(int x, int y, int frameIndex, Configuration configuration, int objectSize, PApplet applet)
    {
        final int size = PApplet.parseInt(
                configuration.isHaveSizeTransform()
                        ? objectSize * applet.random(configuration.getMinSizeTransform(), configuration.getMaxSizeTransform())
                        : objectSize);

        applet.pushMatrix();

        applet.fill(Utils.getRandomColor(applet, configuration.getColorsForm().get(FormType.SQUARE)));
        applet.arc(x + size / 2f, y + size / 2f, size, size, 0, PConstants.PI, PConstants.CHORD);

        applet.popMatrix();
    }
}
