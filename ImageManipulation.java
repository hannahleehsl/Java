import java.util.*;
import java.awt.*;

//Hannah Lee
//CSE 122 AB
//TA: Andrew Awada
//February 2, 2023
//Creative Project 1: Image Manipulation
//This program enables the user to manipulate
//  an image through various helper methods.

public class ImageManipulation {
    public static void main(String[] args) {
        Picture pic = new Picture("suzzallo.jpg");
        pic.save("suzzalloBefore.jpg");
        
        Color[][] pixels = pic.getPixels();

        // TODO: Apply filters to pixels here
        increasePurple(pixels);
        
        negative(pixels);

        negativeRectangle(pixels, 40, 40, 700, 200);
        negativeRectangle(pixels, 40, 220, 700, 500);
        negativeRectangle(pixels, 40, 440, 700, 600);
        negativeRectangle(pixels, 40, 660, 700, 800);
        negativeRectangle(pixels, 40, 880, 700, 980);
        negativeRectangle(pixels, 40, 1000, 700, 1200);

        mirrorRight(pixels);

        // Set Pixels and display Image
        pic.setPixels(pixels);
        pic.save("suzzaloAfter.jpg");
    }

    // TODO: Your methods here
    // task 1:
    // this method increases the purple color of all the pixels in
    //      the image. if the max amount of red and blue is reached,
    //      the smaller value between the max value and current value 
    //      with 100 added is used.
    // parameters:
    //      - Color[][] pixels: the picture being altered
    // returns:
    //      - none
    public static void increasePurple(Color[][] pixels) {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                Color originalColor = pixels[i][j];
                int red = originalColor.getRed();
                int green = originalColor.getGreen();
                int blue = originalColor.getBlue();
                
                Color newColor = new Color(Math.min(red + 100, 255), green, Math.min(blue + 100, 255));
                pixels[i][j] = newColor;
            }
        }
    }

    // task 2: invert image
    // this method inverts the color of the image by subtracting
    //      the value of the colors (RGB) from 255
    // parameters:
    //      - Color[][] pixels: the picture being altered
    // returns:
    //      - none
    public static void negative(Color[][] pixels) {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                Color originalColor = pixels[i][j];
                int red = originalColor.getRed();
                int green = originalColor.getGreen();
                int blue = originalColor.getBlue();
                Color negativeColor = new Color(255 - red, 255 - green, 255 - blue);
                pixels[i][j] = negativeColor;
            }
        }
    }

    // task 3: invert image in rectangles
    // this method inverts the color of the image by subtracting
    //      the value of the colors (RGB) from 255 in sections of
    //      rectangles rather than the entire image
    // parameters:
    //      - Color[][] pixels: the picture being altered
    //      - int row1: the desired row to start inverting
    //      - int col1: the desired col to start inverting
    //      - int row2: the desired row to stop inverting
    //      - int col2: the desired row to stop inverting
    // returns:
    //      - none
    public static void negativeRectangle(Color[][] pixels, int row1, int col1, 
        int row2, int col2) {
            for(int i = row1; i <= row2; i++){
                for(int j = col1; j <= col2; j++){
                    Color originalColor = pixels[i][j];
                    int red = originalColor.getRed();
                    int green = originalColor.getGreen();
                    int blue = originalColor.getBlue();
                    Color negativeColor = new Color(255 - red, 255 - green, 255 - blue);
                    pixels[i][j] = negativeColor;
                }
            }
    }

    //task 4: mirror image to mirror
    // this method mirrors the image so that the right half of the
    //      image is the same as the left
    // parameters:
    //      - Color[][] pixels: the image being modified
    // returns:
    //      - none
    public static void mirrorRight(Color[][] pixels) {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = (pixels[i].length) / 2; j < pixels[i].length; j++) {
                Color original = pixels[i][j];
                pixels[i][pixels[i].length - j - 1] = original;
            }
        }
    }
}
