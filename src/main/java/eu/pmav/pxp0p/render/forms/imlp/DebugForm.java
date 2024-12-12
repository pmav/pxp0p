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

        pApplet.pushMatrix();

        // Create square
        pApplet.fill(getRandomColor(configuration.getColorsForm().get(FormType.DEBUG)));

        pApplet.beginShape();
        pApplet.vertex(x, y);
        pApplet.vertex(x + size, y);
        pApplet.vertex(x + size, y + size);
        pApplet.vertex(x, y + size);
        pApplet.endShape(PShape.OPEN);

        pApplet.popMatrix();
    }
}
