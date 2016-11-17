/* Filename: PSA4A.java 
* Created by: Nick Lin, Robert Tso, CS8a
* Date: 10/27/16
*/ 
//Chooses a picture, copies it thrice, then flips the first copy vertically
//second copy horizontally, and grayscales the third one.
//Then shows all the pictures and shows it on a canvas
public class PSA4A {
 public static void main(String [] args)
 {

   String sourceFile = FileChooser.pickAFile();
   Picture sourcePicture = new Picture(sourceFile);

   Picture copy1 = new Picture(sourcePicture);
   Picture copy2 = new Picture(sourcePicture);
   Picture copy3 = new Picture(sourcePicture);

   copy1.flipVertical();
   copy2.flipHorizontal();
   copy3.grayscale();
   
   Picture [] pictures = new Picture[]{copy1,copy2,copy3};
   
   int width= sourcePicture.getWidth();
   int height=sourcePicture.getHeight();
   Picture canvas = new Picture(3*width,height);
   canvas.collage(pictures);
   
   sourcePicture.show();
   copy1.show();
   copy2.show();
   copy3.show();
   canvas.show();

   

   
 }
 
}