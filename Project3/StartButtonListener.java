import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class StartButtonListener implements ActionListener {    
    private String S;
    public StartButtonListener() {
        S = "Running? ";
    }
  
    public void actionPerformed(ActionEvent e) {   
        Menu.running = true;
        System.out.println(S + Menu.running);
    }
}