import CIE.Internals;
import SEE.External;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        
        Internals[] internals = new Internals[n];
        External[] externals = new External[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("USN: ");
            String usn = scanner.next();
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Semester: ");
            int sem = scanner.nextInt();

            // Input internal marks
            int[] internalMarks = new int[5];
            System.out.println("Enter internal marks for 5 courses:");
            for (int j = 0; j < 5; j++) {
                internalMarks[j] = scanner.nextInt();
            }

            // Input external marks
            int[] externalMarks = new int[5];
            System.out.println("Enter external marks for 5 courses:");
            for (int j = 0; j < 5; j++) {
                externalMarks[j] = scanner.nextInt();
            }

            // Create objects
            internals[i] = new Internals(usn, name, sem, internalMarks);
            externals[i] = new External(usn, name, sem, externalMarks);
        }

        // Display final marks
        System.out.println("\nFinal Marks of Students:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student: " + internals[i].getName() + " (" + internals[i].getUsn() + ")");
            System.out.println("Internal Marks: ");
            int[] internalMarks = internals[i].getInternalMarks();
            for (int mark : internalMarks) {
                System.out.print(mark + " ");
            }
            System.out.println();
            
            System.out.println("External Marks: ");
            int[] externalMarks = externals[i].getExternalMarks();
            for (int mark : externalMarks) {
                System.out.print(mark + " ");
            }
            System.out.println();
            
            // Calculate total marks
            int total = 0;
            for (int mark : internalMarks) {
                total += mark;
            }
            for (int mark : externalMarks) {
                total += mark;
            }
            System.out.println("Total Marks: " + total);
            System.out.println();
        }

        scanner.close();
    }
}
