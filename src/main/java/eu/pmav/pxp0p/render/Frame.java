package eu.pmav.pxp0p.render;

import eu.pmav.pxp0p.render.forms.FormType;
import eu.pmav.pxp0p.render.forms.imlp.CircleForm;
import eu.pmav.pxp0p.render.forms.imlp.PollyForm;
import eu.pmav.pxp0p.render.forms.imlp.SquareForm;
import eu.pmav.pxp0p.render.forms.imlp.TriangleForm;
import eu.pmav.pxp0p.render.model.Configuration;
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

    public Frame(PApplet applet, Configuration configuration)
    {
        this.applet = applet;
        this.configuration = configuration;
    }

    public void render()
    {
        applet.randomSeed(0);

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

        int x = configuration.getxInit();
        int y = configuration.getyInit();
        int frameIndex = 0;

        for (int line = 0; line < configuration.getObjectLines(); line++)
        {
            for (int column = 0; column < configuration.getObjectColumns(); column++)
            {
                coordinateList.add(new Coordinate(x, y, frameIndex));
                frameIndex++;

                x += configuration.getxIncrement();
            }

            x = configuration.getxInit(); // Reset x-axis position
            y += configuration.getyIncrement();
        }

        // Randomize list of base object coordinates
        Collections.shuffle(coordinateList, new Random(0));

        // Draw object for each base coordinate
        coordinateList.forEach(c ->
        {
            drawObject(c.getX(), c.getY(), configuration, c.getFrameIndex());
        });

        applet.filter(PApplet.BLUR, configuration.getBlurValue());
    }

    private void drawObject(int x, int y, Configuration configuration, int frameIndex)
    {
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
                (new SquareForm(applet)).draw(x, y, frameIndex, configuration);
                break;

            case CIRCLE:
                (new CircleForm(applet)).draw(x, y, frameIndex, configuration);
                break;

            case TRIANGLE:
                (new TriangleForm(applet)).draw(x, y, frameIndex, configuration);
                break;
            case POLLY:
                (new PollyForm(applet)).draw(x, y, frameIndex, configuration);
                break;
        }
    }
}
