package helpers;

import java.io.*;
import java.util.ArrayList;

public class Annotation {
    private int left;
    private int top;
    private int width;
    private int height;

    public Annotation(int left, int top, int right, int bottom){
        this.left = left;
        this.top = top;
        this.width = right - left;
        this.height = top - bottom;
    }

    public int getLeft(){
        return this.left;
    }
    public int getTop(){
        return this.top;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    public static ArrayList<Annotation> ReadAnnotationsFromFile(File file){
        ArrayList<Annotation> result = new ArrayList<>();
        //File inputFile = new File(pathFile);

        try(FileInputStream  fstream  = new FileInputStream(file)){
            BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));

            String line;
            while ((line = reader.readLine())!=null){
                String[] s = line.split(",");
                if(s.length == 4){
                    Annotation annotation = new Annotation(Integer.valueOf(s[0]), Integer.valueOf(s[1]), Integer.valueOf(s[2]), Integer.valueOf(s[3]));
                    result.add(annotation);
                }
            }

        }
        catch (IOException exc){
            System.out.println(exc.getMessage());
            return null;
        }

        return result;
    }
}
