import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel{
    //-Start
    //-Feed (2)
    //-Adjust
    //-Add (3)
    //-
    public static JFrame F;
    public static String[] Species = {"Shark", "Tetra", "Guppy"};
    public static JComboBox<String> AddFish = new JComboBox<String> (Species);
    public static JButton Start = new JButton("START");
    public static JButton Feed = new JButton("FEED");
    public static JTextField Adjust = new JTextField(20); 

    public Menu(JFrame F){
        this.F = F; 
    }

    public static void MenuDisplay() {
        JPanel P = new JPanel(new FlowLayout());
        F.add(P, BorderLayout.EAST);
        P.add(AddFish);
        P.add(Start);
        P.add(Feed);
        P.add(Adjust);
    }
}