/*
 * CS310 Assignment 7 - Stacks and Image Manipulation
 */
package cs310datastructures;

import java.io.File;
import java.util.Scanner;

/**
 * The main class for the entire program. This runs an pictureObj manipulation
 * program that allows the user to manipulate images in various ways. The user
 * can use these filters:
 * <br><br>
 * - convert an image to black and white<br>
 * - convert an image to only red tones<br>
 * - convert an image to only green tones<br>
 * - convert an image to only blue tones<br>
 * - flip an image horizontally<br>
 * - flip an image vertically<br>
 * - create a new image based on a specific tile pattern<br>
 * - create a new abstract image based on a specific tile pattern <br>
 * <br>
 * The user can also run a barrage of all filters happening one after the other.
 * This is merely offered for testing and would likely be removed from a full
 * release version of the program.
 * <br><br>
 * Picture/image files can only end in .png, .gif, or .jpg for this application.
 *
 * @author Jeffrey LaMarche
 * @version 1.0  2020-Sept-2 Initial Version
 * @version 1.01 2020-Sept-4 Updates for template version functionality
 */
public class CS310Assignment7
{

    // defines constants for menu item choices, would probably be better as
    //  an enumerated type
    private static final int BLACK_WHITE_FILTER = 1;
    private static final int RED_FILTER = 2;
    private static final int GREEN_FILTER = 3;
    private static final int BLUE_FILTER = 4;
    private static final int HORIZONTAL_FLIP = 5;
    private static final int VERTICAL_FLIP = 6;
    private static final int NORMAL_TILE_PATTERN = 7;
    private static final int ABSTRACT_TILE_PATTERN = 8;
    private static final int RUN_TESTS = 9;
    private static final int QUIT_PROGRAM = 10;

    // private constant values
    private static final int LOW_MENU_CHOICE = 1;
    private static final int HIGH_MENU_CHOICE = QUIT_PROGRAM;

