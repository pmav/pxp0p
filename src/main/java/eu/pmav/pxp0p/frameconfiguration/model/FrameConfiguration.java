package eu.pmav.pxp0p.frameconfiguration.model;


import eu.pmav.pxp0p.framerendered.forms.FormType;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FrameConfiguration implements Serializable
{
    // Size: this value is defined on the Frame
    private int size;

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

    // Forms to be generated
    private FormType[] formTypes;

    // Initial Position variation
    private int xVariation;
    private int yVariation;

    // Background color
    private int colorBackground;

    // Blur value
    private float blurValue;

    // Object colors
    private final Map<FormType, int[]> colorsForm = new HashMap<>();

    // Size Transform
    private boolean sizeTransform;
    private float minSizeTransform;
    private float maxSizeTransform;

    // Alpha value
    private boolean alpha;
    private int minAlpha;
    private int maxAlpha;

    // Stroke
    private boolean stroke;
    private int strokeSize;
    private int strokeColor;

    // Cuts
    private boolean cuts;
    private float cutSize;

    // TODO To be refactor and remove hardcoded reference to Forms
    private int[] colorsCutCircle;
    private int[] colorsCutSquare;
    private int[] colorsCutTriangle;

    // Direction
    private boolean direction;
    private Function<Integer, Integer> calculateDirection;

    // Center object
    private boolean centerObject;
    private float centerObjectSize;
    private int[] colorsCenterObject;

    public FrameConfiguration()
    {
    }

    public FrameConfiguration copy() throws IOException, ClassNotFoundException
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(outputStream);
        ObjectOutputStream.writeObject(this);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
        return (FrameConfiguration) objInputStream.readObject();
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

    //region Getters and setters

    // General

    public int getSize()
    {
        return this.size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public String getFramePath()
    {
        return this.framePath;
    }

    public void setFramePath(String framePath)
    {
        this.framePath = framePath;
    }

    public int getCanvasWidth()
    {
        return this.canvasWidth;
    }

    public void setCanvasWidth(int canvasWidth)
    {
        this.canvasWidth = canvasWidth;
    }

    public int getCanvasHeight()
    {
        return this.canvasHeight;
    }

    public void setCanvasHeight(int canvasHeight)
    {
        this.canvasHeight = canvasHeight;
    }

    public int getGridWidth()
    {
        return this.gridWidth;
    }

    public void setGridWidth(int gridWidth)
    {
        this.gridWidth = gridWidth;
    }

    public int getGridHeight()
    {
        return this.gridHeight;
    }

    public void setGridHeight(int gridHeight)
    {
        this.gridHeight = gridHeight;
    }

    // Layout

    public int getObjectColumns()
    {
        return this.objectColumns;
    }

    public void setObjectColumns(int objectColumns)
    {
        this.objectColumns = objectColumns;
    }

    public int getObjectLines()
    {
        return this.objectLines;
    }

    public void setObjectLines(int objectLines)
    {
        this.objectLines = objectLines;
    }

    public int getObjectSpacing()
    {
        return this.objectSpacing;
    }

    public void setObjectSpacing(int objectSpacing)
    {
        this.objectSpacing = objectSpacing;
    }

    // Object types

    public FormType[] getObjectTypes()
    {
        return this.formTypes;
    }

    public void setObjectTypes(FormType[] formTypes)
    {
        this.formTypes = formTypes;
    }

    // Initial Position variation

    public int getxVariation()
    {
        return this.xVariation;
    }

    public void setxVariation(int xVariation)
    {
        this.xVariation = xVariation;
    }

    public int getyVariation()
    {
        return this.yVariation;
    }

    public void setyVariation(int yVariation)
    {
        this.yVariation = yVariation;
    }

    // Background color

    public int getColorBackground()
    {
        return this.colorBackground;
    }

    public void setColorBackground(int colorBackground)
    {
        this.colorBackground = colorBackground;
    }

    // Blur

    public float getBlurValue()
    {
        return this.blurValue;
    }

    public void setBlurValue(float blurValue)
    {
        this.blurValue = blurValue;
    }

    // Size

    public boolean hasSizeTransform()
    {
        return this.sizeTransform;
    }

    public void setSizeTransform(boolean sizeTransform)
    {
        this.sizeTransform = sizeTransform;
    }

    public float getMinSizeTransform()
    {
        return this.minSizeTransform;
    }

    public void setMinSizeTransform(float minSizeTransform)
    {
        this.minSizeTransform = minSizeTransform;
    }

    public float getMaxSizeTransform()
    {
        return this.maxSizeTransform;
    }

    public void setMaxSizeTransform(float maxSizeTransform)
    {
        this.maxSizeTransform = maxSizeTransform;
    }

    // Cuts

    public boolean hasCuts()
    {
        return this.cuts;
    }

    public void setCuts(boolean haveCuts)
    {
        this.cuts = haveCuts;
    }

    public float getCutSize()
    {
        return this.cutSize;
    }

    public void setCutSize(float cutSize)
    {
        this.cutSize = cutSize;
    }

    // Object colors

    public int[] getColorsCutCircle()
    {
        return this.colorsCutCircle;
    }

    public void setColorsCutCircle(int[] colorsCutCircle)
    {
        this.colorsCutCircle = colorsCutCircle;
    }

    public int[] getColorsCutSquare()
    {
        return this.colorsCutSquare;
    }

    public void setColorsCutSquare(int[] colorsCutSquare)
    {
        this.colorsCutSquare = colorsCutSquare;
    }

    public int[] getColorsCutTriangle()
    {
        return this.colorsCutTriangle;
    }

    public void setColorsCutTriangle(int[] colorsCutTriangle)
    {
        this.colorsCutTriangle = colorsCutTriangle;
    }

    // Alpha

    public boolean hasAlpha()
    {
        return this.alpha;
    }

    public void setAlpha(boolean haveAlpha)
    {
        this.alpha = haveAlpha;
    }

    public int getMinAlpha()
    {
        return this.minAlpha;
    }

    public void setMinAlpha(int minAlpha)
    {
        this.minAlpha = minAlpha;
    }

    public int getMaxAlpha()
    {
        return this.maxAlpha;
    }

    public void setMaxAlpha(int maxAlpha)
    {
        this.maxAlpha = maxAlpha;
    }

    // Stroke

    public boolean hasStroke()
    {
        return this.stroke;
    }

    public void setStroke(boolean haveStroke)
    {
        this.stroke = haveStroke;
    }

    public int getStrokeColor()
    {
        return this.strokeColor;
    }

    public void setStrokeColor(int strokeColor)
    {
        this.strokeColor = strokeColor;
    }

    public int getStrokeSize()
    {
        return this.strokeSize;
    }

    public void setStrokeSize(int strokeSize)
    {
        this.strokeSize = strokeSize;
    }

    public Map<FormType, int[]> getColorsForm()
    {
        return this.colorsForm;
    }

    public void addColorsForm(FormType formType, int[] colors)
    {
        this.colorsForm.put(formType, colors);
    }

    // Center object

    public boolean hasCenterObject()
    {
        return this.centerObject;
    }

    public void setCenterObject(boolean haveCenterObject)
    {
        this.centerObject = haveCenterObject;
    }

    public float getCenterObjectSize()
    {
        return this.centerObjectSize;
    }

    public void setCenterObjectSize(float centerObjectSize)
    {
        this.centerObjectSize = centerObjectSize;
    }

    public int[] getColorsCenterObject()
    {
        return this.colorsCenterObject;
    }

    public void setColorsCenterObject(int[] colorsCenterObject)
    {
        this.colorsCenterObject = colorsCenterObject;
    }

    // Direction

    public boolean hasDirection()
    {
        return this.direction;
    }

    public void setDirection(boolean haveDirection)
    {
        this.direction = haveDirection;
    }

    public Function<Integer, Integer> getCalculateDirection()
    {
        return this.calculateDirection;
    }

    public void setCalculateDirection(Function<Integer, Integer> calculateDirection)
    {
        this.calculateDirection = calculateDirection;
    }

    //endregion
}

