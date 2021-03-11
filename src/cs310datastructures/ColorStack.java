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
 * @version 1.0 2020-Oct-4
 */
public class ColorStack
{
    private Color[] colors;     // array for the stack Color data
    private int stackTop;       // index for the top stack value
    
    
    /*
    Default Constructor
    */
    public ColorStack(int StackSize)
    {
        
        colors = new Color[StackSize];
        stackTop = -1;
    }
    /**
     * A method to test whether the stack is full
     * 
     * @return true if stack is full, false otherwise
     */
    public boolean isStackFull()
    {
        int stackLimit = colors.length - 1;      //MAX idx of stack
        //conditional statement to determine whether stack is full or not
        return (stackTop >= stackLimit)? true : false;
    }
    
    /**
     * A method to test whether the stack is empty
     * 
     * @return true if empty, false otherwise
     */
    public boolean isStackEmpty()
    {
        //conditional statement to determine whether stack is empty or not
        return (stackTop < 0)? true : false;
        
    }
    /**
     * A method to push a color object onto stack if there is room
     * 
     * @param color
     * @return true if successfully pushed, false otherwise
     */
    public boolean pushColor(Color color)
    {
        boolean wasPushed = false;
        //If the stack is not full
        if( ! this.isStackFull() )
        {
            //Increment the stack top index
            this.stackTop++;
            //Add the color to the colors array at the stack top
            colors[stackTop] = color;
            wasPushed = true;
        }
        //Return true or false appropriately
        return wasPushed;
    }
    
    /**
     * A method that will pop a color object from the stack if it is not empty
     * 
     * @return reference to color object or null if stack was empty
     */
    public Color popColor()
    {
        Color poppedColor = null;
        //If the stack is not empty
        if( ! isStackEmpty() )
        {
            //Store the color reference at the top of the stack
            poppedColor = colors[stackTop];
            //Set the top of the stack to null
            colors[stackTop] = null;
            //Decrement the stack top index
            stackTop--;
        }
        //Return the color reference
        return poppedColor;
    }
    
    /**
     * A method to provide access to stack top but won't remove it
     * 
     * @return color object reference or null if stack is empty
     */
    public Color peekColor()
    {
        Color peekedColor = null;
        // If the stack is not empty
        if( ! isStackEmpty() )
        {
            //Store the color reference at the stack top index
            peekedColor = colors[stackTop];
        }
        //Return the color reference
        return peekedColor;
    }
}
