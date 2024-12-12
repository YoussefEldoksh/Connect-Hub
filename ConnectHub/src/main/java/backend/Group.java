/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author malak
 */
public class Group {
    
    private static ArrayList<Group> listOfGroups;
    private static ArrayList<GroupRequests> requests;
    private String groupID;
    private String groupName;
    private String groupDescription;
    private String groupCreator;  //ID of creator
    private String groupPhotoPath;
    private ImageIcon groupPhotoIcon;
    private ArrayList<String> groupAdmins; //ID of admin
    private ArrayList<String> groupMembers; //ID of member
    private ArrayList<Posts> groupPosts;

    public Group(String groupID, String groupName, String groupDescription, String groupCreatorUsername, ArrayList<String> groupAdmins, ArrayList<String> groupMembers, ArrayList<Posts> groupPosts) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.groupCreator = groupCreatorUsername;
        this.groupPhotoPath = null;
        this.groupPhotoIcon = null;
        this.groupAdmins = groupAdmins;
        this.groupMembers = groupMembers;
        this.groupPosts = groupPosts;
        listOfGroups.add(this);
    }

    public String getGroupID() {
        return groupID;
    }

    
    public void setGroupPhotoPath(String groupPhotoPath) {
        this.groupPhotoPath = groupPhotoPath;
    }

    public void setGroupPhotoIcon(ImageIcon groupPhotoIcon) {
        this.groupPhotoIcon = groupPhotoIcon;
    }

    public void setGroupCreator(String groupCreator) {
        this.groupCreator = groupCreator;
    }
    

    public void addUserToGroup(String userToJoinId) 
    {
        for(int i=0; i< groupMembers.size(); i++)
            if(groupMembers.get(i).equals(userToJoinId))
            {System.out.println("User already a member of the group");
            return;
            }
        groupMembers.add(userToJoinId);
    }
    
    public void removeUserFromGroup(String userToRemoveId) // for removing and leaving
    {
        //check first if userId is a group member
        for (int i = 0; i < groupMembers.size(); i++) {
            if (groupMembers.get(i).equals(userToRemoveId)) {
                //check if userId is an admin
                for (int j = 0; j < groupAdmins.size(); j++) {
                    if (groupAdmins.get(i).equals(userToRemoveId)) {
                        groupAdmins.remove(userToRemoveId);
                        System.out.println("User is no longer a member of the group");
                        //check if userId is the group creator
                        if (groupCreator.equals(userToRemoveId)) {
                            int k= j++;
                            this.setGroupCreator(groupAdmins.get(k));
                            System.out.println("The user you are trying to remove is the creator of the group.");
                            System.out.println("The new Creator of the group is " + AccountManagement.findUsername(groupAdmins.get(k)));
                        }
                        //exit loop if found
                        break;
                    }
                }
                groupMembers.remove(userToRemoveId);
                System.out.println("User is no longer a member of the group");
                return;
            }
        }
    }
    
    public void promoteMemberToAdmin(String userId){}
    
    public void demoteAdminToMember(String userId){}
    
    public void editPost(String postId){}
    
    public void addPost(Posts post){}
    
    public void deletePost(String postId){}
    
    //most probably should be somewhere else
    public void deleteGroup(){
     listOfGroups.remove(this);
    }
    
}
