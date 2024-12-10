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
public class NotificationGroupAdd extends Notification{
    private String groupId;

    public NotificationGroupAdd(String groupId, String id, String type, String message, LocalDateTime time) {
        super(id, type, message, time);
        this.groupId = groupId;
    }
    
    
    
    
    
    
}
