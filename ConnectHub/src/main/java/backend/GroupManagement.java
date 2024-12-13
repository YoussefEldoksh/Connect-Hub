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
public class GroupManagement {
    
    public static ArrayList<String> getLineRepresentationGroupAdmins(Group g){
    ArrayList<String> admins= g.getGroupAdmins();
    ArrayList<String> adminsLineRep = new ArrayList<>();
        for(int i=0; i<admins.size(); i++){
        adminsLineRep.add(AccountManagement.findUsername(admins.get(i)));
        }
    return adminsLineRep;
    }
    
    public static ArrayList<String> getLineRepresentationGroupMembers(Group g){
    ArrayList<String> members= g.getGroupMembersWithoutAdmins();
    ArrayList<String> membersLineRep = new ArrayList<>();
        for(int i=0; i<members.size(); i++){
        membersLineRep.add(AccountManagement.findUsername(members.get(i)));
        }
    return membersLineRep;
    }
    
    public static ArrayList<String> getLineRepresentationGroupRequests(Group g){
    ArrayList<GroupRequests> requests= g.getRequests();
    ArrayList<String> requestsLineRep = new ArrayList<>();
        for(int i=0; i<requests.size(); i++){
        requestsLineRep.add(requests.get(i).getUserMakingReqId());
        }
    return requestsLineRep;
    }
}

