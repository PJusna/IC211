/**
This class is the base for each dot to be output.
 */
import java.util.*;


public class MovingDot extends Dot {
    private int dir;
    protected int Sdir;
    /** 
    A constructor that takes row and column position as integers
    @param int row
    @param int column
    **/
    public MovingDot(int r, int c){ 
        super(r, c);
        dir = 0;
        Sdir = 0;
    }

    /** A
     step method that moves the Dot in the direction that it is facing 
    for the first step, choose an arbitrary direction
    */
    public void step(){
        System.out.print("error");
    }

    public void move(){    
        //N
        if(dir == 0) 
            super.incRow();

        //NE
        else if(dir == 1){
            super.incRow();
            super.incCol();
        }

        //E
        else if(dir == 2)
            super.incCol();

        //SE
        else if(dir == 3){ 
            super.decRow();
            super.incCol();
        }

        //S
        else if(dir == 4)
            super.decRow();

        //SW
        else if(dir == 5){ 
            super.decRow();
            super.decCol();
        }

        //W
        else if(dir == 6)
            super.decCol();
        
        //NW
        else{
            super.incRow();
            super.decCol();
        }

    }
    
    //a function to turn the dot's diretion right.
    protected void tright(){
        dir = dir + 2;
        if(dir >= 8)
            dir = Sdir;
    }

    //a function to turn the dot's diretion left.
    protected void tleft(){
        if(dir <= 1)
            dir = Sdir + 8;
        dir = dir - 2;
    }

    // Test
    public static void main(String[] args){
        MovingDot blue    = new MovingDot( 0,  0);
        blue.tright();
        System.out.println(blue    + " b " + blue.dir);
    }

}