package eu.pmav.pxp0p.app.forms.imlp;

import eu.pmav.pxp0p.app.model.Configuration;
import eu.pmav.pxp0p.app.forms.Form;
import processing.core.PApplet;

public class SquareForm extends Form
{
    public SquareForm(PApplet pApplet)
    {
        super(pApplet);
    }

    public void draw(int x, int y, Configuration configuration)
    {
        final int size = PApplet.parseInt(
            configuration.isHaveSizeTransform()
                ? configuration.getObjectSize() * pApplet.random(configuration.getMinSizeTransform(), configuration.getMaxSizeTransform())
                : configuration.getObjectSize());

        int offset = configuration.getObjectSize() - size;
        x = x + offset/2;
        y = y + offset/2;

        final boolean cut1 = configuration.isHaveCuts() && PApplet.parseInt(pApplet.random(0, 2)) == 1;
        final boolean cut2 = configuration.isHaveCuts() && PApplet.parseInt(pApplet.random(0, 2)) == 1;
        final boolean cut3 = configuration.isHaveCuts() && PApplet.parseInt(pApplet.random(0, 2)) == 1;
        final boolean cut4 = configuration.isHaveCuts() && PApplet.parseInt(pApplet.random(0, 2)) == 1;
        final int cutSize = Math.round(size * configuration.getCutSize());

        final boolean haveCenterObject = configuration.haveCenterObject();
        final int centerObjectSize = Math.round(size * configuration.getCenterObjectSize());

        final int alpha = configuration.isHaveAlpha()
            ? PApplet.parseInt(pApplet.random(configuration.getMinAlpha(), configuration.getMaxAlpha()))
            : 255;

        pApplet.pushMatrix();

        pApplet.fill(getRandomColor(configuration.getColorsSquare()), alpha);
        pApplet.square(x, y, size);

        if (cut1)
        {
            pApplet.fill(getRandomColor(configuration.getColorsCutSquare()));
            pApplet.square(x, y, cutSize);
        }

        if (cut2)
        {
            pApplet.fill(getRandomColor(configuration.getColorsCutSquare()));
            pApplet.square(x + size - cutSize, y, cutSize);
        }

        if (cut3)
        {
            pApplet.fill(getRandomColor(configuration.getColorsCutSquare()));
            pApplet.square(x, y + size - cutSize, cutSize);
        }

        if (cut4)
        {
            pApplet.fill(getRandomColor(configuration.getColorsCutSquare()));
            pApplet.square(x + size - cutSize, y + size - cutSize, cutSize);
        }

        if (haveCenterObject) {
            pApplet.fill(getRandomColor(configuration.getColorsCenterObject()), alpha);
            pApplet.square((x+size/2f)-(centerObjectSize/2f), (y+size/2f)-(centerObjectSize/2f), centerObjectSize);
        }

        pApplet.popMatrix();
    }
}
