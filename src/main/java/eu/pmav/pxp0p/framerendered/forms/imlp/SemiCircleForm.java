package eu.pmav.pxp0p.framerendered.forms.imlp;

import eu.pmav.pxp0p.framerendered.forms.Form;
import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.framerendered.model.ObjectConfiguration;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;
import processing.core.PConstants;

public class SemiCircleForm extends Form
{
    public SemiCircleForm()
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

        final int x = objectConfiguration.getX() // Get center coordinate
                - (frameConfiguration.getSize() / 2) // Offset coordinate to top left
                + xVariation; // Position variation

        final int y = objectConfiguration.getY() // Get center coordinate
                - (frameConfiguration.getSize() / 2) // Offset coordinate to top left
                + yVariation; // Position variation

        final int size = (int)(
                frameConfiguration.hasSizeTransform()
                        ? frameConfiguration.getSize() * Utils.getRandomFloat(frameConfiguration.getMinSizeTransform(), frameConfiguration.getMaxSizeTransform())
                        : frameConfiguration.getSize());

        // Transparency
        final int alpha = frameConfiguration.hasAlpha()
                ? frameConfiguration.getAlphaFunction().run(objectConfiguration.getFrameIndex())
                : 255;

        // Center object
        final boolean haveCenterObject = frameConfiguration.hasCenterObject();
        final int centerObjectSize = Math.round(size * frameConfiguration.getCenterObjectSize());

        // Get anglesForObject for the main object based on direction
        final int direction = frameConfiguration.hasDirection()
                ? frameConfiguration.getCalculateDirection().apply(frameIndex)
                : 0;
        Angles anglesForObject = getAngles(direction);

        // Get anglesForObject for the center object
        Angles anglesForCenterObject = getAngles((direction + 2) % 4);

        // Draw
        applet.pushMatrix();

        int[] colors = frameConfiguration.getColorsForm().get(FormType.SEMICIRCLE);
        applet.fill(colors[Utils.getRandomInt(colors.length)], alpha);
        applet.arc(x + size / 2f, y + size / 2f, size, size, anglesForObject.startAngle(), anglesForObject.stopAngle(), PConstants.CHORD);

        if (haveCenterObject)
        {
            int[] centerColors = frameConfiguration.getColorsCenterObject();
            applet.fill(centerColors[Utils.getRandomInt(centerColors.length)]);
            applet.arc(x + size / 2f, y + size / 2f, centerObjectSize, centerObjectSize, anglesForCenterObject.startAngle(), anglesForCenterObject.stopAngle(), PConstants.CHORD);
        }

        applet.popMatrix();
    }

    private static Angles getAngles(int direction) {
        final float startAngle = switch (direction) {
            case 0 -> 0;
            case 1 -> 1 * PConstants.HALF_PI;
            case 2 -> 2 * PConstants.HALF_PI;
            case 3 -> 3 * PConstants.HALF_PI;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };

        final float stopAngle = switch (direction) {
            case 0 -> 2 * PConstants.HALF_PI;
            case 1 -> 3 * PConstants.HALF_PI;
            case 2 -> 4 * PConstants.HALF_PI;
            case 3 -> 5 * PConstants.HALF_PI;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        };

        return new Angles(startAngle, stopAngle);
    }

    private record Angles(float startAngle, float stopAngle) { }
}
