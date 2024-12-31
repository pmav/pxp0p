package eu.pmav.pxp0p.framerendered.forms.imlp;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.Form;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.framerendered.model.ObjectConfiguration;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;

public class SquareForm extends Form
{
    public SquareForm()
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

        final boolean cut1 = frameConfiguration.hasCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final boolean cut2 = frameConfiguration.hasCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final boolean cut3 = frameConfiguration.hasCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final boolean cut4 = frameConfiguration.hasCuts() && (int)(Utils.getRandomFloat(0, 2)) == 1;
        final int cutSize = Math.round(size * frameConfiguration.getCutSize());

        final boolean haveCenterObject = frameConfiguration.hasCenterObject();
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

        int[] colors = frameConfiguration.getColorsForm().get(FormType.SQUARE);
        applet.fill(colors[Utils.getRandomInt(colors.length)], alpha);

        applet.square(x, y, size);

        if (cut1)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.square(x, y, cutSize);
        }

        if (cut2)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.square(x + size - cutSize, y, cutSize);
        }

        if (cut3)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.square(x, y + size - cutSize, cutSize);
        }

        if (cut4)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.square(x + size - cutSize, y + size - cutSize, cutSize);
        }

        if (haveCenterObject)
        {
            int[] centerColors = frameConfiguration.getColorsCenterObject();
            applet.fill(centerColors[Utils.getRandomInt(centerColors.length)]);
            applet.square((x + size / 2f) - (centerObjectSize / 2f), (y + size / 2f) - (centerObjectSize / 2f), centerObjectSize);
        }

        applet.popMatrix();
    }
}
