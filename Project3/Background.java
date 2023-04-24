import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

// libraries needed for drawing an image
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;   

public class Background extends JComponent{
    private ArrayList<Living> Alive = new ArrayList<Living>();
    private int foodrop = 500;
    
    public Background(){
        super();
        setPreferredSize(new Dimension(400, 400));
        for(int i = 0; i < 1; i++){
          Alive.add(new Shark(600, 800));
        }
        for(int i = 0; i < 3; i++){
          Alive.add(new Guppy(200 + 75 * i, 100 + 250*i));
        }
        for(int i = 0; i < 3; i++){
          Alive.add(new Tetra(300 + 250 * i, 800 - 50 * i));
        }
    }

    public void addLiving(String name){
      if(name.equals("Plank")){
        Alive.add(new Plankton(foodrop, 0));
        foodrop += 100;
        if(foodrop > 1400){
          foodrop = 200;
        }
      }
      else if(name.equals("Guppy")){
        Alive.add(new Guppy(500, 500));
      }
      else if(name.equals("Tetra")){
        Alive.add(new Tetra(100, 900));
      }
      else if(name.equals("Shark")){
        Alive.add(new Shark(800, 300));
      }
    }

    public void step() {
        for(Living l: Alive){ l.step(); }
//        ArrayList<Living> Preditors = new ArrayList<Living>();
//        Preditors = Alive;
//        for(Living Preditor: Preditors){
//          for(Living Prey: Alive){
//            if((Prey.getName().equals("Tetra") || Prey.getName().equals("Guppy"))){
//              if(Preditor.GetLocation() <= Prey.GetLocation()){
//                if(Preditor.getName().equals("Shark")){ Alive.remove(Prey); }
//              } 
//            }
//          } 
//        }
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

      for(Living l: Alive){ l.paint(b2); }
      Toolkit.getDefaultToolkit().sync();
    }
}