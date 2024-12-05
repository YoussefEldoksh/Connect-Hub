/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;



import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
 *
 * @author dell
 */
public class Stories extends Content {

    public Stories(String contentID, String authorID, String content, ImageIcon image, String imagePath) {
        super(contentID, authorID, content, image, imagePath);
    }
    
  public static boolean isExpiredStory(Stories story)
    {
        // check if story passed 24hours
    LocalDateTime timeAgo = LocalDateTime.now().minusHours(24); //instance 24 hours ago
    if(story.getTimestamp().isEqual(timeAgo)||story.getTimestamp().isBefore(timeAgo))
        return true;
    else
        return false;
    }
    
   public static void expiredStory(User user)
    {
     FileManagement storiesFile= new FileManagement();
     ArrayList<Stories> stories;
        stories = storiesFile.loadFromStroiesJsonFile(user);
     ArrayList<Stories> updated= new ArrayList();
     
     for(Stories s: stories)
     {
     if(!isExpiredStory(s))
     {
         updated.add(s);
     }
     storiesFile.saveToStoriesJsonFile(user);
     }
    }
}
