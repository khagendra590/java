import java.util.Scanner;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a: ");
        double a = scanner.nextDouble();

        System.out.println("Enter b: ");
        double b = scanner.nextDouble();

        System.out.println("Enter c: ");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("There are no real solutions.");
        }
        else if(discriminant>0){
            System.out.println("root are real:");
        }
        else {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            double solution1 = (-b + sqrtDiscriminant) / (2 * a);
            double solution2 = (-b - sqrtDiscriminant) / (2 * a);

            System.out.println("The solutions are:");
            System.out.println("x1 = " + solution1);
            System.out.println("x2 = " + solution2);
        }
        System.out.println("khagendra chakkamoji");
        System.out.println("1BM23CS149");
    }
}