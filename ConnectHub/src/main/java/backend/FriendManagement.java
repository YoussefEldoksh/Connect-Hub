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
public class FriendManagement {
    ArrayList<User> allUsers = FileManagement.loadFromUsersJSONfile();
    
    public void friendRequest(boolean accept, User user,FriendRequests friend, boolean rejected)
    {
      ArrayList<String> excludedIds = new ArrayList<>();
        for (Friend excludedfriends : user.getListOfBlockedFriends()) {
            excludedIds.add(excludedfriends.getUserId());
        }
        for(Friend excludedFriends : user.getListOfFriends())
        {
            excludedIds.add(excludedFriends.getUserId());
        }
        excludedIds.add(user.getUserId());
        
        
      if(!user.getListOfFriendReq().contains(friend))// if the request is already made don't added it again to the array
      {
          user.addFriendsReq(friend);
      }
       
       if(!excludedIds.contains(friend.getUserId()))
       {
            if(accept == true) 
            {
                user.addFriends(new Friend(friend.getEmail(),friend.getUsername(), friend.getUserId()));
                user.removeFriendReq(friend);
                DataBase.addToGlobalFriendRequests(friend);
                FileManagement.saveToFriendRequestsJsonFile();
                FileManagement.saveInUsersJSONfile();
            }
            else if(accept == false &&  rejected == true)
            {
                user.removeFriendReq(friend);//this means that the request if rejected
                DataBase.addToGlobalFriendRequests(friend);
                FileManagement.saveToFriendRequestsJsonFile();
            }

            //else the request is still pending
            DataBase.addToGlobalFriendRequests(friend);
            FileManagement.saveToFriendRequestsJsonFile(); // add it for future responding
       }

    }
    
    public ArrayList<Friend> friendSuggestion(User user )
    {
        // check for the friends that are not 
        ArrayList<Friend> suggestions = new ArrayList<>();
        ArrayList<Friend> blockedFriends = user.getListOfBlockedFriends();
        ArrayList<Friend> friends = user.getListOfFriends();
        
        ArrayList<String> excludedIds = new ArrayList<>();
        for (Friend excludedfriends : blockedFriends) {
            excludedIds.add(excludedfriends.getUserId());
        }
        for(Friend excludedFriends : friends)
        {
            excludedIds.add(excludedFriends.getUserId());
        }
        excludedIds.add(user.getUserId()); // exclude the user themselves
        
        for (User allUser : allUsers) {
                if(!excludedIds.contains(allUser.getUserId()))
                 // check if this user in the database is one of the friends or one of the blocked don't add to suggestions
                {
                    suggestions.add(new Friend(allUser.getEmail(), allUser.getUsername(), allUser.getUserId())); // if user isn't friend add to suggestions
                }
        }
        return suggestions;
    }
    
    public void blockFriend(User user, Friend blockFriend)// moving the friend from the friends list to the blocked list
    {
        user.addBlockedFriends(blockFriend);
        FileManagement.saveInUsersJSONfile();
    }
    
    public void removeFriend(User user,Friend friend){
        user.removeFriend(friend);
        FileManagement.saveInUsersJSONfile();
    }
    
    public void unblockFriend(User user, Friend blockedFriend) // function for unblocking someone
    {                                                          // can be added to suggestions and searched for
        user.removeBlockedFriend(blockedFriend);
    }
    
    public Boolean displayFriendStatus(User user,Friend friend){
        
        if(user.getListOfFriends().contains(friend))
        {
            for (User allUser : allUsers) 
            {
                if(allUser.getUserId().equals(friend.getUserId()))
                {
                    return allUser.getStatus();// true == online
                }                              // false == offline
            }
        }
        return null;
    }
        
}
