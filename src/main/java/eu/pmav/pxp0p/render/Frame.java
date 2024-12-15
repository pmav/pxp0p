package eu.pmav.pxp0p.render;

import eu.pmav.pxp0p.configuration.FrameConfiguration;
import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.render.forms.FormType;
import eu.pmav.pxp0p.render.forms.imlp.*;
import eu.pmav.pxp0p.render.model.ObjectConfiguration;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Frame
{
    private final PApplet applet;
    private final FrameConfiguration frameConfiguration;

    // Internal state (defined after running calculate())
    private int xIncrement;
    private int xInit;
    private int yIncrement;
    private int yInit;

    public Frame(PApplet applet, FrameConfiguration frameConfiguration)
    {
        this.applet = applet;
        this.frameConfiguration = frameConfiguration;
    }

    public void render()
    {
        // Set deterministic behaviour
        applet.randomSeed(0);

        // Create internal state needed for render
        calculate();

        // Generate stroke
        if (frameConfiguration.isHaveStroke())
        {
            applet.stroke(frameConfiguration.getStrokeColor());
        }
        else
        {
            applet.noStroke();
        }

        applet.strokeWeight(frameConfiguration.getStrokeSize());

        // Set background color
        applet.background(frameConfiguration.getColorBackground());

        // Generate configuration for each object in Frame
        List<ObjectConfiguration> objectConfigurations = new ArrayList<>();

        int x = this.xInit;
        int y = this.yInit;
        int framePosition = 0;

        for (int line = 0; line < frameConfiguration.getObjectLines(); line++)
        {
            for (int column = 0; column < frameConfiguration.getObjectColumns(); column++)
            {
                objectConfigurations.add(new ObjectConfiguration(x, y, framePosition));

                framePosition++;
                x += this.xIncrement;
            }

            x = this.xInit; // Reset x-axis position
            y += this.yIncrement;
        }

        // Randomize list of object configurations
        Collections.shuffle(objectConfigurations, new Random(0));

        // Draw object for each configuration
        objectConfigurations.forEach(objectConfiguration -> {
            // TODO Move to each Form:
            /*
            int x = objectConfiguration.getX();
            int y = objectConfiguration.getY();

            if (configuration.getxVariation() != 0)
            {
                x = x + Math.round((applet.random(-1, 1) * configuration.getxVariation()));
            }

            if (configuration.getyVariation() != 0)
            {
                y = y + Math.round((applet.random(-1, 1) * configuration.getyVariation()));
            }
             */

            final FormType formType = frameConfiguration.getObjectTypes()[PApplet.parseInt(applet.random(frameConfiguration.getObjectTypes().length))];

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

        applet.filter(PApplet.BLUR, frameConfiguration.getBlurValue());
    }

    public void calculate()
    {
        final int objectSizeInGrid = Math.min(this.frameConfiguration.getGridWidth() / this.frameConfiguration.getObjectColumns(), this.frameConfiguration.getGridHeight() / this.frameConfiguration.getObjectLines()); // Size of the object in the grid

        xIncrement = objectSizeInGrid;
        final int borderWidth = (this.frameConfiguration.getCanvasWidth() - this.frameConfiguration.getGridWidth()) / 2;
        xInit = borderWidth + (this.frameConfiguration.getGridWidth() - (xIncrement * this.frameConfiguration.getObjectColumns())) / 2;

        yIncrement = objectSizeInGrid;
        final int borderHeight = (this.frameConfiguration.getCanvasHeight() - this.frameConfiguration.getGridHeight()) / 2;
        yInit = borderHeight + (this.frameConfiguration.getGridWidth() - (yIncrement * this.frameConfiguration.getObjectLines())) / 2;
    }
}
