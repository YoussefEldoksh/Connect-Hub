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
public class NewsFeed {
    ArrayList<User> users = FileManagement.loadFromUsersJSONfile();
    FriendManagement friendmanager = new FriendManagement();
    public ArrayList<Posts> fetchPosts(User user)
    {
        ArrayList<Posts> posts = new ArrayList<>();
        ArrayList<String> friends = new ArrayList<>();
        for (Friend friend : user.getListOfFriends()) {
            friends.add(friend.getUserId());
        }
        for (User allusers : users) {
            if(friends.contains(allusers.getUserId()))
            {
                ArrayList<Posts> friendPosts = FileManagement.loadFromPostsJsonFile(user);
                if (friendPosts != null) {
                 posts.addAll(friendPosts); // Add all posts from this friend
                 }
            }
        }
        return posts;
    }
    
    public ArrayList<Stories> fetchStories(User user)
    {
        ArrayList<Stories> stories = new ArrayList<>();
        ArrayList<String> friends = new ArrayList<>();
        for (Friend friend : user.getListOfFriends()) {
            friends.add(friend.getUserId());
        }
        for (User allusers : users) {
            if(friends.contains(allusers.getUserId()))
            {
                ArrayList<Stories> friendStories = FileManagement.loadFromStroiesJsonFile(user);
                if (friendStories != null) {
                 stories.addAll(friendStories); // Add all Stories from this friend
                 }
            }
        }
     
        return stories;
    }
    
    public ArrayList<String> fetchFriends(User user) // fetching an array list of friends in the String format for display
    {
        ArrayList<String> friends = new ArrayList<>();
        ArrayList<Friend> userFriends = user.getListOfFriends();
        int i = 0;
        for (Friend userFriend : userFriends) {
            
            friends.add(userFriend.getUserId() + " " +friendmanager.displayFriendStatus(user, userFriend));
        }
        return friends;
    }
}
