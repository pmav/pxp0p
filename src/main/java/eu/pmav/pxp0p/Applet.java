package eu.pmav.pxp0p;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.FrameRendered;
import eu.pmav.pxp0p.utils.ExitHandler;
import processing.core.PApplet;

public class Applet extends PApplet
{
    private final FrameConfiguration frameConfiguration;

    private final ExitHandler exitHandler;

    public Applet(FrameConfiguration frameConfiguration, ExitHandler exitHandler)
    {
        this.frameConfiguration = frameConfiguration;
        this.exitHandler = exitHandler;
    }

    public void settings()
    {
        size(this.frameConfiguration.getCanvasWidth(), this.frameConfiguration.getCanvasHeight());
    }

    public void setup()
    {
        noLoop();
    }

    public void draw()
    {
        // Render frame
        FrameRendered.render(this, this.frameConfiguration);

        // Save from to disk
        save(this.frameConfiguration.getFramePath());

        // Notify Exit Handler that this Applet have finished
        this.exitHandler.notifyFinish(this);
    }
}
