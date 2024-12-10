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
    

    public NotificationGroupPost(String groupId, String postId, String id, String type, String message, LocalDateTime time) {
        super(id, type, message, time);
        this.groupId = groupId;
        this.postId = postId;
    }
    
    
}
