    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.User;
import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author malak
 */
public class FileManagement { // Centrlized file operations system
    
     public static ArrayList<User> loadFromUsersJSONfile()
    {
        ArrayList<User> users = new ArrayList<>();
        try{
            
             if (!Files.exists(Paths.get("users.json")) || Files.size(Paths.get("users.json")) == 0) {
                    Files.createFile(Paths.get("users.json")); // create the file if not found
                    return new ArrayList<>();
                }
            String json = new String(Files.readAllBytes(Paths.get("users.json")));
            JSONArray usersArray = new JSONArray(json);
            
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
            
            for (int i = 0; i < usersArray.length(); i++) {
                
                JSONObject userJson = usersArray.getJSONObject(i);
                String email = userJson.getString("email");
                String id = userJson.getString("userId");
                String username = userJson.getString("username");
                LocalDate date = LocalDate.parse(userJson.getString("dob"),formatter);
                String password = userJson.getString("password");
                boolean status = userJson.getBoolean("status");
                User user = new User(id, email, username, password, date, status,"load");
                
                JSONArray friends = userJson.getJSONArray("friends");
                
                for (int j = 0; j < friends.length(); j++) 
                {
                    JSONObject friend = friends.getJSONObject(j);
                    String friendEmail = friend.getString("email");
                    String friendId = friend.getString("userId");
                    String friendUsername = friend.getString("username");
                    user.addFriends(new Friend(friendEmail, friendId, friendUsername));
                    
                }
                
                JSONArray blockedFriends = userJson.getJSONArray("blockedfriends");
                  for (int j = 0; j < blockedFriends.length(); j++) 
                {
                    JSONObject friend = blockedFriends.getJSONObject(j);
                    String friendEmail = friend.getString("email");
                    String friendId = friend.getString("userId");
                    String friendUsername = friend.getString("username");
                    user.addBlockedFriends(new Friend(friendEmail, friendId, friendUsername));
                    
                }
                
                            users.add(user);
            }
        } catch (IOException ex) {
            System.err.println("Error loading users from JSON file: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Error parsing JSON: " + ex.getMessage());
            ex.printStackTrace();
        }
        return users;
    }
    
    public static void saveInUsersJSONfile()
    {
       ArrayList<User> users = DataBase.getInstance().getUsers();
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
                
                JSONArray blockedfriends = new JSONArray();
                
                for (Friend blockedfriend : user.getListOfBlockedFriends()) {
                     JSONObject jsonBlockedFriend = new JSONObject();
                    jsonBlockedFriend.put("userId", blockedfriend.getUserId());
                    jsonBlockedFriend.put("email", blockedfriend.getEmail());
                    jsonBlockedFriend.put("username", blockedfriend.getUsername());
                    
                    blockedfriends.put(jsonBlockedFriend);
                }
                
                jsonUser.put("friends", friends);
                jsonUser.put("blockedfriends", blockedfriends);
                jsonUsersArray.put(jsonUser);
            }
        Files.write(Paths.get("users.json"), jsonUsersArray.toString(4).getBytes());
        
