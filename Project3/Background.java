import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

// libraries needed for drawing an image
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;   

public class Background extends JComponent{
    private Shark Bob;
    public Background(){
        super();
        Bob = new Shark(200, 200);
        setPreferredSize(new Dimension(400, 400));
    }

    public void step() {
      Bob.step();
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
          img = ImageIO.read(new File("BG.jpg"));
        } catch (IOException e) {}
        b2.drawImage(img, 0, 0, null);

        Bob.paint(b2);

        AffineTransform tf = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(tf, AffineTransformOp.TYPE_BILINEAR);
        tf.scale(4, 4);
        op = new AffineTransformOp(tf, AffineTransformOp.TYPE_BILINEAR);
        img = op.filter(img, null); 
        b2.drawImage(img, 0, 0, null);

        Toolkit.getDefaultToolkit().sync();
    }
}