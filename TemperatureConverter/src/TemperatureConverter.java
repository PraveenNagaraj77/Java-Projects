import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Get the temperature value
            System.out.print("Enter the temperature value: ");
            double temperature = scanner.nextDouble();

            // Step 2: Choose the source unit
            System.out.println("Select the source unit: ");
            System.out.println("1. Celsius\n2. Fahrenheit\n3. Kelvin");
            int sourceUnit = scanner.nextInt();

            // Step 3: Choose the target unit
            System.out.println("Select the target unit: ");
            System.out.println("1. Celsius\n2. Fahrenheit\n3. Kelvin");
            int targetUnit = scanner.nextInt();

            // Step 4: Perform the conversion
            double convertedTemperature = convertTemperature(temperature, sourceUnit, targetUnit);

            // Step 5: Display the result
            System.out.printf("Converted Temperature: %.2f%n", convertedTemperature);

        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        } finally {
            scanner.close();
        }
    }

    public static double convertTemperature(double temp, int source, int target) {
        if (source == target) {
            return temp; // No conversion needed
        }

        // Convert source to Celsius first
        double tempInCelsius;
        switch (source) {
            case 1: // Celsius
                tempInCelsius = temp;
                break;
            case 2: // Fahrenheit
                tempInCelsius = (temp - 32) * 5 / 9;
                break;
            case 3: // Kelvin
                tempInCelsius = temp - 273.15;
                break;
            default:
                throw new IllegalArgumentException("Invalid source unit");
        }

        // Convert Celsius to target unit
        switch (target) {
            case 1: // Celsius
                return tempInCelsius;
            case 2: // Fahrenheit
                return (tempInCelsius * 9 / 5) + 32;
            case 3: // Kelvin
                return tempInCelsius + 273.15;
            default:
                throw new IllegalArgumentException("Invalid target unit");
        }
    }
}
