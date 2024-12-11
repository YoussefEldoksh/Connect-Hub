/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import static backend.FriendManagement.friendSuggestion;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DatabaseMetaData;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;

/**
 *
 * @author malak
 */
public class User extends Account {
    /*private String userId ;
    private String email;
    private String username;*/
    private String password;
    private LocalDate dateOfBirth;
    private boolean status;
    private ArrayList<Friend> friends;
    private ArrayList<Friend> blockedFriends;
    private ArrayList<FriendRequests> friendReq;
    private ArrayList<User> unviewableUsers;
    private ArrayList<Posts> userPosts;
    private ArrayList<Stories> userStories;
    public String getPassword;

    public User(String userId, String email, String username, String password, LocalDate dateOfBirth, boolean status) {
        super(email,username,userId);
        setPassword(password);
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        friends = new ArrayList<>();
        blockedFriends = new ArrayList<>();
        unviewableUsers = new ArrayList<>();
        friendReq = FileManagement.loadFromFriendRequestsJsonFileForSpecificUser(userId);
        userStories = FileManagement.loadFromStroiesJsonFileForSpecificUser(userId);
        userPosts = FileManagement.loadFromPostsJsonFileForSpecificUser(userId);
    }
    
    public User(String userId, String email, String username, String password, LocalDate dateOfBirth, boolean status,String load) {
        super(email,username,userId);
        this.password=password;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        friends = new ArrayList<>();
        blockedFriends = new ArrayList<>();
        unviewableUsers = new ArrayList<>();
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

     public String getUsername() {
        return username;
    }

    /*public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

   */
    public String getPassword() {
        return password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean getStatus() {
        return status;
    }

    public void setUsername(String username){
        this.username=username;
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
           //unviewableUsers.add(AccountManagement.findUser(friend.getUsername()));
           //AccountManagement.findUser(friend.getUsername()).addUnviewableUser(this); 
           //make the blocked friend not view the user 
          // AccountManagement.findUser(friend.getUsername()).getListOfFriends().remove(new Friend(this.getEmail(),this.getUsername(),this.getUserId()));
        }
        
        
        for(FriendRequests request:friendReq){
            if(request.getUserId().equals(friend.getUserId())){
                friendReq.remove(request);
                AccountManagement.findUser(friend.getUsername()).getListOfFriendReq().remove(request); //remove friend req from the blocked user too
                return;
            }
        }
    }

     
    
    public void removeBlockedFriend(Friend friend) // for unblocking
    {
        if(blockedFriends.contains(friend)){
        unviewableUsers.remove(AccountManagement.findUser(friend.getUsername()));
        AccountManagement.findUser(friend.getUsername()).removeUnviewableUser(this);
        blockedFriends.remove(friend);
            System.out.println("Unblocked.");
            return;
        }
        System.out.println("Friend not blocked in the first place");
    }
    
    public void addUnviewableUser(User user){
        unviewableUsers.add(user);
        user.addUnviewableUser(this);
    }
    
    public void removeUnviewableUser(User user){
        unviewableUsers.remove(user);
    }
    
    public ArrayList<User> getListOfUnviewableUsers()
    {
        return unviewableUsers;
    }
    
    public ArrayList<Friend> getListOfBlockedFriends()
    {
        return blockedFriends;
    }
    
    public Friend getListOfBlockedFriends(String username){
    for (int i=0; i< getListOfBlockedFriends().size(); i++) {
            if(getListOfBlockedFriends().get(i).getUsername().equals(username)){
            return getListOfBlockedFriends().get(i);
            }
        }
        return null;
    }
    
    public ArrayList<String> getLineRepOfBlockedFriends() // fetching an array list of friends suggestions in the String format for display
    {
        ArrayList<String> blocked = new ArrayList<>();
        ArrayList<Friend> userblocked = this.blockedFriends;
        int i;
        for (i=0; i< userblocked.size(); i++) {
            blocked.add(userblocked.get(i).getUsername());
        }
        return blocked;
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
    
    public FriendRequests getFriendReq(String username) {
        for (int i = 0; i < friendReq.size(); i++) {
            if (friendReq.get(i).getUsername().equals(username))
                return this.getListOfFriendReq().get(i);
        }
        System.out.println(friendReq);
        return null;
    }
    
     public ArrayList<String> getLineRepOfFriendReq() // fetching an array list of friends suggestions in the String format for display
    {
        ArrayList<String> requests = new ArrayList<>();
        ArrayList<FriendRequests> requested = this.getListOfFriendReq();
        int i;
        for (i=0; i< requested.size(); i++) {
            requests.add(requested.get(i).getUsername());
        }
        return requests;
    }
     /*
    public void addSentRequest(FriendRequests friend){
        sentFriendReq.add(friend);
    }
    
    public void removeSentRequest(FriendRequests friend){
        sentFriendReq.remove(friend);
    }
    
     */
     
     public ArrayList<FriendRequests> getListOfSentReq()
    {
        ArrayList<FriendRequests>sent=new ArrayList<>();
        for(FriendRequests req:friendReq){
            if(req.getUserId().equals(this.getUserId())){
                sent.add(req);
            }
        }
        return sent;
    }
     
     public ArrayList<FriendRequests> getListOfReceivedReq()
    {
        ArrayList<FriendRequests>received=new ArrayList<>();
        for(FriendRequests req:friendReq){
            if(req.getReceiver().equals(this.getUserId())){
                received.add(req);
            }
        }
        return received;
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
    
    public void reload()
    {
        friendReq = FileManagement.loadFromFriendRequestsJsonFileForSpecificUser(this.getUserId());
        userStories = FileManagement.loadFromStroiesJsonFileForSpecificUser(this.getUserId());
        userPosts = FileManagement.loadFromPostsJsonFileForSpecificUser(this.getUserId());
    }
    
}
