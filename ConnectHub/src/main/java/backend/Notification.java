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
public abstract class Notification {
    private String id;
    private String type;
    private String message;
    private LocalDateTime time;

    public Notification(String id, String type, String message, LocalDateTime time) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }
    
    
    
    
    
}