    /**
     * The main method for the entire program. This makes everything work.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // the string name to the directory containing the images
        final String directoryPath = "images/";

        Scanner input = new Scanner(System.in);
        File directory = new File(directoryPath);

        String imageFileName = null;
        Picture originalImage = null;
        Picture image = null;
        int userChoice = -1;

        System.out.println("Welcome to the image manipulation program 1.0!");

        System.out.println();

        // keep running until the user decides to quit
        while (userChoice != QUIT_PROGRAM)
        {
            displayMenu();

            userChoice = getUserMenuInput(input);

            System.out.println();

            // if the user selects to manipulate an image, get the file name
            // and attempt to get the image
            if (userChoice >= LOW_MENU_CHOICE && userChoice < HIGH_MENU_CHOICE)
            {
                imageFileName = getImageFileName(input, directory);
                originalImage = getPictureFromFile(imageFileName);
            }

            switch (userChoice)
            {
                case BLACK_WHITE_FILTER:
                    if (originalImage != null)
                    {
                        System.out.print("The black and white image");
                        System.out.println(" will be displayed shortly.");

                        image = ImageManipulation.blackWhiteFilter(originalImage);

                        displayImage(image);                      
                    }

                    break;
                case RED_FILTER:
                    if (originalImage != null)
                    {
                        System.out.print("The red tone Filtered image");
                        System.out.println(" will be displayed shortly.");

                        image = ImageManipulation.redToneFilter(originalImage);
                        
                        displayImage(image);
                    }

                    break;
                case GREEN_FILTER:
                    if (originalImage != null)
                    {
                        System.out.print("The freen tone Filtered image");
                        System.out.println(" will be displayed shortly.");

                        image = ImageManipulation.greenToneFilter(originalImage);
                        
                        displayImage(image);
                    }

                    break;
                case BLUE_FILTER:
                    if (originalImage != null)
                    {
                        System.out.print("The blue tone filtered image");
                        System.out.println(" will be displayed shortly.");

                        image = ImageManipulation.blueToneFilter(originalImage);
                        
                        displayImage(image);
                    }

                    break;
                case HORIZONTAL_FLIP:
                    if (originalImage != null)
                    {
                        System.out.print("The horizontally flipped image");
                        System.out.println(" will be displayed shortly.");

                        image = ImageManipulation.flipHorizontally(originalImage);
                        
                        displayImage(image);
                    }

                    break;
                case VERTICAL_FLIP:
                    if (originalImage != null)
                    {
                        System.out.print("The vertically flipped image");
                        System.out.println(" will be displayed shortly.");

                        image = ImageManipulation.flipVertically(originalImage);
                        
                        displayImage(image);
                    }

                    break;
                case NORMAL_TILE_PATTERN:
                    if (originalImage != null)
                    {
                        System.out.print("The flipped tile pattern image");
                        System.out.println(" will be displayed shortly.");

                        image = ImageManipulation.normalTilePattern(originalImage);
                        
                        displayImage(image);
                    }

                    break;
                case ABSTRACT_TILE_PATTERN:
                    if (originalImage != null)
                    {
                        System.out.print("The abstract flipped tile pattern");
                        System.out.println(" image will be displayed shortly.");

                        image = ImageManipulation.abstractTilePattern(originalImage);
                        
                        displayImage(image);
                    }

                    break;
                case RUN_TESTS:
                    if (originalImage != null)
                    {
                        System.out.print("Running all testing of the");
                        System.out.println(" image manipulation filters.");

                        runTests(originalImage);
                    }

                    break;
                case QUIT_PROGRAM:
                    System.out.print("Thanks for using the image manipulation");
                    System.out.println(" program 1.0!");
                    System.exit(0);

                    break;
                default:
                    System.out.println("ERROR: This should not be possible!");

                    break;
            }

            System.out.println();
        }
    }

    /**
     * Displays the image manipulation menu interface to standard output
     */
    private static void displayMenu()
    {
        System.out.println("Image Manipulation Main Menu: ");
        System.out.println("--------------------------------------");
        System.out.println(" " + BLACK_WHITE_FILTER
                + ". Convert to Black and White");
        System.out.println(" " + RED_FILTER
                + ". Convert to Red Tones");
        System.out.println(" " + GREEN_FILTER
                + ". Convert to Green Tones");
        System.out.println(" " + BLUE_FILTER
                + ". Convert to Blue Tones");
        System.out.println(" " + HORIZONTAL_FLIP
                + ". Flip Image Horizontally");
        System.out.println(" " + VERTICAL_FLIP
                + ". Flip Image Vertically");
        System.out.println(" " + NORMAL_TILE_PATTERN
                + ". Create Normal Tile Pattern");
        System.out.println(" " + ABSTRACT_TILE_PATTERN
                + ". Create Abstract Tile Pattern");
        System.out.println(" " + RUN_TESTS + ". Run All Tests");
        System.out.println(" " + QUIT_PROGRAM + ". Quit Program");
        System.out.println("--------------------------------------");
    }

    /**
     * Obtains the user input for the menu selection. Ensures that the user
     * choice is a valid value based on the current menu options.
     *
     * @param input the scanner object used for input
     *
     * @return an integer corresponding to the user selection
     */
    private static int getUserMenuInput(Scanner input)
    {
        String userChoice = "";
        int intChoice = -1;

        while (intChoice < LOW_MENU_CHOICE || intChoice > HIGH_MENU_CHOICE)
        {
            System.out.print("Enter selection (" + LOW_MENU_CHOICE + " - "
                    + HIGH_MENU_CHOICE + "): ");
            userChoice = input.nextLine();

            while (!isPositiveInteger(userChoice))
            {
                System.out.println("ERROR: Invalid choice!");
                System.out.print("Enter selection (" + LOW_MENU_CHOICE + " - "
                        + HIGH_MENU_CHOICE + "): ");
                userChoice = input.nextLine();
            }

            intChoice = Integer.parseInt(userChoice);

            if (intChoice < LOW_MENU_CHOICE || intChoice > HIGH_MENU_CHOICE)
            {
                System.out.println("ERROR: Invalid choice!");
            }
        }

        return intChoice;
    }

