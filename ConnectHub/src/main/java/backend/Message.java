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
public class Message {

    private String recieverId;
    private String senderId;
    private String message;
    private LocalDateTime timeSent;
    private String imagePath;

    Message(String recieverId, String senderId, String message, LocalDateTime timeSent, String imagePath) {
        this.recieverId = recieverId;
        this.senderId = senderId;
        this.message = message;
        this.timeSent = timeSent;
        this.imagePath = imagePath;
    }

    public String getRecieverId() {
        return recieverId;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeSent() {
        return timeSent;
    }

    public String getImagePath() {
        return imagePath;
    }

}
