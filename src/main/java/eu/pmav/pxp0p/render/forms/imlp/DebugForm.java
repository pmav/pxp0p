package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.configuration.Configuration;
import eu.pmav.pxp0p.render.forms.FormType;
import processing.core.PApplet;
import processing.core.PShape;

public class DebugForm extends Form {
    public DebugForm(PApplet pApplet) {
        super(pApplet);
    }

    public void draw(int x, int y, int frameIndex, Configuration configuration) {
        final int size = configuration.getObjectSize();

        System.out.printf("x: %s, y: %s, size: %s\n", x, y, size);

        applet.pushMatrix();

        // Create square
        applet.fill(getRandomColor(configuration.getColorsForm().get(FormType.DEBUG)));

        applet.beginShape();
        applet.vertex(x, y);
        applet.vertex(x + size, y);
        applet.vertex(x + size, y + size);
        applet.vertex(x, y + size);
        applet.endShape(PShape.OPEN);

        applet.popMatrix();
    }
}
