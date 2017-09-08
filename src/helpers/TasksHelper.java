package helpers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TasksHelper {

    public static void createFragments(ImageObject imageObject, ArrayList<Annotation> annotations){
        for(Annotation annotation : annotations) {
            BufferedImage fragment = imageObject.getImg().getSubimage(annotation.getLeft(), annotation.getTop(), annotation.getWidth(), annotation.getHeight());
            File outputFile = new File(imageObject.getPath());
            String path = outputFile.getParentFile().getParent();
            outputFile = new File(path + "\\fragments");
            if(!outputFile.exists()){
                if(outputFile.mkdir()){
                    try {
                        ImageIO.write( fragment, "png" ,new File(path + imageObject.getName()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
