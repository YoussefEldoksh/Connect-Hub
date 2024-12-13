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
public class NotificationFriendReq extends Notification{
    
    
    private String recieverId;
    private String senderId;

    public NotificationFriendReq(String recieverId, String senderId, String id, String type, String message, LocalDateTime time) {
        super(id, type, message, time);
        this.recieverId = recieverId;
        this.senderId = senderId;
    }

    public String getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(String recieverId) {
        this.recieverId = recieverId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
    
        public static String lineRepresentation(String requester){
        
        //requester could be changed to be username not id
        return requester+" has requested to add you as a friend";
        
    }
}
