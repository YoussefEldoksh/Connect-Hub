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

    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Posts> posts = new ArrayList<>();
    private ArrayList<Stories> stories = new ArrayList<>();
    private ArrayList<FriendRequests> requests = new ArrayList<>();
    private ArrayList<NotificationFriendReq> notificationsFriendReq = new ArrayList<>();

    private static DataBase database = null;
    private static boolean isLoading = false;

    private DataBase() {
        if (isLoading) {
            throw new IllegalStateException("DataBase is already being initialized!");
        }
        isLoading = true;
        loadAllFiles();
        isLoading = false;
    }

    public static DataBase getInstance() {
        if (database == null) {
            database = new DataBase();
        }
        return database;
    }

    public synchronized void addToGlobalPosts(Posts post) // add for future saving
    {
        posts.add(post);
        FileManagement.saveToPostsJsonFile();
    }

    public synchronized void addTOGlobalStories(Stories story)// add for future saving
    {
        stories.add(story);
        FileManagement.saveToStoriesJsonFile();
    }

    
    

    public synchronized void addToGlobalRequestsNotifications(NotificationFriendReq req)
    {
        notificationsFriendReq.add(req);
        FileManagement.saveRequestsNotificationsJsonFile();
    }
    

    
    public synchronized ArrayList<Posts> getGlobalPosts() {
        return posts;
    }

    public synchronized ArrayList<Stories> getGlobalStories() {
        return stories;
    }

    public synchronized void addToGlobalFriendRequests(FriendRequests request) // add for future saving
    {
        requests.add(request);
        FileManagement.saveToFriendRequestsJsonFile();
    }

    public synchronized ArrayList<FriendRequests> getGlobalFriendRequests() {
        return requests;
    }

    public synchronized void removeToGlobalFriendRequests(FriendRequests request) // add for future saving
    {
        requests.remove(request);
        FileManagement.saveToFriendRequestsJsonFile();
    }

    public synchronized ArrayList<User> getUsers() {
        return users;
    }

    public synchronized void addUser(User user) {
        users.add(user);
        FileManagement.saveInUsersJSONfile();
    }

    public void loadAllFiles() {
        this.users.clear();
        this.posts.clear();
        this.stories.clear();
        this.requests.clear();
        this.notificationsFriendReq.clear();

        this.users = FileManagement.loadFromUsersJSONfile();
        this.posts = FileManagement.loadFromPostsJsonFile();
        this.stories = FileManagement.loadFromStroiesJsonFile();
        this.requests = FileManagement.loadFromFriendRequestsJsonFile();
        this.notificationsFriendReq = FileManagement.loadFromRequestsNotificationsJsonFile();

    }

    public synchronized ArrayList<NotificationFriendReq> getNotificationsFriendReq() {
        return notificationsFriendReq;
    }

    public synchronized void removeFriendReq(FriendRequests request) {
        for (FriendRequests req : requests) {
            if (req.getUsername().equals(request.getUsername())) {
                System.out.println("Found the request");
                request = req;
                break;

            }
        }
        requests.remove(request);
        System.out.println("requests" + requests);
    }

}
