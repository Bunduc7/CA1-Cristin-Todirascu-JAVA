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

