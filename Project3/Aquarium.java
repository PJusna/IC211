import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

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

    public static class Animation extends Thread {
        private Background Liv; 
        public Animation(Background b) {
            Liv = b;
        }
        public void run() {
            while (true) {
                try {
                    Thread.sleep(20);
                } catch (Exception e) {}
                Liv.step();
                Liv.repaint();
            }
        }
    }

    public static void main(String[] args) {
        JFrame F     = new JFrame();
        //Create Background
        Background B = new Background();
        
        //Make the menu
        Menu M = new Menu(F);
        Menu.MenuDisplay();   

        //Introduce Life
        //ArrayList<Living> L = new ArrayList<Living>();   
        //if(true){
        //    L.add(new Shark());
        //    L.add(new Tetra());
        //    L.add(new Guppy());
        //}
        F.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        F.setUndecorated(true);
        F.setVisible(true);
        F.add(B);
        Thread t = new Animation(B);
        F.pack();
        F.setVisible(true);
    }
}