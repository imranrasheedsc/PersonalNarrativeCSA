import org.code.theater.*;
import org.code.media.*;

import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  public ImageFilter(String fileName) {
    super(fileName);
  }

   public void saturate(int factor) {
    /*
     * ✅ Gets the pixels from the image, and traverses the 2D array of Pixel objects.
     * Calculates the average of the red, green, and blue values of each Pixel object,
     * then calculates the adjusted grayscale value.
     * -----------------------------------------------------------------------------
     */
    Pixel[][] pixels = getPixelsFromImage();
  
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
  
        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();
  
        int average = (currentRed+currentGreen+currentBlue)/3;
  
        int adjustedGrayScale = average + (average - 255) * factor;
  
        int newRed = 0;
        int newGreen = 0;
        int newBlue = 0;
        
        if (2 * adjustedGrayScale - currentRed <= 255) {
          newRed = 2 * adjustedGrayScale - currentRed;
        } else {
          newRed = 255;
        }
  
        if (2 * adjustedGrayScale - currentGreen <= 255) {
          newGreen = 2 * adjustedGrayScale - currentGreen;
        } else {
          newGreen = 255;
        }
  
        if (2 * adjustedGrayScale - currentBlue <= 255) {
          newBlue = 2 * adjustedGrayScale - currentBlue;
        } else {
          newBlue = 255;
        }
  
        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
   }
    
  public void makeNegative() {
    /* 
     * ✅ Gets the pixels from the image, then traverses the 2D array of pixels. Sets
     * the red, green, and blue color values of each Pixel object to the result of
     * 255 minus the current values.
     * -----------------------------------------------------------------------------
     */
    Pixel[][] pixels = getPixelsFromImage();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int newRed = 255 - currentRed;
        int newGreen = 255 - currentGreen;
        int newBlue = 255 - currentBlue;

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }

 public void colorShift(int value) {
  /* 
   * ✅ Gets the pixels from the image, and traverses the 2D array of Pixel objects.
   * Adds the parameter value to each of the red, green, and blue color values
   * of each Pixel object.
   * -----------------------------------------------------------------------------
   */
    Pixel[][] tempPixels = getPixelsFromImage();
  
    for (int row = 0; row < tempPixels.length; row++) {
      for (int col = 0; col < tempPixels[0].length; col++) {
        Pixel currentPixel = tempPixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();
        
        int newRed = currentRed + value;
        int newGreen = currentGreen + value;
        int newBlue = currentBlue + value;
  
        // int average = (currentRed+currentGreen+currentBlue)/(pixels.length * pixels[0].length);
        if (newRed > 255) {
          newRed = 255;
        }
        if (newGreen > 255) {
          newGreen = 255;
        }
        if (newBlue > 255) {
          newBlue = 255;
        }
  
        currentPixel.setGreen(newGreen);
        currentPixel.setRed(newRed);
        currentPixel.setBlue(newBlue);
      }
    }
 }

 public void grayOutImage() {
    /* Equals every red, green, and blue color value to the average of all 3 values.
     * This makes every single color value equal, and removes the color of the image in the process
     * Making it grayed out.
     */
    Pixel[][] tempPixels = getPixelsFromImage();
  
    for (int row = 0; row < tempPixels.length; row++) {
      for (int col = 0; col < tempPixels[0].length; col++) {
        Pixel currentPixel = tempPixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();
        
        int color = (currentRed + currentGreen + currentBlue) / 3;
  
        // int average = (currentRed+currentGreen+currentBlue)/(pixels.length * pixels[0].length);
        if (color > 255) {
          color = 255;
        }
  
        currentPixel.setGreen(color);
        currentPixel.setRed(color);
        currentPixel.setBlue(color);
      }
    }
 }
}