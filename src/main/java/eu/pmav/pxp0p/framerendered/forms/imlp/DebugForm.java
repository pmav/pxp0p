package eu.pmav.pxp0p.framerendered.forms.imlp;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.Form;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.framerendered.model.ObjectConfiguration;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;
import processing.core.PShape;

public class DebugForm extends Form
{
    public DebugForm()
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

        final int size = frameConfiguration.getSize();

        x = x - (frameConfiguration.getSize() / 2);
        y = y - (frameConfiguration.getSize() / 2);

        System.out.printf("x: %s, y: %s, size: %s\n", x, y, size);

        applet.pushMatrix();

        // Create square
        int[] colors = frameConfiguration.getColorsForm().get(FormType.DEBUG);
        applet.fill(colors[Utils.getRandomInt(colors.length)]);

        applet.beginShape();
        applet.vertex(x, y);
        applet.vertex(x + size, y);
        applet.vertex(x + size, y + size);
        applet.vertex(x, y + size);
        applet.endShape(PShape.CLOSE);

        applet.popMatrix();
    }
}
