import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;


public class DrawArea extends JComponent {
    public DrawArea() {
        super();
        setPreferredSize(new Dimension(400, 400));
    }
    protected void paintComponent(Graphics g) {
        
        //call the old paintComponent
        super.paintComponent(g);

        //cast 2D version
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2.setColor(new Color(255, 51, 255, 255));
        g2.draw(new Ellipse2D.Double(25, 25, 250, 25*4));

        BufferedImage img = null;
        try{
            img = ImageIO.read(new File("PB.jpg"));
        }catch(Exception e) {}
        g2.drawImage(img, 80, 120, null);
    }
}