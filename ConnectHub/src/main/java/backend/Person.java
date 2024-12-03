/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author malak
 */
public abstract class Person {
    private String email;
    private String username;
    private String userId;

    public Person(String email, String username, String userId) {
        this.email = email;
        this.username = username;
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }

    
    
    
}
