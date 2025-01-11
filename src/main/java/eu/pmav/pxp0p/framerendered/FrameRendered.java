package eu.pmav.pxp0p.framerendered;

import eu.pmav.pxp0p.frameconfiguration.model.FrameConfiguration;
import eu.pmav.pxp0p.framerendered.forms.Form;
import eu.pmav.pxp0p.framerendered.forms.FormType;
import eu.pmav.pxp0p.framerendered.forms.imlp.*;
import eu.pmav.pxp0p.framerendered.model.ObjectConfiguration;
import eu.pmav.pxp0p.utils.Utils;
import processing.core.PApplet;

import java.util.*;

public class FrameRendered
{
    private FrameRendered()
    {
    }

    public static void render(PApplet applet, FrameConfiguration frameConfiguration)
    {
        // Calculate size of each object
        int size = Math.min(
                (frameConfiguration.getGridWidth() - (frameConfiguration.getObjectColumns() * frameConfiguration.getObjectSpacing())) / frameConfiguration.getObjectColumns(),
                (frameConfiguration.getGridHeight() - (frameConfiguration.getObjectLines() * frameConfiguration.getObjectSpacing())) / frameConfiguration.getObjectLines()
        );

        // Calculate X and Y initial position
        final int xInit = (frameConfiguration.getCanvasWidth() / 2) - (frameConfiguration.getObjectColumns()*(size + frameConfiguration.getObjectSpacing()) / 2);
        final int yInit = (frameConfiguration.getCanvasHeight() / 2) - (frameConfiguration.getObjectLines()*(size + frameConfiguration.getObjectSpacing()) / 2);

        // Create configuration for each object in Frame
        List<ObjectConfiguration> objectConfigurations = new ArrayList<>();
        int x = xInit;
        int y = yInit;
        int frameIndex = 0;

        for (int line = 0; line < frameConfiguration.getObjectLines(); line++)
        {
            for (int column = 0; column < frameConfiguration.getObjectColumns(); column++)
            {
                objectConfigurations.add(new ObjectConfiguration(x, y, size, frameIndex));

                // TODO Add random FormType to object configuration
                // TODO Add multiple formType to object configuration based on new configuration feature: e.g.: overlap forms

                x += size + frameConfiguration.getObjectSpacing();
                frameIndex++;
            }

            x = xInit; // Reset x-axis position
            y += size + frameConfiguration.getObjectSpacing();
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

        // Draw object for each configuration
        objectConfigurations.forEach(objectConfiguration -> {
            List<FormType> forms = frameConfiguration.getFormTypes();
            final FormType formType = forms.get(Utils.getRandomInt(forms.size()));

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
