/*
 * CS310 Assignment 7 - Stacks and Image Manipulation
 */
package cs310datastructures;

import java.awt.Color;

/**
 * TODO Class Description
 * 
 * @author Jeffrey LaMarche
 * @version 1.0 2020-Sept-4 Template Version
 * 
 * @author David Rausch
 * @version version 1.0 2020-Oct-4
 */
public class ImageManipulation
{
    /**
     * Restricted default constructor 
     */
    private ImageManipulation()
    {
        // Given private access to prevent someone from being able to 
        // instantiate an ImageManipulation object
    }
    
    public static Picture blackWhiteFilter(Picture originalImage)
    {
        int avg, newVal;
        int height = originalImage.height();
        int width = originalImage.width();
        //Create a new Picture object with the same size as the original image
        Picture blackAndWhite = new Picture(width, height);
        Color newColor;
        //Loop through each x value in the width of the original image
        for(int col = 0; col < width; col++)
        {
             //Loop through each y value in the height of the original image
            for(int row = 0; row < height; row++){
                //Get the original image pixel Color value 
                Color color = originalImage.get(col, row);
                avg = (color.getRed() + color.getGreen() + color.getBlue() / 3);
                newVal = (avg > 127) ? 255 : 0;
                //Create a new Color with the correct values for the new picture
                newColor = new Color(newVal, newVal, newVal);
                //Set the new image pixel Color value 
                blackAndWhite.set(col, row, newColor);
            }
        }
        //Return the new picture image
        return blackAndWhite;
    }
    
    public static Picture redToneFilter(Picture originalImage)
    {
        int height = originalImage.height();
        int width = originalImage.width();
        //Create a new Picture object with the same size as the original image
        Picture redFilter = new Picture(width, height);
        //Loop through each x value in the width of the original image
        for(int col = 0; col < width; col++)
        {
             //Loop through each y value in the height of the original image
            for(int row = 0; row < height; row++)
            {
                //Get the original image pixel Color value
                Color color = originalImage.get(col, row);
                //Create a new Color with the correct values for the new picture
                int red = color.getRed();
                //Set the new image pixel Color value 
                redFilter.set(col, row, new Color(red, 0, 0));
            }
        }
        //Return the new picture image
        return redFilter;
    }
    
    public static Picture greenToneFilter(Picture originalImage)
    {
        int height = originalImage.height();
        int width = originalImage.width();
        //Create a new Picture object with the same size as the original image
        Picture greenFilter = new Picture(width, height);
        //Loop through each x value in the width of the original image
        for(int col = 0; col < width; col++)
        {
             //Loop through each y value in the height of the original image
            for(int row = 0; row < height; row++)
            {
                //Get the original image pixel Color value
                Color color = originalImage.get(col, row);
                //Create a new Color with the correct values for the new picture
                int green = color.getGreen();
                //Set the new image pixel Color value 
                greenFilter.set(col, row, new Color(0, green, 0));
            }
        }
        //Return the new picture image
        return greenFilter;
    }
    
    public static Picture blueToneFilter(Picture originalImage)
    {
        int height = originalImage.height();
        int width = originalImage.width();
        //Create a new Picture object with the same size as the original image
        Picture blueFilter = new Picture(width, height);
        //Loop through each x value in the width of the original image
        for(int col = 0; col < width; col++)
        {
             //Loop through each y value in the height of the original image
            for(int row = 0; row < height; row++)
            {
                //Get the original image pixel Color value
                Color color = originalImage.get(col, row);
                //Create a new Color with the correct values for the new picture
                int blue = color.getBlue();
                //Set the new image pixel Color value
                blueFilter.set(col, row, new Color(0, 0, blue));
            }
        }
        //Return the new picture image
        return blueFilter;
    }
    
    public static Picture flipHorizontally(Picture originalImage)
    {
        Color tempColor;
        int height = originalImage.height();
        int width = originalImage.width();
        //Create a ColorStack with the original image width as the size value
        ColorStack flipStack = new ColorStack(width);
        //Create a new Picture object with the same size as the original image
        Picture horizontalPic = new Picture(width, height);
        //Loop through each y value in the height of the original image
        for(int row = 0; row < height; row++)
        {
            //Loop through each x value in the width of the original image
            for(int col = 0; col < width; col++)
            {
                //Push original image pixel color onto stack
                tempColor = originalImage.get(col, row);
                flipStack.pushColor(tempColor);
            }
            for(int col = 0; col < width; col++)
            {
                //Pop the stack and set new image pixel color value
                tempColor = flipStack.popColor();
                horizontalPic.set( col, row, tempColor);
            }
        }
        return horizontalPic;
    }
    
