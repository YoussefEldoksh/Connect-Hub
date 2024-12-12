/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author dell
 */
public class Posts extends Content{

    String groupID;
    public Posts(String contentID, String authorID, String content) {
            super(contentID, authorID, content);
            this.groupID = null;
    }

    public Posts(String groupID, String contentID, String authorID, String content) {
        super(contentID, authorID, content);
        this.groupID = groupID;
    }

    public String getGroupID() {
        return groupID;
    }

  
    @Override
   public void delete(String contentID)
    {
     ArrayList<Posts> posts;
        posts = DataBase.getInstance().getGlobalPosts();
     ArrayList<Posts> updated= new ArrayList();
     
     for(Posts p: posts)
     {
     if(!p.getContentID().equals(contentID))
     {
         updated.add(p);
         DataBase.getInstance().addToGlobalPosts(p);
     }
     }
    }
  
     public static ArrayList<Posts> readPostForUser(String userID) {
        ArrayList<Posts> x = DataBase.getInstance().getGlobalPosts();
        ArrayList<Posts> y = new ArrayList<>();
        for (Posts post : x) {
            if (post.getAuthorID() == userID) {
                y.add(post);
            }
        }
        return y;
    }
   
}
