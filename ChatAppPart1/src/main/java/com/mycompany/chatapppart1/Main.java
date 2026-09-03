/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppart1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
       
        // 1. REGISTRATION
        System.out.println("=== REGISTRATION ===");
       
        System.out.print("Enter username (must contain _ and be smaller or equal to 5 characters): ");
        String username = scanner.nextLine();
       
        System.out.print("Enter password (8+ characters, capital, number, special chararacter): ");
        String password = scanner.nextLine();
       
        System.out.print("Enter SA cellphone number (e.g +27831234567): ");
        String phone = scanner.nextLine();

        String regMessage = login.registerUser(username, password, phone);
        System.out.println(regMessage);
       
        // Stop if registration failed - this is required by POE
        if(!regMessage.equals("User has been registered successfully.")){
            scanner.close();
            return;
        }

        System.out.println("\n=== LOGIN ===");
        // 2. LOGIN
        System.out.print("LOGIN - Enter username: ");
        String loginUsername = scanner.nextLine();
       
        System.out.print("LOGIN - Enter password: ");
        String loginPassword = scanner.nextLine();

        // This calls your Login class
        String loginStatus = login.returnLoginStatus(loginUsername, loginPassword);
        System.out.println(loginStatus);
       
        scanner.close();
    }
}