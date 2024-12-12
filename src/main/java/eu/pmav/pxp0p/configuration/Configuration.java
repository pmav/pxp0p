package eu.pmav.pxp0p.configuration;


import eu.pmav.pxp0p.render.forms.Form;
import eu.pmav.pxp0p.render.forms.FormType;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Configuration implements Serializable
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
    private boolean haveSizeTransform;
    private float minSizeTransform;
    private float maxSizeTransform;

    // Alpha value
    private boolean haveAlpha;
    private int minAlpha;
    private int maxAlpha;

    // Stroke
    private boolean haveStroke;
    private int strokeSize;
    private int strokeColor;

    // Cuts
    private boolean haveCuts;
    private float cutSize;

    // TODO To be refactor and remove hardcoded reference to Forms
    private int[] colorsCutCircle;
    private int[] colorsCutSquare;
    private int[] colorsCutTriangle;

    // Direction
    private boolean haveDirection = false;
    private Function<Integer, Integer> calculateDirection;

    // Center object
    private boolean haveCenterObject;
    private float centerObjectSize;
    private int[] colorsCenterObject;

    // Internal state (defined after running calculate())
    private int objectSize;
    private int xIncrement;
    private int xInit;
    private int yIncrement;
    private int yInit;

    public Configuration()
    {
    }

    public Configuration copy() throws IOException, ClassNotFoundException
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(outputStream);
        ObjectOutputStream.writeObject(this);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
        return (Configuration) objInputStream.readObject();
    }

    public void calculate()
    {
        final int borderWidth = (canvasWidth - gridWidth) / 2;
        final int borderHeight = (canvasHeight - gridHeight) / 2;

        final int objectSizeInGrid = Math.min(gridWidth / objectColumns, gridHeight / objectLines); // Size of the object in the grid

        objectSize = objectSizeInGrid - objectSpacing; // Actual object size, if spacing is zero the objects will fill the grid

        xIncrement = objectSizeInGrid;
        xInit = borderWidth + (gridWidth - (xIncrement * objectColumns)) / 2;

        yIncrement = objectSizeInGrid;
        yInit = borderHeight + (gridHeight - (yIncrement * objectLines)) / 2;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "canvasWidth=" + canvasWidth +
                ", canvasHeight=" + canvasHeight +
                ", gridWidth=" + gridWidth +
                ", gridHeight=" + gridHeight +
                ", objectColumns=" + objectColumns +
                ", objectLines=" + objectLines +
                ", objectSpacing=" + objectSpacing +
                ", objectSize=" + objectSize +
                ", xIncrement=" + xIncrement +
                ", xInit=" + xInit +
                ", yIncrement=" + yIncrement +
                ", yInit=" + yInit +
                "}\n";
    }

    //region Getters and setters

    // General

    public String getFramePath()
    {
        return framePath;
    }

    public void setFramePath(String framePath)
    {
        this.framePath = framePath;
    }

    public int getCanvasWidth()
    {
        return canvasWidth;
    }

    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public int getCanvasHeight()
    {
        return canvasHeight;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    public void setGridWidth(int gridWidth)
    {
        this.gridWidth = gridWidth;
    }

    public void setGridHeight(int gridHeight)
    {
        this.gridHeight = gridHeight;
    }

    // Layout

    public int getObjectColumns()
    {
        return objectColumns;
    }

    public void setObjectColumns(int objectColumns)
    {
        this.objectColumns = objectColumns;
    }

    public int getObjectLines()
    {
        return objectLines;
    }

    public void setObjectLines(int objectLines)
    {
        this.objectLines = objectLines;
    }

    public int getObjectSpacing()
    {
        return objectSpacing;
    }

    public void setObjectSpacing(int objectSpacing)
    {
        this.objectSpacing = objectSpacing;
    }

    // Object types

    public FormType[] getObjectTypes()
    {
        return formTypes;
    }

    public void setObjectTypes(FormType[] formTypes)
    {
        this.formTypes = formTypes;
    }

    // Initial Position variation

    public int getxVariation()
    {
        return xVariation;
    }

    public void setxVariation(int xVariation)
    {
        this.xVariation = xVariation;
    }

    public int getyVariation()
    {
        return yVariation;
    }

    public void setyVariation(int yVariation)
    {
        this.yVariation = yVariation;
    }

    // Background color

    public int getColorBackground()
    {
        return colorBackground;
    }

    public void setColorBackground(int colorBackground)
    {
        this.colorBackground = colorBackground;
    }

    // Blur

    public void setBlurValue(float blurValue)
    {
        this.blurValue = blurValue;
    }

    // Size

    public boolean isHaveSizeTransform()
    {
        return haveSizeTransform;
    }

    public void setHaveSizeTransform(boolean haveSizeTransform)
    {
        this.haveSizeTransform = haveSizeTransform;
    }

    public float getMinSizeTransform()
    {
        return minSizeTransform;
    }

    public void setMinSizeTransform(float minSizeTransform)
    {
        this.minSizeTransform = minSizeTransform;
    }

    public float getMaxSizeTransform()
    {
        return maxSizeTransform;
    }

    public void setMaxSizeTransform(float maxSizeTransform)
    {
        this.maxSizeTransform = maxSizeTransform;
    }

    // Cuts

    public boolean isHaveCuts()
    {
        return haveCuts;
    }

    public void setHaveCuts(boolean haveCuts)
    {
        this.haveCuts = haveCuts;
    }

    public float getCutSize()
    {
        return cutSize;
    }

    public void setCutSize(float cutSize)
    {
        this.cutSize = cutSize;
    }

    // Object colors

    public int[] getColorsCutCircle()
    {
        return colorsCutCircle;
    }

    public void setColorsCutCircle(int[] colorsCutCircle)
    {
        this.colorsCutCircle = colorsCutCircle;
    }

    public int[] getColorsCutSquare()
    {
        return colorsCutSquare;
    }

    public void setColorsCutSquare(int[] colorsCutSquare)
    {
        this.colorsCutSquare = colorsCutSquare;
    }

    public int[] getColorsCutTriangle()
    {
        return colorsCutTriangle;
    }

    public void setColorsCutTriangle(int[] colorsCutTriangle)
    {
        this.colorsCutTriangle = colorsCutTriangle;
    }

    // Alpha

    public boolean isHaveAlpha()
    {
        return haveAlpha;
    }

    public void setHaveAlpha(boolean haveAlpha)
    {
        this.haveAlpha = haveAlpha;
    }

    public int getMinAlpha()
    {
        return minAlpha;
    }

    public void setMinAlpha(int minAlpha)
    {
        this.minAlpha = minAlpha;
    }

    public int getMaxAlpha()
    {
        return maxAlpha;
    }

    public void setMaxAlpha(int maxAlpha)
    {
        this.maxAlpha = maxAlpha;
    }

    // Stroke

    public boolean isHaveStroke()
    {
        return haveStroke;
    }

    public void setHaveStroke(boolean haveStroke)
    {
        this.haveStroke = haveStroke;
    }

    public int getStrokeColor()
    {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor)
    {
        this.strokeColor = strokeColor;
    }

    public int getStrokeSize()
    {
        return strokeSize;
    }

    public void setStrokeSize(int strokeSize)
    {
        this.strokeSize = strokeSize;
    }

    public float getBlurValue()
    {
        return blurValue;
    }

    public Map<FormType, int[]> getColorsForm() {
        return colorsForm;
    }

    public void addColorsForm(FormType formType, int[] colors) {
        this.colorsForm.put(formType, colors);
    }

    // Center object

    public boolean haveCenterObject()
    {
        return haveCenterObject;
    }

    public void setHaveCenterObject(boolean haveCenterObject)
    {
        this.haveCenterObject = haveCenterObject;
    }

    public float getCenterObjectSize()
    {
        return centerObjectSize;
    }

    public void setCenterObjectSize(float centerObjectSize)
    {
        this.centerObjectSize = centerObjectSize;
    }

    public int[] getColorsCenterObject()
    {
        return colorsCenterObject;
    }

    public void setColorsCenterObject(int[] colorsCenterObject)
    {
        this.colorsCenterObject = colorsCenterObject;
    }

    // Direction

    public boolean isHaveDirection()
    {
        return haveDirection;
    }

    public void setHaveDirection(boolean haveDirection)
    {
        this.haveDirection = haveDirection;
    }

    public Function<Integer, Integer> getCalculateDirection()
    {
        return calculateDirection;
    }

    public void setCalculateDirection(Function<Integer, Integer> calculateDirection)
    {
        this.calculateDirection = calculateDirection;
    }

    //endregion

    //region Getters for internal state

    public int getObjectSize()
    {
        return objectSize;
    }

    public int getxIncrement()
    {
        return xIncrement;
    }

    public int getxInit()
    {
        return xInit;
    }

    public int getyIncrement()
    {
        return yIncrement;
    }

    public int getyInit()
    {
        return yInit;
    }

    //endregion
}
