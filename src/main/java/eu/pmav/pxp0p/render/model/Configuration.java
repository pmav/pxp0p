package eu.pmav.pxp0p.render.model;


import eu.pmav.pxp0p.render.forms.FormType;

import java.io.*;
import java.util.function.Function;

public class Configuration implements Serializable
{
    // Frame path
    private String framePath;

    // Canvas size
    private int canvasWidth = 1000; // TODO Remove hardcoded value
    private int canvasHeight = 1000; // TODO Remove hardcoded value

    // Space used inside canvas
    private int gridWidth = 800; // TODO Remove hardcoded value
    private int gridHeight = 800; // TODO Remove hardcoded value

    // Objects in the grid
    private int objectColumns = 16;
    private int objectLines = 16;

    // Space between objects in px
    private int objectSpacing = 0;

    // Initial Position variation
    private int xVariation = 0;
    private int yVariation = 0;

    // Size Transform
    private boolean haveSizeTransform = true;
    private float minSizeTransform = 1;
    private float maxSizeTransform = 1;

    // Alpha value
    private boolean haveAlpha = true;
    private int minAlpha = 0;
    private int maxAlpha = 255;

    // Stroke
    private boolean haveStroke = true;
    private int strokeSize = 4;
    private int strokeColor = 0xffDCDCDC;

    // Cuts
    private boolean haveCuts = true;
    private float cutSize = 0.5f;

    private int[] colorsCutCircle = {0xff000000};
    private int[] colorsCutSquare = {0xff000000};
    private int[] colorsCutTriangle = {0xff000000};

    // Direction
    private boolean haveDirection = false;
    private Function<Integer, Integer> calculateDirection;

    // Center object
    private boolean haveCenterObject = true;
    private float centerObjectSize = 0.5f;

    private int[] colorsCenterObject = {0xff000000};

    private int colorBackground = 0xff101010;

    private float blurValue = 0.6f;

    private FormType[] formTypes = {
            FormType.CIRCLE,
            FormType.SQUARE,
            FormType.TRIANGLE
    };

    private int[] colorsCircle = {0xff000000};
    private int[] colorsSquare = {0xff000000};
    private int[] colorsTriangle = {0xff000000};

    // Internal state (defined after running calculate())
    private int borderWidth;
    private int borderHeight;
    private int objectSizeGrid;
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
        borderWidth = (canvasWidth - gridWidth) / 2;
        borderHeight = (canvasHeight - gridHeight) / 2;

        objectSizeGrid = Math.min(gridWidth / objectColumns, gridHeight / objectLines); // Size of the object in the grid

        objectSize = objectSizeGrid - objectSpacing; // Actual object size

        xIncrement = objectSizeGrid;
        xInit = borderWidth + (gridWidth - (xIncrement * objectColumns)) / 2;

        yIncrement = objectSizeGrid;
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
                ", borderWidth=" + borderWidth +
                ", borderHeight=" + borderHeight +
                ", objectSizeGrid=" + objectSizeGrid +
                ", objectSize=" + objectSize +
                ", xIncrement=" + xIncrement +
                ", xInit=" + xInit +
                ", yIncrement=" + yIncrement +
                ", yInit=" + yInit +
                "}\n";
    }

// Getters and setters

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

    public int getGridWidth()
    {
        return gridWidth;
    }

    public void setGridWidth(int gridWidth)
    {
        this.gridWidth = gridWidth;
    }

    public int getGridHeight()
    {
        return gridHeight;
    }

    public void setGridHeight(int gridHeight)
    {
        this.gridHeight = gridHeight;
    }

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

    public FormType[] getObjectTypes()
    {
        return formTypes;
    }

    public void setObjectTypes(FormType[] formTypes)
    {
        this.formTypes = formTypes;
    }

    public boolean isHaveCuts()
    {
        return haveCuts;
    }

    public void setHaveCuts(boolean haveCuts)
    {
        this.haveCuts = haveCuts;
    }

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

    public int getColorBackground()
    {
        return colorBackground;
    }

    public void setColorBackground(int colorBackground)
    {
        this.colorBackground = colorBackground;
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

    public void setBlurValue(float blurValue)
    {
        this.blurValue = blurValue;
    }

    public int[] getColorsCircle()
    {
        return colorsCircle;
    }

    public void setColorsCircle(int[] colorsCircle)
    {
        this.colorsCircle = colorsCircle;
    }

    public int[] getColorsSquare()
    {
        return colorsSquare;
    }

    public void setColorsSquare(int[] colorsSquare)
    {
        this.colorsSquare = colorsSquare;
    }

    public int[] getColorsTriangle()
    {
        return colorsTriangle;
    }

    public void setColorsTriangle(int[] colorsTriangle)
    {
        this.colorsTriangle = colorsTriangle;
    }

    public int getBorderWidth()
    {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth)
    {
        this.borderWidth = borderWidth;
    }

    public int getBorderHeight()
    {
        return borderHeight;
    }

    public void setBorderHeight(int borderHeight)
    {
        this.borderHeight = borderHeight;
    }

    public int getObjectSizeGrid()
    {
        return objectSizeGrid;
    }

    public void setObjectSizeGrid(int objectSizeGrid)
    {
        this.objectSizeGrid = objectSizeGrid;
    }

    public int getObjectSize()
    {
        return objectSize;
    }

    public void setObjectSize(int objectSize)
    {
        this.objectSize = objectSize;
    }

    public int getxIncrement()
    {
        return xIncrement;
    }

    public void setxIncrement(int xIncrement)
    {
        this.xIncrement = xIncrement;
    }

    public int getxInit()
    {
        return xInit;
    }

    public void setxInit(int xInit)
    {
        this.xInit = xInit;
    }

    public int getyIncrement()
    {
        return yIncrement;
    }

    public void setyIncrement(int yIncrement)
    {
        this.yIncrement = yIncrement;
    }

    public int getyInit()
    {
        return yInit;
    }

    public void setyInit(int yInit)
    {
        this.yInit = yInit;
    }

    public float getCutSize()
    {
        return cutSize;
    }

    public void setCutSize(float cutSize)
    {
        this.cutSize = cutSize;
    }

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
}

