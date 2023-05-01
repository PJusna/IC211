import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public interface Living {
    public void              paint(Graphics2D g);
    public String                      getName();
    public int                            step();
    public int                       getHunger();
    public double                     getSpeed();
    public void                           feed();
    public double                         GetX();
    public double                         GetY();
    public boolean doesThisCollide(int a, int b);  
}