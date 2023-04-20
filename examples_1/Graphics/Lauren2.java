import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.BorderLayout;

public class Lauren2 extends JButton {
    public Lauren2(String s)  {
        super(s);
    }
    // personalize paint
    // never called by you, java calls it through repaint
    protected void paintComponent(Graphics g) {
        //we could call original paint component 
        super.paintComponent(g); 

        Graphics2D g2 = (Graphics2D) g;
        // or make it your own
        g2.setColor(Color.WHITE);
        g2.fill(new Rectangle2D.Double(75, 5, 140, 15));
        g.setColor(Color.BLUE);
        g.drawString("added button", 80, 18);
    }
}