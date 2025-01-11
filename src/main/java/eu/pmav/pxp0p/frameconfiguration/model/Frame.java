package eu.pmav.pxp0p.frameconfiguration.model;

import java.util.List;

public class Frame
{
    // Frame path
    private String framePath;

    // Canvas size
    private int canvasWidth;
    private int canvasHeight;

    // Space used inside canvas
    private int gridWidth;
    private int gridHeight;

    // Objects in the grid
    private int objectColumns;
    private int objectLines;

    // Space between objects in px
    private int objectSpacing;

    // Background color
    private int colorBackground;

    // Blur value
    private float blurValue;

    // Frame configurations
    private final List<FrameConfiguration> frameConfigurations;

    // Constructors

    public Frame(List<FrameConfiguration> frameConfigurations)
    {
        this.frameConfigurations = frameConfigurations;
    }

    @Override
    public String toString()
    {
        return "Configuration{" +
                "canvasWidth=" + canvasWidth +
                ", canvasHeight=" + canvasHeight +
                ", gridWidth=" + gridWidth +
                ", gridHeight=" + gridHeight +
                ", objectColumns=" + objectColumns +
                ", objectLines=" + objectLines +
                ", objectSpacing=" + objectSpacing +
                "}\n";
    }

    // Getters and Setters

    public List<FrameConfiguration> getFrameConfigurations()
    {
        return frameConfigurations;
    }

}
