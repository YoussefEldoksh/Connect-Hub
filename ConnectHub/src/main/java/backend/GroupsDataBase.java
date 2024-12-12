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
    private static GroupsDataBase groupdatabase = null;
    private static boolean isLoading = false;
    
    private GroupsDataBase() {
        if (isLoading) {
            throw new IllegalStateException("DataBase is already being initialized!");
        }
        isLoading = true;
        //loadAllFiles(); 
        isLoading = false;
    }
    
    public  synchronized void addToGlobalGroups(Group group){}
     
    public synchronized ArrayList<Group> getAllGroups(){
    return groups;
    }
    
    public synchronized Group getSpecificGroup(String groupId) {
        ArrayList<Group> groups = getAllGroups();
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getGroupID().equals(groupId)) {
                return groups.get(i);
            }
        }
        return null;
    }
    
    public synchronized void removeFromGlobalGroups(Group group){}
    
    public static GroupsDataBase getInstance() {
        if (groupdatabase == null) {
            groupdatabase = new GroupsDataBase(); 
        }
        return groupdatabase;
    }
}
