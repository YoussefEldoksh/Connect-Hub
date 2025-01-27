/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;

/**
 *
 * @author malak
 */
public class NewsFeed {

    public static ArrayList<Posts> fetchPosts(User user) {
        ArrayList<Posts> posts = new ArrayList<>();
        ArrayList<String> friends = new ArrayList<>();
        for (Friend friend : user.getListOfFriends()) {
            friends.add(friend.getUserId());
        }
        friends.add(user.getUserId());
        for (User allusers : DataBase.getInstance().getUsers()) {
            if (friends.contains(allusers.getUserId())) {
                ArrayList<Posts> friendPosts = allusers.getUserPosts();
                if (friendPosts != null) {
                    posts.addAll(friendPosts); // Add all posts from this friend
                }
            }
        }
        return sortPosts(posts);
    }

    public static ArrayList<Stories> fetchStories(User user) {
        ArrayList<Stories> stories = new ArrayList<>();
        ArrayList<String> friends = new ArrayList<>();
        for (Friend friend : user.getListOfFriends()) {
            friends.add(friend.getUserId());
        }
        friends.add(user.getUserId());
        for (User allusers : DataBase.getInstance().getUsers()) {
            if (friends.contains(allusers.getUserId())) {
                ArrayList<Stories> friendStories = allusers.getUserStories();
                if (friendStories != null) {
                    stories.addAll(friendStories); // Add all Stories from this friend
                }
            }
        }

        return sortStories(stories);
    }

    public static Stories findStoryUsingContentId(String contentId) {
        ArrayList<Stories> stories = new ArrayList<>();
        ArrayList<String> friends = new ArrayList<>();
        for (Friend friend : UserSession.getCurrentUser().getListOfFriends()) {
            friends.add(friend.getUserId());
        }
        friends.add( UserSession.getCurrentUser().getUserId());
        for (User allusers : DataBase.getInstance().getUsers()) {
            if (friends.contains(allusers.getUserId())) {
                ArrayList<Stories> friendStories = allusers.getUserStories();
            for (Stories story : friendStories) {
                // Check if the story's contentId matches the given contentId
                if (story.getContentID().equals(contentId)) {
                    return story; // Return the story if found
                }
            }
        }
    }
        return null;
    }

    public static ArrayList<Posts> fetchPostsForUser(User user) {
        ArrayList<Posts> allPosts = DataBase.getInstance().getGlobalPosts();
        ArrayList<Posts> userPosts = new ArrayList<>();
        for (Posts post : allPosts) {
            if (post.getAuthorID().equals(user.getUserId())) {
                userPosts.add(post);
            }
        }
        return NewsFeed.sortPosts(userPosts);
    }

