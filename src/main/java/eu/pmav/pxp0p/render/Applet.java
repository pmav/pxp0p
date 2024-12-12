package eu.pmav.pxp0p.render;

import eu.pmav.pxp0p.configuration.Configuration;
import eu.pmav.pxp0p.utils.ExitHandler;
import processing.core.PApplet;

public class Applet extends PApplet
{
    private final Configuration configuration;

    private final ExitHandler exitHandler;

    public Applet(Configuration configuration, ExitHandler exitHandler)
    {
        this.configuration = configuration;
        this.exitHandler = exitHandler;
    }

    public void settings()
    {
        size(this.configuration.getCanvasWidth(), this.configuration.getCanvasHeight());
    }

    public void setup()
    {
        noLoop();
    }

    public void draw()
    {
        // Render frame
        (new Frame(this, configuration)).render();

        // Save from to disk
        save(this.configuration.getFramePath());

        // Notify Exit Handler that this Applet have finished
        this.exitHandler.notifyFinish(this);
    }
}
