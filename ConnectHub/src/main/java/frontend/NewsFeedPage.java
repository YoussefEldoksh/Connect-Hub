/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.AccountManagement;
import backend.DataBase;
import backend.FileManagement;
import backend.Friend;
import backend.FriendManagement;
import backend.FriendRequests;
import backend.Group;
import backend.NewsFeed;
import backend.Stories;
import backend.User;
import backend.UserSession;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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

        mainNewsPanel1.updateStoriesList(user);
        mainNewsPanel1.updatePostsList(user);

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
       
     public void openGroupManagement(Group group) {
        this.setVisible(false);
        GroupManagementPage gpf = GroupManagementPage.getInstance(group, user);
        gpf.setVisible(true);
    }
    
    public void openGroupCreationFrame(User user) {
        this.setVisible(false);
        GroupCreationFrame gcf = GroupCreationFrame.getInstance(user);
        gcf.setVisible(true);
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
        searchButton = new javax.swing.JButton();
        notificationsButton = new javax.swing.JButton();
        GroupsButton = new javax.swing.JButton();
        FeedPanel = new javax.swing.JPanel();
        scrollPane1 = new java.awt.ScrollPane();
        friendReqSuggPanel3 = new frontend.FriendReqSuggPanel();
        newPostPanel21 = new frontend.NewPostPanel2();
        mainNewsPanel1 = new frontend.MainNewsPanel();

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

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_searchIcon.jpg"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        notificationsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_notification.png"))); // NOI18N
        notificationsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationsButtonActionPerformed(evt);
            }
        });

        GroupsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_groupicon.png"))); // NOI18N
        GroupsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GroupsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout friendReqSuggPanel1Layout = new javax.swing.GroupLayout(friendReqSuggPanel1);
        friendReqSuggPanel1.setLayout(friendReqSuggPanel1Layout);
        friendReqSuggPanel1Layout.setHorizontalGroup(
            friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friendReqSuggPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(refreshButton)
                .addGap(33, 33, 33)
                .addComponent(friendsButton)
                .addGap(27, 27, 27)
                .addComponent(notificationsButton)
                .addGap(33, 33, 33)
                .addComponent(searchButton)
                .addGap(27, 27, 27)
                .addComponent(GroupsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
        );
        friendReqSuggPanel1Layout.setVerticalGroup(
            friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendReqSuggPanel1Layout.createSequentialGroup()
                .addGroup(friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, friendReqSuggPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, friendReqSuggPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(friendsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(profileButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(notificationsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(GroupsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout IconPanelLayout = new javax.swing.GroupLayout(IconPanel);
        IconPanel.setLayout(IconPanelLayout);
        IconPanelLayout.setHorizontalGroup(
            IconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IconPanelLayout.createSequentialGroup()
                .addComponent(friendReqSuggPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        IconPanelLayout.setVerticalGroup(
            IconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IconPanelLayout.createSequentialGroup()
                .addComponent(friendReqSuggPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        FeedPanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout FeedPanelLayout = new javax.swing.GroupLayout(FeedPanel);
        FeedPanel.setLayout(FeedPanelLayout);
        FeedPanelLayout.setHorizontalGroup(
            FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeedPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(friendReqSuggPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
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
                        .addGap(38, 38, 38)
                        .addComponent(newPostPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(mainNewsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FeedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FriendPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(702, 702, 702))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FriendPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(FeedPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainNewsPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newPostPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        DataBase.getInstance().loadAllFiles();
        user.reload();
        
        friendReqSuggPanel3.updateFriendsList(user);
        friendReqSuggPanel3.updateRequestsList(user);
        friendReqSuggPanel3.updateSuggestionsList(user);
        mainNewsPanel1.updatePostsList(user);
        mainNewsPanel1.updateStoriesList(user);
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

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
       
        SearchForUserFrame.getInstance().setVisible(true);
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void notificationsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationsButtonActionPerformed
        // TODO add your handling code here:
        NotificationsFrame.getInstance().setVisible(true);
        NotificationsFrame.getInstance().updateNotificationsList();
    }//GEN-LAST:event_notificationsButtonActionPerformed

    private void GroupsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupsButtonActionPerformed
        // TODO add your handling code here:
        GroupsListFrame.getInstance().updateNotificationsList();
        GroupsListFrame.getInstance().setVisible(true);
    }//GEN-LAST:event_GroupsButtonActionPerformed
    private void createGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createGroupButtonActionPerformed
        // TODO add your handling code here:
        this.openGroupCreationFrame(user);
    }//GEN-LAST:event_createGroupButtonActionPerformed

  

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FeedPanel;
    private javax.swing.JPanel FriendPanel;
    private javax.swing.JButton GroupsButton;
    private javax.swing.JPanel IconPanel;
    private frontend.FriendReqSuggPanel friendReqSuggPanel1;
    private frontend.FriendReqSuggPanel friendReqSuggPanel3;
    private javax.swing.JButton friendsButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private frontend.MainNewsPanel mainNewsPanel1;
    private frontend.NewPostPanel2 newPostPanel21;
    private javax.swing.JButton notificationsButton;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton refreshButton;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
