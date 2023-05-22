public class Classes {
    public static void main(String[] args) {
        
        // associating memory for classes
        
        // Cat beluga = new Cat();
        // Pen P1 = new Pen(); 
        // BankAcc MyAcc = new BankAcc();
        // Football F2 = new Football()                            // non parameterized
        // Football F1 = new Football("UEFA", 9);        // parameterized 

        // Testing Copy Constructor
        /* Student n1 = new Student("ABC", 12, "xyz");
            n1.marks[0] = 100;
            n1.marks[1] = 90;
            n1.marks[2] = 80;

            Student n2 = new Student(n1);   // copy constructor call
            n1.marks[0] = 25;
            // System.out.println("N2\n" + n2.name + "\n" + n2.roll + "\n" + n2.pwd);
            for (int i= 0 ; i<3 ; i++) {
                System.out.println(n2.marks[i]);
            }
        */

        
        // MyAcc.username = "ishant";
        // MyAcc.changePassword("null");
        // P1.setColor("BLUE");
        // System.out.println(P1.getColor());
        // P1.setSize(3);
        // System.out.println(P1.getSize());
        // // System.out.println(F1.getSize() + "\n" + F1.getName());
        // System.out.println(beluga.color());
        // beluga.isAlive();
        // beluga.eats();
    }
}

class Student {
    String name;
    int roll;
    String pwd;
    int marks[];

    /*   (try out Lazy Copy Constructor)
     
    Student(Student s1) {       
        // Shallow - Copy Constructor
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        this.pwd = s1.pwd;
        this.marks = s1.marks;
    }
    
     */

    Student(Student s1) {

        // Deep - Copy Constructor
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        this.pwd = s1.pwd;
        
        for (int i=0 ; i<marks.length ; i++) {
            this.marks[i] = s1.marks[i];
        }
    }

    Student(String name, int roll, String pwd) {    
        // parameterized
        marks = new int[3];
        this.name = name;
        this.roll = roll;
        this.pwd = pwd;
    }
}

class Pen {

    // this keyword is used to refer the current object, here it is pen

    private String color = "Black";
    private int size = 5;

    String getColor() {
        return this.color;
    }
    
    void setColor(String color) {
        this.color = color;
        
    }

    void setSize(int size) {
        this.size = size;
    }

    int getSize() {
        return this.size;
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


class Football {
    int radius;
    String model_name;

    Football() {                                        
        // this a non-parameterized constructor
        System.out.println("Constructor is created");
    }

    Football(String name, int size) {       
        // this is a parameterized constructor
        this.radius = size;
        this.model_name = name;
    }


    // getters
    int getSize() {
        return this.radius;
    }

    String getName() {
        return this.model_name;
    }
}

class Animal {             
    
    // superclass, parent class, base class
    void eats() {
        System.out.println("It eats");
    }

    void isAlive() {
        System.out.println("Is alive");
    }
}

class Mammal extends Animal {   // subclass, child class, derived class
    int legs = 4;

    int getLegs() {
        return legs;
    }
}

class Cat extends Mammal {     // Multi Level Inheritence, from Animal to Mammal to Cat

    //extends keyword is used to inhert a class
    String color = "Orange";
    String color() {
        return this.color;
    }
}


//interfaces 

interface Car {
    int wheels = 4;
    void engine();    
    void speed();
}

class Toyota implements Car {
    public void engine() {              //public mandatory
        System.out.println("H2");
    }
    public void speed() {
        System.out.println("340");
    }
}

class Maruti implements Car {
    public void engine() {              //public mandatory
        System.out.println("H1");
    }
    public void speed() {
        System.out.println("120");
    }
}

interface herbivore {
    void eats_plants();
}

interface carnivore {
    void eats_meat();
}

class bear implements herbivore, carnivore{
    public void eats_plants() {
        System.out.println("Plant eater");
    }
    public void eats_meat() {
        System.out.println("Meat eater");
    }
}