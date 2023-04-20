import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class Lauren extends JButton {
    public Lauren(String s)  {
        super(s);
    }
    // personalize paint
    // never called by you, java calls it through repaint
    protected void paintComponent(Graphics g) {
        //we could call original paint component 
        super.paintComponent(g); 

        // or make it your own
        g.setColor(Color.pink);
        g.fillRect(75, 5, 140, 15);
        g.setColor(Color.BLUE);
        g.drawString("added button", 80, 18);
    }
}