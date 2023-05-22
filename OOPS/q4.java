public class q4 {
    public static void main(String args[]) {
        Vehicle o1 = new Car();
        o1.print1();

        Vehicle o2 = new Vehicle();
        o2.print();
    }
}

class Vehicle {
    void print() {
        System.out.println("Base class");
    }
}

class Car extends Vehicle {
    void print1() {
        System.out.println("Child class");
    }
}


