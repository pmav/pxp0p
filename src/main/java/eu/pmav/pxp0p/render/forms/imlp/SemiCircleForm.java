package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.configuration.Configuration;
import eu.pmav.pxp0p.render.forms.FormType;
import processing.core.PApplet;
import processing.core.PConstants;

public class SemiCircleForm extends Form
{
    public SemiCircleForm(PApplet pApplet)
    {
        super(pApplet);
    }

    public void draw(int x, int y, int frameIndex, Configuration configuration)
    {
        final int size = PApplet.parseInt(
                configuration.isHaveSizeTransform()
                        ? configuration.getObjectSize() * pApplet.random(configuration.getMinSizeTransform(), configuration.getMaxSizeTransform())
                        : configuration.getObjectSize());

        pApplet.pushMatrix();

        pApplet.fill(getRandomColor(configuration.getColorsForm().get(FormType.SQUARE)));
        pApplet.arc(x + size / 2f, y + size / 2f, size, size, 0, PConstants.PI, PConstants.CHORD);

        pApplet.popMatrix();
    }
}
