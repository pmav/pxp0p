package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.configuration.FrameConfiguration;
import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.render.forms.FormType;
import eu.pmav.pxp0p.render.model.ObjectConfiguration;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;

public class TriangleForm extends Form
{
    public TriangleForm()
    {
        super();
    }

    public void draw(PApplet applet, FrameConfiguration frameConfiguration, ObjectConfiguration objectConfiguration)
    {
        int x = objectConfiguration.getX();
        int y = objectConfiguration.getY();
        final int objectSize = frameConfiguration.getSize();
        final int frameIndex = objectConfiguration.getFrameIndex();

        final int size = PApplet.parseInt(
                frameConfiguration.isHaveSizeTransform()
                        ? objectSize * applet.random(frameConfiguration.getMinSizeTransform(), frameConfiguration.getMaxSizeTransform())
                        : objectSize);

        final boolean cut1 = frameConfiguration.isHaveCuts(); // && PApplet.parseInt(pApplet.random(0, 2)) == 1;
        final int cutSize = Math.round(size * frameConfiguration.getCutSize());

        final int direction = frameConfiguration.isHaveDirection()
                ? frameConfiguration.getCalculateDirection().apply(frameIndex) // PApplet.parseInt(pApplet.random(0, 4))
                : 0;

        final int alpha = frameConfiguration.isHaveAlpha()
                ? PApplet.parseInt(applet.random(frameConfiguration.getMinAlpha(), frameConfiguration.getMaxAlpha()))
                : 255;

        applet.pushMatrix();
        applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsForm().get(FormType.TRIANGLE)), alpha);

        switch (direction)
        {
            case 0:
                // Pointing up
                applet.triangle(x, y + size, x + (size / 2f), y, x + size, y + size);

                if (cut1)
                {
                    applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutTriangle()));
                    x = x + size / 2 - cutSize / 2;
                    applet.triangle(x, y + cutSize, x + (cutSize / 2f), y, x + cutSize, y + cutSize);
                }
                break;

            case 2:
                // Pointing down
                applet.triangle(x, y, x + size, y, x + (size / 2f), y + size);
                if (cut1)
                {
                    applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutTriangle()));
                    x = x + size / 2 - cutSize / 2;
                    y = y + size - cutSize;
                    applet.triangle(x, y, x + cutSize, y, x + (cutSize / 2f), y + cutSize);
                }
                break;

            case 3:
                // Pointing left
                applet.triangle(x + size, y, x, y + (size / 2f), x + size, y + size);
                if (cut1)
                {
                    applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutTriangle()));
                    y = y + size / 2 - cutSize / 2;
                    applet.triangle(x + cutSize, y, x, y + (cutSize / 2f), x + cutSize, y + cutSize);
                }
                break;

            case 1:
                // Pointing right
                applet.triangle(x, y, x, y + size, x + size, y + (size / 2f));
                if (cut1)
                {
                    applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsCutTriangle()));
                    x = x + size - cutSize;
                    y = y + size / 2 - cutSize / 2;
                    applet.triangle(x, y, x, y + cutSize, x + cutSize, y + (cutSize / 2f));
                }
                break;
        }

        applet.popMatrix();
    }
}
