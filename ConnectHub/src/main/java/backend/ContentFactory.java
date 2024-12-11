/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import javax.swing.ImageIcon;

/**
 *
 * @author dell
 */
public class ContentFactory {
    public static Content createContent(String type,String contentID, String authorID,String content) {
        switch (type.toLowerCase()) {
            case "post":
                return new Posts(contentID,authorID,content); 
            case "story":
                return new Stories(contentID,authorID,content); 
            default:
                throw new IllegalArgumentException("Unknown content type: " + type);
        }
}
}
