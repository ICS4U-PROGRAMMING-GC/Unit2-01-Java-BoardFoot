import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculates the required length of wood for 1 board foot.
 *
 * @author  carel
 * @version 1.0
 * @since   2026-10-06
 */
public final class BoardFoot {

    /**
     * Private constructor to prevent instantiation.
     */
    private BoardFoot() {
    }

    /**
     * Calculates the length required for 1 board foot.
     *
     * @param width  The width in inches.
     * @param height The height in inches.
     * @return The length in inches.
     */
    public static double calculateBoardFoot(
        final double width, final double height) {
        // Calculate length (1 board foot = 144 cubic inches)
        return 144.0 / (width * height);
    }

    /**
     * Main entry point for the program.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        // Setup scanner
        Scanner scanner = new Scanner(System.in);

        // Variables
        double width = 0.0;
        double height = 0.0;

        // Get width
        while (width <= 0) {
            System.out.print("Enter width (inches): ");

            try {
                width = scanner.nextDouble();

                // Check for positive value
                if (width <= 0) {
                    System.out.println(
                        "Invalid input! Must be greater than 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.next(); // Cleans up invalid token
            }
        }

        // Get height
        while (height <= 0) {
            System.out.print("Enter height (inches): ");

            try {
                height = scanner.nextDouble();

                // Check for positive value
                if (height <= 0) {
                    System.out.println(
                        "Invalid input! Must be greater than 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.next(); // Cleans up invalid token
            }
        }

        // Calculate result
        double length = calculateBoardFoot(width, height);

        // Display output
        System.out.println("The required length is "
            + length + " inches.");

        scanner.close();
    }
}
