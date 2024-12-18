/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author pc castle
 */
public class GroupsDataBase {

    private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<Posts> posts = new ArrayList<>();
    private ArrayList<GroupRequests> grouprequests = new ArrayList<>();

    private static GroupsDataBase groupdatabase = null;
    private static boolean isLoading = false;

    private GroupsDataBase() {
        if (isLoading) {
            throw new IllegalStateException("DataBase is already being initialized!");
        }
        isLoading = true;
        loadAllFiles();
        isLoading = false;
    }

    public static GroupsDataBase getInstance() {
        if (groupdatabase == null) {
            groupdatabase = new GroupsDataBase();
        }
        return groupdatabase;
    }

    public synchronized void addToGlobalGroups(Group group) {
        groups.add(group);
        FileManagement.saveToGroupsJsonFile();
    }

    public synchronized void addToGlobalGroupsPosts(Posts post) {
        posts.add(post);
        FileManagement.saveToGroupsPostsJsonFile();
    }

    public synchronized void removeFromGlobalGroupsPosts(Posts post) {
        posts.remove(post);
        FileManagement.saveToGroupsPostsJsonFile();
    }

    public synchronized void addToGlobalGroupRequests(GroupRequests request) {
        grouprequests.add(request);
        FileManagement.saveToGroupRequestsJsonFile();
    }

    public synchronized void removeFromGlobalGroupRequests(GroupRequests request) {
        grouprequests.remove(request);
        FileManagement.saveToGroupRequestsJsonFile();
    }

    public synchronized ArrayList<Group> getAllGlobalGroups() {
        return groups;
    }

    public synchronized ArrayList<Posts> getAllGlobalGroupsPosts() {
        return posts;
    }

    public synchronized void setAllGlobalGroupsPosts(ArrayList<Posts> posts) {
        this.posts = posts;
    }

    public synchronized ArrayList<GroupRequests> getAllGlobalGroupRequests() {
        return grouprequests;
    }

    public synchronized Group getSpecificGroup(String groupId) {
        ArrayList<Group> groups = getAllGlobalGroups();
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getGroupID().equals(groupId)) {
                return groups.get(i);
            }
        }
        return null;
    }

    public GroupRequests getGroupRequest(String userMakingReqId, String groupId) {
        for (int i = 0; i < grouprequests.size(); i++) {
            if (grouprequests.get(i).getGroupId().equals(groupId) && grouprequests.get(i).getUserMakingReqId().equals(userMakingReqId)) {
                return grouprequests.get(i);
            }

        }
        return null;
    }

    public synchronized void removeFromGlobalGroups(Group group) {
        groups.remove(group);
    }

    public void loadAllFiles() {
        this.grouprequests.clear();
        this.posts.clear();
        this.groups.clear();

        this.grouprequests = FileManagement.loadFromGroupRequestsJsonFile();
        this.posts = FileManagement.loadAllFromGroupsPostsJsonFile();
        this.groups = FileManagement.loadFromGroupsJsonFile();
    }

    public Group getGroupByName(String key) {
        for (Group group : this.groups) {
            if (group.getGroupName().equals(key)) {
                return group;
            }
        }
        return null;
    }

}
