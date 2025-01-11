package eu.pmav.pxp0p;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.frameconfiguration.model.Frame;
import eu.pmav.pxp0p.framerendered.FrameRendered;
import eu.pmav.pxp0p.utils.ExitHandler;
import processing.core.PApplet;

public class Applet extends PApplet
{
    private final Frame frame;

    private final ExitHandler exitHandler;

    public Applet(Frame frame, ExitHandler exitHandler)
    {
        this.frame = frame;
        this.exitHandler = exitHandler;
    }

    public void settings()
    {
        FrameConfiguration frameConfiguration = this.frame.getFrameConfigurations().getFirst();

        // Use first configuration to set canvas size
        size(frameConfiguration.getCanvasWidth(), frameConfiguration.getCanvasHeight());

        // Leve 3 applies bicubic smoothing
        // Source: https://processing.org/reference/smooth_.html
        smooth(3);
    }

    public void setup()
    {
        noLoop();
    }

    public void draw()
    {
        // Render multiple frame configurations in a single frame
        this.frame.getFrameConfigurations().forEach(frameConfiguration -> FrameRendered.render(this, frameConfiguration));

        // Save from to disk using the first configuration
        FrameConfiguration frameConfiguration = this.frame.getFrameConfigurations().getFirst();
        save(frameConfiguration.getFramePath());

        // Notify Exit Handler that this Applet have finished
        this.exitHandler.notifyFinish(this);
    }
}
