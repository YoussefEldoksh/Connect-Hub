/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.AccountManagement;
import backend.Friend;
import backend.FriendManagement;
import backend.FriendRequests;
import backend.NewsFeed;
import backend.User;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author malak
 */
public class SearchForUserFrame extends javax.swing.JFrame {

    /**
     * Creates new form SearchForUserFrame
     */
    
    
    boolean resultsUpdated;
    DefaultListModel<String> resultsListModel = new DefaultListModel<>();
    private static SearchForUserFrame instance = null;
    private SearchForUserFrame() {
        initComponents();
    }
    
    public static SearchForUserFrame getInstance()    
    {
        if(instance == null)
        {
            instance  = new SearchForUserFrame();                 
        }
        return instance;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchBar = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultsList = new javax.swing.JList<>();
        label1 = new java.awt.Label();
        clearSearchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        getContentPane().add(searchBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 284, 34));

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_searchIcon.jpg"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 34, 34));

        resultsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        resultsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                resultsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(resultsList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 324, 208));

        label1.setBackground(new java.awt.Color(153, 0, 255));
        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Search For  A User");
        getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 8, 182, -1));

        clearSearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_cancel-icon.jpg"))); // NOI18N
        clearSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSearchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(clearSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 34, 34));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/purple-gradient-background-5472-x-3648-i2xtxsy5ijm2ik4e.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 400, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
       if(searchBar.getText().isBlank())
       {
           JOptionPane.showMessageDialog(this,"Nothing in search bar");
           return;
       }
        
        
        updateStoriesList();
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void clearSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSearchButtonActionPerformed
        // TODO add your handling code here:
           resultsUpdated = true;
           resultsListModel.clear();
           resultsList.setModel(resultsListModel);
           searchBar.setText("");
           resultsUpdated = false;
    }//GEN-LAST:event_clearSearchButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosed

    private void resultsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_resultsListValueChanged
        // TODO add your handling code here:
         if (!resultsUpdated) {
            String selectedValue = resultsList.getSelectedValue();

            if (selectedValue == null) {
                JOptionPane.showMessageDialog(this, "No selection was made;");
            }

            if (FriendManagement.isFriend(selectedValue)) {  // if the searched user is a friend
                String username = backend.UserSession.getCurrentUser().getUsername();
                Friend friend = Friend.getFriend(username, selectedValue);
               
                
                if (friend == null) {
                    JOptionPane.showMessageDialog(this, "There is no such friend");
                    return;
                }

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
                    FriendManagement.removeFriend(backend.UserSession.getCurrentUser(), friend);
                    
                } else if (choice == 1) {
                    FriendManagement.blockFriend(backend.UserSession.getCurrentUser(), friend);
                    /*must update blocked*/
                    JOptionPane.showMessageDialog(null, "Friend removed successfully");
                }
            }
            
            
            if(!FriendManagement.isFriend(selectedValue))
            {
                String username = backend.UserSession.getCurrentUser().getUsername();
        Friend suggestedFriend = FriendManagement.getFriendSuggested(backend.UserSession.getCurrentUser(), selectedValue);
        if (suggestedFriend == null) {
            JOptionPane.showMessageDialog(this, "Error finding suggestedFriend");
            return;
        }

        System.out.println("User selected: " + selectedValue);

        String[] options = {"Send Request", "Ignore"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Would you like to: ",
                ("Suggested Friend" + suggestedFriend.getUsername()),
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]
        );

        System.out.println("User selected: " + selectedValue);
        if (choice == 0) {
            FriendRequests fr = new FriendRequests(backend.UserSession.getCurrentUser().getEmail(), backend.UserSession.getCurrentUser().getUsername(), backend.UserSession.getCurrentUser().getUserId(), suggestedFriend.getUserId());
            FriendManagement.requestSent(fr, AccountManagement.findUser(suggestedFriend.getUsername()));
            JOptionPane.showMessageDialog(null, "Friend request sent successfully");
        } else if (choice == 1) {

        }
            }

        }
        
    }//GEN-LAST:event_resultsListValueChanged

    
    public void updateStoriesList() {
        resultsUpdated = true;
        ArrayList<String> linerep = FriendManagement.getLineRepresentationUserSearch(searchBar.getText());
        resultsListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            resultsListModel.addElement(linerep.get(i));
        }
        resultsList.setModel(resultsListModel);
        resultsUpdated = false;
        System.out.println("Stories: " + linerep);
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearSearchButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JList<String> resultsList;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}