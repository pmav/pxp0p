package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.render.model.Configuration;
import processing.core.PApplet;

public class TriangleForm extends Form
{
    public TriangleForm(PApplet pApplet)
    {
        super(pApplet);
    }

    public void draw(int x, int y, int frameIndex, Configuration configuration)
    {
        final int size = PApplet.parseInt(
                configuration.isHaveSizeTransform()
                        ? configuration.getObjectSize() * pApplet.random(configuration.getMinSizeTransform(), configuration.getMaxSizeTransform())
                        : configuration.getObjectSize());

        final boolean cut1 = configuration.isHaveCuts(); // && PApplet.parseInt(pApplet.random(0, 2)) == 1;
        final int cutSize = Math.round(size * configuration.getCutSize());

        final int direction = configuration.isHaveDirection()
                ? configuration.getCalculateDirection().apply(frameIndex) // PApplet.parseInt(pApplet.random(0, 4))
                : 0;

        final int alpha = configuration.isHaveAlpha()
                ? PApplet.parseInt(pApplet.random(configuration.getMinAlpha(), configuration.getMaxAlpha()))
                : 255;

        pApplet.pushMatrix();
        pApplet.fill(getRandomColor(configuration.getColorsTriangle()), alpha);

        switch (direction)
        {
            case 0:
                // Pointing up
                pApplet.triangle(x, y + size, x + (size / 2f), y, x + size, y + size);

                if (cut1)
                {
                    pApplet.fill(getRandomColor(configuration.getColorsCutTriangle()));
                    x = x + size / 2 - cutSize / 2;
                    pApplet.triangle(x, y + cutSize, x + (cutSize / 2f), y, x + cutSize, y + cutSize);
                }
                break;

            case 2:
                // Pointing down
                pApplet.triangle(x, y, x + size, y, x + (size / 2f), y + size);
                if (cut1)
                {
                    pApplet.fill(getRandomColor(configuration.getColorsCutTriangle()));
                    x = x + size / 2 - cutSize / 2;
                    y = y + size - cutSize;
                    pApplet.triangle(x, y, x + cutSize, y, x + (cutSize / 2f), y + cutSize);
                }
                break;

            case 3:
                // Pointing left
                pApplet.triangle(x + size, y, x, y + (size / 2f), x + size, y + size);
                if (cut1)
                {
                    pApplet.fill(getRandomColor(configuration.getColorsCutTriangle()));
                    y = y + size / 2 - cutSize / 2;
                    pApplet.triangle(x + cutSize, y, x, y + (cutSize / 2f), x + cutSize, y + cutSize);
                }
                break;

            case 1:
                // Pointing right
                pApplet.triangle(x, y, x, y + size, x + size, y + (size / 2f));
                if (cut1)
                {
                    pApplet.fill(getRandomColor(configuration.getColorsCutTriangle()));
                    x = x + size - cutSize;
                    y = y + size / 2 - cutSize / 2;
                    pApplet.triangle(x, y, x, y + cutSize, x + cutSize, y + (cutSize / 2f));
                }
                break;
        }

        pApplet.popMatrix();
    }
}
