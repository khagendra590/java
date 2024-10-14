import java.util.Scanner;

class StudDetails {
    int marks[] = new int[3];
    int credits[] = new int[3];
    String usn, name;

    Scanner sc = new Scanner(System.in);

    void getDetails() {
        System.out.print("Enter USN: ");
        usn = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();

        System.out.println("Enter marks and credits for 3 subjects (marks out of 100):");
        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
           
            credits[i] = sc.nextInt();
        }
    }

    double computeSGPA() {
        double totalPoints = 0.0;
        int totalCredits = 0;

        for (int i = 0; i < 3; i++) {
            int grade = calculateGrade(marks[i]);
            totalPoints += grade * credits[i];
            totalCredits += credits[i];
        }

        return (totalCredits > 0) ? (totalPoints / totalCredits) : 0.0;
    }

    int calculateGrade(int mark) {
        if (mark >= 90) return 10;
        else if (mark >= 80) return 9;
        else if (mark >= 70) return 8;
        else if (mark >= 60) return 7;
        else if (mark >= 50) return 6;
        else if (mark >= 40) return 5;
        else return 0;
    }

    void display() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        for (int i = 0; i < 3; i++) {
            System.out.println("Marks of subject " + (i + 1) + "with credit "+credits[i]+ "is " + marks[i]);
        }
        System.out.printf("SGPA: %.2f\n", computeSGPA());
    }
}

class Student {
    public static void main(String args[]) {
        StudDetails s1[] = new StudDetails[3];

        for (int j = 0; j < 3; j++) {
            s1[j] = new StudDetails();
            System.out.println("Enter the details of student " + (j + 1) + ":");
            s1[j].getDetails();
        }

        System.out.println("\nDisplaying student details:");
        for (int j = 0; j < 3; j++) {
            System.out.println("\nDetails of student " + (j + 1) + ":");
            s1[j].display();
        }
System.out.println("Name: Khagendra kumar mahato");
System.out.println("USN: 1BM23CS149");
    }
}