/*
    Objects = entities in the real world
    Classes = Group of similar entities 

    in a class,
        attribute (property)
        functions (behaviour)

    Access Modifiers:

    private: only within class
    default: within class and within package
    protected: within class, package and outside package by sublass only
    public: full access to any
 */

public class Classes {
    public static void main(String[] args) {
        
        // associating memory for class Pen

        Pen P1 = new Pen(); 
        BankAcc MyAcc = new BankAcc();

        // MyAcc.username = "ishant";

        // P1.changeColor("BLUE");
        // System.out.println(P1.color);
        // P1.color = "error";
        // System.out.println(P1.color);
    }
}

class Pen {
    String color = "Black";
    int size = 5;

    void changeColor(String newCol) {
        color = newCol;
    }

    void changeSize(int newSize) {
        size = newSize;
    }
}

class BankAcc {
    public String username = "admin";
    private String password = "admin";

    void changeUsername(String newName) {
        username = newName;
    }

    void changePassword(String newPwd) {
        password = newPwd;
    }
}