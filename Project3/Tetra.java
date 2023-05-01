import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;  

public class Tetra extends Living{
    //location
    double x = 100, y = 100, dx = 1, dy = 1, speed = 1;
    BufferedImage Foto = null;
    boolean Dead = false;
    int hunger = 1500, metab = 1;
    public Tetra(int x, int y){
        super();
        this.x = x;
        this.y = y;
        dx = 1;
        dy = 1;
    }


    public String getName(){
        return "Tetra";
    }

    public void AdjustSandH(int S, int H){
        speed = S * 0.1;
        metab = H;
    }
    public int step(){
        
        if(x < 5){
            dx = 1;
        }else if(x > 1075){
            dx = -1;
        }
        if(y < 5){
            dy = 1;
        }else if(y > 825){
            dy = -1;
        }
        x = x + dx*speed;
        y = y + dy*speed;
        hunger--;
        hunger = hunger - metab;
        return hunger;
    }
    public int getHunger(){
        return hunger;
    }

    public double getSpeed(){
        return speed;
    }

    public void feed(){
        hunger += 100;
    }

    public void paint(Graphics2D g) {
        try {
          Foto = ImageIO.read(new File("Tetra1.0.jpg"));
        } catch (IOException e) {}
        
        AffineTransform tf = AffineTransform.getScaleInstance(-0.1, 0.1);
        tf.translate(-Foto.getWidth(), 0);
        AffineTransformOp op = new AffineTransformOp(tf, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        Foto = op.filter(Foto, null);
        int width = -70;
        if(dx < 0){ width = 70; }
        g.drawImage(Foto, (int) x, (int) y, width, 40, null);
    }

    public double GetX(){
        return x;
    }
    public double GetY(){
        return y;
    }

    public boolean doesThisCollide(int a, int b){
        if((x + 50 > a) && (x - 50 < a) && (y + 50 > b) && (y - 50 < b)){
            return true;
        }
        return false;
    }
}