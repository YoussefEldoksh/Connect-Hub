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
    
    
    ArrayList<User> users = FileManagement.loadFromJSONfile();
    
    public User signUp(String userId, String email, String username, String password, LocalDate dateOfBirth, boolean status) //create a user
    {
        EmailValidator validator = EmailValidator.getInstance();
        if(!validator.isValid(email)) // check for email format
        {
            System.out.println("Invalid email format");
            return null;
        }
        for (User user : users) // validate if the user already exists or uses a username or email that is already used
        {
            if(user.getUserId().equals(userId))
            {
                System.out.println("User Already exists");
                return null;
            }
            if(user.getEmail().equals(email))
            {
                System.out.println("Email Already used");
                return  null;
            }
            
        }
        
        

        User user = new User(userId, email, username, password, dateOfBirth, status);// created a new user
        users.add(user); //adding a new user to our data base
        //here I'll add the user to the json file before I return the user
        FileManagement.saveInJSONfile(users);
        return user; //returned the new user for use
    }
    
    public boolean signIn(User user, ArrayList<User> users)
    {
        if(users.contains(user)) //check if the user is in our database
        {
            int index = users.indexOf(user);  // get indix of that user to compare
            if(index == -1)
            {
                return false;
            }
            
            if((user.getUsername().equals(users.get(index).getUsername()) || user.getEmail().equals(users.get(index).getEmail())) && user.getPassword().equals(users.get(index).getPassword()))
            {
                System.out.println("User varified");
                return true;
            }
        }
        return false;
    }
    
    
    public void signOut(User user)
    {
        user.setStatus(false);
    }
    
    

}
