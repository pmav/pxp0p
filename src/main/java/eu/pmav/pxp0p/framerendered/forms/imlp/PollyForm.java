package eu.pmav.pxp0p.framerendered.forms.imlp;

import eu.pmav.pxp0p.framerendered.forms.Form;
import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.framerendered.model.ObjectConfiguration;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;
import processing.core.PShape;

public class PollyForm extends Form
{
    public PollyForm()
    {
        super();
    }

    public void draw(PApplet applet, FrameConfiguration frameConfiguration, ObjectConfiguration objectConfiguration)
    {
        applet.pushMatrix();

        int[] colors = frameConfiguration.getColorsForm().get(FormType.SQUARE);
        applet.fill(colors[Utils.getRandomInt(colors.length)]);

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
