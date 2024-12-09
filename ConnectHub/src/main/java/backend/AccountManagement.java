/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import javax.swing.JOptionPane;
import org.apache.commons.validator.routines.EmailValidator;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author malak
 */
public abstract class AccountManagement {
    
    public static int signUp(String userId, String email, String username, String password, LocalDate dateOfBirth, boolean status) //create a user
    {
        
        EmailValidator validator = EmailValidator.getInstance();
        if(!validator.isValid(email)) // check for email format
        {
            System.out.println("Invalid email format");
            return 1;
        }
        for (int i=0; i< DataBase.getInstance().getUsers().size() ; i++) // validate if the user already exists or uses a username or email that is already used
        {
            if(DataBase.getInstance().getUsers().get(i).getUsername().equals(username))
            {
                System.out.println("User Already exists");
                return 2;
            }
            if(DataBase.getInstance().getUsers().get(i).getEmail().equals(email))
            {
                System.out.println("Email Already used");
                return  3;
            }
            
        }
        
        
        User user = new User(userId, email, username, password, dateOfBirth, status);// created a new user
        Profile userProfile = new Profile(null, null, "", user); // create a profile for this user
        DataBase.getInstance().addUser(user); //adding a new user to our data base
        DataBase.getInstance().addProfile(userProfile);
        //here I'll add the user to the json file before I return that it was successfully added
        
        FileManagement.saveInUsersJSONfile();
        return 4; //returned the new user for use

    }
    
    public static User signIn(String username, String password) {
        for (int i = 0; i < DataBase.getInstance().getUsers().size(); i++) {
            if ((DataBase.getInstance().getUsers().get(i).getUsername().equals(username) || DataBase.getInstance().getUsers().get(i).getEmail().equals(username)) && (DataBase.getInstance().getUsers().get(i).getPassword().equals(hashPassword(password)))) //check if the user is in our database
            {
                DataBase.getInstance().getUsers().get(i).setStatus(true);
                FileManagement.saveInUsersJSONfile();
                return DataBase.getInstance().getUsers().get(i);
            }
     
        }
        return null;
    }
    
    public static User findUser(String username) {
        for (int i = 0; i < DataBase.getInstance().getUsers().size(); i++) {
            if (DataBase.getInstance().getUsers().get(i).getUsername().equals(username)) {
                System.out.println("User found");
                return DataBase.getInstance().getUsers().get(i);
            }
        }
        return null;
    }
    
    public static String findUsername(String userId) {
        for (int i = 0; i < DataBase.getInstance().getUsers().size(); i++) {
            if (DataBase.getInstance().getUsers().get(i).getUserId().equals(userId)) {
                System.out.println("User found");
                return DataBase.getInstance().getUsers().get(i).getUsername();
            }
        }
        return null;
    }
    public static void signOut(User user)
    {
        user.setStatus(false);
        //save eveything in its file
        FileManagement.saveInUsersJSONfile();
        FileManagement.saveToFriendRequestsJsonFile();
        FileManagement.saveToPostsJsonFile();
        FileManagement.saveToStoriesJsonFile();
        FileManagement.saveToProfilesJsonFile();
        System.exit(0);
    }
    
    public static String hashPassword(String password) {
        
        if (password == null || password.isEmpty()) {
             throw new IllegalArgumentException("Password cannot be null or empty.");
        }

        try {
               MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hashedBytes);
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException("SHA-256 algorithm not available.", e);
    }
}

}
