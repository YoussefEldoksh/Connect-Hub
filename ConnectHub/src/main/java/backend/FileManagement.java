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

    public static ArrayList<User> loadFromUsersJSONfile() {
        System.out.println("t6ttttttt");
        System.out.println("Entering loadFromUsersJSONfile");

        ArrayList<User> users = new ArrayList<>();
        try {

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
                LocalDate date = LocalDate.parse(userJson.getString("dob"), formatter);
                String password = userJson.getString("password");
                boolean status = userJson.getBoolean("status");
                User user = new User(id, email, username, password, date, status, "load");

                JSONArray friends = userJson.getJSONArray("friends");

                for (int j = 0; j < friends.length(); j++) {
                    JSONObject friend = friends.getJSONObject(j);
                    String friendEmail = friend.getString("email");
                    String friendId = friend.getString("userId");
                    String friendUsername = friend.getString("username");
                    user.addFriends(new Friend(friendEmail, friendUsername, friendId));

                }

                JSONArray blockedFriends = userJson.getJSONArray("blockedfriends");
                for (int j = 0; j < blockedFriends.length(); j++) {
                    JSONObject friend = blockedFriends.getJSONObject(j);
                    String friendEmail = friend.getString("email");
                    String friendId = friend.getString("userId");
                    String friendUsername = friend.getString("username");
                    user.addBlockedFriends(new Friend(friendEmail, friendUsername, friendId));

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

    public static void saveInUsersJSONfile() {
        ArrayList<User> users = DataBase.getInstance().getUsers();
        try {
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

    public static void saveToFriendRequestsJsonFile() {
        ArrayList<FriendRequests> requests = DataBase.getInstance().getGlobalFriendRequests();
        try {
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

    public static ArrayList<FriendRequests> loadFromFriendRequestsJsonFileForSpecificUser(String userId) {

        ArrayList<FriendRequests> friendRequests = new ArrayList<>();
        try {

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

                if (receiverId.equals(userId)) // add friend request as a receiver
                {

                    friendRequests.add(new FriendRequests(email, username, id, receiverId));

                }

            }
        } catch (IOException ex) {
            System.err.println("Error loading friend requests from JSON file: " + ex.getMessage());
        }

        System.out.println("Exiting loadFromUsersJSONfile");
        return friendRequests;
    }

    public static ArrayList<FriendRequests> loadFromFriendRequestsJsonFile() {

        ArrayList<FriendRequests> friendRequests = new ArrayList<>();
        try {

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

    public static ArrayList<Posts> loadFromPostsJsonFileForSpecificUser(String id) {
        ArrayList<Posts> posts = new ArrayList<>();

        try {
            if (!Files.exists(Paths.get("posts.json")) || Files.size(Paths.get("posts.json")) == 0) {
                Files.createFile(Paths.get("posts.json")); // create the file if not found
                return posts;
            }
            String json = new String(Files.readAllBytes(Paths.get("posts.json")));

            JSONArray jsonPosts = new JSONArray(json);

            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject jsonPost = jsonPosts.getJSONObject(i);
                String userId = jsonPost.getString("userid");
                if (!userId.equals(id)) {
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

                Posts post = new Posts(contentId, userId, content);
                if (photoPath != null) {
                    post.setImagePath(photoPath);
                    post.setImage(image);
                }
                post.setTimestamp(date);
                posts.add(post);// adding a new post to the array
            }

        } catch (IOException ex) {
            System.err.println("Error loading posts from JSON file: " + ex.getMessage());
        }

        return posts;
    }

    public static ArrayList<Posts> loadFromPostsJsonFile() {
        ArrayList<Posts> posts = new ArrayList<>();

        try {

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

                Posts post = new Posts(contentId, userId, content);
                if (photoPath != null) {
                    post.setImagePath(photoPath);
                    post.setImage(image);
                }
                post.setTimestamp(date);//setting the date to the actual one saved in file
                posts.add(post);// adding a new post to the array

            }

        } catch (IOException ex) {
            System.err.println("Error loading posts from JSON file: " + ex.getMessage());
        }

        return posts;
    }

    public static void saveToPostsJsonFile() {
        ArrayList<Posts> posts = DataBase.getInstance().getGlobalPosts();
        try {
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

        } catch (IOException ex) {
            System.err.println("Error saving posts to JSON file: " + ex.getMessage());
        }
    }

    public static ArrayList<Stories> loadFromStroiesJsonFileForSpecificUser(String id) {
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
                if (!userId.equals(id)) {
                    continue;
                }
                String contentId = jsonPost.getString("contentid");
                String content = jsonPost.getString("content");
                String time = jsonPost.getString("timestamp");
                LocalDateTime date = LocalDateTime.parse(time);
                String photoPath = jsonPost.optString("photopath", null);
                ImageIcon image = null;
                if (photoPath != null && Files.exists(Paths.get(photoPath))) {
                    image = new ImageIcon(photoPath);
                } else {
                    System.err.println("Image not found for path: " + photoPath);
                }

                Stories story = new Stories(contentId, userId, content);
                if (photoPath != null) {
                    story.setImagePath(photoPath);
                    story.setImage(image);
                }
                story.setTimestamp(date);//because constructor doesn't set the date saved in the file
                if (!Stories.isExpiredStory(story)) {
                    stories.add(story);
                }

            }
        } catch (IOException e) {
            System.err.println("Error loading stories from JSON file: " + e.getMessage());
        }
        return stories;
    }

    public static ArrayList<Stories> loadFromStroiesJsonFile() {
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
                LocalDateTime date = LocalDateTime.parse(time, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                String photoPath = jsonPost.optString("photopath", null);
                ImageIcon image = null;
                if (photoPath != null && Files.exists(Paths.get(photoPath))) {
                    image = new ImageIcon(photoPath);
                } else {
                    System.err.println("Image not found for path: " + photoPath);
                }
                Stories story = new Stories(contentId, userId, content);
                if (photoPath != null) {
                    story.setImagePath(photoPath);
                    story.setImage(image);
                }
                story.setTimestamp(date);//because constructor doesn't set the date saved in the file
                if (!Stories.isExpiredStory(story)) {
                    stories.add(story);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading stories from JSON file: " + e.getMessage());
        }
        return stories;
    }

    public static void saveToStoriesJsonFile() {
        ArrayList<Stories> stories = DataBase.getInstance().getGlobalStories();

        try {
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

        } catch (IOException ex) {
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
    
    public static ArrayList<Profile> loadFromProfilesJsonFile() {
        ArrayList<Profile> profiles = new ArrayList<>();
        ArrayList<User> users = DataBase.getInstance().getUsers();
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
                String cover = jsonProfile.optString("cover", null);
                String profilePic = jsonProfile.optString("profile pic", null);
                String bio = jsonProfile.getString("bio");
                User user1 = null;
                for (User user : users) {
                    if (user.getUserId().equals(userId)) {
                        user1 = user;
                        break;
                    }
                }
                if (user1 == null) {
                    System.out.println("User not found");
                    continue;
                }
                Profile profile = new Profile(cover, profilePic, bio, user1);
                profiles.add(profile);
            }
        } catch (IOException e) {
            System.err.println("Error loading profiles from JSON file: " + e.getMessage());
        }
        return profiles;
    }

    public static void saveToProfilesJsonFile() {
        ArrayList<Profile> profiles = ProfilesDataBase.getInstance().getProfiles();

        try {
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

        } catch (IOException ex) {
            System.err.println("Error saving stories to JSON file: " + ex.getMessage());
        }
    }
    
    
    public static void saveToGroupsJsonFile(){
    ArrayList<Group> groups = GroupsDataBase.getInstance().getAllGlobalGroups();
    
        try {
            JSONArray Groups = new JSONArray();
            for (int i = 0; i < groups.size(); i++) {
                JSONObject group = new JSONObject();
                group.put("groupid", groups.get(i).getGroupID());
                group.put("group name", groups.get(i).getGroupName());
                group.put("group description", groups.get(i).getGroupDescription());
                group.put("group creator", groups.get(i).getGroupCreator());
                group.put("group photopath", groups.get(i).getGroupPhotoPath());
                
                JSONArray admins = new JSONArray();
                for (int j = 0; j < groups.get(j).getGroupAdmins().size(); j++) {
                JSONObject admin = new JSONObject(); 
                group.put("adminid", groups.get(i).getGroupAdmins().get(j));
                
                admins.put(admin);
                }
                
                JSONArray members = new JSONArray();
                for (int j = 0; j < groups.get(i).getGroupMembers().size(); j++) {
                JSONObject member = new JSONObject(); 
                group.put("memberid", groups.get(i).getGroupMembers().get(j));
                
                members.put(member);
                }
                
                group.put("admins", admins);
                group.put("members", members);
                Groups.put(groups);
            }
            Files.write(Paths.get("groups.json"), Groups.toString(4).getBytes());
            System.out.println("System successfully saved the stories");
        }
        catch (IOException ex) {
            System.err.println("Error saving groups to JSON file: " + ex.getMessage());
        }
    }
        
    public static ArrayList<NotificationFriendReq> loadFromRequestsNotificationsJsonFile() {
        ArrayList<NotificationFriendReq> notifications = new ArrayList<>();
       
        try {
            System.out.println("Entering loadFromNotificationsJSONfile");
            if (!Files.exists(Paths.get("friendsReqNotif.json")) || Files.size(Paths.get("friendsReqNotif.json")) == 0) {
                Files.createFile(Paths.get("friendsReqNotif.json")); // create the file if not found
                return new ArrayList<>();
            }
            String json = new String(Files.readAllBytes(Paths.get("friendsReqNotif.json")));
            JSONArray usersArray = new JSONArray(json);
            
             for (int i = 0; i < usersArray.length(); i++){
                 JSONObject notificationJson = usersArray.getJSONObject(i);
                 String reciever = notificationJson.getString("recieverID");
                 String sender = notificationJson.getString("senderID");
                 String notificationID = notificationJson.getString("notificationID");
                 String notificationType = notificationJson.getString("notificationType");
                 String message = notificationJson.getString("message");
                 String time = notificationJson.getString("time");
                 LocalDateTime date = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
                 
                 notifications.add(new NotificationFriendReq(reciever,sender,notificationID, notificationType, message, date));
                 
             }
        } catch (IOException ex) {
            System.err.println("Error loading users from JSON file: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Error parsing JSON: " + ex.getMessage());
            ex.printStackTrace();
        }
        return notifications;
    }

    public static void saveRequestsNotificationsJsonFile() {
        ArrayList<NotificationFriendReq> notifications = DataBase.getInstance().getNotificationsFriendReq();
         try {
            JSONArray notifications_array = new JSONArray();

            for (int i = 0; i < notifications.size(); i++) {
                JSONObject notification = new JSONObject();
                
                notification.put("recieverID", notifications.get(i).getRecieverId());
                notification.put("senderID", notifications.get(i).getSenderId());
                notification.put("notificationID", notifications.get(i).getId());
                notification.put("notificationType", notifications.get(i).getType());
                notification.put("message", notifications.get(i).getMessage());
                notification.put("time",notifications.get(i).getTime());

                notifications_array.put(notification);

            }
            Files.write(Paths.get("friendsReqNotif.json"), notifications_array.toString(4).getBytes());
            System.out.println("System successfully saved the stories");

        } catch (IOException ex) {
            System.err.println("Error saving stories to JSON file: " + ex.getMessage());
        }
    }

    
    
    public static ArrayList<Group> loadFromGroupsJsonFile() {
        ArrayList<Group> groups = new ArrayList<>();
        try {
            if (!Files.exists(Paths.get("groups.json")) || Files.size(Paths.get("groups.json")) == 0) {
                Files.createFile(Paths.get("groups.json")); // create the file if not found
                return groups;
            }
            String json = new String(Files.readAllBytes(Paths.get("groups.json")));
            JSONArray jsonGroups = new JSONArray(json);

            for (int i = 0; i < jsonGroups.length(); i++) {
                JSONObject jsonGroup = jsonGroups.getJSONObject(i);
                String groupId = jsonGroup.getString("groupid");
                String groupName = jsonGroup.getString("group name");
                String groupDescription = jsonGroup.getString("group description");
                String groupCreator = jsonGroup.getString("group creator");
                String groupPhotoPath = jsonGroup.getString("group photopath");

                Group group = new Group(groupId, groupName, groupDescription, groupCreator,groupPhotoPath);
                JSONArray jsonAdmins = jsonGroup.getJSONArray("admins");
                for (int j = 0; j < jsonAdmins.length(); j++) {
                    JSONObject admin = jsonAdmins.getJSONObject(j);
                    String adminId = admin.getString("adminid");
                    group.addGroupAdmin(adminId);
                }     
                

                JSONArray jsonMembers = jsonGroup.getJSONArray("members");
                for (int j = 0; j < jsonMembers.length(); j++) {
                    JSONObject member = jsonMembers.getJSONObject(j);
                    String memberId = member.getString("memberid");
                    System.out.println("Loading a member");
                    group.addGroupMember(memberId);
                }
                groups.add(group);
            }
        } catch (IOException ex) {
            System.err.println("Error loading groups from JSON file: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Error parsing JSON file: " + ex.getMessage());
            ex.printStackTrace();
        }
        return groups;
    }
    
    //all posts present in all groups
    public static ArrayList<Posts> loadAllFromGroupsPostsJsonFile() {
        ArrayList<Posts> posts = new ArrayList<>();
        try {
            if (!Files.exists(Paths.get("groupsposts.json")) || Files.size(Paths.get("groupsposts.json")) == 0) {
                Files.createFile(Paths.get("groupsposts.json")); // create the file if not found
                return posts;
            }
            String json = new String(Files.readAllBytes(Paths.get("groupsposts.json")));

            JSONArray jsonPosts = new JSONArray(json);

            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject jsonPost = jsonPosts.getJSONObject(i);
                String groupId = jsonPost.getString("groupid");
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

                Posts post = new Posts(groupId, contentId, userId, content);
                if (photoPath != null) {
                    post.setImagePath(photoPath);
                    post.setImage(image);
                }
                post.setTimestamp(date);//setting the date to the actual one saved in file
                posts.add(post);// adding a new post to the array

            }

        } catch (IOException ex) {
            System.err.println("Error loading posts from JSON file: " + ex.getMessage());
        }

        return posts;
    }


    public static void saveToGroupsPostsJsonFile() {
       ArrayList<Posts> posts = GroupsDataBase.getInstance().getAllGlobalGroupsPosts();
        try {
            JSONArray Posts = new JSONArray();

            for (int i = 0; i < posts.size(); i++) {
                JSONObject post = new JSONObject();
                post.put("groupid", posts.get(i).getGroupID());
                post.put("userid", posts.get(i).getAuthorID());
                post.put("contentid", posts.get(i).getContentID());
                post.put("content", posts.get(i).getContent());
                post.put("photopath", posts.get(i).getImagePath());
                post.put("timestamp", posts.get(i).getTimestamp());

                Posts.put(post);

            }
            Files.write(Paths.get("groupsposts.json"), Posts.toString(4).getBytes());
            System.out.println("System successfully saved the friendrequests");

        } catch (IOException ex) {
            System.err.println("Error saving posts to JSON file: " + ex.getMessage());
        }
    }

    public static ArrayList<Posts> loadFromPostsJsonFileForSpecificGroup(String groupid) {
        ArrayList<Posts> posts = new ArrayList<>();
        
        try {
            if (!Files.exists(Paths.get("groupsposts.json")) || Files.size(Paths.get("groupsposts.json")) == 0) {
                Files.createFile(Paths.get("groupsposts.json")); // create the file if not found
                return posts;
            }
            String json = new String(Files.readAllBytes(Paths.get("posts.json")));
            JSONArray jsonPosts = new JSONArray(json);

            for (int i = 0; i < jsonPosts.length(); i++) {
                JSONObject jsonPost = jsonPosts.getJSONObject(i);
                String groupId = jsonPost.getString("groupid");
                if (!groupId.equals(groupid)) {
                    continue;
                }
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

                Posts post = new Posts(groupId, contentId, userId, content);
                if (photoPath != null) {
                    post.setImagePath(photoPath);
                    post.setImage(image);
                }
                post.setTimestamp(date);
                posts.add(post);// adding a new post to the array
            }

        } catch (IOException ex) {
            System.err.println("Error loading posts from JSON file: " + ex.getMessage());
        }
        return posts;
    }
    
    public static void saveToGroupRequestsJsonFile(){
        ArrayList<GroupRequests> requests = GroupsDataBase.getInstance().getAllGlobalGroupRequests();
        try {
            JSONArray Requests = new JSONArray();

            for (int i = 0; i < requests.size(); i++) {
                JSONObject request = new JSONObject();
                request.put("groupid", requests.get(i).getGroupId());
                request.put("userid", requests.get(i).getUserMakingReqId());
                Requests.put(request);
            }
            Files.write(Paths.get("grouprequests.json"), Requests.toString(4).getBytes());
            System.out.println("System successfully saved the group requests");

        } catch (IOException ex) {
            System.err.println("Error saving posts to JSON file: " + ex.getMessage());
        }
    
    }
    
    
    public static ArrayList<GroupRequests> loadFromGroupRequestsJsonFile() {

        ArrayList<GroupRequests> requests = new ArrayList<>();
        try {

            if (!Files.exists(Paths.get("grouprequests.json")) || Files.size(Paths.get("grouprequests.json")) == 0) {
                Files.createFile(Paths.get("grouprequests.json")); // create the file if not found
                return requests;

            }

            String json = new String(Files.readAllBytes(Paths.get("grouprequests.json")));
            JSONArray RequestsJson = new JSONArray(json);

            for (int i = 0; i < RequestsJson.length(); i++) {

                JSONObject requestJson = RequestsJson.getJSONObject(i);
                String groupId= requestJson.getString("groupid");
                String userId = requestJson.getString("userid");
                requests.add(new GroupRequests(groupId, userId));
            }
        } catch (IOException ex) {
            System.err.println("Error loading group requests from JSON file: " + ex.getMessage());
        }
        return requests;
    }
    
    public static ArrayList<GroupRequests> loadFromGroupRequestsJsonFileForSpecificGroup(String id) {
        ArrayList<GroupRequests> requests = new ArrayList<>();
        try {

            if (!Files.exists(Paths.get("grouprequests.json")) || Files.size(Paths.get("grouprequests.json")) == 0) {
                Files.createFile(Paths.get("grouprequests.json")); // create the file if not found
                return requests;

            }

            String json = new String(Files.readAllBytes(Paths.get("grouprequests.json")));
            JSONArray RequestsJson = new JSONArray(json);

            for (int i = 0; i < RequestsJson.length(); i++) {
                JSONObject requestJson = RequestsJson.getJSONObject(i);
                if(!requestJson.getString("groupid").equals(id))
                    continue;
                String groupId= requestJson.getString("groupid");
                String userId = requestJson.getString("userid");
                requests.add(new GroupRequests(groupId, userId));
            }
        } catch (IOException ex) {
            System.err.println("Error loading group requests from JSON file: " + ex.getMessage());
        }
        return requests;
    }
    
    public static ArrayList<GroupRequests> loadFromGroupRequestsJsonFileForSpecificUser(String id) {
        ArrayList<GroupRequests> requests = new ArrayList<>();
        try {

            if (!Files.exists(Paths.get("grouprequests.json")) || Files.size(Paths.get("grouprequests.json")) == 0) {
                Files.createFile(Paths.get("grouprequests.json")); // create the file if not found
                return requests;

            }

            String json = new String(Files.readAllBytes(Paths.get("grouprequests.json")));
            JSONArray RequestsJson = new JSONArray(json);

            for (int i = 0; i < RequestsJson.length(); i++) {
                JSONObject requestJson = RequestsJson.getJSONObject(i);
                if(!requestJson.getString("user").equals(id))
                    continue;
                String groupId= requestJson.getString("groupid");
                String userId = requestJson.getString("userid");
                requests.add(new GroupRequests(groupId, userId));
            }
        } catch (IOException ex) {
            System.err.println("Error loading group requests from JSON file: " + ex.getMessage());
        }
        return requests;
    }

}

