package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.configuration.FrameConfiguration;
import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.render.forms.FormType;
import eu.pmav.pxp0p.render.model.ObjectConfiguration;
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
        final int x = frameConfiguration.getxVariation() != 0
                ? objectConfiguration.getX() + Math.round((applet.random(-1, 1) * frameConfiguration.getxVariation()))
                : objectConfiguration.getX();

        final int y = frameConfiguration.getyVariation() != 0
                ? objectConfiguration.getY() + Math.round((applet.random(-1, 1) * frameConfiguration.getyVariation()))
                : objectConfiguration.getY();

        final int size = frameConfiguration.getSize();

        System.out.printf("x: %s, y: %s, size: %s\n", x, y, size);

        applet.pushMatrix();

        // Create square
        applet.fill(Utils.getRandomColor(applet, frameConfiguration.getColorsForm().get(FormType.DEBUG)));

        applet.beginShape();
        applet.vertex(x, y);
        applet.vertex(x + size, y);
        applet.vertex(x + size, y + size);
        applet.vertex(x, y + size);
        applet.endShape(PShape.OPEN);

        applet.popMatrix();
    }
}
