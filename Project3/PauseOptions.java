import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PauseOptions extends JPanel implements MouseListener{
    private JTextField      L;
    private Background  B;
    private Menu        M;
    private int Start = 0;
    private Living ClickTarget; 
    public PauseOptions(Background B, JTextField L, Menu M){
        System.out.println("Listening");
        this.B = B;
        this.L = L;
        this.M = M;
    }
    public void mouseClicked(MouseEvent e) {
        B.Click(e.getX(), e.getY());
        if(!M.getRunning()){ 
            ClickTarget = B.GetClickTarget();
            L.setText("This is a " + ClickTarget.getName()
                + ". They have: " 
                + ClickTarget.getHunger() 
                + " Food stored. They are going " 
                + ClickTarget.getSpeed() + " MPH");
            Start++;
        }
    }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e)  { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e){ }
    
}
