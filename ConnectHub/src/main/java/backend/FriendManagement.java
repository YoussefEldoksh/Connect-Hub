/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.security.AllPermission;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author malak
 */
public class FriendManagement {

    
    public static void friendRequest(boolean accept, User user, FriendRequests friend, boolean rejected)
    {
      ArrayList<String> excludedIds = new ArrayList<>();
      User sender=AccountManagement.findUser(friend.getUsername());
      
        if (sender == null) {
            System.out.println("Sender user not found: " + friend.getUsername());
            return;
        }
        for (Friend excludedfriends : user.getListOfBlockedFriends()) {
            excludedIds.add(excludedfriends.getUserId());
        }
        for (Friend excludedFriends : user.getListOfFriends()) {
            excludedIds.add(excludedFriends.getUserId());
        }
        excludedIds.add(user.getUserId());

        if (!user.getListOfFriendReq().contains(friend))// if the request is already made don't added it again to the array
        {
            user.addFriendsReq(friend);
        }


       if(!excludedIds.contains(friend.getUserId()))
       {
            if(accept == true) 
            {
                
                user.addFriends(new Friend(sender.getEmail(),sender.getUsername(), sender.getUserId()));
                user.removeFriendReq(friend);

                System.out.println("Friendrequests: "+user.getListOfFriendReq());
                
                sender.addFriends(new Friend(user.getEmail(),user.getUsername(),user.getUserId()));
                DataBase.getInstance().removeFriendReq(friend);
            }
            else if(accept == false &&  rejected == true)
            {

                user.removeFriendReq(friend);//this means that the request if 
                DataBase.getInstance().removeFriendReq(friend);

            }

            FileManagement.saveToFriendRequestsJsonFile();
            FileManagement.saveInUsersJSONfile();

            //else the request is still pending
            // add it for future responding
        }

    }

    public static void requestSent(FriendRequests request, User user) {
        if (user.getListOfFriendReq().contains(request)) {
            System.out.println("Friend request already sent: " + request.getUsername());
            return;
        }

        DataBase.getInstance().addToGlobalFriendRequests(request);
        DataBase.getInstance().addToGlobalRequestsNotifications(new NotificationFriendReq(request.getReceiver(),request.getUserId(),"NR", "FriendRequest", UserSession.getCurrentUser().getUsername()+" Sent you a friendrequest", LocalDateTime.now()));
        AccountManagement.findUser(AccountManagement.findUsername(request.getReceiver())).addToListOfNotification(new NotificationFriendReq(request.getReceiver(), UserSession.getCurrentUser().getUserId(),"NR", "FriendRequest", UserSession.getCurrentUser().getUsername()+"Sent you a friendrequest", LocalDateTime.now()));
        user.addFriendsReq(request);
        System.out.println("Friend request sent to: " + request.getUsername());


    }

    public static ArrayList<Friend> friendSuggestion(User user) {
        // check for the friends that are not 
        ArrayList<Friend> suggestions = new ArrayList<>();
        ArrayList<Friend> blockedFriends = user.getListOfBlockedFriends();
        ArrayList<Friend> friends = user.getListOfFriends();

        ArrayList<String> excludedIds = new ArrayList<>();
        for (Friend excludedfriends : blockedFriends) {
            excludedIds.add(excludedfriends.getUserId());
        }
        for (Friend excludedFriends : friends) {
            excludedIds.add(excludedFriends.getUserId());
        }
        excludedIds.add(user.getUserId()); // exclude the user themselves

        for (User allUser : DataBase.getInstance().getUsers()) {
            if (!excludedIds.contains(allUser.getUserId())) // check if this user in the database is one of the friends or one of the blocked don't add to suggestions
            {
                suggestions.add(new Friend(allUser.getEmail(), allUser.getUsername(), allUser.getUserId())); // if user isn't friend add to suggestions
            }
        }
        return suggestions;
    }

    public static Friend getFriendSuggested(User user, String friendUsername) {
        ArrayList<Friend> suggestedFriends = friendSuggestion(user);

        for (int i = 0; i < friendSuggestion(user).size(); i++) {
            if (suggestedFriends.get(i).getUsername().equals(friendUsername)) {
                return suggestedFriends.get(i);
            }
        }
        return null;
    }

