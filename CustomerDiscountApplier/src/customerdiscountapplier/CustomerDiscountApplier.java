package customerdiscountapplier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CustomerDiscountApplier {

    public static void main(String[] args) {
        String inputFile = "customers.txt"; // Name of the input file containing customer data
        String outputFile = "customerdiscount.txt"; // Output file for discounts
        
        // Use try-with-resources to automatically close files after operations
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line; // Variable to hold each line read from the input file
      
                         // Process each customer record until the end of the file
            while ((line = reader.readLine()) != null) {
                                // Split the line into first name and last name
                String[] names = line.split(" ");
                // Validate the format of the names
                if (names.length != 2 || !names[0].matches("[a-zA-Z]+") || names[1].isEmpty()) {
                    System.out.println("Invalid name format for: " + line);
                    continue; // Skip to the next customer if the name is invalid
                }
              
                String Name = names[0]; // First name
                String Surname = names[1]; // Last name
                
                // Read the total purchase amount for the customer
                line = reader.readLine();
                double totalSumOfPurchase;
                try {
                    totalSumOfPurchase = Double.parseDouble(line); // Convert the line to a double
                } catch (NumberFormatException e) {
                    System.out.println("Invalid total purchase for: " + Name + " " + Surname);
                    continue; // Skip if the total purchase is not a valid number
                }
                
                // Read the customer class
                line = reader.readLine();
                int customerClass;
                try {
                    customerClass = Integer.parseInt(line); // Convert the line to an integer
                    // Check if the customer class is within the valid range (1 to 3)
                    if (customerClass < 1 || customerClass > 3) {
                        System.out.println("Invalid data for: " + Name + " " + Surname);
                        continue; // Skip if the class is invalid
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid class for: " + Name + " " + Surname);
                    continue; // Skip if the class is not a valid number
                }
                
                // Read the last purchase year
                line = reader.readLine();
                int lastPurchaseYear;
                try {
                    lastPurchaseYear = Integer.parseInt(line); // Convert the line to an integer
                    // Check if the last purchase year is a reasonable value
                    if (lastPurchaseYear < 1900 || lastPurchaseYear > 2024) {
                        System.out.println("Invalid year for: " + Name + " " + Surname);
                        continue; // Skip if the year is invalid
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid last purchase year for: " + Name + " " + Surname);
                    continue; // Skip if the year is not a valid number
                }
                
                // Calculate the final purchase value after applying the discount
                double finalValue = calculateFinalValue(totalSumOfPurchase, customerClass, lastPurchaseYear);
                
                // Write the customer's name and the calculated final value to the output file
                writer.write(Name + "  " + Surname); // Write the name
                writer.newLine(); // Move to the next line
                writer.write(String.valueOf(finalValue)); // Writes the final value
                writer.newLine(); // Moves to the next line
                System.out.println("Final price for " + Name + " " + Surname + " : " + finalValue); // Prints finals value to the console
            }
        } catch (IOException e) {
            // Handle any errors that occur during file reading or writing
            System.out.println("An error occurred while reading or writing files: " + e.getMessage());
        }
    }
    /**
     * Calculates the final value after applying a discount based on customer class and last purchase year.
     *
     * @param totalPurchase   The total value of purchases made by the customer.
     * @param customerClass   The customer's class (1, 2, or 3).
     * @param lastPurchaseYear The year of the customer's last purchase.
     * @return The final value after the discount is applied.
     */
    private static double calculateFinalValue(double totalPurchase, int customerClass, int lastPurchaseYear) {
        double discount = 0.0; // Initialize discount amount
        int currentYear = 2024; // Set the current year for comparison

        // Determine the discount based on the customer's class and last purchase year
        switch (customerClass) {
            case 1: // Class 1 discounts
                if (lastPurchaseYear == currentYear) {
                    discount = totalPurchase * 0.30; // 30% discount for purchases made this year
                } else if (lastPurchaseYear < currentYear - 5) {
                    discount = totalPurchase * 0.10; // 10% discount if no purchase in the last 5 years
                } else {
                    discount = totalPurchase * 0.20; // 20% discount for purchases made in the last 5 years
                }
                break;
            case 2: // Class 2 discounts
                if (lastPurchaseYear == currentYear) {
                    discount = totalPurchase * 0.15; // 15% discount for purchases made this year
                } else if (lastPurchaseYear < currentYear) {
                    discount = totalPurchase * 0.13; // 13% discount for past purchases
                } else if (lastPurchaseYear < currentYear - 5) {
                    discount = totalPurchase * 0.05; // 5% discount if no purchase in the last 5 years
                }
                break;
            case 3: // Class 3 discounts
                if (lastPurchaseYear == currentYear) {
                    discount = totalPurchase * 0.03; // 3% discount for purchases made this year
                }
                break;
        }

        // Return the final value after applying the calculated discount
        return totalPurchase - discount;
    }
}




            

