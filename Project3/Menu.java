import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel{
    
    //-Start
    //-Feed (2)
    //-Adjust
    //-Add (3)
    //-
    public static JFrame F;

    public static JButton Start = new JButton("START");
    public static JButton Feed = new JButton("FEED");
    public static String[] Species = {"Shark", "Tetra", "Guppy"};
    public static JComboBox<String> AddFish = new JComboBox<String> (Species);
    public static JButton addFishButton = new JButton("ADD");
    public static JComboBox<String> AdjustSpecies = new JComboBox<String> (Species); 
    public static JSlider AdjustHunger = new JSlider(0, 10, 5);
    public static JSlider AdjustSpeed = new JSlider(0, 10, 5);

    public Menu(JFrame F){
        this.F = F; 
    }

    public static void MenuDisplay() {
        JPanel P = new JPanel(new FlowLayout());
        P.setPreferredSize(new Dimension(275, 100));
        F.add(P, BorderLayout.EAST);
        
        P.add(Start);
        P.add(AddFish);
        P.add(addFishButton);
        P.add(Feed);
        P.add(new JLabel("Species:  "));
        P.add(AdjustSpecies);
        P.add(new JLabel("Hunger:  "));
        P.add(AdjustHunger);
        P.add(new JLabel("Speed:  "));
        P.add(AdjustSpeed);
    }
}