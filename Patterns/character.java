public class Character {
    public static void main(String args[]) {
        char a = 'A';

        for (int i = 1 ; i<=4 ; i++) {
            System.out.println();
            for (int j = 1; j<= i ; j++) {
                System.out.print(a++);
            }
        }
    }
}