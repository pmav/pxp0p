package eu.pmav.pxp0p;

import eu.pmav.pxp0p.app.Frame;
import eu.pmav.pxp0p.app.model.Configuration;
import processing.core.PApplet;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Applet extends PApplet
{
    private final List<Configuration> configurations;

    private final String saveDirectory;

    private final Main main;

    public Applet(List<Configuration> configurations, String saveDirectory, Main main)
    {
        this.configurations = configurations;
        this.saveDirectory = saveDirectory;
        this.main = main;
    }

    public void settings()
    {
        // TODO Refactor
        size(this.configurations.getFirst().getCanvasWidth(), this.configurations.getFirst().getCanvasHeight());
    }

    public void setup()
    {
        noLoop();
    }

    public void draw()
    {
        AtomicInteger frameNumber = new AtomicInteger(1);

        configurations.forEach(configuration ->
        {
            Frame frame = new Frame(this, configuration);
            frame.render();

            saveImage(saveDirectory, frameNumber.getAndIncrement());
        });

        this.main.m(this);
    }

    private void saveImage(String saveDirectory, int count)
    {
        save(String.format("%s/%d.png", saveDirectory, count));
    }
}
