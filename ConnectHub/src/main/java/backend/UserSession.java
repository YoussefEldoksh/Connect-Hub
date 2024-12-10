/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author husse
 */
public class UserSession {

    static User user;
    
    public UserSession(User user) {
       this.user = user;
    }
    
    public static User getCurrentUser()
    {
        return user;
    }
    
 
}

