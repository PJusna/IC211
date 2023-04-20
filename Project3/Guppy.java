import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;  

public class Guppy implements Living{
    //location
    int x = 300, y = 300;
    BufferedImage Foto = null;

    public String getName(){
        return "Guppy";
    }
    public void step(){
        x++;
    }
    public String GetLocation(){
        //make this a node?
        String t = "";
        t = x + " " + y;
        return t;
    }
}