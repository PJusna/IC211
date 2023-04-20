import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

// libraries needed for drawing an image
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;   

public class Background extends JComponent{
    private Shark Bob;
    private Tetra Rob;
    public Background(){
        super();
        setPreferredSize(new Dimension(400, 400));
        Bob = new Shark(750, 100);
        Rob = new Tetra(250, 100);
    }

    public void step() {
      Bob.step();
      Rob.step();
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

        

        AffineTransform tf = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(tf, AffineTransformOp.TYPE_BILINEAR);
        tf.scale(4, 4);
        op = new AffineTransformOp(tf, AffineTransformOp.TYPE_BILINEAR);
        img = op.filter(img, null); 
        b2.drawImage(img, 0, 0, null);
        b2.setColor(Color.BLACK);
        Bob.paint(b2);
        b2.setColor(Color.RED);
        Rob.paint(b2);
        Toolkit.getDefaultToolkit().sync();
    }
}