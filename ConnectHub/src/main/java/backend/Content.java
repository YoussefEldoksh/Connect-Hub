/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.time.Duration;
import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
 *
 * @author malak
 */
public abstract class Content {

    private String contentID;
    private String authorID;
    private ImageIcon image;
    private String imagePath;
    private String content;
    private LocalDateTime timestamp;

    public Content(String contentID, String authorID, String content) {
        this.contentID = contentID;
        this.authorID = authorID;
        this.content = content;
        this.image= null;
        this.imagePath=null;
        this.timestamp = LocalDateTime.now();
    }

    
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // Method to check if the image is null
    public boolean hasImage() {
        return image != null;
    }
    
    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public abstract void delete(String contentID);

}
