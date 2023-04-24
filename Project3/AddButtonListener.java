import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddButtonListener implements ActionListener {    
    private String Speceis;
    private int hunger, speed;
    private Background P;
    public AddButtonListener(String S, int h, int s, Background P) {
        this.Speceis = S;
        this.hunger = h;
        this.speed = s;
        this.P = P;        
    }
  
    public void actionPerformed(ActionEvent e) {
        System.out.println(Speceis + " " + hunger + " " + speed);
        P.addLiving(Speceis);
    }
}