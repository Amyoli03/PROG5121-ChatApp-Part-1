/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppart1;

/**
 *
 * @author Student
 */
public class Login {
    
  //Declare variables that are going to be used by the user  
    
  String username;  
  String password;
  String phoneNumber;
          
 // user name validation
 public boolean checkUserName(String username){
     return username.contains("_") && username.length() <= 5;
 }
 
//Password Validation
public boolean checkPasswordComplexity(String password){
    
    boolean hasUpper = !password.equals(password.toLowerCase());
    boolean hasDigit = password.matches(".*\\d.*");
    boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{}';\"\\\\|,.<>\\/?].*");
    boolean longEnough = password.length() >= 8;
    return hasUpper && hasDigit && hasSpecial && longEnough;
}

public boolean checkCellPhoneNumber(String phoneNumber) {
    return phoneNumber.matches("\\+27\\d{9}") && phoneNumber.length() == 12;
}

//register validation
public String registerUser(String username, String password,String phoneNumber){
    
    if(!checkUserName(username)){ 
        return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
    }
    
    if(!checkPasswordComplexity(password)){
        return "Password is not correctly formatted, please ensure that the password contains atleast 8 characters, a capital letter, a number and a special character.";
    }
    if (!checkCellPhoneNumber(phoneNumber)) {
        return "Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
    }
    
    this.username= username;
    this.password= password;
    this.phoneNumber= phoneNumber;
    
    return "Username registered successfully.";
    }

//Login Feature
public boolean loginUser(String enteredUsername, String enteredPassword){
    if (this.username == null || this.password == null) {
        return false;
    }
    return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
}

//Return Login feature - CORRECT SIGNATURE
public String returnLoginStatus(String enteredUsername, String enteredPassword) {
    if (loginUser (enteredUsername, enteredPassword)) {
        return "Welcome " + enteredUsername + " it is great to see you again.";
    } else {
        return "Username or password incorrect, please try again.";
    }
  }
}

