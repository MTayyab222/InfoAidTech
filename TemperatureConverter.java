import java.util.Scanner;

public class TemperatureConverter {

    private static double convertToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    private static double convertToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Choose an option:");
            System.out.println("1. Convert Celsius to Fahrenheit");
            System.out.println("2. Convert Fahrenheit to Celsius");

            int option = scanner.nextInt();

            if (option == 1 || option == 2) {
                System.out.print("Enter temperature: ");
                double temperature = scanner.nextDouble();

                if (option == 1) {
                    double result = convertToFahrenheit(temperature);
                    System.out.println("Result: " + result + " Fahrenheit");
                } else {
                    double result = convertToCelsius(temperature);
                    System.out.println("Result: " + result + " Celsius");
                }
            } else {
                System.out.println("Invalid option. Please choose 1 or 2.");
            }

        } catch (java.util.InputMismatchException ex) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
