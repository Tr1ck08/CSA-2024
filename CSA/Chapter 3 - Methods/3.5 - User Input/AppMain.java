import java.util.Scanner;
public class AppMain {
    public static void main(String[] args) {
        // Create a Scanner object.
        // Asks the user to type their age, the current year, a future year, and their name.
        // Print out "<Name> will be <computed age> years old in <future year>".
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        System.out.print("Enter the current year: ");
        int year = input.nextInt();
        System.out.print("Enter a future year: ");
        int future = input.nextInt();
        System.out.print("Enter your name: ");
        String name = input.next();
        
        System.out.print("\n" + name + " will be " + (age - year + future) + " years old in the year " + future);

        input.close();
    }
}
