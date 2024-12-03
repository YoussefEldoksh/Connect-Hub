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
    ArrayList<User> allUsers = FileManagement.loadFromJSONfile();
    
    public void friendRequest(boolean accept, User user, Friend friend, boolean rejected)
    {
      if(user.getListOfFriendReq().contains(friend))// if the request is already made don't added it again to the array
      {
          user.addFriendsReq(friend);
      }
       
       if(!(user.getListOfFriends().contains(friend)) && !(user.getListOfBlockedFriends().contains(friend)))
       {
            if(accept == true) 
            {
                user.addFriends(friend);
                user.removeFriendReq(friend);
            }
            else if(accept == false &&  rejected == true)
            {
                user.removeFriendReq(friend);//this means that the request if rejected
            }

            //else the request is still pending
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
        user.removeFriend(blockFriend);
        user.addBlockedFriends(blockFriend);
    }
    
    public void removeFriend(User user,Friend friend){
        user.removeFriend(friend);
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
