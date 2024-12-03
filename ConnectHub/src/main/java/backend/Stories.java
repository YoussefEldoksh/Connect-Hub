/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author dell
 */
public class Stories extends Content {
    
    public Stories(String contentID, String authorID, String content, LocalDate timestamp) {
        super(contentID, authorID, content, timestamp);
    }
    
    public static void expiredStory(Stories story)
    {
    
    
    }
}
