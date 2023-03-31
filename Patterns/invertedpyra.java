public class invertedpyra {
    public static void main(String args[]){

        for (int i = 1; i<=4; i++) {
            System.out.println();
            for (int j = 1; j<=5-i; j++) {
                System.out.print("*");
            }
        }
    }
}