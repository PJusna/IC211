import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Living {
    public                              Living(){}
    public void              paint(Graphics2D g){}
    public String                      getName(){
        return "";
    }
    public int                            step(){
        return 1;
    }

    public void        AdjustSandH(int S, int H){}
    public int                       getHunger(){
        return 1;
    }
    public double                     getSpeed(){
        return 1.0;
    }
    public void                           feed(){
        
    }
    public double                         GetX(){
        return 1.0;
    }
    public double                         GetY(){
        return 1.0;
    }
    public boolean doesThisCollide(int a, int b){
        return false;
    } 
}