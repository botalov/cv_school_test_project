package helpers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageObject {
    private BufferedImage img;
    private String name;
    private String path;

    public ImageObject(BufferedImage img, String path, String name){
        this.img = img;
        this.path = path;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getPath() {
         return this.path;
    }

    public BufferedImage getImg() {
        return this.img;
    }

    public void Load(){
        File inputFile = new File(path + "\\" + name);
        try {
            img = ImageIO.read(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Save(){
        File savedFile = new File(path + "\\" + name);
        try {
            ImageIO.write( img, "png" ,savedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
