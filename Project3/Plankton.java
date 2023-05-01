import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;  

public class Plankton extends Living{
    //location
    double x = 100, y = 100, speed = 1;


    public Plankton(double x, double y){
        this.x = x;
        this.y = y;
    }
    public String getName(){
        return "Plankton";
    }
    public void AdjustSandH(int S, int H){
        speed = S * 0.1;
    }
    public int step(){
        if(y<750){ y = y + speed; }
        return 1;
    }
    public int getHunger(){
        return 0;
    }
    public double getSpeed(){
        return speed;
    }
    public void feed(){
        System.out.print("Plankton is eating???");
    }

    public void paint(Graphics2D g) {
        g.fill(new Ellipse2D.Double(x, y, 8, 8));
    }

    public double GetX(){
        return x;
    }
    public double GetY(){
        return y;
    }
    public boolean doesThisCollide(int a, int b){
        if((x + 50 > a) && (x - 50 < a) && (y + 50 > b) && (y - 50 < b)){
            return true;
        }
        return false;
    }
}