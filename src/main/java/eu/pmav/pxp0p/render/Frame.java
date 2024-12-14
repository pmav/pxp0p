package eu.pmav.pxp0p.render;

import eu.pmav.pxp0p.render.forms.FormType;
import eu.pmav.pxp0p.render.forms.imlp.*;
import eu.pmav.pxp0p.configuration.Configuration;
import eu.pmav.pxp0p.render.model.Coordinate;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Frame
{
    private final PApplet applet;
    private final Configuration configuration;

    // Internal state (defined after running calculate())
    private int objectSize;
    private int xIncrement;
    private int xInit;
    private int yIncrement;
    private int yInit;

    public Frame(PApplet applet, Configuration configuration)
    {
        this.applet = applet;
        this.configuration = configuration;
    }

    public void render()
    {
        // Set deterministic behaviour
        applet.randomSeed(0);

        // Create internal state needed for render
        calculate();

        // Generate stroke
        if (configuration.isHaveStroke())
        {
            applet.stroke(configuration.getStrokeColor());
        }
        else
        {
            applet.noStroke();
        }

        applet.strokeWeight(configuration.getStrokeSize());

        // Set background color
        applet.background(configuration.getColorBackground());

        // Generate base coordinates for all objects
        List<Coordinate> coordinateList = new ArrayList<>();

        int x = this.xInit;
        int y = this.yInit;
        int frameIndex = 0;

        for (int line = 0; line < configuration.getObjectLines(); line++)
        {
            for (int column = 0; column < configuration.getObjectColumns(); column++)
            {
                coordinateList.add(new Coordinate(x, y, frameIndex));
                frameIndex++;

                x += this.xIncrement;
            }

            x = this.xInit; // Reset x-axis position
            y += this.yIncrement;
        }

        // Randomize list of base object coordinates
        Collections.shuffle(coordinateList, new Random(0));

        // Draw object for each base coordinate
        coordinateList.forEach(c ->
        {
            drawObject(c, configuration);
        });

        applet.filter(PApplet.BLUR, configuration.getBlurValue());
    }

    public void calculate()
    {
        final int borderWidth = (this.configuration.getCanvasWidth() - this.configuration.getGridWidth()) / 2;
        final int borderHeight = (this.configuration.getCanvasHeight() - this.configuration.getGridHeight()) / 2;

        final int objectSizeInGrid = Math.min(this.configuration.getGridWidth() / this.configuration.getObjectColumns(), this.configuration.getGridHeight() / this.configuration.getObjectLines()); // Size of the object in the grid

        objectSize = objectSizeInGrid - this.configuration.getObjectSpacing(); // Actual object size, if spacing is zero the objects will fill the grid

        xIncrement = objectSizeInGrid;
        xInit = borderWidth + (this.configuration.getGridWidth() - (xIncrement * this.configuration.getObjectColumns())) / 2;

        yIncrement = objectSizeInGrid;
        yInit = borderHeight + (this.configuration.getGridWidth() - (yIncrement * this.configuration.getObjectLines())) / 2;
    }

    private void drawObject(Coordinate coordinate, Configuration configuration)
    {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int frameIndex = coordinate.getY();

        if (configuration.getxVariation() != 0)
        {
            x = x + Math.round((applet.random(-1, 1) * configuration.getxVariation()));
        }

        if (configuration.getyVariation() != 0)
        {
            y = y + Math.round((applet.random(-1, 1) * configuration.getyVariation()));
        }

        final FormType formType = configuration.getObjectTypes()[PApplet.parseInt(applet.random(configuration.getObjectTypes().length))];

        switch (formType)
        {
            case SQUARE:
                (new SquareForm()).draw(x, y, frameIndex, configuration, this.objectSize, applet);
                break;

            case CIRCLE:
                (new CircleForm()).draw(x, y, frameIndex, configuration, this.objectSize, applet);
                break;

            case TRIANGLE:
                (new TriangleForm()).draw(x, y, frameIndex, configuration, this.objectSize, applet);
                break;

            case POLLY:
                (new PollyForm()).draw(x, y, frameIndex, configuration, this.objectSize, applet);
                break;

            case SEMICIRCLE:
                (new SemiCircleForm()).draw(x, y, frameIndex, configuration, this.objectSize, applet);
                break;

            case DEBUG:
                (new DebugForm()).draw(x, y, frameIndex, configuration, this.objectSize, applet);
                break;
        }
    }
}
