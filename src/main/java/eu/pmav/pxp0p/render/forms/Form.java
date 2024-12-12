package eu.pmav.pxp0p.render.forms;

import eu.pmav.pxp0p.configuration.Configuration;
import processing.core.PApplet;

public abstract class Form
{
    protected final PApplet applet;

    public Form(PApplet applet)
    {
        this.applet = applet;
    }

    public abstract void draw(int x, int y, int frameIndex, Configuration configuration);

    // TODO Move this method to a utils file
    protected int getRandomColor(int[] colors)
    {
        return colors[PApplet.parseInt(applet.random(colors.length))];
    }
}
