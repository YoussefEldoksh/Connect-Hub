/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;

/**
 *
 * @author malak
 */
public class User {
    private String userId ;
    private String email;
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private String status;
    private ArrayList<User> friends;
    
    public User(String userId, String email, String username, String password, LocalDate dateOfBirth, String status) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.setPassword(password);
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password){
        MessageDigest md;
        try{
            md=MessageDigest.getInstance("SHA-256");
        }
        catch(NoSuchAlgorithmException e){
            System.out.println("No Such Algorithm.");
            return;
        }
        byte[] hashedBytes=md.digest(password.getBytes());
        this.password=Base64.getEncoder().encodeToString(hashedBytes);
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
