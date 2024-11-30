/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author malak
 */
public class User {
    private String userId ;
    private String email;
    private String username;
    private String password;
    private String dateOfBirth;
    private String status;
    private ArrayList<User> friends;
    
    public User(String userId, String email, String username, String password, String dateOfBirth, String status) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        friends = new ArrayList<>();
    }
    
    
    
    public void addFriends(User friend)
    {
        friends.add(friend);
    }
    
    public void removeFriend(User friend)
    {
        friends.remove(friend);
    }
    
    
    public ArrayList<User> getListOfFriends()
    {
        return friends;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
