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

    public static ArrayList<String> getLineRepresentationGroupAdmins(Group g) {
        ArrayList<String> admins = g.getGroupAdmins();
        ArrayList<String> adminsLineRep = new ArrayList<>();
        for (int i = 0; i < admins.size(); i++) {
            adminsLineRep.add(AccountManagement.findUsername(admins.get(i)));
        }
        return adminsLineRep;
    }

    public static ArrayList<String> getLineRepresentationGroupMembers(Group g) {
        ArrayList<String> members = GroupSession.getCurrentGroup().getGroupMembers();
        System.out.println("Members: " + members);
        ArrayList<String> membersLineRep = new ArrayList<>();
        for (int i = 0; i < members.size(); i++) {
            membersLineRep.add(AccountManagement.findUserUsingId(members.get(i)).getUsername());
            System.out.println("Memberrrrrrr: " + AccountManagement.findUserUsingId(members.get(i)).getUsername());
        }
        return membersLineRep;
    }

    public static ArrayList<String> getLineRepresentationGroupRequests(Group g) {
        ArrayList<GroupRequests> requests = GroupSession.getCurrentGroup().getRequests();
        
        System.out.println("Request to join coming from: " +requests );
        ArrayList<String> requestsLineRep = new ArrayList<>();
        for (int i = 0; i < requests.size(); i++) {
            requestsLineRep.add(requests.get(i).getUserMakingReqUserName());
            System.out.println("Request to join coming from: " +requests.get(i).getUserMakingReqUserName() );

        }
        return requestsLineRep;
    }

    public static ArrayList<String> getLineRepresentationGroupPosts(Group g) {
        System.out.println("enter line rep");
        ArrayList<Posts> groupPosts = g.getGroupPosts();
        ArrayList<String> groupPostsLineRep = new ArrayList<>();
        if (groupPosts == null || groupPosts.isEmpty()) {
            System.out.println("lists are null");
            return new ArrayList<>();
        }
        for (int i = 0; i < groupPosts.size(); i++) {
            String formattedDate = groupPosts.get(i).getTimestamp().toString();
            groupPostsLineRep.add(AccountManagement.findUsername(groupPosts.get(i).getAuthorID()) + "published on" + formattedDate);
            System.out.println("Line rep of posr" + groupPostsLineRep.get(i));
        }
        return groupPostsLineRep;
    }
    
    public void addPost(Group g, User u) {
        ArrayList<Posts> groupPosts = g.getGroupPosts();
        Posts newPost = (Posts) ContentFactory.createContent("post", "", u.getUserId(), "");
        groupPosts.add(newPost);
        GroupsDataBase.getInstance().addToGlobalGroupsPosts(newPost);
    }

    public void deletePost(Group g, String postId) {
        ArrayList<Posts> groupPosts = g.getGroupPosts();
        ArrayList<Posts> updated = new ArrayList();

        for (Posts p : groupPosts) {
            if (!p.getContentID().equals(postId)) {
                updated.add(p);
                GroupsDataBase.getInstance().addToGlobalGroupsPosts(p);
            }
        }

    }

    public static ArrayList<Group> groupSuggestion(User user) {

        ArrayList<Group> suggestions = new ArrayList<>();
        ArrayList<Group> allGroups = GroupsDataBase.getInstance().getAllGlobalGroups();
        ArrayList<Group> userGroups = user.getGroupsOfUser();

        for (Group g : allGroups) {
            if (!userGroups.contains(g)) //check if userGroups contains all Groups available
            {
                suggestions.add(g);

            }
        }
        return suggestions;
    }

    public static ArrayList<String> groupLineRep() {
        ArrayList<Group> groups = groupSuggestion(UserSession.getCurrentUser());
        ArrayList<String> Groups = new ArrayList<>();
        if (groups == null) {
            return new ArrayList<>();
        }

        for (Group group : groups) {
            String s = "Group " + group.getGroupName();
            Groups.add(s);
        }
        return Groups;
    }

    public static Group getGroupSuggested(User user, String groupName) {
        ArrayList<Group> suggestedGroups = groupSuggestion(user);

        for (Group group : suggestedGroups) {
            if (group.getGroupName().equals(groupName)) {
                return group;
            }
        }
        return null; // Return null if no match is found
    }

    public static GroupRequests getGroupRequest(String userMakingReqId, String groupId) {
        ArrayList<GroupRequests> gr = GroupsDataBase.getInstance().getAllGlobalGroupRequests();
        for (int i = 0; i < gr.size(); i++) {
            if (gr.get(i).getGroupId().equals(groupId) && gr.get(i).getUserMakingReqId().equals(userMakingReqId)) {
                return gr.get(i);
            }
        }
        return null;
    }

}
