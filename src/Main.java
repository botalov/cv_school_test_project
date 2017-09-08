import helpers.Annotation;
import helpers.ImageObject;
import helpers.TasksHelper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        System.out.println("Start");

        ArrayList<ImageObject> images = new ArrayList<>();
        String rootPath = null;

        //Get images
        try {
            rootPath = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            File directory = new File(rootPath + "\\cv_school_test\\images");
            for(File file : directory.listFiles()){
                if(file.isFile()){
                    //System.out.println(file.getPath());
                    File inputFile = new File(file.getPath());
                    try {
                        BufferedImage img = ImageIO.read(inputFile);
                        ImageObject imageObject = new ImageObject(img, file.getPath(), file.getName());
                        images.add(imageObject);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        for(ImageObject imageObject : images) {
            File file = new File(rootPath + "\\cv_school_test\\annotations\\" + imageObject.getName().substring(0, imageObject.getName().indexOf('.')) + "txt");
            if(file.exists()) {

                ArrayList<Annotation> annotations = Annotation.ReadAnnotationsFromFile(file);
                TasksHelper.createFragments(imageObject, annotations);
            }
        }


    }
}
