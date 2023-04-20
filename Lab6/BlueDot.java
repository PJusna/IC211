import java.util.*;
/**
The blue dot waits ten spaces to turn
*/

public class BlueDot extends MovingDot {
    Random rand = new Random(System.currentTimeMillis());
    int counter = 0;    
    public BlueDot(int r, int c){
        super(r, c);
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
        return super.toString() + "b"; 
    }
}