import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;    

public class Background extends JComponent{
    public Background(){
        super();

        setPreferredSize(new Dimension(400, 400));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D b2 = (Graphics2D)g;

        // This voodoo makes the output prettier
        b2.setRenderingHint(
          RenderingHints.KEY_ANTIALIASING,
          RenderingHints.VALUE_ANTIALIAS_ON);
        b2.setRenderingHint(
          RenderingHints.KEY_RENDERING,
          RenderingHints.VALUE_RENDER_QUALITY);
        
        // Drawing an image
        BufferedImage img = null;
        try {
          img = ImageIO.read(new File("Background.jpg"));
        } catch (IOException e) {}
        b2.drawImage(img, 0, 0, null);
    }
}