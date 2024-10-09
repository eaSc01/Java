package OOPS;

public class HybridInheritence {
    public static void main(String args[]) {
        
    }
}

class Animal {
    void breathe() {
        System.out.println("Breathes");
    }

    void eats() {
        System.out.println("Eats");
    }
}

class Fish extends Animal{
    int fins;

    int getFins() {
        return fins;
    }
}

class Mammal extends Animal {
    int legs = 4;

    int legs() {
        return legs;
    }
}

class Bird extends Animal {
    
    void fly() {
        System.out.println("It flies");
    }
}

class Tuna extends Fish {
    int size = 5;

    int weight() {
        return size;
    }
}

class Shark extends Fish {
    String name = "Great White";

    String category() {
        return name;
    }   
}

class Peacock extends Bird {
    String color = "Rainbow";

    String color() {
        return color;
    }
}

class Cat extends Mammal {
    String color = "Orange";
    String color() {
        return this.color;
    }
}

class Dog extends Mammal {
    String Breed = "Pitbull";
    String Breed() {
        return this.Breed;
    }
}