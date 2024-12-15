package eu.pmav.pxp0p.render.forms;

import eu.pmav.pxp0p.configuration.FrameConfiguration;
import eu.pmav.pxp0p.render.model.ObjectConfiguration;
import processing.core.PApplet;

public abstract class Form
{
    public Form()
    {
    }

    public abstract void draw(PApplet applet, FrameConfiguration frameConfiguration, ObjectConfiguration objectConfiguration);
}
