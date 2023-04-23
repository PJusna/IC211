import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;   

public class Guppy implements Living{
    //location
    double x = 100, y = 100, dx = 1, dy = 1;
    BufferedImage Foto = null;

    public Guppy(int x, int y){
        this.x = x;
        this.y = y;
        dx = 1;
        dy = 1;
        System.out.println("bang");
    }
    public String getName(){
        return "Shark";
    }
    public void step(){
        
        if(x < 300){
            dx = 1;
        }else if(x > 400){
            dx = -1;
        }
        if(y < 300){
            dy = 1;
        }else if(y > 500){
            dy = -1;
        }
        x = x + dx;
        y = y + dy;
        //x ++;
        //y++;
    }

    public void paint(Graphics2D g) {
        try {
          Foto = ImageIO.read(new File("Guppy1.0.png"));
        } catch (IOException e) {}
        AffineTransform tf = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(tf, AffineTransformOp.TYPE_BILINEAR);
        tf.scale(0.1, 0.1);
        op = new AffineTransformOp(tf, AffineTransformOp.TYPE_BILINEAR);
        Foto = op.filter(Foto, null);
        g = Foto.createGraphics();
        
    }

    public String GetLocation(){
        //make this a node?
        String t = "";
        t = x + " " + y;
        return t;
    }
}