/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import static backend.FriendManagement.friendSuggestion;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Array;
import java.sql.DatabaseMetaData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private ArrayList<GroupRequests> groupRequests = new ArrayList<>();
    private String password;
    private LocalDate dateOfBirth;
    private boolean status;
    private ArrayList<Friend> friends = new ArrayList<>();
    private ArrayList<Friend> blockedFriends = new ArrayList<>();
    private ArrayList<FriendRequests> friendReq = new ArrayList<>();
    private ArrayList<User> unviewableUsers = new ArrayList<>();
    private ArrayList<Posts> userPosts = new ArrayList<>();
    private ArrayList<Stories> userStories = new ArrayList<>();
    public String getPassword;
    private ArrayList<Notification> notifications = new ArrayList<>();
    private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<Chat> myChats = new ArrayList<>();

    public User(String userId, String email, String username, String password, LocalDate dateOfBirth, boolean status) {
        super(email, username, userId);
        setPassword(password);
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        friends = new ArrayList<>();
        blockedFriends = new ArrayList<>();
        unviewableUsers = new ArrayList<>();
        friendReq = FileManagement.loadFromFriendRequestsJsonFileForSpecificUser(userId);
        userStories = FileManagement.loadFromStroiesJsonFileForSpecificUser(userId);
        userPosts = FileManagement.loadFromPostsJsonFileForSpecificUser(userId);
        groupRequests = FileManagement.loadFromGroupRequestsJsonFileForSpecificUser(this.getUserId());
        groups = fillGroups();
        notifications = fillFriendRequestsNotifications();
        notifications.addAll(fillGroupAddNotifications());
        notifications.addAll(fillGroupPostNotifications());
        fillChats();

    }

    public User(String userId, String email, String username, String password, LocalDate dateOfBirth, boolean status, String load) {
        super(email, username, userId);
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        friends = new ArrayList<>();
        blockedFriends = new ArrayList<>();
        unviewableUsers = new ArrayList<>();
        friendReq = FileManagement.loadFromFriendRequestsJsonFileForSpecificUser(userId);
        userStories = FileManagement.loadFromStroiesJsonFileForSpecificUser(userId);
        userPosts = FileManagement.loadFromPostsJsonFileForSpecificUser(userId);
        groups = fillGroups();

        notifications.addAll(fillFriendRequestsNotifications());
        notifications.addAll(fillGroupAddNotifications());
        notifications.addAll(fillGroupPostNotifications());
        fillChats();

    }

    public void addFriends(Friend friend) {
        friends.add(friend);
    }

    public String getUsername() {
        return username;
    }

    public ArrayList<Stories> getUserStories() {
        return userStories;
    }

    public ArrayList<Posts> getUserPosts() {
        return userPosts;
    }

    public void removeFriend(Friend friend) {
        friends.remove(friend);
    }

    public ArrayList<Friend> getListOfFriends() {
        return friends;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm.");
            return;
        }
        byte[] hashedBytes = md.digest(password.getBytes());
        this.password = Base64.getEncoder().encodeToString(hashedBytes);
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void addBlockedFriends(Friend friend) {
        blockedFriends.add(friend);

        if (friends.contains(friend)) {
            friends.remove(friend);
            //unviewableUsers.add(AccountManagement.findUser(friend.getUsername()));
            //AccountManagement.findUser(friend.getUsername()).addUnviewableUser(this); 
            //make the blocked friend not view the user 
            // AccountManagement.findUser(friend.getUsername()).getListOfFriends().remove(new Friend(this.getEmail(),this.getUsername(),this.getUserId()));
        }

        for (FriendRequests request : friendReq) {
            if (request.getUserId().equals(friend.getUserId())) {
                friendReq.remove(request);
                AccountManagement.findUser(friend.getUsername()).getListOfFriendReq().remove(request); //remove friend req from the blocked user too
                return;
            }
        }
    }

    public void removeBlockedFriend(Friend friend) // for unblocking
    {
        if (blockedFriends.contains(friend)) {
            unviewableUsers.remove(AccountManagement.findUser(friend.getUsername()));
            AccountManagement.findUser(friend.getUsername()).removeUnviewableUser(this);
            blockedFriends.remove(friend);
            System.out.println("Unblocked.");
            return;
        }
        System.out.println("Friend not blocked in the first place");
    }

    public void addUnviewableUser(User user) {
        unviewableUsers.add(user);
        user.addUnviewableUser(this);
    }

    public void removeUnviewableUser(User user) {
        unviewableUsers.remove(user);
    }

    public ArrayList<User> getListOfUnviewableUsers() {
        return unviewableUsers;
    }

    public ArrayList<Friend> getListOfBlockedFriends() {
        return blockedFriends;
    }

    public Friend getListOfBlockedFriends(String username) {
        for (int i = 0; i < getListOfBlockedFriends().size(); i++) {
            if (getListOfBlockedFriends().get(i).getUsername().equals(username)) {
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
        for (i = 0; i < userblocked.size(); i++) {
            blocked.add(userblocked.get(i).getUsername());
        }
        return blocked;
    }

    public void addFriendsReq(FriendRequests friend) {
        friendReq.add(friend);
    }

    public void removeFriendReq(FriendRequests friend) {
        friendReq.remove(friend);
    }

    public ArrayList<FriendRequests> getListOfFriendReq() {
        return friendReq;
    }

    public FriendRequests getFriendReq(String username) {
        for (int i = 0; i < friendReq.size(); i++) {
            if (friendReq.get(i).getUsername().equals(username)) {
                return this.getListOfFriendReq().get(i);
            }
        }
        System.out.println(friendReq);
        return null;
    }

    public ArrayList<String> getLineRepOfFriendReq() // fetching an array list of friends suggestions in the String format for display
    {
        ArrayList<String> requests = new ArrayList<>();
        ArrayList<FriendRequests> requested = this.getListOfFriendReq();
        int i;
        for (i = 0; i < requested.size(); i++) {
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
    public ArrayList<FriendRequests> getListOfSentReq() {
        ArrayList<FriendRequests> sent = new ArrayList<>();
        for (FriendRequests req : friendReq) {
            if (req.getUserId().equals(this.getUserId())) {
                sent.add(req);
            }
        }
        return sent;
    }

    public ArrayList<FriendRequests> getListOfReceivedReq() {
        ArrayList<FriendRequests> received = new ArrayList<>();
        for (FriendRequests req : friendReq) {
            if (req.getReceiver().equals(this.getUserId())) {
                received.add(req);
            }
        }
        return received;
    }

    public void addPost(Posts post) {
        this.userPosts.add(post);
    }

    public void addStory(Stories story) {
        this.userStories.add(story);
    }

    public void removePost(Posts post) {
        this.userPosts.remove(post);
    }

    public void removeStory(Stories story) {
        this.userStories.remove(story);

    }

    public void reload() {
        friendReq.clear();
        userStories.clear();
        userPosts.clear();
        notifications.clear();

        friendReq = FileManagement.loadFromFriendRequestsJsonFileForSpecificUser(this.getUserId());
        userStories = FileManagement.loadFromStroiesJsonFileForSpecificUser(this.getUserId());
        userPosts = FileManagement.loadFromPostsJsonFileForSpecificUser(this.getUserId());
        notifications.addAll(fillFriendRequestsNotifications());
        notifications.addAll(fillGroupAddNotifications());
        notifications.addAll(fillGroupPostNotifications());
    }

    public ArrayList<Notification> fillFriendRequestsNotifications() {
        ArrayList<NotificationFriendReq> requestNotification = FileManagement.loadFromRequestsNotificationsJsonFile();
        ArrayList<Notification> Notifications = new ArrayList<>();

//        if (requestNotification.isEmpty()) {
//            return Notifications;
//        }
        for (NotificationFriendReq notificationFriendReq : requestNotification) {
            if (notificationFriendReq.getRecieverId().equals(this.getUserId())) {
                Notifications.add(notificationFriendReq);
            }
        }
        //hena el loop el hay add el notifications beta3et el group lazem a valdiate el awel eno a member

        return Notifications;
    }

    public ArrayList<Notification> fillGroupAddNotifications() {
        ArrayList<NotificationGroupAdd> AddNotification = FileManagement.loadFromGroupAddNotificationsJsonFile();
        ArrayList<Notification> Notifications = new ArrayList<>();

//        if (requestNotification.isEmpty()) {
//            return Notifications;
//        }
        ArrayList<String> myGroups = new ArrayList<>();

        for (Group group : this.groups) {
            myGroups.add(group.getGroupID());
        }

        if (myGroups.isEmpty()) {
            return new ArrayList<>();
        }

        for (NotificationGroupAdd notificationFriendReq : AddNotification) {
            if (myGroups.contains(notificationFriendReq.getGroupId())) {
                Notifications.add(notificationFriendReq);
                System.out.println("Filling the notification group add for userrrr");
            }
        }
        //hena el loop el hay add el notifications beta3et el group lazem a valdiate el awel eno a member

        return Notifications;
    }

    public ArrayList<Notification> fillGroupPostNotifications() {
        ArrayList<NotificationGroupPost> AddNotification = FileManagement.loadFromGroupPostNotificationsJsonFile();
        ArrayList<Notification> Notifications = new ArrayList<>();

//        if (requestNotification.isEmpty()) {
//            return Notifications;
//        }
        ArrayList<String> myGroups = new ArrayList<>();

        for (Group group : this.groups) {
            myGroups.add(group.getGroupID());
        }

        if (myGroups.isEmpty()) {
            System.out.println("Groups empty returninggggggggggggggggg");
            return new ArrayList<>();
        }

        for (NotificationGroupPost notificationFriendReq : AddNotification) {
            if (myGroups.contains(notificationFriendReq.getGroupId())) {
                Notifications.add(notificationFriendReq);
                System.out.println("Filling the notification group post for userrrr");
            }
        }
        //hena el loop el hay add el notifications beta3et el group lazem a valdiate el awel eno a member
        System.out.println("Group post notific: " + Notifications);
        return Notifications;
    }

    public ArrayList<Group> fillGroups() {
        ArrayList<Group> userGroups = new ArrayList<>();

        ArrayList<Group> allGroups = FileManagement.loadFromGroupsJsonFile();
        System.out.println("AllGroups: " + allGroups);
        if (allGroups.isEmpty()) {
            return userGroups;
        }

        for (Group allGroup : allGroups) {
            if (allGroup.getGroupMembers().contains(this.getUserId())) {
                userGroups.add(allGroup);
            }
        }
        return userGroups;
    }

    public ArrayList<String> getLineRepresentationForUserGroups() {
        ArrayList<String> Groups = new ArrayList<>();

        System.out.println("Groups: " + this.groups);
        if (groups.isEmpty()) {
            return Groups;
        }

        for (Group Group : this.groups) {
            String s = "Group " + Group.getGroupName() + " : " + Group.getGroupDescription();
            Groups.add(s);
        }
        return Groups;
    }

    public static ArrayList<Group> advancedSearchUsersString(String group) {

        ArrayList<Group> searchGroup = new ArrayList<>();
        if (group == null || group.trim().isEmpty()) {
            return searchGroup; // Return empty list for null or empty input
        }
        if (group == null) {
            return searchGroup; // Return empty list if input is invalid
        }

        for (Group allGroups : GroupsDataBase.getInstance().getAllGlobalGroups()) {
            if (allGroups.getGroupName().toLowerCase().contains(group.toLowerCase())) // make case insenstive
            {
                searchGroup.add(allGroups);
            }
        }
        return searchGroup;
    }

    public void addToGroups(Group group) {
        this.groups.add(group);
    }

    public ArrayList<String> getLineRepresentationForAllGroups(String key) {
        ArrayList<String> Groups = new ArrayList<>();

        if (advancedSearchUsersString(key).isEmpty()) {
            return Groups;
        }

        for (Group Group : advancedSearchUsersString(key)) {
            String s = "Group " + Group.getGroupName() + " : " + Group.getGroupDescription();
            Groups.add(s);
        }
        return Groups;
    }

    public ArrayList<String> getLineRepresentationForNotifications() {
        ArrayList<String> notification = new ArrayList<>();

        if (notifications.isEmpty()) {
            return notification;
        }

        for (Notification Notification : notifications) {

            if (Notification instanceof NotificationFriendReq) {
                String s = Notification.getMessage() + " " + Notification.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a"));
                notification.add(s);
            }
            if (Notification instanceof NotificationGroupAdd || Notification instanceof NotificationGroupPost) {
                String s = Notification.getMessage() + " " + Notification.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a"));
                notification.add(s);
            }
        }
        return notification;
    }

    public void addToListOfNotification(Notification notification) {
        notifications.add(notification);
    }

    public ArrayList<Notification> getListOfNotifications() {
        return notifications;
    }

    public void setUserPosts(ArrayList<Posts> userPosts) {
        this.userPosts = userPosts;
    }

    public void setUserStories(ArrayList<Stories> userStories) {
        this.userStories = userStories;
    }

    public ArrayList<Group> getGroupsOfUser() {
        return groups;
    }

    public void addToGroupsOfUser(Group group) {
        groups.add(group);
    }

    public void removeFromsGroupsOfUser(Group group) {
        groups.remove(group);
    }

    public void setGroupsOfUser(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<GroupRequests> getGroupRequestsOfUser() {
        return groupRequests;
    }

    public void addToGroupRequestsOfUser(GroupRequests grouprequest) {
        groupRequests.add(grouprequest);
    }

    public void removeFromsGroupRequestsOfUser(GroupRequests grouprequest) {
        groupRequests.remove(grouprequest);
    }

    public void setGroupRequestsOfUser(ArrayList<GroupRequests> grouprequests) {
        this.groupRequests = grouprequests;
    }

    public boolean isGroupMember(String key) {
        ArrayList<Group> allGroups = GroupsDataBase.getInstance().getAllGlobalGroups();
        System.out.println("AllGroups: " + allGroups);

        if (allGroups.isEmpty()) {
            return false;
        }

        Group group = GroupsDataBase.getInstance().getGroupByName(key);
        if (group == null) {
            return false;
        }

        if (group.getGroupMembers().contains(this.getUserId())) {
            return true;
        }

        return false;
    }

    public void fillChats() {
        ArrayList<Chat> chats = FileManagement.loadFromChatsJsonFile();
        if (chats.isEmpty()) {
            return;
        }
        myChats.clear();
        for (Chat chat : chats) {
            if (chat.getChatId().contains(this.getUserId())) {
                this.myChats.add(chat);
            }
        }
    }

    public void addChat(Chat newChat) {
        if (newChat == null) {
            System.err.println("Cannot add a null chat to the user's chat list.");
            return;
        }
        myChats.add(newChat);
        System.out.println("Chat added to user's chat list: " + newChat.getChatId());
    }

    public ArrayList<Chat> getMyChats() {
        return myChats;
    }

    public Chat getSpecificChat(String username) {
        String id = AccountManagement.findUserId(username);

        for (Chat chat : myChats) {
            if (chat.getChatId().contains(id)) {
                return chat;
            }
        }
        System.out.println("Chat is nulllllllllllllll");
        return null;
    }

}
