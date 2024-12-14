package eu.pmav.pxp0p.render.forms;

import eu.pmav.pxp0p.configuration.Configuration;
import processing.core.PApplet;

public abstract class Form
{
    public Form()
    {
    }

    public abstract void draw(int x, int y, int frameIndex, Configuration configuration, int objectSize, PApplet applet);
}