    public static Picture flipVertically(Picture originalImage)
    {
        Color tempColor;
        int height = originalImage.height();
        int width = originalImage.width();
        //Create a ColorStack with original image height as the size value
        ColorStack flipStack = new ColorStack(height);
        //Create a new Picture object with the same size as original image
        Picture verticalPic = new Picture(width, height);
        //Loop through each x value in the width of the original image
        for(int col = 0; col < width; col++)
        {
            //Loop through each y value in the height of the original image
            for(int row = 0; row < height; row++)
            {
                //Push original image pixel color onto stack
                tempColor = originalImage.get(col, row);
                flipStack.pushColor(tempColor);
            }
            for(int row = 0; row < height; row++)
            {
                //Pop the stack and set new image pixel color value
                tempColor = flipStack.popColor();
                verticalPic.set(col, row, tempColor);
            }
            
        }
        return verticalPic;
    }
    
    public static Picture normalTilePattern(Picture originalImage)
    {   
        //Original Image Quadrant
        Picture topLeft = new Picture(originalImage);
        //Horizontal Flip of Original Image Quadrant
        Picture topRight = flipHorizontally(topLeft);
        //Vertical Flip of Original Image Quadrant
        Picture bottomLeft = flipVertically(originalImage);
        //Horizontal Flip of Bottom Left Image Quadrant
        Picture bottomRight = flipHorizontally(bottomLeft);
        //Call to private method combineImages
        return combineImages(topLeft, topRight, bottomLeft, bottomRight);
    }
    
    public static Picture abstractTilePattern(Picture originalImage)
    {   
        //Original Image
        Picture topLeft = new Picture(originalImage);
        //Horizontal Flip Original Image 
        Picture topRight = flipHorizontally(topLeft);
        //Vertical Flip Original Image
        Picture bottomLeft = flipVertically(originalImage);
        //Horizontal Flip Bottom Left Image
        Picture bottomRight = flipHorizontally(bottomLeft);
        //Black and White Filter of topLeft
        topLeft = blackWhiteFilter(topLeft);
        //Red Filter of topRight
        topRight = redToneFilter(topRight);
        //Blue Filter of bottomLeft
        bottomLeft = blueToneFilter(bottomLeft);
        //Green Filter of bottomRight
        bottomRight = greenToneFilter(bottomRight);
        //Call to private method combineImages
        return combineImages(topLeft, topRight, bottomLeft, bottomRight);
    }
    
    private static Picture combineImages(Picture topLeft, Picture topRight, 
                                         Picture bottomLeft, Picture bottomRight)
    {
        int width = 2 * topLeft.width();
        int height = 2 * topLeft.height();
        int widthCenter = width/2;
        int heightCenter = height/2;
        int col, row;
        Color tempColor;
        //Create a new Picture object that is 2 * width and 2 * height of topLeft
        Picture combinedPic = new Picture(width, height);
        //Loop through all x values in width of new larger image
        for(col = 0; col < width; col++)
        {
            //Loop through all y values in height of new larger image
            for(row = 0; row < height; row++)
            {
                //If the x and y values are in top left quadrant
                if(col < widthCenter)
                {
                    if(row < heightCenter)
                    {
                        //Upper Left
                        //Get correct top left pixel color
                        tempColor = topLeft.get(col, row);
                        //Set new image pixel color to top left image pixel color
                        combinedPic.set( col, row, tempColor);
                    }else {
                        //Lower Left
                        //Get correct bottom left pixel color with y-value adj.
                        tempColor = bottomLeft.get(col, row - heightCenter);
                        //Set new image pixel color to lower left image pixel color
                        combinedPic.set( col, row, tempColor);
                    }
                }else {
                    if(row < heightCenter)
                    {
                        //Upper Right
                        //Get correct top right pixel color with x-value adj.
                        tempColor = topRight.get(col - widthCenter, row);
                        //Set new image pixel color to top right image pixel color
                        combinedPic.set( col, row, tempColor);
                    }else {
                        //Lower Right
                        //Get correct bottom right pixel color with x and y-value adj.
                        tempColor = bottomRight.get(col - widthCenter, row - heightCenter);
                        //Set new image pixel color to bottom right image pixel color
                        combinedPic.set( col, row, tempColor);
                    }
                }
            }
        }
        return combinedPic;
    }
}
