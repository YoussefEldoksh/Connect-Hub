
package backend;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public abstract class ImageHandler {
    
    
    public static ImageIcon saveImage(String imagePath){
        ImageIcon imageIcon=new ImageIcon(imagePath);
        try{
            String filename=Paths.get(imagePath).getFileName().toString();
            File outputFile=new File("/Images/"+filename);//name of the new file to save it in our folder,add src/ in case of error
            outputFile.getParentFile().mkdirs();
            Image image=imageIcon.getImage();
            BufferedImage bufferedImage=new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_ARGB);//used to write an image into a file using graphics in a compatible format
            Graphics2D g2d=bufferedImage.createGraphics();//used to draw the image to the buffered image
            g2d.drawImage(image, 0,0, null);
            g2d.dispose();
            ImageIO.write(bufferedImage, "PNG", outputFile);//our file type is png
        }
        catch(IOException e){
            System.out.println("Error handling and saving image");
        }
        return imageIcon;
    }
    
    public static ImageIcon scaledImage(ImageIcon i){
        Image img=i.getImage();
        Image scaledImage = img.getScaledInstance(300, 200, Image.SCALE_SMOOTH);//resize for scale
        ImageIcon scaledIcon=new ImageIcon(scaledImage);
        return scaledIcon;
    }
    
}
