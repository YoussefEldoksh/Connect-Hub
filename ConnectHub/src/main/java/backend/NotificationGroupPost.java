/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.LocalDateTime;

/**
 *
 * @author malak
 */
public class NotificationGroupPost extends Notification{
    private String groupId;
    private String postId;
    

    public NotificationGroupPost(String groupId, String postId, String id, String type, LocalDateTime time,String poster) {
        super(id, type, lineRepresentation(groupId,postId,poster), time);
        this.groupId = groupId;
        this.postId = postId;
    }
    
    public static String lineRepresentation(String groupId ,String postId ,String poster){
        Group group1=null;
        for(Group group:DataBase.getInstance().getGroups()){
            if(group.getGroupID().equals(groupId)){
                group1=group;
                break;
            }
        }
        if(group1==null){
            return null;
        }
        Content post1=null;
        for(Content post:DataBase.getInstance().getGlobalPosts()){
            if(post.getContentID().equals(postId)){
                post1=post;
                break;
            }
        }
        if(post1==null){
            return null;
        }
        if(post1 instanceof Posts){
            return poster+" has posted a new Post in group:"+group1.getGroupName();
        }
        else{
            return poster+" has posted a new Story in group:"+group1.getGroupName();
        }
       
    }
    
}
