package OOPS;

public class Abstraction {
    public static void main(String args[]) {

        // Horse h1 = new Horse();
        // Chicken c1 = new Chicken();
        return;
    }
}

abstract class Animal {
    String color;

    Animal() {              //constructor will be called first, not to allocate memory but to inititalize
        color = "Brown";
    }

    void eats() {
        System.out.println("It eats");
    }

    abstract void walk();       // needs to be defined in sub classes
}

class Horse extends Animal {
    void changeColor() {
        color = "dark brown";
    }

    void walk() {
        System.out.println("Walks on 4 legs");
    }
}

class Chicken extends Animal {
    void changeColor() {
        color = "white";
    }

    void walk() {
        System.out.println("Walks on 2 legs");
    }
}

