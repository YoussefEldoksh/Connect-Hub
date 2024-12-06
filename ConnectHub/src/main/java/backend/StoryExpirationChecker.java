/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import static backend.Stories.isExpiredStory;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class StoryExpirationChecker implements Runnable {
    private ArrayList<Stories> stories;

    public StoryExpirationChecker(ArrayList<Stories> stories) {
        this.stories = stories;
    }

    @Override
    public void run() {
    stories=  DataBase.getGlobalStories(); 
    ArrayList<Stories> updated= new ArrayList();
     
     for(Stories s: stories)
     {
     if(!isExpiredStory(s))
     {
         updated.add(s);
         DataBase.addTOGlobalStories(s);
     }
     }  
    }

}
