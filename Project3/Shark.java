import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;  

public class Shark implements Living{
    //location
    double x = 100, y = 100, dx = 1, dy = 1;
    BufferedImage Foto = null;

    public Shark(int x, int y){
        this.x = x;
        this.y = y;
        dx = 0.5;
        dy = 0.5;
    }
    public String getName(){
        return "Shark";
    }
    public void step(){
        
        if(x < 300){
            dx = 0.5;
        }else if(x > 1465){
            dx = -0.5;
        }
        if(y < 200){
            dy = 0.5;
        }else if(y > 1015){
            dy = -0.5;
        }
        x = x + dx;
        y = y + dy;
        //x ++;
        //y++;
    }

    public void paint(Graphics2D g) {
        try {
          Foto = ImageIO.read(new File("Shark2.0.jpg"));
        } catch (IOException e) {}
        
        AffineTransform tf = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(tf, AffineTransformOp.TYPE_BILINEAR);
        tf.scale(0.1, 0.1);
        op = new AffineTransformOp(tf, AffineTransformOp.TYPE_BILINEAR);
        Foto = op.filter(Foto, null);
        //g = Foto.createGraphics();
        g.drawImage(Foto, (int) x, (int) y, null);
    }

    public double GetLocation(){
        return x*1000 + y;
    }
}