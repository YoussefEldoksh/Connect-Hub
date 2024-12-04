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
public class User{
    private String userId ;
    private String email;
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private boolean status;
    private ArrayList<Friend> friends;
    private ArrayList<Friend> blockedFriends;
    private ArrayList<Friend> friendReq;
    private ArrayList<Posts> userPosts;
    private ArrayList<Stories> userStories;

    public User(String userId, String email, String username, String password, LocalDate dateOfBirth, boolean status) {
        this.email = email;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        friends = new ArrayList<>();
        blockedFriends = new ArrayList<>();
        userStories = new ArrayList<>();
        userPosts = new ArrayList<>();
    }
    
  public void addFriends(Friend friend)
    {
        friends.add(friend);
    }

    public ArrayList<Stories> getUserStories() {
        return userStories;
    }

    public ArrayList<Posts> getUserPosts() {
        return userPosts;
    }
    
    public void removeFriend(Friend friend)
    {
        friends.remove(friend);
    }
    
    
    public ArrayList<Friend> getListOfFriends()
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

    public boolean getStatus() {
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

    public void setStatus(boolean status) {
        this.status = status;
    }
    
     public void addBlockedFriends(Friend friend)
    {
        blockedFriends.add(friend);
    }
    
    public void removeBlockedFriend(Friend friend) // for unblocking
    {
        blockedFriends.remove(friend);
    }
    
    
    public ArrayList<Friend> getListOfBlockedFriends()
    {
        return blockedFriends;
    }
     public void addFriendsReq(Friend friend)
    {
        friendReq.add(friend);
    }
    
    public void removeFriendReq(Friend friend) 
    {
        friendReq.remove(friend);
    }
    
    
    public ArrayList<Friend> getListOfFriendReq()
    {
        return friendReq;
    }    
    
}
