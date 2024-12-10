/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.AccountManagement;
import backend.DataBase;
import backend.Friend;
import backend.FriendManagement;
import backend.FriendRequests;
import backend.NewsFeed;
import backend.Posts;
import backend.Stories;
import backend.User;
import backend.UserSession;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author malak
 */
public class NewsFeedPage extends javax.swing.JFrame {

    private static NewsFeedPage instance;
    private final User user;
    
    /**
     * Creates new form NewsFeedPage
     */
    private DefaultListModel<String> friendsListModel;
    private DefaultListModel<String> requestsListModel;
    private DefaultListModel<String> suggestionsListModel;
    private DefaultListModel<String> storiesListModel;
    private DefaultListModel<String> postsListModel;
    
    private NewsFeedPage(User user) {
        initComponents();
        System.out.println(refreshButton.getHeight() + " " + refreshButton.getWidth());
        
        this.user = user;

        mainNewsPanel2.updateStoriesList(user);
        mainNewsPanel2.updatePostsList(user);
//        friendsListModel = new DefaultListModel<>();
//        requestsListModel = new DefaultListModel<>();
//        suggestionsListModel = new DefaultListModel<>();
//        storiesListModel = new DefaultListModel<>();
//        postsListModel = new DefaultListModel<>();
        
        
        friendReqSuggPanel3.updateFriendsList(user);
        friendReqSuggPanel3.updateRequestsList(user);
        friendReqSuggPanel3.updateSuggestionsList(user);
//            friendsList1 = new JList<>(friendsListModel);
//            requestsList1 = new JList<>(requestsListModel);
//            updateFriendsList();
//            updateRequestsList();
//            updateSuggestionsList();
//            updateStoriesList();
//            updatePostsList();
        
    }

//    public void updateFriendsList() {
//        ArrayList<String> linerep = NewsFeed.fetchFriends(user);
//       friendsListModel.clear();
//
//        for (int i = 0; i < linerep.size(); i++) {
//            friendsListModel.addElement(linerep.get(i));
//        }
//        System.out.println("Friends List Data: " + linerep);
//        friendsList1.setModel(friendsListModel);
//    }
//    
//     public void updateSuggestionsList() {
//        ArrayList<String> linerep = FriendManagement.fetchFriendsSuggestions(user);
//        suggestionsListModel.clear();
//         for (String string : linerep) {
//             suggestionsListModel.addElement(string);
//         }
//        suggestionsList.setModel(suggestionsListModel);
//        System.out.println("Friends List Data: " + linerep);
//    }
//     
     
     
     
//      public void updateStoriesList() {
//        ArrayList<String> linerep = NewsFeed.getLineRepresentationsAllStories(user);
//        storiesListModel.clear();
//
//        for (int i = 0; i < linerep.size(); i++) {
//            storiesListModel.addElement(linerep.get(i));
//
//        }
//        storiesList.setModel(storiesListModel);
//    }
//
//    public void updatePostsList() {
//        ArrayList<String> linerep = NewsFeed.getLineRepresentationsAllPosts(user);
//        postsListModel.clear();
//
//        for (int i = 0; i < linerep.size(); i++) {
//            postsListModel.addElement(linerep.get(i));
//
//        }
//        postsList.setModel(postsListModel);
//
//    }

     
     
     
//     
//     public void updateRequestsList() {
//        ArrayList<String> linerep = user.getLineRepOfFriendReq();
//        requestsListModel.clear();
//        
//        for (int i = 0; i < linerep.size(); i++) {
//            requestsListModel.addElement(linerep.get(i));
//        }
//        requestsList1.setModel(requestsListModel);
//        System.out.println("Friends List Data: " + linerep);
//    }
    
     
    
    



//    private static NewsFeedPage getInstance(SignInWindow signInToNews, User user) {
//        if (instance == null) {
//            instance = new NewsFeedPage(signInToNews, user);
//        }
//        
//        return instance;
//    }
//
//
// 
//    public static NewsFeedPage getInstance(SignUpWindow signUpToNews, User user) {
//
//        if (instance == null) {
//            instance = new NewsFeedPage(signUpToNews, user);
//        }
//        return instance;
//    }

    public static NewsFeedPage getInstance(User user) {
        if (instance == null) {
            instance = new NewsFeedPage(user);
        }
        return instance;
    }

    public void openNewsFeedPage(User u) {
        this.setVisible(false);
        NewsFeedPage nfp = NewsFeedPage.getInstance(u);
        nfp.setVisible(true);
    }

