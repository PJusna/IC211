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
    private ArrayList<Shark> Sharks = new ArrayList<Shark>();
    private ArrayList<Tetra> Tetras = new ArrayList<Tetra>();
    private ArrayList<Guppy> Guppys = new ArrayList<Guppy>();
    private ArrayList<Plankton> Planks = new ArrayList<Plankton>();
    
    public int SharkCnt = 1, GuppyCnt = 2, TetraCnt = 3, PlankCnt = 0;
    public Background(){
        super();
        setPreferredSize(new Dimension(400, 400));
        for(int i = 0; i < SharkCnt; i++){
          Sharks.add(new Shark(100 + 300 * i, 100 + 300*i));
        }
        for(int i = 0; i < GuppyCnt; i++){
          Guppys.add(new Guppy(200 + 75 * i, 100 + 250*i));
        }
        for(int i = 0; i < TetraCnt; i++){
          Tetras.add(new Tetra(300 + 250 * i, 800 - 50 * i));
        }
    }

    public void addLiving(String name){
        System.out.println(name);
        Planks.add(new Plankton(500, 500));
        PlankCnt++;
  
      if(name.equals("Guppy")){
        Guppys.add(new Guppy(500, 500));
        GuppyCnt++;
      }
      else if(name.equals("Tetra")){
        Tetras.add(new Tetra(100, 900));
        TetraCnt++;
      }
      else if(name.equals("Shark")){
        Sharks.add(new Shark(800, 300));
        SharkCnt++;
      }
    }

    public void step() {
      for(int i = 0; i < SharkCnt; i++){
        Sharks.get(i).step();
      }
      for(int i = 0; i < GuppyCnt; i++){
        Guppys.get(i).step();
      }
      for(int i = 0; i < TetraCnt; i++){
        Tetras.get(i).step();
      }
      for(int i = 0; i < PlankCnt; i++){
        Planks.get(i).step();
      }
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
      
      for(int i = 0; i < SharkCnt; i++){
        Sharks.get(i).paint(b2);
      }
      b2.setColor(Color.RED);
      for(int i = 0; i < GuppyCnt; i++){
        Guppys.get(i).paint(b2);
      }
      b2.setColor(Color.GREEN);
      for(int i = 0; i < TetraCnt; i++){
        Tetras.get(i).paint(b2);
      }
      Toolkit.getDefaultToolkit().sync();
    }
}