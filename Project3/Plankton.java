import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;  

public class Plankton implements Living{
    //location
    double x = 100, y = 100;


    public Plankton(double x, double y){
        this.x = x;
        this.y = y;
    }
    public String getName(){
        return "Plankton";
    }
    public void step(){
        y++;
    }

    public void paint(Graphics2D g) {
        g.fill(new Ellipse2D.Double(x, y, 8, 8));
    }

    public String GetLocation(){
        //make this a node?
        String t = "";
        t = x + " " + y;
        return t;
    }
}