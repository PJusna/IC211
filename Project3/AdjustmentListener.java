import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AdjustmentListener implements ActionListener {   
    private JComboBox S;
    private JSlider Hunger, Speed;
    private Background B;
    private String Sname = "Toby";
    public AdjustmentListener(JComboBox S, JSlider Hunger, JSlider Speed, Background B){
        this.S      =      S;
        this.Hunger = Hunger;
        this.Speed  =  Speed;
        this.B      =      B;
    }
  
    public void actionPerformed(ActionEvent e) {  
        
        B.adjustSpecies((String) S.getSelectedItem(), Hunger.getValue(), Speed.getValue());
    }
}