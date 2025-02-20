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

    private String groupID;
    private String groupName;
    private String groupDescription;
    private String groupCreator;  //ID of creator
    private String groupPhotoPath;
    private ImageIcon groupPhotoIcon;
    private ArrayList<String> groupAdmins = new ArrayList<>(); //ID of admin
    private ArrayList<String> groupMembers = new ArrayList<>(); //ID of member
    private ArrayList<Posts> groupPosts = new ArrayList<>();
    private  ArrayList<GroupRequests> requests = new ArrayList<>();

    public Group(String groupID, String groupName, String groupDescription, String groupCreator, String groupPhotoPath) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.groupCreator = groupCreator;

        if (groupPhotoPath == null) {
            this.groupPhotoPath = "/Images/background.jpg";
            this.groupPhotoIcon = new ImageIcon(getClass().getResource("/Images/background.jpg"));
        } else {
            this.groupPhotoPath = groupPhotoPath;
            this.groupPhotoIcon = new ImageIcon(getClass().getResource(groupPhotoPath));
        }
        requests = FileManagement.loadFromGroupRequestsJsonFileForSpecificGroup(groupID);
        groupPosts = FileManagement.loadFromPostsJsonFileForSpecificGroup(groupID);
        
    }

    public String getGroupID() {
        return groupID;
    }

    public  ArrayList<GroupRequests> getRequests() {
        return requests;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public String getGroupCreator() {
        return groupCreator;
    }

    public String getGroupPhotoPath() {
        return groupPhotoPath;
    }

    public ImageIcon getGroupPhotoIcon() {
        return groupPhotoIcon;
    }

    public ArrayList<String> getGroupAdmins() {
        return groupAdmins;
    }

    public ArrayList<String> getGroupMembers() {
        return groupMembers;
    }

    public ArrayList<Posts> getGroupPosts() {
        return groupPosts;
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

    public void setGroupMembers(ArrayList<String> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public void setGroupPosts(ArrayList<Posts> groupPosts) {
        this.groupPosts = groupPosts;
    }

    //only for filemanagement
    public void addGroupMember(String groupMember) {
        groupMembers.add(groupMember);
    }

    public void addGroupAdmin(String groupAdmin) {
        groupAdmins.add(groupAdmin);
        
    }

    //when this is called, database method addToGlobalPosts should also be called
    public void addGroupPosts(Posts groupPost) {
        groupPosts.add(groupPost);
    }

    //called when request is accepted
    public void addUserToGroup(String userToJoinId) {
        for (int i = 0; i < groupMembers.size(); i++) {
            if (groupMembers.get(i).equals(userToJoinId)) {
                System.out.println("User already a member of the group");
                return;
            }
        }
        groupMembers.add(userToJoinId);
        AccountManagement.findUserUsingId(userToJoinId).addToGroups(this);
    }
    
     public void addUserToGroupRequests(String userToJoinId) {
        for (int i = 0; i < requests.size(); i++) {
         
            if (requests.contains(userToJoinId)) {
                System.out.println("Request already made");
                return;
            }
        }
        GroupRequests gr= GroupManagement.getGroupRequest(userToJoinId, this.getGroupID());
        requests.add(gr);
        AccountManagement.findUserUsingId(userToJoinId).addToGroupRequestsOfUser(gr);
    }

    //creator can remove anyone and also himself
    public void removeUserFromGroupByCreator(String userToRemoveId) // for removing and leaving
    {
        //remove group from suggestions list of this user and all posts from newsfeed
        //check first if userId is a group member
        for (int i = 0; i < groupMembers.size(); i++) {
            if (groupMembers.get(i).equals(userToRemoveId)) {
                //check if userId is an admin
                for (int j = 0; j < groupAdmins.size(); j++) {
                    if (groupAdmins.get(j).equals(userToRemoveId)) {
                        groupAdmins.remove(userToRemoveId);
                        System.out.println("User is no longer a member of the group");
                        //check if userId is the group creator
                        if (groupCreator.equals(userToRemoveId)) {
                            int k = ++j;
                            this.setGroupCreator(groupAdmins.get(k));
                            System.out.println("The user you are trying to remove is the creator of the group.");
                            System.out.println("The new Creator of the group is " + AccountManagement.findUsername(groupAdmins.get(k)));
                        }
                        //exit loop if found
                        break;
                    }
                }
                groupMembers.remove(userToRemoveId);
                AccountManagement.findUserUsingId(userToRemoveId).removeFromsGroupsOfUser(this);
                FileManagement.saveToGroupsJsonFile();

                System.out.println("User is no longer a member of the group");
                return;
            }
        }
    }

    //admins can remove normal members but not other admins
    public boolean removeUserFromGroupByAdmin(String userToRemoveId) // for removing and leaving
    {
        //remove group from suggestions list of this user and all posts from newsfeed
        //check first if userId is a group member
        for (int i = 0; i < groupMembers.size(); i++) {
            if (groupMembers.get(i).equals(userToRemoveId)) {
                //check if userId is an admin
                for (int j = 0; j < groupAdmins.size(); j++) {
                    if (groupAdmins.get(j).equals(userToRemoveId)) {
                        System.out.println("Admins can't remove other admins. Only the creator of the group can");
                        return false;
                    }
                }
                groupMembers.remove(userToRemoveId);

                AccountManagement.findUserUsingId(userToRemoveId).removeFromsGroupsOfUser(this);
                FileManagement.saveToGroupsJsonFile();
                System.out.println("User is no longer a member of the group");
                return true;
            }
        }
        return false;
    }

    //called when request is accepted or declined
    public void removeGroupRequest(String userToRemoveId) {
        GroupRequests gr= GroupManagement.getGroupRequest(userToRemoveId, this.getGroupID());
        AccountManagement.findUserUsingId(userToRemoveId).removeFromsGroupRequestsOfUser(gr);
        FileManagement.saveToGroupRequestsJsonFile();

        requests.remove(gr);
    }

    public void promoteMemberToAdmin(String userId) {
        groupAdmins.add(userId);
        FileManagement.saveToGroupsJsonFile();

        System.out.println("Congratulations. You are now an admin in the group");
    }

    public void acceptRequest(String userId, boolean accept) {
        if (AccountManagement.findUser(userId) == null) {
            System.out.println("The user does not exist");
        }
        if (accept == true) {
            //remove from requests
            this.removeGroupRequest(userId);
            this.addUserToGroup(userId);
            GroupsDataBase.getInstance().removeFromGlobalGroupRequests(GroupsDataBase.getInstance().getGroupRequest(userId, this.getGroupID()));
        } else if (accept == false) {
            this.removeGroupRequest(userId);
            GroupsDataBase.getInstance().removeFromGlobalGroupRequests(GroupsDataBase.getInstance().getGroupRequest(userId, this.getGroupID()));
            //remove also from requests if it was declined
        }
        FileManagement.saveToGroupsJsonFile();
    }

    public void demoteAdminToMember(String userId) {
        groupAdmins.remove(userId);
        System.out.println("User is no longer an admin");
    }
   
    public void reload()
    {
        requests.clear();
        requests = FileManagement.loadFromGroupRequestsJsonFileForSpecificGroup(groupID);
    }
    
    public void editPost(String postId) {
    }

    public void addPost(Posts post) {
    }

    public void deletePost(String postId) {
    }

    public ArrayList<String> getGroupMembersWithoutAdmins() {
        ArrayList<String> membersNotAdmins = new ArrayList<>();
        for (String member : getGroupMembers()) {
            // Check if the member is not in the admins list
            if (!getGroupAdmins().contains(member)) {
                membersNotAdmins.add(member);
            }
            if (!getGroupCreator().equals(member)) {
                membersNotAdmins.add(member);
            }
        }
        return membersNotAdmins;

    }
    
    public boolean checkIfUserIsAdmin(String userId) {
        for (int i = 0; i < getGroupAdmins().size(); i++) {
            if (getGroupAdmins().get(i).equals(userId)) {
                return true;
            }
        }
        return false;
    }
}
