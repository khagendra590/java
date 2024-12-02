import java.util.Scanner;

// Custom exception class
class WrongAge extends Exception {
    public WrongAge() {
        super("Age Error");
    }

    public WrongAge(String message) {
        super(message);
    }
}

// Input scanner class
class InputScanner {
    protected Scanner scanner;

    public InputScanner() {
        scanner = new Scanner(System.in);
    }
}

// Father class extending InputScanner
class Father extends InputScanner {
    protected int fatherAge;

    public Father() throws WrongAge {
        System.out.print("Enter father's age: ");
        fatherAge = scanner.nextInt();

        if (fatherAge < 0) {
            throw new WrongAge("Age cannot be negative");
        }
    }

    public int getFatherAge() {
        return fatherAge;
    }

    public void display() {
        System.out.println("Father's age: " + fatherAge);
    }
}

// Son class extending Father
class Son {
    private int sonAge;
    private int fatherAge;

    public Son(int fatherAge) throws WrongAge {
        this.fatherAge = fatherAge; // Store the father's age
        InputScanner scanner = new InputScanner(); // Create a new scanner instance
        System.out.print("Enter son's age: ");
        sonAge = scanner.scanner.nextInt();

        if (sonAge < 0) {
            throw new WrongAge("Age cannot be negative");
        } else if (sonAge >= fatherAge) {
            throw new WrongAge("Son's age cannot be greater than or equal to father's age");
        }
    }

    public void display() {
        System.out.println("Son's age: " + sonAge);
    }
}

// Main class to run the program
public class Mains {
    public static void main(String[] args) {
        try {
            Father father = new Father();
            father.display();

            Son son = new Son(father.getFatherAge());
            son.display();
        } catch (WrongAge e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}