    public void openFriendManagementPage(User u) {
        this.setVisible(false);
        FriendManagementPage fmp = FriendManagementPage.getInstance(u);
        fmp.setVisible(true);
    }
     
       public void openProfileManagementPage(User u) {
        this.setVisible(false);
        ProfileManagement pmp = ProfileManagement.getInstance(u);
        pmp.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FriendPanel = new javax.swing.JPanel();
        IconPanel = new javax.swing.JPanel();
        friendReqSuggPanel1 = new frontend.FriendReqSuggPanel();
        profileButton = new javax.swing.JButton();
        friendsButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        FeedPanel = new javax.swing.JPanel();
        scrollPane1 = new java.awt.ScrollPane();
        friendReqSuggPanel3 = new frontend.FriendReqSuggPanel();
        mainNewsPanel2 = new frontend.MainNewsPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FriendPanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout FriendPanelLayout = new javax.swing.GroupLayout(FriendPanel);
        FriendPanel.setLayout(FriendPanelLayout);
        FriendPanelLayout.setHorizontalGroup(
            FriendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        FriendPanelLayout.setVerticalGroup(
            FriendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
        );

        IconPanel.setBackground(new java.awt.Color(255, 255, 255));

        profileButton.setBackground(new java.awt.Color(102, 153, 255));
        profileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_Profile_Icon.png"))); // NOI18N
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        friendsButton.setBackground(new java.awt.Color(51, 153, 255));
        friendsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_group.png"))); // NOI18N
        friendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsButtonActionPerformed(evt);
            }
        });

        homeButton.setBackground(new java.awt.Color(51, 153, 255));
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_home-button.png"))); // NOI18N
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Connect Hub");

        refreshButton.setBackground(new java.awt.Color(51, 153, 255));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_result_refresh_button.png"))); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout friendReqSuggPanel1Layout = new javax.swing.GroupLayout(friendReqSuggPanel1);
        friendReqSuggPanel1.setLayout(friendReqSuggPanel1Layout);
        friendReqSuggPanel1Layout.setHorizontalGroup(
            friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friendReqSuggPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(refreshButton)
                .addGap(38, 38, 38)
                .addComponent(friendsButton)
                .addGap(33, 33, 33)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(481, Short.MAX_VALUE))
        );
        friendReqSuggPanel1Layout.setVerticalGroup(
            friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendReqSuggPanel1Layout.createSequentialGroup()
                .addGroup(friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(friendReqSuggPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addGroup(friendReqSuggPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(friendsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(profileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout IconPanelLayout = new javax.swing.GroupLayout(IconPanel);
        IconPanel.setLayout(IconPanelLayout);
        IconPanelLayout.setHorizontalGroup(
            IconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IconPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(friendReqSuggPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        IconPanelLayout.setVerticalGroup(
            IconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IconPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendReqSuggPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        FeedPanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout FeedPanelLayout = new javax.swing.GroupLayout(FeedPanel);
        FeedPanel.setLayout(FeedPanelLayout);
        FeedPanelLayout.setHorizontalGroup(
            FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeedPanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(friendReqSuggPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        FeedPanelLayout.setVerticalGroup(
            FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(FeedPanelLayout.createSequentialGroup()
                        .addComponent(friendReqSuggPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(mainNewsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FeedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FriendPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(702, 702, 702))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FriendPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainNewsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FeedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        friendReqSuggPanel3.updateFriendsList(user);
        friendReqSuggPanel3.updateRequestsList(user);
        friendReqSuggPanel3.updateSuggestionsList(user);
        this.openNewsFeedPage(user);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        this.openNewsFeedPage(user);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        // TODO add your handling code here:
        this.openProfileManagementPage(user);
    }//GEN-LAST:event_profileButtonActionPerformed

    private void friendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsButtonActionPerformed
        // TODO add your handling code here:
        this.openFriendManagementPage(user);
    }//GEN-LAST:event_friendsButtonActionPerformed

   
    
 
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FeedPanel;
    private javax.swing.JPanel FriendPanel;
    private javax.swing.JPanel IconPanel;
    private frontend.FriendReqSuggPanel friendReqSuggPanel1;
    private frontend.FriendReqSuggPanel friendReqSuggPanel3;
    private javax.swing.JButton friendsButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private frontend.MainNewsPanel mainNewsPanel2;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton refreshButton;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
