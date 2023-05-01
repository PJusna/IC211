import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.geom.*;

// libraries needed for drawing an image
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;   


/**
 * This is Class manages all of the moving elements of
 * the Aquarium. 
 * @author MIDN Peter Asjes
 */
public class Background extends JComponent{  
    private ArrayList<Living> Alive = new ArrayList<Living>();
    //Starting location for where food falls in. 
    private int foodrop = 500;
    private Living ClickTarget = null;
    
    public Background(){
        super();
        setPreferredSize(new Dimension(400, 400));
        for(int i = 0; i < 1; i++){
          Alive.add(new Shark(600, 800));
        }
        for(int i = 0; i < 2; i++){
          Alive.add(new Guppy(200 + 75 * i, 100 + 250*i));
        }
        for(int i = 0; i < 2; i++){
          Alive.add(new Tetra(300 + 250 * i, 800 - 50 * i));
        }    
    }
    
    public Living GetClickTarget(){
      return ClickTarget;
    }
    /**
     * addLiving is how new fishes are added to the aquarium. Called from
     * the AddButtonListener.class.
     * @param name The name of the fish the user wants to add. 
     */
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
    /*
     * step Moves all the things that can move which are 
     * stored in the Alive ArrayList
     */
    public void step() {
        //This 
        for(int l = 0; l < Alive.size(); l++){ 
          if(Alive.get(l).step() < 0){
            System.out.println(Alive.get(l).getName() + " Starved");
            Alive.remove(l);
          } 
        }
        ArrayList<Living> Preditors = new ArrayList<Living>();
        Preditors = Alive;
        for(int i = 0; i < Preditors.size(); i++){
          Living Preditor = Preditors.get(i);
          for(int j = 0; j < Alive.size(); j++){
            Living Prey = Alive.get(j);
              if(Preditor.doesThisCollide((int) Prey.GetX(), (int) Prey.GetY())){
                if((Prey.getName().equals("Tetra")||Prey.getName().equals("Guppy"))){
                  if(Preditor.getName().equals("Shark")){ 
                    Alive.remove(j); 
                    System.out.println(Prey.getName() + " was eaten");
                    Preditor.feed();
                  }
                }else if(Prey.getName().equals("Plankton")){
                  if(Preditor.getName().equals("Tetra") || Preditor.getName().equals("Guppy") ){ 
                    Alive.remove(j); 
                    System.out.println(Prey.getName() + " was eaten");
                    Preditor.feed();
                  }
                } 
            }
          } 
        }
    }
    public void Click(int a, int b){
      System.out.println("Click at " + a + ":" + b);
      for(int l = 0; l < Alive.size(); l++){ 
        if(Alive.get(l).doesThisCollide(a, b)){
          System.out.println(Alive.get(l).getName() + " Was Clicked");
          ClickTarget = Alive.get(l);
        } 
      }
    }

    /*
     * paintComponent Places the the Background Image.
     */
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

      try{
        for(Living l: Alive){ l.paint(b2); }      
        Toolkit.getDefaultToolkit().sync();
      }catch(Exception e){
        System.out.println("dead");
      } 
    }  
    
}