package eu.pmav.pxp0p.render.forms;

import eu.pmav.pxp0p.configuration.Configuration;
import processing.core.PApplet;

public abstract class Form
{
    protected final PApplet pApplet;

    public Form(PApplet pApplet)
    {
        this.pApplet = pApplet;
    }

    public abstract void draw(int x, int y, int frameIndex, Configuration configuration);

    protected int getRandomColor(int[] colors)
    {
        return colors[PApplet.parseInt(pApplet.random(colors.length))];
    }
}
