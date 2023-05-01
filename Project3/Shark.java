import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;  

public class Shark extends Living{
    //location
    double x = 100, y = 100, dx = 1, dy = 1, speed = 0.1;
    BufferedImage Foto = null;
    int hunger = 1500, metab = 1;

    public Shark(int x, int y){
        super();
        this.x = x;
        this.y = y;
        dx = 0.5;
        dy = 0.5;
    }
    public String getName(){
        return "Shark";
    }
    public void AdjustSandH(int S, int H){
        speed = S * 0.1;
        metab = H;
    }
    public int step(){
        if(x < 300){
            dx = 1;
        }else if(x > 1065){
            dx = -1;
        }
        if(y < 200){
            dy = 1;
        }else if(y > 1015){
            dy = -1;
        }
        x = x + dx*speed;
        y = y + dy*speed;
        hunger = hunger - metab;
        return hunger;
    }
    public double getSpeed(){
        return speed;
    }

    public int getHunger(){
        return hunger;
    }

    public void feed(){
        hunger += 100;
        
    }

    public void paint(Graphics2D g) {
        try {
          Foto = ImageIO.read(new File("Shark2.0.jpg"));
        } catch (IOException e) {}
        
        AffineTransform tf = AffineTransform.getScaleInstance(-0.1, 0.1);
        tf.translate(-Foto.getWidth(), 0);
        AffineTransformOp op = new AffineTransformOp(tf, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        Foto = op.filter(Foto, null);
        int width = -300;
        if(dx < 0){ width = 300; }
        g.drawImage(Foto, (int) x, (int) y, width, 150, null);
    }

    public double GetX(){
        return x;
    }
    public double GetY(){
        return y;
    }
    public boolean doesThisCollide(int a, int b){
        if((x > a) && (x - 300 < a) && (y + 100 > b) && (y < b)){
            return true;
        }
        return false;
    }
}