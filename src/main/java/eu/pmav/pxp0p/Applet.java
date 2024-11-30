package eu.pmav.pxp0p;

import eu.pmav.pxp0p.configuration.*;
import eu.pmav.pxp0p.app.model.Configuration;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import eu.pmav.pxp0p.app.Frame;
import processing.core.PApplet;

public class Applet extends PApplet
{
    // Canvas size
    final int CANVAS_WIDTH = 1000;
    final int CANVAS_HEIGHT = 1600;

    // Path to save each frame
    final String SAVE_PATH = "/mnt/Storage/pxp0p/";


    public void settings()
    {
        size(CANVAS_WIDTH, CANVAS_HEIGHT);
    }

    public void setup()
    {
        noLoop();
    }

    public void draw()
    {
        try
        {
            // List<Configuration> configurations = CuidadoComOCaoCombinatorGenerator.generateConfigurations();
            // List<Configuration> configurations = InstagramCombinatorGenerator.generateConfigurations();
            // List<Configuration> configurations = DevelopmentCombinatorGenerator.generateConfigurations();
            // List<Configuration> configurations = OlympicsCombinatorGenerator.generateConfigurations();
            List<Configuration> configurations = new RandomGenerator(1).generateConfigurations(10);

            AtomicInteger frameNumber = new AtomicInteger(1);

            configurations.forEach(configuration -> {
                Frame frame = new Frame(this, configuration);
                frame.render();

                saveImage(frameNumber.getAndIncrement());
            });

            exit();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void saveImage(int count)
    {
        final String year = nf(year(), 4);
        final String month = nf(month(), 2);
        final String day = nf(day(), 2);
        final String hour = nf(hour(), 2);
        final String minute = nf(minute(), 2);
        final String second = nf(second(), 2);

        String currentTimestamp = String.format("%s_%s_%s-%s_%s_%s", year, month, day, hour, minute, second);

        save(String.format("%s/%s-%d.png", SAVE_PATH, currentTimestamp, count));
    }
}
