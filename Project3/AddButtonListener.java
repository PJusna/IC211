import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddButtonListener implements ActionListener {    
    private String Speceis;
    private int hunger, speed;
    public AddButtonListener(String S, int h, int s) {
        this.Speceis = S;
        this.hunger = h;
        this.speed = s;
    }
  
    public void actionPerformed(ActionEvent e) {
        System.out.println(Speceis + " " + hunger + " " + speed);
    }
}