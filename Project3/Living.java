import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public interface Living {
    public void paint(Graphics2D g);
    public String getName();
    public void step();
    public String GetLocation();
}