package eu.pmav.pxp0p.framerendered.forms;

import eu.pmav.pxp0p.frameconfiguration.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.model.ObjectConfiguration;
import processing.core.PApplet;

public abstract class Form
{
    public Form()
    {
    }

    public abstract void draw(PApplet applet, FrameConfiguration frameConfiguration, ObjectConfiguration objectConfiguration);
}
