/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;



import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
   
   @Override
   public void delete(String contentID) //not expired user chooses to delete it
    {
     ArrayList<Stories> stories;
     
        stories = DataBase.getGlobalStories();
     ArrayList<Stories> updated= new ArrayList();
     
     for(Stories s: stories)
     {
    if(s.getContentID() != contentID)
     {
         updated.add(s);
         DataBase.addTOGlobalStories(s);
     }
     }  
    }
 
   public ArrayList<Stories> readStoryForUser(String userID) {
        ArrayList<Stories> x = DataBase.getGlobalStories();
        ArrayList<Stories> y = new ArrayList<>();
        for (Stories story : x) {
            if (story.getAuthorID() == userID) {
                y.add(story);
            }
        }
        return y;
    }
   
}
