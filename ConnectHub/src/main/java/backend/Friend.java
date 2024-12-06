/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author malak
 */
public class Friend extends Account{

     

    public Friend(String email, String username, String userId) {
        super(email,username,userId);
    }

   /* public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }*/
    
    public static Friend getFriend(String username,String friendname){
        for(Friend friend:AccountManagement.findUser(username).getListOfFriends()){
            if(friend.getUsername().equals(friendname)){
                return friend;
            }
        }
        return null;
    }
}
