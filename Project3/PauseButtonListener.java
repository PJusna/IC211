import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PauseButtonListener implements ActionListener {   
    private String S;
    public PauseButtonListener() {
        S = "Running? ";
    }
  
    public void actionPerformed(ActionEvent e) { 
        Menu.running = false; 
        System.out.println( S + Menu.running);
    }
}