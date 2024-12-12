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
public class GroupRequests {
    String userMakingReqId;
    String userMakingReqUsername;
    String groupId;

    public GroupRequests(String userMakingReqId, String groupId) {
        this.userMakingReqId = userMakingReqId;
        this.userMakingReqUsername = AccountManagement.findUsername(userMakingReqId);
        this.groupId = groupId;
    }
    
    public void acceptRequest(boolean accept) {
        if (AccountManagement.findUser(userMakingReqId) == null) {
            System.out.println("The user does not exist");
        }
        if (accept == true) {
            //remove from requests
            GroupsDataBase.getInstance().getSpecificGroup(groupId).addUserToGroup(userMakingReqId);
        }
        else if (accept == false) {
            //remove also from requests if it was declined
        }       
    }

    public String getUserMakingReqId() {
        return userMakingReqId;
    }

    public String getGroupId() {
        return groupId;
    }
    
    
}
