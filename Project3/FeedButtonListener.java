import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FeedButtonListener implements ActionListener {    
    private String S;
    Background B;
    public FeedButtonListener(Background B) {
        this.B = B;
    }
  
    public void actionPerformed(ActionEvent e) {
        B.addLiving("Plank");
    }
}