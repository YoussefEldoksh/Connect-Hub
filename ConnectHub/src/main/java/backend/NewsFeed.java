/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 *
 * @author malak
 */
public class NewsFeed {

    public static ArrayList<Posts> fetchPosts(User user)
    {
        ArrayList<Posts> posts = new ArrayList<>();
        ArrayList<String> friends = new ArrayList<>();
        for (Friend friend : user.getListOfFriends()) {
            friends.add(friend.getUserId());
        }
        for (User allusers : DataBase.getInstance().getUsers()) {
            if(friends.contains(allusers.getUserId()))
            {
                ArrayList<Posts> friendPosts = allusers.getUserPosts();
                if (friendPosts != null) {
                 posts.addAll(friendPosts); // Add all posts from this friend
                 }
            }
        }
        return sortPosts(posts);
    }
    
    public static ArrayList<Stories> fetchStories(User user)
    {
        ArrayList<Stories> stories = new ArrayList<>();
        ArrayList<String> friends = new ArrayList<>();
        for (Friend friend : user.getListOfFriends()) {
            friends.add(friend.getUserId());
        }
        for (User allusers :  DataBase.getInstance().getUsers()) {
            if(friends.contains(allusers.getUserId()))
            {
                ArrayList<Stories> friendStories = allusers.getUserStories();
                if (friendStories != null) {
                 stories.addAll(friendStories); // Add all Stories from this friend
                 }
            }
        }
     
        return sortStories(stories);
    }
    
    public static ArrayList<String> fetchFriends(User user) // fetching an array list of friends in the String format for display
    {
        ArrayList<String> friends = new ArrayList<>();
        ArrayList<Friend> userFriends = user.getListOfFriends();
        int i = 0;
        for (Friend userFriend : userFriends) {
            if(FriendManagement.displayFriendStatus(user, userFriend))
            friends.add(userFriend.getUserId() + " " + "ONLINE");
            else
            friends.add(userFriend.getUserId() + " " + "OFFLINE");
        }
        return friends;
    }
    
    public static ArrayList<Posts> sortPosts(ArrayList<Posts> posts)
    {
        boolean swapped;
        
        for(int i = 0; i < posts.size(); i++) {
            swapped = false;
            for(int j = i; j < posts.size(); j++) {
                if(posts.get(j).getTimestamp().isBefore(posts.get(j+1).getTimestamp()))
                {
                   Posts temp = posts.get(j);
                   posts.set(j, posts.get(j + 1));
                   posts.set(j + 1, temp);
                   swapped=true; 
                   
                }
            }
            if(swapped == false)
            {
                break;
            }
        }
        return posts;
    }
    
    public static ArrayList<Stories> sortStories(ArrayList<Stories> stories)
    {
        boolean swapped;
        
        for(int i = 0; i < stories.size(); i++) {
            swapped = false;
            for(int j = i; j < stories.size(); j++) {
                if(stories.get(j).getTimestamp().isBefore(stories.get(j+1).getTimestamp()))
                {
                   Stories temp = stories.get(j);
                   stories.set(j, stories.get(j + 1));
                   stories.set(j + 1, temp);
                   swapped=true;
                   
                }
            }
            if(swapped == false)
            {
                break;
            }
        }
        return stories;
    }
    
    public static void createPost(User user,String contentID,String content, ImageIcon image, String imagePath )
    {
        Posts post = new Posts(contentID, user.getUserId(), content, image, imagePath);
        user.addPost(post);
        DataBase.getInstance().addToGlobalPosts(post);
    }
    
    
}



