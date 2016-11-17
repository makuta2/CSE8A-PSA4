/* Filename: Picture.java 
* Created by: Nick Lin, Robert Tso CS8a
* Date: 10/27/16
*/ 
//flipVertical-flips a picture vertically
//flipHorizontal-flips a picture horizontally
//grayscale-changes a picture black and white
//collage-creates a college made up of different pictures in a row
//flipVerticalRectangle-flips a box inside a picture vertically
//flipHorizontalRectangle-flips box inside a picture horizontally
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; 
import java.util.Random;// resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /**
   * Horizontal flip method
   * In this method, I've given you the basic structure of how things will look.  There are a few incomplete assignments inside of the method.  It is your job to figure out how to complete those assignments!
   * This method works almost like the horizontal mirroring method you saw in your text book (pg 135), but instead of mirroring on the middle of the image, we want to flip it all the way.
   * Hint: Why do we need tempColor in this case?  I encourage you to reflect on this question if you find your method not working the way it should!**/
public void flipVertical()
  {
    Color tempColor;
    Color sourceColor;
    Color targetColor;
    int width=this.getWidth();
    int horizontalMiddle=this.getHeight()/2;
    int upperLimit = 0;
    int lowerLimit =this.getHeight()-1;
    Pixel sourcePixel=null;
    Pixel targetPixel=null;
    for(int sourcex = 0; sourcex < width; sourcex++)
    {
      for(int sourcey = 0; sourcey < horizontalMiddle; sourcey++)
      {
        sourcePixel= getPixel(sourcex,sourcey);
        int targety= lowerLimit-(sourcey-upperLimit);
        targetPixel=getPixel (sourcex,targety);
        tempColor=targetPixel.getColor();
        targetPixel.setColor(sourcePixel.getColor());
        sourcePixel.setColor(tempColor);   
      }
     }
   }
  
  /*
   * Horizontal flip method
   */
public void flipHorizontal()
  {
    Color tempColor;
    Color sourceColor;
    Color targetColor;
    int height=this.getHeight();
    int verticalMiddle=this.getWidth()/2;
    int leftLimit = 0;
    int rightLimit =this.getWidth()-1;
    Pixel sourcePixel=null;
    Pixel targetPixel=null;
    for(int sourcex = 0; sourcex < verticalMiddle; sourcex++)
    {
      for(int sourcey = 0; sourcey < height; sourcey++)
      {
        sourcePixel= getPixel(sourcex,sourcey);
        int targetx= rightLimit-(sourcex-leftLimit);
        targetPixel=getPixel (targetx,sourcey);
        tempColor=targetPixel.getColor();
        targetPixel.setColor(sourcePixel.getColor());
        sourcePixel.setColor(tempColor);
        
       }
     }
   }
  
  /**
   * Grayscale method **/
public void grayscale()
  {
    Color sourceColor;
    int height=this.getHeight();
    int width=this.getWidth();
    Pixel sourcePixel=null;
    int value=0;
    for(int sourcex = 0; sourcex < width; sourcex++)
     {
      for(int sourcey = 0; sourcey < height; sourcey++)
       {
        sourcePixel=getPixel(sourcex,sourcey);
        value=(sourcePixel.getRed()+sourcePixel.getBlue()+sourcePixel.getGreen())/3;            
        sourcePixel.setRed(value);
        sourcePixel.setGreen(value);
        sourcePixel.setBlue(value);
       }
      }
   }
  
  /**The collage method
    * This method will create the collage of your modified pictures.  
    * Hint 1: Inside of the for loop here will be another 2 nested for loops, giving you a grand total of 3 nested for loops in this method
    * Hint 2: If you're clever about the way you decide to draw your pixels onto the canvas, you may only have to write ONE LINE OF CODE inside the inner-most for loop to achieve the desired collage effect!
    * However, more than one line inside of the nested for loops is perfectly fine, of course! **/

