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

        System.out.printf("x: %s, y: %s, size: %s\n", x, y, size);

        applet.pushMatrix();

        // Point
        //applet.stroke(0xffffff00);
        //applet.strokeWeight(8);
        //applet.point(xCenter, yCenter);

        // Rotate (first translate to center of object)
        final int xCenter = x + size / 2;
        final int yCenter = y + size / 2;
        applet.translate(xCenter, yCenter);
        applet.rotate(PApplet.radians(1f * objectConfiguration.getFrameIndex()));
        x = x - xCenter; // Offset x based on translation
        y = y - yCenter; // Offset y based on translation

        int[] colors = frameConfiguration.getColorsForm().get(FormType.DEBUG);
        applet.fill(colors[Utils.getRandomInt(colors.length)]);

        // Create square
        applet.beginShape();
        applet.vertex(x, y);
        applet.vertex(x + size, y);
        applet.vertex(x + size, y + size);
        applet.vertex(x, y + size);
        applet.endShape(PShape.CLOSE);

        applet.popMatrix();
    }
}