    public static ArrayList<String> fetchFriendsSuggestions(User user) // fetching an array list of friends suggestions in the String format for display
    {
        ArrayList<String> friends = new ArrayList<>();
        ArrayList<Friend> userFriends = friendSuggestion(user);

        for (Friend userFriend : userFriends) {
            if (AccountManagement.findUser(userFriend.getUsername()).getStatus()) {
                friends.add(userFriend.getUsername() + " " + "ONLINE");
            } else {
                friends.add(userFriend.getUsername() + " " + "OFFLINE");
            }
        }
        return friends;
    }

    public static void blockFriend(User user, Friend blockFriend)// moving the friend from the friends list to the blocked list
    {
        user.addBlockedFriends(blockFriend);
        FriendManagement.removeFriend(AccountManagement.findUser(blockFriend.getUsername()), Friend.getFriend(blockFriend.getUsername(), user.getUsername()));
        AccountManagement.findUser(blockFriend.getUsername()).addUnviewableUser(user);
        FileManagement.saveInUsersJSONfile();
        FileManagement.saveToFriendRequestsJsonFile();
    }

    public static void removeFriend(User user, Friend friend) {
        user.removeFriend(friend);
        AccountManagement.findUser(friend.getUsername()).removeFriend(Friend.getFriend(friend.getUsername(), user.getUsername()));//remove friend from both friends
        FileManagement.saveInUsersJSONfile();
    }

    public static void unblockFriend(User user, Friend blockedFriend) // function for unblocking someone
    {                                                          // can be added to suggestions and searched for
        user.removeBlockedFriend(blockedFriend);

        FileManagement.saveInUsersJSONfile();
    }

    public static Boolean displayFriendStatus(User user, Friend friend) {

        if (user.getListOfFriends().contains(friend)) {
            for (User allUser : DataBase.getInstance().getUsers()) {
                if (allUser.getUserId().equals(friend.getUserId())) {
                    return allUser.getStatus();// true == online
                }                              // false == offline
            }
        }
        return false;
    }

    public static ArrayList<Friend> advancedSearchFriends(String friend, User user) {
        ArrayList<Friend> friends = new ArrayList<>();
        ArrayList<Friend> userFriends = user.getListOfFriends();

        if (friend == null || user == null || user.getListOfFriends() == null) {
            return friends; // Return empty list if input is invalid
        }

        for (Friend userFriend : userFriends) {
            if (userFriend.getUsername().toLowerCase().contains(friend.toLowerCase())) {
                friends.add(userFriend);
            }
        }
        return friends;
    }

    public static ArrayList<FriendRequests> advancedSearchFriendsRequests(String friend, User user) {
        ArrayList<FriendRequests> friendrequests = new ArrayList<>();
        ArrayList<FriendRequests> userFriends = user.getListOfFriendReq();

        if (friend == null || user == null || user.getListOfFriendReq() == null) {
            return friendrequests; // Return empty list if input is invalid
        }

        for (FriendRequests userFriendRequests : userFriends) {
            if (userFriendRequests.getUsername().toLowerCase().contains(friend.toLowerCase())) // make case insenstive
            {
                friendrequests.add(userFriendRequests);
            }
        }
        return friendrequests;
    }

    public static ArrayList<User> advancedSearchUsersString(String user) {

        ArrayList<User> searchedUser = new ArrayList<>();
        if (user == null || user.trim().isEmpty()) {
            return searchedUser; // Return empty list for null or empty input
        }
        if (user == null) {
            return searchedUser; // Return empty list if input is invalid
        }

        for (User allUsers : DataBase.getInstance().getUsers()) {
            if (allUsers.getUsername().toLowerCase().contains(user.toLowerCase())) // make case insenstive
            {
                searchedUser.add(allUsers);
            }
        }
        return searchedUser;
    }

    public static ArrayList<String> getLineRepresentationUserSearch(String keyword) {

        ArrayList<String> keyUsers = new ArrayList<>();

        ArrayList<User> users = advancedSearchUsersString(keyword);

        if (users.isEmpty()) {
            return keyUsers;
        }

        for (User user : users) {
            keyUsers.add(user.getUsername());

        }
        return keyUsers;
    }

    public static boolean isFriend(String key) {
        ArrayList<Friend> friends = UserSession.getCurrentUser().getListOfFriends();

        for (Friend friend : friends) {
            if (key.equals(friend.getUsername())) {
                return true;  // return true if they key is a friend of the user
            }
        }
        return false;
    }

}