public void collage(Picture[] pictures)
  {
    Pixel sourcePixel=null;
    Pixel targetPixel=null;
    int targetx=0;
    int sourcex=0;
    int sourcey=0;
    for(int i = 0; i < pictures.length; i ++)
    {
      int width=pictures[i].getWidth();
      int height=pictures[i].getHeight();
      for (sourcex=0; sourcex<width; sourcex++)
      {
       for (sourcey=0; sourcey<height;sourcey++)
       {
        targetx=(i*width)+sourcex;
        sourcePixel= pictures[i].getPixel(sourcex,sourcey);
        targetPixel=getPixel(targetx,sourcey);
        targetPixel.setColor(sourcePixel.getColor());
        }  
       }
     }
   /* TODO:
   * Write flipVerticalRectangle and flipHorizontalRectangle methods here **/
  }
  
public void flipVerticalRectangle(int x, int y, int width, int height)
  {
    Color tempColor;
    Color sourceColor;
    Color targetColor;
    int upperLimit = y-height+1;
    int lowerLimit =y;
    Pixel sourcePixel=null;
    Pixel targetPixel=null;
    for(int sourcex = x; sourcex < width; sourcex++)
    {
      for(int sourcey = y-height+1; sourcey < y-(height/2)+1; sourcey++)
      {
        sourcePixel= getPixel(sourcex,sourcey);
        int targety= lowerLimit-(sourcey-upperLimit);
        targetPixel=getPixel (sourcex,targety);
        tempColor=targetPixel.getColor();
        targetPixel.setColor(sourcePixel.getColor());
        sourcePixel.setColor(tempColor);
        
      }
    }
  }
    
public void flipHorizontalRectangle(int x, int y, int width, int height)
  {
    Color tempColor;
    Color sourceColor;
    Color targetColor;
    int leftLimit = x;
    int rightLimit = x+width-1;
    Pixel sourcePixel=null;
    Pixel targetPixel=null;
    for(int sourcex = x; sourcex < x+(width/2); sourcex++)
    {
      for(int sourcey = y-height+1; sourcey < y; sourcey++)
      {
        sourcePixel= getPixel(sourcex,sourcey);
        int targetx= rightLimit-(sourcex-leftLimit);
        targetPixel=getPixel (targetx,sourcey);
        tempColor=targetPixel.getColor();
        targetPixel.setColor(sourcePixel.getColor());
        sourcePixel.setColor(tempColor);
      }
    }
  }

public void scramble(Picture originalPicture)
 {
  Random generator= new Random();
  int value1=0;
  int value2=0;
  int value3=0;
  int value4=0;
  int value5=0;
  int value6=0;
  int value7=0;
  int value8=0;
  int value9=0;
  value1=generator.nextInt(10);
  value2=generator.nextInt(10);
  while (value2==value1)
  {
    value2=generator.nextInt(10);
  }
  while (value3==value2||value3==value1)
  {
    value3=generator.nextInt(10);
  }
  while (value4==value3||value4==value2||value4==value1)
  {
    value4=generator.nextInt(10);
  }
  while (value5==value4||value5==value3||value5==value2||value5==value1)
  {
    value5=generator.nextInt(10);
  }
  while (value6==value5||value6==value4||value6==value3||value6==value2||value6==value1)
  {
    value6=generator.nextInt(10);
  }
  while (value7==value6||value7==value5||value7==value4||value7==value3||value7==value2||value7==value1)
  {
    value7=generator.nextInt(10);
  }
  while (value8==value7||value8==value6||value8==value5||value8==value4||value8==value3||value8==value2
        ||value8==value1)
  {
    value8=generator.nextInt(10);
  }
   while (value9==value8||value9==value7||value9==value6||value9==value5||value9==value4||value9==value3
         ||value9==value2||value8==value1)
  {
    value9=generator.nextInt(10);
  }
  
}


}// this } is the end of class Picture, put all new methods before this
 
