/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author malak
 */
public class Content {

    private String contentID;
    private String authorID;
    private String content;
    private LocalDateTime timestamp;

    public Content(String contentID, String authorID, String content) {
        this.contentID = contentID;
        this.authorID = authorID;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static Posts createPost(String contentID, String authorID, String content) {
        Posts newPost = new Posts(contentID, authorID, content, LocalDateTime.now());
        return newPost;
    }

    public static Stories createStory(String contentID, String authorID, String content) {
        Stories newStory = new Stories(contentID, authorID, content, LocalDateTime.now());
        return newStory;
    }
    
    public static void deleteStory()
    {
    }
    
    public static void deletePost()
    {
    }
    
    public static void readPosts()
    {
    
    }
    
    public static void readStories()
    {}
    
    public static void savePosts()
    {}
    
    public static void saveStories()
    {}

}
