/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.commons.validator.routines.EmailValidator;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author malak
 */
public class AccountManagement {
    
    
    ArrayList<User> users = FileManagement.loadFromUsersJSONfile();
    
    public int signUp(String userId, String email, String username, String password, LocalDate dateOfBirth, boolean status) //create a user
    {
        EmailValidator validator = EmailValidator.getInstance();
        if(!validator.isValid(email)) // check for email format
        {
            System.out.println("Invalid email format");
            return 1;
        }
        for (int i=0; i< users.size() ; i++) // validate if the user already exists or uses a username or email that is already used
        {
            if(users.get(i).getUserId().equals(userId))
            {
                System.out.println("User Already exists");
                return 2;
            }
            if(users.get(i).getEmail().equals(email))
            {
                System.out.println("Email Already used");
                return  3;
            }
            
        }
        User user = new User(userId, email, username, password, dateOfBirth, status);// created a new user
        users.add(user); //adding a new user to our data base
        //here I'll add the user to the json file before I return that it was successfully added
       // FileManagement.saveInJSONfile(users);
        return 4; //returned the new user for use

   
    }
    
    public User signIn(String unOrem, String password) {
        for (int i = 0; i < users.size(); i++) {
            if ((users.get(i).getUsername().equals(unOrem) || users.get(i).getEmail().equals(unOrem)) && (users.get(i).getPassword().equals(password))) //check if the user is in our database
            {
                return users.get(i);
            }
     
        }
        return null;
    }
    
    public User findUser(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                System.out.println("User found");
                return users.get(i);
            }
        }
        return null;
    }
    
    public void signOut(User user)
    {
        user.setStatus(false);
    }
    
    

}
