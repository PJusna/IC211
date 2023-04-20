import java.util.*;
/**
The Green dot goes diagonal. 
*/

public class GreenDot extends MovingDot {
    Random rand = new Random(System.currentTimeMillis());
    int counter = 0;    
    public GreenDot(int r, int c){
        super(r, c);
        super.Sdir = 1; //This sets the green dot on a diagonal trajectory. 
    }

    public void step(){
        if(counter%10 == 0){
            int r = rand.nextInt(3);        
            if(r == 0)
                super.tright();
            else if(r == 1)  
                super.tleft();
        
            
        }
        counter++; 
        super.move();
    }   
    
    public String toString(){
        return super.toString() + "g"; 
    }
}