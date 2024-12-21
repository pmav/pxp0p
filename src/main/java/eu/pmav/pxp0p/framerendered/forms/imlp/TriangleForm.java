package eu.pmav.pxp0p.framerendered.forms.imlp;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.Form;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.framerendered.model.ObjectConfiguration;
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
        int x = frameConfiguration.getxVariation() != 0
                ? objectConfiguration.getX() + Math.round((Utils.getRandomFloat(-1, 1) * frameConfiguration.getxVariation()))
                : objectConfiguration.getX();

        int y = frameConfiguration.getyVariation() != 0
                ? objectConfiguration.getY() + Math.round((Utils.getRandomFloat(-1, 1) * frameConfiguration.getyVariation()))
                : objectConfiguration.getY();

        final int size = (int)(
                frameConfiguration.hasSizeTransform()
                        ? frameConfiguration.getSize() * Utils.getRandomFloat(frameConfiguration.getMinSizeTransform(), frameConfiguration.getMaxSizeTransform())
                        : frameConfiguration.getSize());

        x = x - (frameConfiguration.getSize() / 2);
        y = y - (frameConfiguration.getSize() / 2);

        final int frameIndex = objectConfiguration.getFrameIndex();
        final boolean cut1 = frameConfiguration.hasCuts(); // && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final int cutSize = Math.round(size * frameConfiguration.getCutSize());

        final int alpha = frameConfiguration.hasAlpha()
                ? (int)(Utils.getRandomFloat(frameConfiguration.getMinAlpha(), frameConfiguration.getMaxAlpha()))
                : 255;

        final int direction = frameConfiguration.hasDirection()
                ? frameConfiguration.getCalculateDirection().apply(frameIndex) // (int)(Utils.getRandomFloat(0, 4))
                : 0;

        applet.pushMatrix();

        int[] colors = frameConfiguration.getColorsForm().get(FormType.TRIANGLE);
        applet.fill(colors[Utils.getRandomInt(colors.length)], alpha);

        switch (direction)
        {
            case 0:
                // Pointing up
                applet.triangle(x, y + size, x + (size / 2f), y, x + size, y + size);

                if (cut1)
                {
                    int[] cutColors = frameConfiguration.getColorsCutTriangle();
                    applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);

                    x = x + size / 2 - cutSize / 2;
                    applet.triangle(x, y + cutSize, x + (cutSize / 2f), y, x + cutSize, y + cutSize);
                }
                break;

            case 2:
                // Pointing down
                applet.triangle(x, y, x + size, y, x + (size / 2f), y + size);
                if (cut1)
                {
                    int[] cutColors = frameConfiguration.getColorsCutTriangle();
                    applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);

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
                    int[] cutColors = frameConfiguration.getColorsCutTriangle();
                    applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);

                    y = y + size / 2 - cutSize / 2;
                    applet.triangle(x + cutSize, y, x, y + (cutSize / 2f), x + cutSize, y + cutSize);
                }
                break;

            case 1:
                // Pointing right
                applet.triangle(x, y, x, y + size, x + size, y + (size / 2f));
                if (cut1)
                {
                    int[] cutColors = frameConfiguration.getColorsCutTriangle();
                    applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);

                    x = x + size - cutSize;
                    y = y + size / 2 - cutSize / 2;
                    applet.triangle(x, y, x, y + cutSize, x + cutSize, y + (cutSize / 2f));
                }
                break;
        }

        applet.popMatrix();
    }
}
