/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.LocalDate;

/**
 *
 * @author malak
 */
public class Content {
   private String contentID;
   private String authorID;
   private String content;
   private LocalDate timestamp;

    public Content(String contentID, String authorID, String content, LocalDate timestamp) {
        this.contentID = contentID;
        this.authorID = authorID;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }
   
   
}
