/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.AccountManagement;
import backend.DataBase;
import backend.Friend;
import backend.FriendManagement;
import backend.FriendRequests;
import backend.NewsFeed;
import backend.User;
import backend.UserSession;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author malak
 */
public class FriendReqSuggPanel extends javax.swing.JPanel {

    private JList<String> friendsList;
    private JList<String> requestsList;
    private JList<String> suggestionsList;

    private DefaultListModel<String> friendsListModel;
    private DefaultListModel<String> requestsListModel;
    private DefaultListModel<String> suggestionsListModel;

    public FriendReqSuggPanel() {
        initComponents();
        friendsListModel = new DefaultListModel<>();
        requestsListModel = new DefaultListModel<>();
        suggestionsListModel = new DefaultListModel<>();
        // Set the JList models to DefaultListModel
        friendsList = new JList<>(friendsListModel);
        requestsList = new JList<>(requestsListModel);
        suggestionsList = new JList<>(suggestionsListModel);

        friendsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedFriend = friendsList.getSelectedValue();
                    String[] token = selectedFriend.split(" ");
                    String usernameUser = UserSession.getCurrentUser().getUsername();
                    Friend friend = Friend.getFriend(usernameUser, token[0]);
                    String[] options = {"Remove", "Block"};
                    int choice = JOptionPane.showOptionDialog(
                            null,
                            "Would you like to: ",
                            ("Friend" + friend.getUsername()),
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]
                    );
                    if (choice == 0) {
                        FriendManagement.removeFriend(UserSession.getCurrentUser(), friend);
                        friendsListModel.removeElement(selectedFriend);
          
                        updateFriendsList(UserSession.getCurrentUser());
                    } else if (choice == 1) {
                        FriendManagement.blockFriend(UserSession.getCurrentUser(), friend);
                        UserSession.getCurrentUser().addBlockedFriends(friend);
                        friendsListModel.removeElement(selectedFriend);
                        updateFriendsList(UserSession.getCurrentUser());
                        /*must update blocked*/
                        JOptionPane.showMessageDialog(null, "Friend removed successfully");
                    }
                }

            }
        }
        );

        requestsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedFriend = requestsList.getSelectedValue();
                    String[] token = selectedFriend.split(" ");
                    String usernameUser = UserSession.getCurrentUser().getUsername();
                    FriendRequests friendrequest = UserSession.getCurrentUser().getFriendReq(token[0]);
                    String[] options = {"Accept", "Remove"};
                    int choice = JOptionPane.showOptionDialog(
                            null,
                            "Would you like to: ",
                            ("Request by" + friendrequest.getUsername()),
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]
                    );

                    System.out.println("User selected: " + selectedFriend);
                    if (choice == 0) {
                        FriendManagement.friendRequest(true, UserSession.getCurrentUser(), friendrequest, false);
                        updateRequestsList(UserSession.getCurrentUser());  // Refresh the requests list
                        updateFriendsList(UserSession.getCurrentUser());
                        JOptionPane.showMessageDialog(null, "Friend request accepted successfully");
                        
                    } else if (choice == 1) {
                        FriendManagement.friendRequest(false, UserSession.getCurrentUser(), friendrequest, true);
                        JOptionPane.showMessageDialog(null, "Friend request denied successfully");
                    }
                }
            }
        }
        );

        suggestionsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    
                    String selectedFriend = suggestionsList.getSelectedValue();
                    String[] token = selectedFriend.split(" ");
                    String usernameUser = UserSession.getCurrentUser().getUsername();
                    Friend suggestedFriend = FriendManagement.getFriendSuggested(UserSession.getCurrentUser(), token[0]);
                    System.out.println("User selected: " + selectedFriend);

                    String[] options = {"Send Request", "Ignore"};
                    int choice = JOptionPane.showOptionDialog(
                            null,
                            "Would you like to: ",
                            ("Suggested Friend" + suggestedFriend.getUsername()),
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]
                    );

                    System.out.println("User selected: " + selectedFriend);
                    if (choice == 0) {
                        FriendRequests fr = new FriendRequests(UserSession.getCurrentUser().getUsername(), UserSession.getCurrentUser().getEmail(), UserSession.getCurrentUser().getUserId(), suggestedFriend.getUserId());
                        DataBase.getInstance().addToGlobalFriendRequests(fr);
                        JOptionPane.showMessageDialog(null, "Friend request sent successfully");
                    } else if (choice == 1) {
                    }
                }
            }
        }
        );
    }

    public void updateFriendsList(User u) {
        ArrayList<String> linerep = NewsFeed.fetchFriends(u);
        friendsListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            friendsListModel.addElement(linerep.get(i));
        }
        System.out.println("Friends List Data: " + linerep);
        friendsList.revalidate();
        friendsList.repaint();
    }
    
     public void  updateSuggestionsList(User u) {
        ArrayList<String> linerep = FriendManagement.fetchFriendsSuggestions(u);
        suggestionsListModel.clear();
        
         for (String string : linerep) {
             suggestionsListModel.addElement(string);
         }
        
        System.out.println("Friends List Data: " + linerep);
        suggestionsList.validate();
        suggestionsList.repaint();
    }
     
     public void updateRequestsList(User u) {
        ArrayList<String> linerep = u.getLineRepOfFriendReq();
        requestsListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            requestsListModel.addElement(linerep.get(i));
        }
        requestsList.revalidate();
        requestsList.repaint();
        System.out.println("Friends List Data: " + linerep);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
