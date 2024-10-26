/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customerdiscountapplier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CustomerDiscountApplier {

    public static void main(String[] args) {
        String inputFile = "customers.txt"; // Input file with customer data
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
            }
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

            

