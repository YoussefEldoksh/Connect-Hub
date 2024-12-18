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
public class Message_Builder {

    private String recieverId;
    private String senderId;
    private String message;
    private LocalDateTime timeSent;
    private String imagePath;

    public Message_Builder setRecieverId(String recieverId) {
        this.recieverId = recieverId;
        return this;
    }

    public Message_Builder setSenderId(String senderId) {
        this.senderId = senderId;
        return this;
    }

    public Message_Builder setMessage(String message) {
        this.message = message;
        return this;

    }

    public Message_Builder setTimeSent(LocalDateTime timeSent) {
        this.timeSent = timeSent;
        return this;

    }

    public Message_Builder setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;

    }

    public Message build() {
        return new Message(recieverId, senderId, message, timeSent,imagePath);
    }

}
