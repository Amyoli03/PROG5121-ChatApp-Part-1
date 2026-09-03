/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Student
 */
public class LoginTest {
    
    Login login = new Login();
    
    @Test
    public void testCheckUsernameCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }
    
     @Test
    public void testCheckUsernameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

 @Test
    public void testChecPasswordComplexityMeetsRequirements() {
        assertTrue(login.checkPasswordComplexity("Ch&&secke99!"));
    }
    
 @Test
    public void testCheckPasswordComplexityDoesNotMeetRequirements() {
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
@Test
    public void testCheckCellPhoneNumberCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27831234567"));
    }
    
@Test
    public void testCheckCellPhoneNumberIncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
    
@Test
   public void testLoginUserSuccessful() {
       login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567");
       assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
   }
   
@Test
   public void testLoginUserFailed() {
       login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567");
       assertFalse(login.loginUser("kyl_1", "wrongPass"));
    }
   
@Test
   public void testReturnLoginStatusSuccess() {
       login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567");
       String expected = "Welcome kyl_1 it is great to see you again.";
       assertEquals(expected, login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!"));
   }
   
@Test
   public void testReturnLoginStatusFailed() {
       login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27831234567");
       String expected = "Username or password incorrect, please try again.";
       assertEquals(expected, login.returnLoginStatus("kyl_1", "wrong"));
   }
}