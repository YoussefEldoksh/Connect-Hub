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
    private static User currentUser;
    
    public static User getCurrentUser() {
        return currentUser;
    }
    
    public static void setCurrentUser(User user) {
        currentUser = user;
    }
}
