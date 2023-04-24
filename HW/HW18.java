import java.util.*;
import java.io.*;

public class HW18 {
  public static void main(String[] args) {
    Reader r = new InputStreamReader(System.in);
    LineNumberReader L = new LineNumberReader(r); 
    Scanner sc = new Scanner(L);
    Mystery myster = new Mystery();
    String fname;
    if(args.length == 1){
        fname = args[0];
        try{
            r = new LineNumberReader(r);
            sc = new Scanner(new FileReader(fname));
        }
        catch(FileNotFoundException e){
            System.out.println("File not Found");
        }
    }
    
    try {
      myster.compute(sc); // can be called multiple times to continue computation
      System.out.println(myster.result()); // only called once after all compute() calls are finished
    } catch( Exception e ) {
      System.out.println("Error on line " + L.getLineNumber() + ": " + e.getMessage());
    }
  }
}