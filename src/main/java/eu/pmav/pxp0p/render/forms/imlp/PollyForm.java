package eu.pmav.pxp0p.render.forms.imlp;

import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.configuration.Configuration;
import eu.pmav.pxp0p.render.forms.FormType;
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


        applet.pushMatrix();

        applet.fill(getRandomColor(configuration.getColorsForm().get(FormType.SQUARE)));

        applet.beginShape();
        applet.vertex(100,100);
        applet.vertex(100,200);
        applet.vertex(200,100);
        applet.vertex(200,200);

//        for (float a = 0; a < TWO_PI; a += angle) {
//            float sx = x + cos(a) * radius;
//            float sy = y + sin(a) * radius;
//            vertex(sx, sy);
//        }

        applet.endShape(PShape.CLOSE);

        applet.popMatrix();
    }
}
