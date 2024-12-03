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
    
    
    public User signUp(String userId, String email, String username, String password, LocalDate dateOfBirth, boolean status,ArrayList<User> users) //create a user
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
        saveInJSONfile(users);
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
    
    
    public void loadFromJSONfile(ArrayList<User> users)
    {
        try{
            
            if (!Files.exists(Paths.get("users.json"))) {
                    Files.createFile(Paths.get("users.json")); // create the file if not found
                }
            String json = new String(Files.readAllBytes(Paths.get("users.json")));
            JSONArray usersArray = new JSONArray(json);
            
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
            
            for (int i = 0; i < usersArray.length(); i++) {
                
                JSONObject userJson = usersArray.getJSONObject(i);
                String email = userJson.getString("email");
                String id = userJson.getString("userId");
                String username = userJson.getString("username");
                LocalDate date = LocalDate.parse(userJson.getString("dob"));
                String password = userJson.getString("password");
                boolean status = userJson.getBoolean("status");
                User user = new User(id, email, username, password, date, status);
                JSONArray friends = userJson.getJSONArray("friends");
                
                for (int j = 0; j < friends.length(); j++) 
                {
                    JSONObject friend = friends.getJSONObject(j);
                    String friendEmail = friend.getString("email");
                    String friendId = friend.getString("userId");
                    String friendUsername = friend.getString("username");
                    user.addFriends(new Friend(friendEmail, friendId, friendUsername));
                    
                }
                
                
                users.add(user);
            }
        } catch (IOException ex) {
             System.err.println("Error loading users from JSON file: " + ex.getMessage());
        }
    }
    
    public void saveInJSONfile(ArrayList<User> users)
    {
       
        try{
            JSONArray jsonUsersArray = new JSONArray();
            for (User user : users) {
                JSONObject jsonUser = new JSONObject();
                
                jsonUser.put("userId", user.getUserId());
                jsonUser.put("email", user.getEmail());
                jsonUser.put("username", user.getUsername());
                jsonUser.put("dob", user.getDateOfBirth().format(DateTimeFormatter.ISO_DATE));
                jsonUser.put("password", user.getPassword());
                jsonUser.put("status", user.getStatus());
                
                JSONArray friends = new JSONArray();
                
                for (Friend friend : user.getListOfFriends()) {
                    JSONObject jsonFriend = new JSONObject();
                    jsonFriend.put("userId", friend.getUserId());
                    jsonFriend.put("email", friend.getEmail());
                    jsonFriend.put("username", friend.getUsername());
                    
                    friends.put(jsonFriend);
                }
                jsonUser.put("friends", friends);
                jsonUsersArray.put(jsonUser);
            }
        Files.write(Paths.get("users.json"), jsonUsersArray.toString(4).getBytes());
        
            System.out.println("System successfully saved the users");
        } catch (IOException ex) {
             System.err.println("Error saving users from JSON file: " + ex.getMessage());
            }
    }
}
