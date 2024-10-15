package eu.pmav.pxp0p.app;

import eu.pmav.pxp0p.app.forms.imlp.CircleForm;
import eu.pmav.pxp0p.app.forms.imlp.SquareForm;
import eu.pmav.pxp0p.app.forms.imlp.TriangleForm;
import eu.pmav.pxp0p.app.model.Configuration;
import eu.pmav.pxp0p.app.model.Coordinate;
import eu.pmav.pxp0p.app.forms.FormType;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Frame
{
    private final PApplet pApplet;
    private final Configuration configuration;

    public Frame(PApplet pApplet, Configuration configuration)
    {
        this.pApplet = pApplet;
        this.configuration = configuration;
    }

    public void render()
    {
        pApplet.clear();
        pApplet.randomSeed(0);

        if (configuration.isHaveStroke())
        {
            pApplet.stroke(configuration.getStrokeColor());
        }
        else
        {
            pApplet.noStroke();
        }

        pApplet.strokeWeight(configuration.getStrokeSize());
        pApplet.background(configuration.getColorBackground());

        // Generate base coordinates for all objects.
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
        coordinateList.forEach(c -> {
            drawObject(c.getX(), c.getY(), configuration, c.getFrameIndex());
        });

        pApplet.filter(pApplet.BLUR, configuration.getBlurValue());
    }

    private void drawObject(int x, int y, Configuration configuration, int frameIndex)
    {
        if (configuration.getxVariation() != 0) {
            x = x + Math.round((pApplet.random(-1, 1) * configuration.getxVariation()));
        }

        if (configuration.getyVariation() != 0) {
            y = y + Math.round((pApplet.random(-1, 1) * configuration.getyVariation()));
        }

        final FormType formType = configuration.getObjectTypes()[PApplet.parseInt(pApplet.random(configuration.getObjectTypes().length))];

        switch (formType)
        {
            case SQUARE:
                (new SquareForm(pApplet)).draw(x, y, frameIndex, configuration);
                break;

            case CIRCLE:
                (new CircleForm(pApplet)).draw(x, y, frameIndex, configuration);
                break;

            case TRIANGLE:
                (new TriangleForm(pApplet)).draw(x, y, frameIndex, configuration);
                break;
        }
    }
}
