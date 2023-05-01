import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;

public class DescriptionPanel extends JPanel {
    public static JFrame     F;
    public static Background B;
    public DescriptionPanel(JFrame F, Background B){
        this.F = F; 
        this.B = B;
    }

    public static void Describe() {
        JPanel P = new JPanel(new FlowLayout());
        P.setPreferredSize(new Dimension(275, 100));
        F.add(P, BorderLayout.NORTH);
        
        P.add(new JLabel("Wo"));
    }

}
