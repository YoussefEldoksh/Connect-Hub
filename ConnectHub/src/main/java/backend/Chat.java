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
public class Chat {
    private String chatId;
    private ArrayList<Message> chatMessages = new ArrayList<>();

    public Chat(String chatId,ArrayList<Message> chatMessages ) {
        this.chatId = chatId;
        this.chatMessages = chatMessages;
    }

    public Chat(String chatId) {
        this.chatId = chatId;
    }
    
    

    public String getChatId() {
        return chatId;
    }

    public ArrayList<Message> getChatMessages() {
        return chatMessages;
    }
    
    public ArrayList<Message> getChatMessagesAfter(LocalDateTime lastMessageTime) {
    ArrayList<Message> newMessages = new ArrayList<>();
    for (Message message : this.getChatMessages()) {
        if (lastMessageTime == null || message.getTimeSent().isAfter(lastMessageTime)) {
            newMessages.add(message);
        }
    }
    return newMessages;
}

    public void AddChatMessages(Message newMessage) {
       
        if(newMessage==null)
        {
            System.out.println("can't add a null message");
            return;
        }
        
        this.chatMessages.add(newMessage);
        
    }
    
    
}
