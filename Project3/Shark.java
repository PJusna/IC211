import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;  

public class Shark implements Living{
    //location
    int x = 300, y = 300, r = 4;
    BufferedImage Foto = null;

    public Shark(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String getName(){
        return "Shark";
    }
    public void step(){
        x++;
    }

    public void paint(Graphics2D g) {
        g.fill(new Ellipse2D.Double(x + r, y + r, 2 * r, 2 * r));
    }

    public String GetLocation(){
        //make this a node?
        String t = "";
        t = x + " " + y;
        return t;
    }
}