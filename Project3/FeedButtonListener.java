import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FeedButtonListener implements ActionListener {    
    private String S;
    public FeedButtonListener() {
        S = "Feed";
    }
  
    public void actionPerformed(ActionEvent e) {
        System.out.println(S);
    }
}