import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StartButtonListener implements ActionListener {    
    private String S;
    public StartButtonListener() {
        S = "Start";
    }
  
    public void actionPerformed(ActionEvent e) {
        System.out.println(S);
    }
}