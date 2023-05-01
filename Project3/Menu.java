import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Menu extends JPanel {
    
    //-Start
    //-Feed (2)
    //-Adjust
    //-Add (3)
    //-
    public static JFrame                                                          F;
    public static JPanel                                                          P;
    public static Background                                                      B;
    public static boolean                                            running = true;
    public static JButton                              Start = new JButton("START");
    public static JButton                              Pause = new JButton("PAUSE");
    public static JButton                                Feed = new JButton("FEED");
    public static String[]                    Species = {"Shark", "Tetra", "Guppy"};
    public static JComboBox<String>       AddFish = new JComboBox<String> (Species);
    public static JButton                        addFishButton = new JButton("ADD");
    public static JComboBox<String> AdjustSpecies = new JComboBox<String> (Species); 
    
    public static JSlider AdjustHunger = new JSlider(0, 10, 5);
    public static JSlider AdjustSpeed = new JSlider(0, 10, 5);
    
    public static JTextField D = new JTextField("Undescribed", 20);
    private PauseOptions PC;

    public Menu(JFrame F, Background B){
        this.F = F; 
        this.B = B;
        PC = new PauseOptions(B, D, this); 
        B.addMouseListener(PC);        
    }
    public boolean getRunning(){ return running; }

    public static void MenuDisplay(boolean Desc) {
        System.out.println("NEW MENU");
        P = new JPanel(new FlowLayout());
        P.setPreferredSize(new Dimension(275, 100));
        F.add(P, BorderLayout.EAST);
        

        P.add(Start);
        P.add(Pause);
        P.add(AddFish);
        P.add(addFishButton);
        P.add(Feed);
        D.setPreferredSize(new Dimension(500, 50));
        P.add(D);
        
        P.add(new JLabel("Pick a Species to adjust:"));
        P.add(AdjustSpecies);
        P.add(new JLabel("How much do they need to eat?"));
        P.add(AdjustHunger);
        P.add(new JLabel("How fast are they?"));
        P.add(AdjustSpeed);


        AdjustSpecies.addActionListener(new AdjustmentListener( AdjustSpecies, AdjustHunger, AdjustSpeed, B));
        Start.addActionListener(new StartButtonListener());
        Pause.addActionListener(new PauseButtonListener());
        Feed.addActionListener(new FeedButtonListener(B));
        addFishButton.addActionListener(new AddButtonListener(AddFish, AdjustHunger.getValue(), AdjustSpeed.getValue(), B));
    }
}