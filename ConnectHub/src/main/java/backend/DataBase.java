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
public class DataBase { // Centralized Data Management
    private ArrayList<User> users;
    private ArrayList<Posts> posts;
    private ArrayList<Stories> stories;
    private ArrayList<FriendRequests> requests;
    
    private static DataBase database = null;

    private DataBase() {
        this.users = FileManagement.loadFromUsersJSONfile();
        this.posts = FileManagement.loadFromPostsJsonFile();
        this.stories = FileManagement.loadFromStroiesJsonFile();
        this.requests = FileManagement.loadFromFriendRequestsJsonFile();
        
    }
    
    public static DataBase getInstance() {
        if (database == null) {
            database = new DataBase(); 
        }
        return database;
    }
    
    
        
    public  synchronized void addToGlobalPosts(Posts post) // add for future saving
    {
        posts.add(post);
    }
    public  synchronized void addTOGlobalStories(Stories story)// add for future saving
    {
        stories.add(story);
    }

    
    
    public synchronized ArrayList<Posts> getGlobalPosts() 
    {
        return posts;
    }

    public synchronized ArrayList<Stories> getGlobalStories() 
    {
        return stories;
    }
    
    public synchronized void addToGlobalFriendRequests(FriendRequests request) // add for future saving
    {
        requests.add(request);
    }
    
    public synchronized ArrayList<FriendRequests> getGlobalFriendRequests() 
    {
        return requests;
    }

    public synchronized ArrayList<User> getUsers() {
        return users;
    }
    public synchronized void addUser(User user){
        users.add(user);
    }
    

    
    
    
}
