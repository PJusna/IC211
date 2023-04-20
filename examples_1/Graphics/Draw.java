//draw gives the outline 
//fill the shape 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class Draw {
    public static void main (String [] args){
        // create a Jframe
        JFrame f = new JFrame();

        // make my button
        String s = "This is Lauren's";
        JButton b = new Lauren2(s);

        f.add(b);
        f.pack(); 
        f.setVisible(true);

    }
}