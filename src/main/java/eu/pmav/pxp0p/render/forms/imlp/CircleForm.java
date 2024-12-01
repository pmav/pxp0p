package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.render.model.Configuration;
import processing.core.PApplet;

public class CircleForm extends Form
{
    public CircleForm(PApplet pApplet)
    {
        super(pApplet);
    }

    public void draw(int x, int y, int frameIndex, Configuration configuration)
    {
        final int size = PApplet.parseInt(
                configuration.isHaveSizeTransform()
                        ? configuration.getObjectSize() * pApplet.random(configuration.getMinSizeTransform(), configuration.getMaxSizeTransform())
                        : configuration.getObjectSize());

        final boolean cut1 = configuration.isHaveCuts() && PApplet.parseInt(pApplet.random(0, 2)) == 1;
        final boolean cut2 = configuration.isHaveCuts() && PApplet.parseInt(pApplet.random(0, 2)) == 1;
        final boolean cut3 = configuration.isHaveCuts() && PApplet.parseInt(pApplet.random(0, 2)) == 1;
        final boolean cut4 = configuration.isHaveCuts() && PApplet.parseInt(pApplet.random(0, 2)) == 1;
        final int cutSize = Math.round(size * configuration.getCutSize());

        final boolean haveCenterObject = configuration.haveCenterObject();
        final int centerObjectSize = Math.round(size * configuration.getCenterObjectSize());

        final int alpha = configuration.isHaveAlpha() ? PApplet.parseInt(pApplet.random(configuration.getMinAlpha(), configuration.getMaxAlpha())) : 255;

        pApplet.pushMatrix();
        pApplet.fill(getRandomColor(configuration.getColorsCircle()), alpha);
        pApplet.circle(x + size / 2f, y + size / 2f, size);

        if (cut1)
        {
            pApplet.fill(getRandomColor(configuration.getColorsCutCircle()));
            pApplet.circle(x + size / 2f, y + cutSize / 2f, cutSize);
        }
        else if (cut2)
        {
            pApplet.fill(getRandomColor(configuration.getColorsCutCircle()));
            pApplet.circle(x + size - cutSize / 2f, y + size / 2f, cutSize);
        }
        else if (cut3)
        {
            pApplet.fill(getRandomColor(configuration.getColorsCutCircle()));
            pApplet.circle(x + size / 2f, y + size - cutSize / 2f, cutSize);
        }
        else if (cut4)
        {
            pApplet.fill(getRandomColor(configuration.getColorsCutCircle()));
            pApplet.circle(x + cutSize / 2f, y + size / 2f, cutSize);
        }

        if (haveCenterObject)
        {
            pApplet.fill(getRandomColor(configuration.getColorsCenterObject()));
            pApplet.circle(x + size / 2f, y + size / 2f, centerObjectSize);
        }

        pApplet.popMatrix();
    }
}
