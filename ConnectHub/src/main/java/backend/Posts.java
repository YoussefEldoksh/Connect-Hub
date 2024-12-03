/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.LocalDate;

/**
 *
 * @author dell
 */
public class Posts extends Content{
    
    public Posts(String contentID, String authorID, String content, LocalDate timestamp) {
        super(contentID, authorID, content, timestamp);
    }
    
}
