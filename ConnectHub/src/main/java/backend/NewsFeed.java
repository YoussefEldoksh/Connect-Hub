/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.format.DateTimeFormatter;
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
            if (FriendManagement.displayFriendStatus(user, userFriend)) {
                friends.add(userFriend.getUsername() + " " + "ONLINE");
            } else {
                friends.add(userFriend.getUsername() + " " + "OFFLINE");
            }
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
    
    public static void createPost(User user,String contentID,String content, String imagePath )
    {
        Posts post = new Posts(contentID, user.getUserId(), content, ImageHandler.saveImage(imagePath), imagePath);
        user.addPost(post);
        DataBase.getInstance().addToGlobalPosts(post);
    }
    
    public static ArrayList<String> getLineRepresentationsStories(User u) {
        ArrayList<Stories> stories = fetchStories(u);
        ArrayList<String> lineRepresentations = new ArrayList<>();
        for (int i = 0; i < stories.size(); i++) {
            String username = AccountManagement.findUsername(stories.get(i).getAuthorID());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // Convert LocalDate to String
            String formattedDate = stories.get(i).getTimestamp().format(formatter);
            String s = username + "published on: " + formattedDate;
            lineRepresentations.add(s);
        }
        return lineRepresentations;
    }
    
       public static ArrayList<String> getLineRepresentationsAllStories(User user) {
        ArrayList<String> lineRepresentations = new ArrayList<>();
        ArrayList<String> friendsId = new ArrayList<>();
        
            for (Friend friend : user.getListOfFriends()) {
                friendsId.add(friend.getUserId());
               
            }
         friendsId.add(user.getUserId());
        for (int i = 0; i < DataBase.getInstance().getGlobalStories().size(); i++) {
           
            if(friendsId.contains(DataBase.getInstance().getGlobalStories().get(i).getAuthorID()))
            { String username = AccountManagement.findUsername(DataBase.getInstance().getGlobalStories().get(i).getAuthorID());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // Convert LocalDate to String
            String formattedDate = DataBase.getInstance().getGlobalStories().get(i).getTimestamp().format(formatter);
            String s = username + " published on: " + formattedDate;
            lineRepresentations.add(s);
            }
        }
           System.out.println(lineRepresentations);
        return lineRepresentations;
    }
    public static ArrayList<String> getLineRepresentationsAllPosts(User u) {
      ArrayList<String> lineRepresentations = new ArrayList<>();
        ArrayList<String> friendsId = new ArrayList<>();
        
            for (Friend friend : u.getListOfFriends()) {
                friendsId.add(friend.getUserId());
            }
        
        for (int i = 0; i < DataBase.getInstance().getGlobalPosts().size(); i++) {
           
            if(friendsId.contains(DataBase.getInstance().getGlobalPosts().get(i).getAuthorID()))
            { String username = AccountManagement.findUsername(DataBase.getInstance().getGlobalPosts().get(i).getAuthorID());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // Convert LocalDate to String
            String formattedDate = DataBase.getInstance().getGlobalPosts().get(i).getTimestamp().format(formatter);
            String s = username + "published on: " + formattedDate;
            lineRepresentations.add(s);
            }
        }
        return lineRepresentations;
    }

    public static ArrayList<String> getLineRepresentationsPosts(User u) {
        ArrayList<Posts> posts = fetchPosts(u);
        ArrayList<String> lineRepresentations = new ArrayList<>();
        for (int i = 0; i < posts.size(); i++) {
            String username = AccountManagement.findUsername(posts.get(i).getAuthorID());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // Convert LocalDate to String
            String formattedDate = posts.get(i).getTimestamp().format(formatter);
            String s = username + "published on: " + formattedDate;
            lineRepresentations.add(s);
        }
        return lineRepresentations;
    }
    
    
}