    public static ArrayList<Stories> fetchStoriesForUser(User user) {
        ArrayList<Stories> allStories = DataBase.getInstance().getGlobalStories();
        ArrayList<Stories> userStories = new ArrayList<>();
        for (Stories story : allStories) {
            if (story.getAuthorID().equals(user.getUserId())) {
                userStories.add(story);
            }
        }
        return NewsFeed.sortStories(userStories);
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

    public static ArrayList<Posts> sortPosts(ArrayList<Posts> posts) {
        boolean swapped;
        if (posts.size() == 1 || posts.size() == 0) {
            return posts;
        }
        for (int i = 0; i < posts.size() - 1; i++) {
            swapped = false;
            for (int j = i; j < posts.size() - 1 - i; j++) {
                if (posts.get(j).getTimestamp().isBefore(posts.get(j + 1).getTimestamp())) {
                    Posts temp = posts.get(j);
                    posts.set(j, posts.get(j + 1));
                    posts.set(j + 1, temp);
                    swapped = true;

                }
            }
            if (swapped == false) {
                break;
            }
        }
        return posts;
    }

    public static ArrayList<Stories> sortStories(ArrayList<Stories> stories) {
        boolean swapped;
        if (stories.size() == 1 || stories.size() == 0) {
            return stories;
        }
        for (int i = 0; i < stories.size() - 1; i++) {
            swapped = false;
            for (int j = i; j < stories.size() - 1 - i; j++) {
                if (stories.get(j).getTimestamp().isBefore(stories.get(j + 1).getTimestamp())) {
                    Stories temp = stories.get(j);
                    stories.set(j, stories.get(j + 1));
                    stories.set(j + 1, temp);
                    swapped = true;

                }
            }
            if (swapped == false) {
                break;
            }
        }
        return stories;
    }

    /*public static void createPost(User user,String contentID,String content, String imagePath )
    {
        Posts post = new Posts(contentID, user.getUserId(), content, ImageHandler.saveImage(imagePath), imagePath);
        user.addPost(post);
        DataBase.getInstance().addToGlobalPosts(post);
    }
     */
    public static ArrayList<String> getLineRepresentationsStories(User u) {
        ArrayList<Stories> stories = fetchStoriesForUser(u);
        ArrayList<String> lineRepresentations = new ArrayList<>();
        for (int i = 0; i < stories.size(); i++) {
            String username = AccountManagement.findUsername(stories.get(i).getAuthorID());

            // Convert LocalDate to String
            String formattedDate = stories.get(i).getTimestamp().toString();
            String s = username + "published on: " + formattedDate;
            lineRepresentations.add(s);
        }

        return lineRepresentations;
    }

    public static Stories getStorybyDate(User user, LocalDateTime Date) {

        for (Stories stories : fetchStories(user)) {
            if (Date.equals(stories.getTimestamp())) {

                return stories;
            }
            System.out.println(stories.getTimestamp());
        }
        return null;
    }

    public static Posts getPostbyDate(User user, LocalDateTime Date) {

        for (Posts post : fetchPosts(user)) {
            if (Date.equals(post.getTimestamp())) {
                return post;
            }
        }
        return null;
    }

    public static ArrayList<String> getLineRepresentationsAllStories(User user) {
        // ArrayList<Stories> filteredStories = new ArrayList<>();

        ArrayList<String> lineRepresentations = new ArrayList<>();
        ArrayList<String> friendsId = new ArrayList<>();

        for (Friend friend : user.getListOfFriends()) {
            friendsId.add(friend.getUserId());

        }
        friendsId.add(user.getUserId());

        /*
    for (Stories story : DataBase.getInstance().getGlobalStories()) {
        if (friendsId.contains(story.getAuthorID())) {
            filteredStories.add(story);
        }
    }

    // Sort the filtered stories
    filteredStories = sortStories(filteredStories);

    // Generate line representations
    for (Stories story : filteredStories) {
        String username = AccountManagement.findUsername(story.getAuthorID());
        String formattedDate = story.getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String s = username + " published on: " + formattedDate;
        lineRepresentations.add(s);
    }

    return lineRepresentations;
}
         */
        for (int i = 0; i < DataBase.getInstance().getGlobalStories().size(); i++) {

            if (friendsId.contains(DataBase.getInstance().getGlobalStories().get(i).getAuthorID())) {
                String username = AccountManagement.findUsername(DataBase.getInstance().getGlobalStories().get(i).getAuthorID());
                String formattedDate = DataBase.getInstance().getGlobalStories().get(i).getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
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
        ArrayList<Posts> filteredPosts = new ArrayList<>();

        for (Friend friend : u.getListOfFriends()) {
            friendsId.add(friend.getUserId());
        }
        friendsId.add(u.getUserId());

        for (Posts post : DataBase.getInstance().getGlobalPosts()) {
            if (friendsId.contains(post.getAuthorID())) {
                filteredPosts.add(post);
            }
        }

        // Sort the filtered posts
        filteredPosts = sortPosts(filteredPosts);

        // Generate line representations
        for (Posts post : filteredPosts) {
            String username = AccountManagement.findUsername(post.getAuthorID());
            String formattedDate = post.getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            String s = username + " published on: " + formattedDate;
            lineRepresentations.add(s);
        }

        return lineRepresentations;
        /*for (int i = 0; i < DataBase.getInstance().getGlobalPosts().size(); i++) {

            if (friendsId.contains(DataBase.getInstance().getGlobalPosts().get(i).getAuthorID())) {
                String username = AccountManagement.findUsername(DataBase.getInstance().getGlobalPosts().get(i).getAuthorID());

                // Convert LocalDate to String
                String formattedDate = DataBase.getInstance().getGlobalPosts().get(i).getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                String s = username + " published on: " + formattedDate;
                lineRepresentations.add(s);
            }
        }
        return lineRepresentations;*/
    }

    public static ArrayList<String> getLineRepresentationsPosts(User u) {
        ArrayList<Posts> posts = fetchPostsForUser(u);
        ArrayList<String> lineRepresentations = new ArrayList<>();
        for (int i = 0; i < posts.size(); i++) {
            String username = AccountManagement.findUsername(posts.get(i).getAuthorID());

            // Convert LocalDate to String
            String formattedDate = posts.get(i).getTimestamp().toString();
            String s = username + "published on: " + formattedDate;
            lineRepresentations.add(s);
        }
        return lineRepresentations;
    }

}
