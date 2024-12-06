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
    private ArrayList<FriendRequests> friendReq;
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
        friendReq = FileManagement.loadFromFriendRequestsJsonFileForSpecificUser(userId);
        userStories = FileManagement.loadFromStroiesJsonFileForSpecificUser(userId);
        userPosts = FileManagement.loadFromPostsJsonFileForSpecificUser(userId);
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
        if(friends.contains(friend)){
            friends.remove(friend);
        }
        
        
        for(FriendRequests request:friendReq){
            if(request.getUserId().equals(friend.getUserId())){
                friendReq.remove(request);
                return;
            }
        }
    }
    
    public void removeBlockedFriend(Friend friend) // for unblocking
    {
        blockedFriends.remove(friend);
    }
    
    
    public ArrayList<Friend> getListOfBlockedFriends()
    {
        return blockedFriends;
    }
     public void addFriendsReq(FriendRequests friend)
    {
        friendReq.add(friend);
    }
    
    public void removeFriendReq(FriendRequests friend) 
    {
        friendReq.remove(friend);
    }
    
    
    public ArrayList<FriendRequests> getListOfFriendReq()
    {
        return friendReq;
    }    
    
    public void addPost(Posts post)
    {
        this.userPosts.add(post);
    }
    public void addStory(Stories story)
    {
        this.userStories.add(story);
    }
    public void removePost(Posts post)
    {
        this.userPosts.remove(post);
    }
    public void removeStory(Stories story)
    {
        this.userStories.remove(story);
    }
}
