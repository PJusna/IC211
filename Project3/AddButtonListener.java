import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Listens for the user adding a species.  
 * @author MIDN Peter Asjes
 */
class AddButtonListener implements ActionListener {    
    private JComboBox Speceis;
    private int hunger, speed;
    private Background P;

    public AddButtonListener(JComboBox S, int h, int s, Background P) {
        this.Speceis = S;
        this.hunger = h;
        this.speed = s;
        this.P = P;        
    }
  
    public void actionPerformed(ActionEvent e) {
        P.addLiving((String)Speceis.getSelectedItem());
    }
}