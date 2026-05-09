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
        // Frame index
        final int frameIndex = objectConfiguration.getFrameIndex();

        int x = objectConfiguration.getX() // Get top left coordinate
                + (frameConfiguration.getxVariationFunction() != null ? frameConfiguration.getxVariationFunction().run(frameIndex) : 0); // Position variation

        int y = objectConfiguration.getY() // Get top left coordinate
                + (frameConfiguration.getyVariationFunction() != null ? frameConfiguration.getyVariationFunction().run(frameIndex) : 0); // Position variation

        // Size transform
        final int size = (int)(
                frameConfiguration.getSizeTransformFunction() != null
                        ? objectConfiguration.getSize() * frameConfiguration.getSizeTransformFunction().run(frameIndex)
                        : objectConfiguration.getSize());

        // Transparency
        final int alpha = frameConfiguration.getAlphaFunction() != null
                ? frameConfiguration.getAlphaFunction().run(objectConfiguration.getFrameIndex())
                : 255;

        final boolean hasCuts = frameConfiguration.hasCuts();
        final int cutSize = Math.round(size * frameConfiguration.getCutSize());

        final boolean hasCenterObject = frameConfiguration.hasCenterObject();
        final int centerObjectSize = Math.round(size * frameConfiguration.getCenterObjectSize());

        // Draw
        applet.pushMatrix();

        // Rotate (first translate to center of object)
        if (frameConfiguration.getRotateFunction() != null)
        {
            final int xCenter = x + size / 2;
            final int yCenter = y + size / 2;
            applet.translate(xCenter, yCenter);
            applet.rotate(PApplet.radians(frameConfiguration.getRotateFunction().run(frameIndex)));
            x = x - xCenter; // Offset x based on translation
            y = y - yCenter; // Offset y based on translation
        }

        int[] colors = frameConfiguration.getColorsForm().get(FormType.TRIANGLE);
        applet.fill(colors[Utils.getRandomInt(colors.length)], alpha);

        applet.triangle(x, y + size, x + (size / 2f), y, x + size, y + size);

        if (hasCuts)
        {
            int[] cutColors = frameConfiguration.getColorsCutTriangle();

            // Top cut
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.triangle(
                    x + size / 2f - cutSize / 2f, y + cutSize,
                    x + size / 2f, y,
                    x + size / 2f + cutSize / 2f, y + cutSize);

            // Left cut
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.triangle(
                    x, y + size,
                    x + cutSize / 2f, y + size - cutSize,
                    x + cutSize, y + size);

            // Right cut
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.triangle(
                    x + size - cutSize, y + size,
                    x + size - cutSize / 2f, y + size - cutSize,
                    x + size, y + size);
        }

        if (hasCenterObject)
        {
            int[] centerColors = frameConfiguration.getColorsCenterObject();
            applet.fill(centerColors[Utils.getRandomInt(centerColors.length)]);

            final int xCenter = x + size / 2;
            final int yCenter = y + size / 2;

            // This is a y-axis adjustment to center the center object relative to the main object
            final int yAdjust = (size - centerObjectSize) / 4;

            applet.triangle(
                    xCenter - (centerObjectSize / 2f), yCenter + (centerObjectSize / 2f) + yAdjust,
                    xCenter, yCenter - (centerObjectSize / 2f) + yAdjust,
                    xCenter + (centerObjectSize / 2f), yCenter + (centerObjectSize / 2f) + yAdjust);
        }

        applet.popMatrix();
    }
}
