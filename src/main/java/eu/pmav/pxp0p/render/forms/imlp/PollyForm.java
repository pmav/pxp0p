package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.render.model.Configuration;
import processing.core.PApplet;
import processing.core.PShape;

public class PollyForm extends Form
{
    public PollyForm(PApplet pApplet)
    {
        super(pApplet);
    }

    public void draw(int x, int y, int frameIndex, Configuration configuration)
    {


        pApplet.pushMatrix();

        pApplet.fill(getRandomColor(configuration.getColorsSquare()));

        pApplet.beginShape();
        pApplet.vertex(100,100);
        pApplet.vertex(100,200);
        pApplet.vertex(200,100);
        pApplet.vertex(200,200);

//        for (float a = 0; a < TWO_PI; a += angle) {
//            float sx = x + cos(a) * radius;
//            float sy = y + sin(a) * radius;
//            vertex(sx, sy);
//        }

        pApplet.endShape(PShape.CLOSE);

        pApplet.popMatrix();
    }
}
