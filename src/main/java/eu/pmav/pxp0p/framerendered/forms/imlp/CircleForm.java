package eu.pmav.pxp0p.framerendered.forms.imlp;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.Form;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.framerendered.model.ObjectConfiguration;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;

public class CircleForm extends Form
{
    public CircleForm()
    {
        super();
    }

    public void draw(PApplet applet, FrameConfiguration frameConfiguration, ObjectConfiguration objectConfiguration)
    {
        // Frame index
        final int frameIndex = objectConfiguration.getFrameIndex();

        // Get initial X position variation
        final int xVariation = frameConfiguration.getxVariationFunction() != null
                ? frameConfiguration.getxVariationFunction().run(frameIndex)
                : 0;

        // Get initial Y position variation
        final int yVariation = frameConfiguration.getyVariationFunction() != null
                ? frameConfiguration.getyVariationFunction().run(frameIndex)
                : 0;

        final int x = objectConfiguration.getX() // Get top left coordinate
                + xVariation; // Position variation

        final int y = objectConfiguration.getY() // Get top left coordinate
                + yVariation; // Position variation

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

        applet.pushMatrix();
        int[] colors = frameConfiguration.getColorsForm().get(FormType.CIRCLE);
        applet.fill(colors[Utils.getRandomInt(colors.length)], alpha);
        applet.circle(x + size / 2f, y + size / 2f, size);

        if (cut1)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.circle(x + size / 2f, y + cutSize / 2f, cutSize);
        }
        else if (cut2)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.circle(x + size - cutSize / 2f, y + size / 2f, cutSize);
        }
        else if (cut3)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.circle(x + size / 2f, y + size - cutSize / 2f, cutSize);
        }
        else if (cut4)
        {
            int[] cutColors = frameConfiguration.getColorsCutSquare();
            applet.fill(cutColors[Utils.getRandomInt(cutColors.length)]);
            applet.circle(x + cutSize / 2f, y + size / 2f, cutSize);
        }

        if (haveCenterObject)
        {
            int[] centerColors = frameConfiguration.getColorsCenterObject();
            applet.fill(centerColors[Utils.getRandomInt(centerColors.length)]);
            applet.circle(x + size / 2f, y + size / 2f, centerObjectSize);
        }

        applet.popMatrix();
    }
}
