/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author malak
 */
public class Group {
    
    private String groupID;
    private String groupName;
    private String groupDescription;
    private String groupCreatorUsername;
    private String groupPhotoPath;
    private ArrayList<String> groupAdmins;
    private ArrayList<String> groupMembers;
    private ArrayList<Posts> groupPosts;

    public Group(String groupID, String groupName, String groupDescription, String groupCreatorUsername, String groupPhotoPath, ArrayList<String> groupAdmins, ArrayList<String> groupMembers, ArrayList<Posts> groupPosts) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.groupCreatorUsername = groupCreatorUsername;
        this.groupPhotoPath = groupPhotoPath;
        this.groupAdmins = groupAdmins;
        this.groupMembers = groupMembers;
        this.groupPosts = groupPosts;
    }

  
    public void addUserToGroup(String username) 
    {
        groupMembers.add(username);
    }
    public void removeUserFromGroup(User user) // for removing and leaving
    {
        groupMembers.remove(user);
    }
    
    
    
    
}