            System.out.println("System successfully saved the users");
        } catch (IOException ex) {
             System.err.println("Error saving users from JSON file: " + ex.getMessage());
            }
    }
    
    
    public static void saveToFriendRequestsJsonFile()
    {
        ArrayList<FriendRequests> requests = DataBase.getInstance().getGlobalFriendRequests();
        try{
            JSONArray jsonFriendsArray = new JSONArray();
            for (FriendRequests request : requests) {
                JSONObject jsonFriend = new JSONObject();
                
                jsonFriend.put("senderid", request.getUserId());
                jsonFriend.put("email", request.getEmail());
                jsonFriend.put("username", request.getUsername());
                jsonFriend.put("receiver", request.getReceiver());// add the reciever id as a tag 
                jsonFriendsArray.put(jsonFriend);
            }
        Files.write(Paths.get("friendrequests.json"), jsonFriendsArray.toString(4).getBytes());
        
            System.out.println("System successfully saved the friendrequests");
        } catch (IOException ex) {
             System.err.println("Error saving friend requests from JSON file: " + ex.getMessage());
            }
    }
    public static ArrayList<FriendRequests> loadFromFriendRequestsJsonFileForSpecificUser(String userId)
    {
    
        ArrayList<FriendRequests> friendRequests = new ArrayList<>();
        try{
            
            if (!Files.exists(Paths.get("friendrequests.json")) ||  Files.size(Paths.get("friendrequests.json")) == 0) {
                    Files.createFile(Paths.get("friendrequests.json")); // create the file if not found
                    return friendRequests;
                }
            String json = new String(Files.readAllBytes(Paths.get("friendrequests.json")));
            JSONArray friendRequestsJson = new JSONArray(json);
            
            for (int i = 0; i < friendRequestsJson.length(); i++) {
                
                JSONObject userJson = friendRequestsJson.getJSONObject(i);
                String email = userJson.getString("email");
                String id = userJson.getString("senderid");
                String username = userJson.getString("username");
                String receiverId = userJson.getString("receiver");
                
                if(receiverId.equals(userId)) // add friend request as a receiver
                {

                    friendRequests.add(new FriendRequests(email, username, id, receiverId));

                }
                
            }
        } catch (IOException ex) {
             System.err.println("Error loading friend requests from JSON file: " + ex.getMessage());
        }
        return friendRequests;
       }
    
    
    
    public static ArrayList<FriendRequests> loadFromFriendRequestsJsonFile()
    {
    
        ArrayList<FriendRequests> friendRequests = new ArrayList<>();
        try{
            

            if (!Files.exists(Paths.get("friendrequests.json")) || Files.size(Paths.get("friendrequests.json")) == 0) {
                    Files.createFile(Paths.get("friendrequests.json")); // create the file if not found
                    return friendRequests;

            }

                    
                

            String json = new String(Files.readAllBytes(Paths.get("friendrequests.json")));
            JSONArray friendRequestsJson = new JSONArray(json);
            
            for (int i = 0; i < friendRequestsJson.length(); i++) {
                
                JSONObject userJson = friendRequestsJson.getJSONObject(i);
                String email = userJson.getString("email");
                String id = userJson.getString("senderid");
                String username = userJson.getString("username");
                String receiverId = userJson.getString("receiver");
                
                friendRequests.add(new FriendRequests(email, username, id, receiverId));
          
            }
        } catch (IOException ex) {
             System.err.println("Error loading friend requests from JSON file: " + ex.getMessage());
        }
        return friendRequests;
       }
    
    
    
    
    
    
    public static ArrayList<Posts> loadFromPostsJsonFileForSpecificUser(String id)
    {
        ArrayList<Posts> posts = new ArrayList<>();
        
        try{
            if (!Files.exists(Paths.get("posts.json")) || Files.size(Paths.get("posts.json")) == 0) {
                    Files.createFile(Paths.get("posts.json")); // create the file if not found
                    return posts;
                }
            String json = new String(Files.readAllBytes(Paths.get("posts.json")));
            
            JSONArray jsonPosts = new JSONArray(json);
            
            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject jsonPost = jsonPosts.getJSONObject(i);
                String userId = jsonPost.getString("userid");
                if(!userId.equals(id))
                {
                    continue;
                }
                String contentId = jsonPost.getString("contentid");
                String content = jsonPost.getString("content");
                String time = jsonPost.getString("timestamp");
                LocalDateTime date = LocalDateTime.parse(time);

                String photoPath = jsonPost.optString("photopath");
                
                
                ImageIcon image = null;
                if (photoPath != null && Files.exists(Paths.get(photoPath))) {
                  image = new ImageIcon(photoPath);
                } else {
                   System.err.println("Image not found for path: " + photoPath);
                }
                
                
               Posts post=new Posts(contentId, userId, content, image, photoPath);
                post.setTimestamp(date);
               posts.add(post);// adding a new post to the array
            }

            
        }catch (IOException ex) {
             System.err.println("Error loading posts from JSON file: " + ex.getMessage());
        }
      
        return posts;
    }
        public static ArrayList<Posts> loadFromPostsJsonFile()
    {
        ArrayList<Posts> posts = new ArrayList<>();
        
        try{

            if (!Files.exists(Paths.get("posts.json")) || Files.size(Paths.get("posts.json")) == 0) {
                    Files.createFile(Paths.get("posts.json")); // create the file if not found
                    return posts;
            }

  

            String json = new String(Files.readAllBytes(Paths.get("posts.json")));
            
            JSONArray jsonPosts = new JSONArray(json);
            
            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject jsonPost = jsonPosts.getJSONObject(i);
                String userId = jsonPost.getString("userid");
                String contentId = jsonPost.getString("contentid");
                String content = jsonPost.getString("content");
                String time = jsonPost.getString("timestamp");
                LocalDateTime date = LocalDateTime.parse(time);
                String photoPath = jsonPost.optString("photopath");
                
                
                ImageIcon image = null;
                if (photoPath != null && Files.exists(Paths.get(photoPath))) {
                  image = new ImageIcon(photoPath);
                } else {
                   System.err.println("Image not found for path: " + photoPath);
                }
                
                Posts post=new Posts(contentId, userId, content, image, photoPath);
                post.setTimestamp(date);//setting the date to the actual one saved in file
               posts.add(post);// adding a new post to the array

            }

            
        }catch (IOException ex) {
             System.err.println("Error loading posts from JSON file: " + ex.getMessage());
        }
      
        return posts;
    }
    
    
    
    
    public static void saveToPostsJsonFile()
    {
        ArrayList<Posts> posts = DataBase.getInstance().getGlobalPosts();
        try{
            JSONArray Posts = new JSONArray();
            
            for (int i = 0; i < posts.size(); i++) {
                JSONObject post = new JSONObject();

                post.put("userid", posts.get(i).getAuthorID());
                post.put("contentid", posts.get(i).getContentID());
                post.put("content", posts.get(i).getContent());
                post.put("photopath", posts.get(i).getImagePath());
                post.put("timestamp", posts.get(i).getTimestamp());

                
                Posts.put(post);
                
            }
           Files.write(Paths.get("posts.json"), Posts.toString(4).getBytes());
            System.out.println("System successfully saved the friendrequests");
            
        }catch (IOException ex) {
             System.err.println("Error saving posts to JSON file: " + ex.getMessage());
        }
    }
    
    
    public static ArrayList<Stories> loadFromStroiesJsonFileForSpecificUser(String id)
    {
        ArrayList<Stories> stories = new ArrayList<>();
        
        try {
             if (!Files.exists(Paths.get("stories.json")) || Files.size(Paths.get("stories.json")) == 0) {
                    Files.createFile(Paths.get("stories.json")); // create the file if not found
                    return stories;
                }
            String json = new String(Files.readAllBytes(Paths.get("stories.json")));
            
            JSONArray jsonPosts = new JSONArray(json);
            
            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject jsonPost = jsonPosts.getJSONObject(i);
                String userId = jsonPost.getString("userid");
                if(!userId.equals(id))
                {
                    continue;
                }
                String contentId = jsonPost.getString("contentid");
                String content = jsonPost.getString("content");
                String time = jsonPost.getString("timestamp");
                LocalDateTime date = LocalDateTime.parse(time);
                String photoPath = jsonPost.optString("photopath",null);
                ImageIcon image = null;
            if (photoPath != null && Files.exists(Paths.get(photoPath))) {
                image = new ImageIcon(photoPath);
            } else {
                System.err.println("Image not found for path: " + photoPath);
            }
               
            Stories story=new Stories(contentId, userId, content, image, photoPath);
                story.setTimestamp(date);//because constructor doesn't set the date saved in the file
               if(!Stories.isExpiredStory(story)){
                    stories.add(story);
               }
               
        }
        } catch (IOException e) {
            System.err.println("Error loading stories from JSON file: " + e.getMessage());
        }
        return stories;
    }
    
        public static ArrayList<Stories> loadFromStroiesJsonFile()
    {
        ArrayList<Stories> stories = new ArrayList<>();
        
        try {

             if (!Files.exists(Paths.get("stories.json")) || Files.size(Paths.get("stories.json")) == 0) {
                    Files.createFile(Paths.get("stories.json")); // create the file if not found
                    return stories;
                }
            String json = new String(Files.readAllBytes(Paths.get("stories.json")));



            JSONArray jsonPosts = new JSONArray(json);
            
            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject jsonPost = jsonPosts.getJSONObject(i);
                String userId = jsonPost.getString("userid");
                String contentId = jsonPost.getString("contentid");
                String content = jsonPost.getString("content");
                String time = jsonPost.getString("timestamp");
                LocalDateTime date = LocalDateTime.parse(time,DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                String photoPath = jsonPost.optString("photopath",null);
                ImageIcon image = null;
            if (photoPath != null && Files.exists(Paths.get(photoPath))) {
                image = new ImageIcon(photoPath);
            } else {
                System.err.println("Image not found for path: " + photoPath);
            }
                Stories story=new Stories(contentId, userId, content, image, photoPath);
                story.setTimestamp(date);//because constructor doesn't set the date saved in the file
               if(!Stories.isExpiredStory(story)){
                    stories.add(story);
               }
        }
        } catch (IOException e) {
            System.err.println("Error loading stories from JSON file: " + e.getMessage());
        }
        return stories;
    }
    
    public static void saveToStoriesJsonFile()
    {       
        ArrayList<Stories> stories = DataBase.getInstance().getGlobalStories();
        
        try{
            JSONArray Stories = new JSONArray();
            
            for (int i = 0; i < stories.size(); i++) {
                JSONObject story = new JSONObject();
                story.put("userid", stories.get(i).getAuthorID());
                story.put("contentid", stories.get(i).getContentID());
                story.put("content", stories.get(i).getContent());
                story.put("photopath", stories.get(i).getImagePath());
                story.put("timestamp", stories.get(i).getTimestamp());
                
                Stories.put(story);
                
            }
           Files.write(Paths.get("stories.json"), Stories.toString(4).getBytes());
            System.out.println("System successfully saved the stories");
            
        }catch (IOException ex) {
             System.err.println("Error saving stories to JSON file: " + ex.getMessage());
        }
    }
    
   /* public static ArrayList<Profiles> loadFromProfilesJsonFileForSpecificUser(String id)
    {
        ArrayList<Profile> profiles = new ArrayList<>();
        
        try {
             if (!Files.exists(Paths.get("profiles.json")) || Files.size(Paths.get("profiles.json")) == 0) {
                    Files.createFile(Paths.get("posts.json")); // create the file if not found
                    return profiles;
                }
            String json = new String(Files.readAllBytes(Paths.get("profiles.json")));
            
            JSONArray jsonProfiles = new JSONArray(json);
            
            for (int i = 0; i < jsonProfiles.length(); i++) {
                JSONObject jsonProfile = jsonProfiles.getJSONObject(i);
                String userId = jsonProfile.getString("userid");
                if(!userId.equals(id))
                {
                    continue;
                }
                String cover = jsonProfile.optString("cover",null);
                String profilePic = jsonProfile.optString("profile pic",null);
                String bio = jsonProfile.getString("bio");
                
            if (cover != null && Files.exists(Paths.get(cover)) && profilePic != null && Files.exists(Paths.get(profilePic))) {
                image = new ImageIcon(photoPath);
            } else {
                System.err.println("Image not found for path: " + photoPath);
            }
            User user1=null;
               for(User user:DataBase.getUsers()){
                   if(user.getUserId().equals(userId)){
                       user1=user;
                       break;
                   }
               }
               if(user1==null){
                   System.out.println("User not found");
                   continue;
               }
            Profile profile=new Profile(cover, profilePic, bio, user1);
            profiles.add(profile);
               
        }
        } catch (IOException e) {
            System.err.println("Error loading profiles from JSON file: " + e.getMessage());
        }
        return profiles;
    }*/
    
        public static ArrayList<Profile> loadFromProfilesJsonFile()
    {
        ArrayList<Profile> profiles = new ArrayList<>();
        ArrayList<User> users = loadFromUsersJSONfile();
        try {

             if (!Files.exists(Paths.get("profiles.json")) || Files.size(Paths.get("profiles.json")) == 0) {
                    Files.createFile(Paths.get("profiles.json")); // create the file if not found
                    return profiles;
                }
            String json = new String(Files.readAllBytes(Paths.get("profiles.json")));



            JSONArray jsonProfiles = new JSONArray(json);
            
            for (int i = 0; i < jsonProfiles.length(); i++) {
                JSONObject jsonProfile = jsonProfiles.getJSONObject(i);
                String userId = jsonProfile.getString("userid");
                String cover = jsonProfile.optString("cover",null);
                String profilePic = jsonProfile.optString("profile pic",null);
                String bio = jsonProfile.getString("bio");
                User user1=null;
               for(User user:users){
                   if(user.getUserId().equals(userId)){
                       user1=user;
                       break;
                   }
               }
               if(user1==null){
                   System.out.println("User not found");
                   continue;
               }
            Profile profile=new Profile(cover, profilePic, bio, user1);
            profiles.add(profile);
        }
        } catch (IOException e) {
            System.err.println("Error loading profiles from JSON file: " + e.getMessage());
        }
        return profiles;
    }
    
    public static void saveToProfilesJsonFile()
    {       
        ArrayList<Profile> profiles = DataBase.getInstance().getProfiles();
        
        try{
            JSONArray Profiles = new JSONArray();
            
            for (int i = 0; i < profiles.size(); i++) {
                JSONObject profile = new JSONObject();
                profile.put("userid", profiles.get(i).getUserId());
                profile.put("cover", profiles.get(i).getCoverPath());
                profile.put("profile pic", profiles.get(i).getProfilePicPath());
                profile.put("bio", profiles.get(i).getBio());
                
                Profiles.put(profile);
                
            }
           Files.write(Paths.get("profiles.json"), Profiles.toString(4).getBytes());
            System.out.println("System successfully saved the stories");
            
        }catch (IOException ex) {
             System.err.println("Error saving stories to JSON file: " + ex.getMessage());
        }
    }
    
    
    

    
}
