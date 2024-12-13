/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;


import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author malak
 */
public class NotificationGroupAdd extends Notification{
    private String groupId;
    private String requesterId;

    public NotificationGroupAdd(String groupId,String requesterId, String id, String type, LocalDateTime time) {
        super(id, type, lineRepresentation(groupId,requesterId), time);
        this.requesterId=requesterId;
        this.groupId = groupId;
    }
    
    public static String lineRepresentation(String groupId,String requester){
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
        //requester could be changed to be username not id
        return requester+" requested to join Group:"+group1.getGroupName();

       
    }
    
    
    
    
    
}
