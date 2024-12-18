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
    private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<NotificationGroupAdd> notificationsGroupAdd = new ArrayList<>();
    private ArrayList<NotificationGroupPost> notificationsGroupPost = new ArrayList<>();
    private ArrayList<Chat> chats = new ArrayList<>();

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

    public synchronized void addToGlobalChats(Chat chat) {
        if (chat == null) {
            System.err.println("Cannot add a null chat to global chats.");
            return;
        }
        chats.add(chat);
        System.out.println("Chat added to global chats: " + chat.getChatId());
        FileManagement.saveToChats();
    }

    public synchronized void removeFromGlobalChats(Chat chat) {
        chats.remove(chat);
    }

    public synchronized ArrayList<Chat> getGlobalChats() {
        return chats;
    }

    public void loadAllFiles() {
        this.users.clear();
        this.posts.clear();
        this.stories.clear();
        this.requests.clear();
        this.notificationsFriendReq.clear();
        this.chats.clear();

        this.users = FileManagement.loadFromUsersJSONfile();
        this.posts = FileManagement.loadFromPostsJsonFile();
        this.stories = FileManagement.loadFromStroiesJsonFile();
        this.requests = FileManagement.loadFromFriendRequestsJsonFile();
        this.notificationsFriendReq = FileManagement.loadFromRequestsNotificationsJsonFile();
        this.notificationsGroupAdd = FileManagement.loadFromGroupAddNotificationsJsonFile();
        this.notificationsGroupPost = FileManagement.loadFromGroupPostNotificationsJsonFile();
        this.chats = FileManagement.loadFromChatsJsonFile();

    }

    public synchronized ArrayList<NotificationFriendReq> getNotificationsFriendReq() {
        return notificationsFriendReq;
    }

    public synchronized ArrayList<NotificationGroupAdd> getNotificationsGroupAdd() {
        return notificationsGroupAdd;
    }

    public synchronized ArrayList<NotificationGroupPost> getNotificationsGroupPost() {
        return notificationsGroupPost;
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

    public void addToGlobalRequestsNotifications(NotificationFriendReq req) {
        this.notificationsFriendReq.add(req);
        FileManagement.saveGroupAddNotificationsJsonFile();
    }

    public void addToGlobalGroupAddNotifications(NotificationGroupAdd add) {
        this.notificationsGroupAdd.add(add);
        FileManagement.saveGroupAddNotificationsJsonFile();
    }

    public void addToGlobalGroupPostNotifications(NotificationGroupPost add) {
        this.notificationsGroupPost.add(add);
        FileManagement.saveGroupPostNotificationsJsonFile();
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

    public synchronized ArrayList<Group> getGroups() {
        return groups;
    }

    public synchronized void addGroup(Group group) {
        groups.add(group);
        //FileManagement.saveInGroupsJSONfile();
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
    
    public synchronized void addChatMessage(String chatId,Message message)
    {
        for (Chat chat : chats) {
            if(chat.getChatId().equals(chatId))
            {
                System.out.println("Chat found in Database class");
                chat.AddChatMessages(message);
            }
        }
    }
    

}
