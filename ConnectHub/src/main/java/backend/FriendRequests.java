/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author malak
 */
public class FriendRequests {
   private String email;
    private String username;
    private String userId;
    private String receiver;
    
        public FriendRequests(String email, String username, String userId, String receiver) {
        this.email = email;
        this.username = username;
        this.userId = userId;
        this.receiver = receiver;
    }

   public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    
    /*public boolean contains(ArrayList<FriendRequests>requests,String id){
        for(FriendRequests request:requests){
            if(request.getUserId().equals(id)){
                return true;
            }
        }
        return false;
    }*/
    
    
    


}

    
