import java.util.*;
/**
The red dot is the most fundamental dot
 */

public class RedDot extends MovingDot {
    Random rand = new Random(System.currentTimeMillis());
    public RedDot(int r, int c){
        super(r, c);
    }

    public void step(){
        int r = rand.nextInt(3);        
        
        if(r == 0)
            super.tright();
        else if(r == 1)  
            super.tleft();
        
        super.move();
    }   
    
    public String toString(){
        return super.toString() + "r"; 
    }
}