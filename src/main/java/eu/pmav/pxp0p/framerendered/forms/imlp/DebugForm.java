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
        // Get initial X position variation
        final int xVariation = frameConfiguration.getxVariationFunction() != null
                ? frameConfiguration.getxVariationFunction().run(0)
                : 0;

        // Get initial Y position variation
        final int yVariation = frameConfiguration.getyVariationFunction() != null
                ? frameConfiguration.getyVariationFunction().run(0)
                : 0;

        final int x = objectConfiguration.getX()
                + Math.round((Utils.getRandomFloat(-1, 1) * xVariation));

        final int y = objectConfiguration.getY()
                + Math.round((Utils.getRandomFloat(-1, 1) * yVariation));

        final int size = objectConfiguration.getSize();

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