    /**
     * Obtains the user input for the image file name selection. Ensures that
     * the user input is not an empty string. This method also displays the
     * contents of the "images" directory to assist the user with selecting
     * something valid.
     *
     * @param input input the scanner object used for input
     *
     * @return a string reference containing the file name entered by the user
     */
    private static String getImageFileName(Scanner input, File path)
    {
        final String BAD_INPUT = "";
        String userInput;
        String[] directoryContents = path.list();

        // display the contents of the directory for helping a user with
        // selecting an image to manipulate
        System.out.println("Listing Image Directory Contents");
        System.out.println("--------------------------------");

        for (String file : directoryContents)
        {
            System.out.println("    " + file);
        }

        System.out.println();

        // attempt to get the item name
        System.out.print("Enter the image file name with extension: ");
        userInput = input.nextLine();

        // while the file name is an empty string, get the item name again
        while (userInput.equals(BAD_INPUT))
        {
            System.out.println("ERROR: File name cannot be empty!");
            System.out.print("Enter the image file name with extension: ");

            userInput = input.nextLine();
        }

        // add the directory on to the file name so things work correctly
        return "images/" + userInput;
    }

    /**
     * Attempts to load an image into a Picture object. A reference to the
     * Picture object is returned, which is null is the picture could not be
     * loaded successfully.
     *
     * @param imageFileName a string containing the filename of the image
     *
     * @return a Picture object reference, which will be null is the picture
     * could not be loaded
     */
    private static Picture getPictureFromFile(String imageFileName)
    {
        Picture pictureObj = null;

        try
        {
            pictureObj = new Picture(imageFileName);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println("ERROR: " + iae);
            System.out.println("Operation unsuccessful because file"
                    + " name is invalid!");
        }

        return pictureObj;
    }

    /**
     * Determines whether a given string is a positive integer value
     *
     * @param strNum string containing value to check for being a positive
     * integer
     *
     * @return true is the string contains a positive integer, false otherwise
     */
    private static boolean isPositiveInteger(String strNum)
    {
        final char LOW_INT_VALUE = '0';
        final char HIGH_INT_VALUE = '9';
        final String BAD_STRING = "";

        // if the string is null or empty, it is not valid
        if (strNum == null || strNum.equals(BAD_STRING))
        {
            return false;
        }

        // check each character, making sure it is between 0 and 9 inclusive
        for (int i = 0; i < strNum.length(); i++)
        {
            if (strNum.charAt(i) < LOW_INT_VALUE
                    || strNum.charAt(i) > HIGH_INT_VALUE)
            {
                return false;
            }
        }

        // all tests passed, so string contains a positive integer
        return true;
    }

    /**
     * Displays the original image and runs all of the available image
     * manipulation filters for easier testing
     *
     * @param pictureObj a valid picture object reference
     */
    private static void runTests(Picture pictureObj)
    {
        Picture image = null;
        
        // display the original image
        pictureObj.show();

        // display the black and white filtered image
        image = ImageManipulation.blackWhiteFilter(pictureObj);
        displayImage(image);
        
        // display the red tone filtered image
        image = ImageManipulation.redToneFilter(pictureObj);
        displayImage(image);
        
        // display the green tone filtered image
        image = ImageManipulation.greenToneFilter(pictureObj);
        displayImage(image);
        
        // display the blue tone filtered image
        image = ImageManipulation.blueToneFilter(pictureObj);
        displayImage(image);
        
        // display the horizontally flipped image
        image = ImageManipulation.flipHorizontally(pictureObj);
        displayImage(image);
        
        // display the vertically flipped image
        image = ImageManipulation.flipVertically(pictureObj);
        displayImage(image);
        
        // display the normal flipped tile pattern image
        image = ImageManipulation.normalTilePattern(pictureObj);
        displayImage(image);
        
        // display the abstract flipped tile pattern image
        image = ImageManipulation.abstractTilePattern(pictureObj);
        displayImage(image);
    }

    /**
     * Helper method that displays the image or displays a generic error
     * if something has gone wrong and the image reference is null.
     * 
     * @param image a Picture object reference, which could be null
     */
    private static void displayImage(Picture image)
    {
        if (image != null)
        {
            image.show();
        }
        else
        {
            System.out.println("ERROR: Image cannot be displayed!");
        }
    }
}
