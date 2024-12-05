    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author malak
 */
public class FileManagement {
    
     public static ArrayList<User> loadFromUsersJSONfile()
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
    
    public static void saveInUsersJSONfile(ArrayList<User> users)
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
    
    
    public static void saveToFriendRequestsJsonFile(User user)
    {
        try{
            JSONArray jsonFriendsArray = new JSONArray();
            for (Friend friend : user.getListOfFriendReq()) {
                JSONObject jsonFriend = new JSONObject();
                
                jsonFriend.put("senderid", friend.getUserId());
                jsonFriend.put("email", friend.getEmail());
                jsonFriend.put("username", friend.getUsername());
                jsonFriend.put("receiver", user.getUserId());// add the reciever id as a tag 
                jsonFriendsArray.put(jsonFriend);
            }
        Files.write(Paths.get("friendrequests.json"), jsonFriendsArray.toString(4).getBytes());
        
            System.out.println("System successfully saved the friendrequests");
        } catch (IOException ex) {
             System.err.println("Error saving friend requests from JSON file: " + ex.getMessage());
            }
    }
    public static ArrayList<Friend> loadFromFriendRequestsJsonFile(User user)
    {
    
        ArrayList<Friend> friendRequests = new ArrayList<>();
        try{
            
            if (!Files.exists(Paths.get("friendrequests.json"))) {
                    Files.createFile(Paths.get("friendrequests.json")); // create the file if not found
                }
            String json = new String(Files.readAllBytes(Paths.get("friendrequests.json")));
            JSONArray friendRequestsJson = new JSONArray(json);
            
            for (int i = 0; i < friendRequestsJson.length(); i++) {
                
                JSONObject userJson = friendRequestsJson.getJSONObject(i);
                String email = userJson.getString("email");
                String id = userJson.getString("senderid");
                String username = userJson.getString("username");
                String receiverId = userJson.getString("receiver");
                
                if(receiverId.equals(user.getUserId())) // add friend request if it's for the user in question
                {
                    friendRequests.add(new Friend(email, username, username));
                }
            }
        } catch (IOException ex) {
             System.err.println("Error loading friend requests from JSON file: " + ex.getMessage());
        }
        return friendRequests;
       }
    
    
    public static ArrayList<Posts> loadFromPostsJsonFile(User user)
    {
        ArrayList<Posts> posts = new ArrayList<>();
        
        try{
            if (!Files.exists(Paths.get("posts.json"))) {
                    Files.createFile(Paths.get("posts.json")); // create the file if not found
                }
            String json = new String(Files.readAllBytes(Paths.get("posts.json")));
            
            JSONArray jsonPosts = new JSONArray(json);
            
            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject jsonPost = jsonPosts.getJSONObject(i);
                String userId = jsonPost.getString("userid");
                if(!userId.equals(user.getUserId()))
                {
                    continue;
                }
                String contentId = jsonPost.getString("contentid");
                String content = jsonPost.getString("content");
                String time = jsonPost.getString("timestamp");
                LocalDateTime date = LocalDateTime.parse(time);
                String photoPath = jsonPost.getString("photo");
              // posts.add(new Posts(contentId, userId, content, date));// adding a new post to the array
            }

            
        }catch (IOException ex) {
             System.err.println("Error loading posts from JSON file: " + ex.getMessage());
        }
      
        return posts;
    }
    
    public static void saveToPostsJsonFile(User user)
    {
        try{
            JSONArray Posts = new JSONArray();
            
            for (int i = 0; i < user.getUserPosts().size(); i++) {
                JSONObject post = new JSONObject();
                post.put("userid", user.getUserPosts().get(i).getAuthorID());
                post.put("contentid", user.getUserPosts().get(i).getContentID());
                post.put("content", user.getUserPosts().get(i).getContent());
                post.put("photo", user.getUserPosts().get(i).getImagePath());
                post.put("timestamp", user.getUserPosts().get(i).getTimestamp());
                
                Posts.put(post);
                
            }
           Files.write(Paths.get("posts.json"), Posts.toString(4).getBytes());
            System.out.println("System successfully saved the friendrequests");
            
        }catch (IOException ex) {
             System.err.println("Error saving posts to JSON file: " + ex.getMessage());
        }
    }
    
    
    public static ArrayList<Stories> loadFromStroiesJsonFile(User user)
    {
        ArrayList<Stories> stories = new ArrayList<>();
        
        try {
             if (!Files.exists(Paths.get("posts.json"))) {
                    Files.createFile(Paths.get("posts.json")); // create the file if not found
                }
            String json = new String(Files.readAllBytes(Paths.get("posts.json")));
            
            JSONArray jsonPosts = new JSONArray(json);
            
            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject jsonPost = jsonPosts.getJSONObject(i);
                String userId = jsonPost.getString("userid");
                if(!userId.equals(user.getUserId()))
                {
                    continue;
                }
                String contentId = jsonPost.getString("contentid");
                String content = jsonPost.getString("content");
                String time = jsonPost.getString("timestamp");
                LocalDateTime date = LocalDateTime.parse(time);
                String photoPath = jsonPost.getString("photo");
               //stories.add(new Stories(contentId, userId, content, date));// adding a new story to the array
            
        }
        } catch (IOException e) {
            System.err.println("Error loading stories from JSON file: " + e.getMessage());
        }
        return stories;
    }
    public static void saveToStoriesJsonFile(User user)
    {
        try{
            JSONArray Posts = new JSONArray();
            
            for (int i = 0; i < user.getUserPosts().size(); i++) {
                JSONObject post = new JSONObject();
                post.put("userid", user.getUserPosts().get(i).getAuthorID());
                post.put("contentid", user.getUserPosts().get(i).getContentID());
                post.put("content", user.getUserPosts().get(i).getContent());
                post.put("photo", user.getUserPosts().get(i).getImage());
                post.put("timestamp", user.getUserPosts().get(i).getTimestamp());
                
                Posts.put(post);
                
            }
           Files.write(Paths.get("posts.json"), Posts.toString(4).getBytes());
            System.out.println("System successfully saved the friendrequests");
            
        }catch (IOException ex) {
             System.err.println("Error saving posts to JSON file: " + ex.getMessage());
        }
    }
    
    
}
