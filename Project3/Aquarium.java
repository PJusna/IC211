import java.util.*;
import java.io.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
/**
 * This is the Overarching class for The Aquarium.
 * It creates the components uses for the Moving, 
 * non-moving, and menu options.
 * @author MIDN Peter Asjes
 */
// I. Make the overarching Frame
// II. create all moving elemnts under the living hierarchy       
// III. create all the menu options under the static hierarchy
//      A. Background
//      B. Menu
//          i. Add button
//          ii. Start
//          iii. feed
//          iv. contro
// IV. implenment all the living and static elements into the visuals.

public class Aquarium extends Thread{
    /*
     * This is the class for the thread. 
     */
    public static class Animation extends Thread {
        private Background Liv; 
        private Menu         M; 
        private JFrame       F;
        
        /**
        * This is the constructor for the Animation thread in which
        * all of the moving elements are progressed.
        * @param b The Background holding the Array List and methods for
        *          moving things.
        * @param M The menu for controlling the things. 
        */
        public Animation(Background b, JFrame F, Menu M) {
            Liv = b;
            this.F = F;            
            this.M = M;
        }
        public void run() {
            while (true) {
                System.out.print("");
                if(M.getRunning()){
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {}
                    Liv.step();
                    
                }
                Liv.repaint();
            }
        }
    }

    public static void main(String[] args) {
        
        JFrame F     = new JFrame("Peter's Fish Tank");
        F.setSize(10000, 8000);
        F.setLocation(0, 0);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create Background
        Background B = new Background();

        //Make the menu
        Menu M = new Menu(F, B);
        Menu.MenuDisplay(false); 
        
        //Start the thread
        Thread t = new Animation(B, F, M);
        t.start(); 
        
        F.add(B);
        F.pack();
        F.setVisible(true);

    }
}