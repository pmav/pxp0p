package eu.pmav.pxp0p.framerendered;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.Form;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.framerendered.forms.imlp.*;
import eu.pmav.pxp0p.framerendered.model.ObjectConfiguration;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FrameRendered
{
    private FrameRendered()
    {
    }

    public static void render(PApplet applet, FrameConfiguration frameConfiguration)
    {
        // Create internal state needed for render
        final int objectSizeInGrid = Math.min(frameConfiguration.getGridWidth() / frameConfiguration.getObjectColumns(), frameConfiguration.getGridHeight() / frameConfiguration.getObjectLines()); // Size of the object in the grid

        final int borderWidth = (frameConfiguration.getCanvasWidth() - frameConfiguration.getGridWidth()) / 2;
        int xInit = borderWidth + (frameConfiguration.getGridWidth() - ((frameConfiguration.getSize() + frameConfiguration.getObjectSpacing()) * frameConfiguration.getObjectColumns())) / 2;
        xInit = xInit + (objectSizeInGrid / 2);

        final int borderHeight = (frameConfiguration.getCanvasHeight() - frameConfiguration.getGridHeight()) / 2;
        int yInit = borderHeight + (frameConfiguration.getGridWidth() - ((frameConfiguration.getSize() + frameConfiguration.getObjectSpacing()) * frameConfiguration.getObjectLines())) / 2;
        yInit = yInit + (objectSizeInGrid / 2);

        // Generate configuration for each object in Frame
        List<ObjectConfiguration> objectConfigurations = new ArrayList<>();

        int x = xInit;
        int y = yInit;
        int framePosition = 0;

        for (int line = 0; line < frameConfiguration.getObjectLines(); line++)
        {
            for (int column = 0; column < frameConfiguration.getObjectColumns(); column++)
            {
                objectConfigurations.add(new ObjectConfiguration(x, y, framePosition));

                framePosition++;
                x += objectSizeInGrid;
            }

            x = xInit; // Reset x-axis position
            y += objectSizeInGrid;
        }

        // Randomize list of object configurations
        Collections.shuffle(objectConfigurations, new Random(0));

        // Set background color
        applet.background(frameConfiguration.getColorBackground());

        // Generate stroke
        if (frameConfiguration.hasStroke())
        {
            applet.stroke(frameConfiguration.getStrokeColor());
            applet.strokeWeight(frameConfiguration.getStrokeSize());
        }
        else
        {
            applet.noStroke();
        }

        // Draw object for each configuration
        objectConfigurations.forEach(objectConfiguration -> {
            final FormType formType = frameConfiguration.getObjectTypes()[Utils.getRandomInt(frameConfiguration.getObjectTypes().length)];

            final Form form = switch (formType) {
                case SQUARE -> new SquareForm();
                case CIRCLE -> new CircleForm();
                case TRIANGLE -> new TriangleForm();
                case POLLY -> new PollyForm();
                case SEMICIRCLE -> new SemiCircleForm();
                case DEBUG -> new DebugForm();
            };

            form.draw(applet, frameConfiguration, objectConfiguration);
        });

        // Apply blur as "extra" antialiasing (antialiasing is handled by smooth() on settings())
        applet.filter(PApplet.BLUR, frameConfiguration.getBlurValue());
    }
}
