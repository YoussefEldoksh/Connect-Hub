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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author malak
 */
public class FileManagement {
    
     public static ArrayList<User> loadFromJSONfile()
    {
        ArrayList<User> users = new ArrayList<>();
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
        return users;
    }
    
    public static void saveInJSONfile(ArrayList<User> users)
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
