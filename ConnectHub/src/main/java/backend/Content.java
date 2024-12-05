/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
 *
 * @author malak
 */
public class Content {

    private String contentID;
    private String authorID;
    private ImageIcon image;
    private String imagePath;
    private String content;
    private LocalDateTime timestamp;

    public Content(String contentID, String authorID, String content, ImageIcon image, String imagePath) {
        this.contentID = contentID;
        this.authorID = authorID;
        this.content = content;
        this.image= image;
        this.imagePath=imagePath;
        this.timestamp = LocalDateTime.now();
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // Method to check if the image is null
    public boolean hasImage() {
        return image != null;
    }
    
    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
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
    

    public static void deleteStory(String contentID) //not expired user chooses to delete it
    {
     ArrayList<Stories> stories;
     
        stories = FileManagement.loadFromStroiesJsonFile();
     ArrayList<Stories> updated= new ArrayList();
     
     for(Stories s: stories)
     {
    if(s.getContentID() != contentID)
     {
         updated.add(s);
     }
     FileManagement.saveToStoriesJsonFile();
     }  
    }
    
    public static void deletePost(String contentID)
    {
     ArrayList<Posts> posts;
        posts = FileManagement.loadFromPostsJsonFile();
     ArrayList<Posts> updated= new ArrayList();
     
     for(Posts p: posts)
     {
     if(!p.getContentID().equals(contentID))
     {
         updated.add(p);
     }
     FileManagement.saveToStoriesJsonFile();
     }
    }
     public static ArrayList<Posts> readPostForUser(String userID) {
        FileManagement postsFile= new FileManagement();
        ArrayList<Posts> x = FileManagement.loadFromPostsJsonFile();
        ArrayList<Posts> y = new ArrayList<>();
        for (Posts post : x) {
            if (post.getAuthorID() == userID) {
                y.add(post);
            }
        }
        return y;
    }
  
 public static ArrayList<Stories> readStoryForUser(String userID) {
        ArrayList<Stories> x = FileManagement.loadFromStroiesJsonFile();
        ArrayList<Stories> y = new ArrayList<>();
        for (Stories story : x) {
            if (story.getAuthorID() == userID) {
                y.add(story);
            }
        }
        return y;
    }


}
