import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;  

public class Tetra implements Living{
    //location
    int x = 300, y = 300;
    BufferedImage Foto = null;

    public String getName(){
        return "Tetra";
    }
    public void step(int direction){
        x++;
    }
    public String GetLocation(){
        //make this a node?
        String t = "";
        t = x + " " + y;
        return t;
    }   
}