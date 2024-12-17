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
        int x = frameConfiguration.getxVariation() != 0
                ? objectConfiguration.getX() + Math.round((applet.random(-1, 1) * frameConfiguration.getxVariation()))
                : objectConfiguration.getX();

        int y = frameConfiguration.getyVariation() != 0
                ? objectConfiguration.getY() + Math.round((applet.random(-1, 1) * frameConfiguration.getyVariation()))
                : objectConfiguration.getY();

        final int size = frameConfiguration.getSize();

        x = x - (frameConfiguration.getSize() / 2);
        y = y - (frameConfiguration.getSize() / 2);

        final int frameIndex = objectConfiguration.getFrameIndex();

        final int direction = frameConfiguration.isHaveDirection()
                ? frameConfiguration.getCalculateDirection().apply(frameIndex)
                : 0;

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

        applet.pushMatrix();

        applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsForm().get(FormType.SEMICIRCLE)));
        applet.arc(x + size / 2f, y + size / 2f, size, size, startAngle, stopAngle, PConstants.CHORD);

        applet.popMatrix();
    }
}
