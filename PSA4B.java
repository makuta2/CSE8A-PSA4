/* Filename: PSA4B.java 
* Created by: Nick Lin, Robert Tso, CS8a
* Date: 
*/ 
//chooses a picture, copies it twice, then flips a box of the first copy vertically
//and flips a box of the second copy horizontally, shows all the pictures.
public class PSA4B {
 public static void main(String [] args)
 {
   String sourceFile = FileChooser.pickAFile();
   Picture sourcePicture = new Picture(sourceFile);

   Picture copy1 = new Picture(sourcePicture);
   Picture copy2 = new Picture(sourcePicture);

   copy1.flipVerticalRectangle(0,79,160,80);
   copy2.flipHorizontalRectangle(0,79,160,80);
   
   sourcePicture.show();
   copy1.show();
   copy2.show();   
 }  
  
}