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
public abstract class DataBase {
    private static ArrayList<User> users = FileManagement.loadFromUsersJSONfile();
    private static ArrayList<Posts> posts =  FileManagement.loadFromPostsJsonFile();
    private static ArrayList<Stories> stories = FileManagement.loadFromStroiesJsonFile();
    private static ArrayList<FriendRequests> requests = FileManagement.loadFromFriendRequestsJsonFile();
    private static ArrayList<Profile> profiles = FileManagement.loadFromProfilesJsonFile();
        
    public static void addToGlobalPosts(Posts post) // add for future saving
    {
        posts.add(post);
    }
    public  static void addTOGlobalStories(Stories story)// add for future saving
    {
        stories.add(story);
    }

    
    
    public static ArrayList<Posts> getGlobalPosts() 
    {
        return posts;
    }

    public static ArrayList<Stories> getGlobalStories() 
    {
        return stories;
    }
    
    public static void addToGlobalFriendRequests(FriendRequests request) // add for future saving
    {
        requests.add(request);
    }
    
    public static ArrayList<FriendRequests> getGlobalFriendRequests() 
    {
        return requests;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
    public static void addUser(User user){
        users.add(user);
    }
    
     public static ArrayList<Profile> getProfiles() {
        return profiles;
    }
    public static void addProfile(Profile profile){
        profiles.add(profile);
    }
    

    
    
    
}
