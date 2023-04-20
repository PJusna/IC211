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

public class Aquarium {

    public static void main(String[] args) {
        JFrame F     = new JFrame();
        //Create Background
        JComponent B = new Background();
        
        //Make the menu
        Menu M = new Menu(F);
        Menu.MenuDisplay();   

        //Introduce Life
        ArrayList<Living> L = new ArrayList<Living>();   
        if(true){
            L.add(new Shark());
            L.add(new Tetra());
            L.add(new Guppy());
        }
        F.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        F.setUndecorated(true);
        F.setVisible(true);
        F.add(B);
        F.pack();
        F.setVisible(true);
    }
}