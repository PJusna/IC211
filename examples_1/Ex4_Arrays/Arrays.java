public class Arrays {
    public static void main (String) {
        //create an array of ints.
        int [] A = new int[5];
        for(int i = 0; i < 5; i++)
            A[i] = i;
        char [] C = new char[5];
        for(int i = 0; i < 5; i++)
            C[i] = (char) (i + 48);
        double [][] D = new double[3][2];
        for(int i = 0; i < D.length; i++){
            System.out.print(D[i])
        }
    }
}