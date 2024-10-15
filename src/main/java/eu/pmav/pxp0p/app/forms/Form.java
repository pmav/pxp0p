package eu.pmav.pxp0p.app.forms;

import eu.pmav.pxp0p.app.model.Configuration;
import processing.core.PApplet;

public abstract class Form
{
    protected final PApplet pApplet;

    public Form(PApplet pApplet)
    {
        this.pApplet = pApplet;
    }

    public abstract void draw(int x, int y, Configuration configuration);

    protected int getRandomColor(int[] colors)
    {
        return colors[PApplet.parseInt(pApplet.random(colors.length))];
    }
}
