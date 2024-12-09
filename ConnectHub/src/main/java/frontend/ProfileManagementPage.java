/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.AccountManagement;
import backend.User;
import backend.UserSession;

import backend.Profile;
import backend.ProfileManagement;
import backend.User;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import backend.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
/**
 *
 * @author malak
 */
public class ProfileManagementPage extends javax.swing.JFrame {

    User user;
    static ProfileManagementPage instance;
    public UserSession userSession;

    /**
     * Creates new form ProfileManagementPage
     */
    
    private DefaultListModel<String> friendsListModel;
    private DefaultListModel<String> requestsListModel;
    private DefaultListModel<String> suggestionsListModel;
    private DefaultListModel<String> storiesListModel;
    private DefaultListModel<String> postsListModel;
    
public ProfileManagementPage(User u) {
    initComponents();  // Ensure this is called first
    this.user = u;
    UserSession.setCurrentUser(user);
    friendReqSuggPanel2.updateFriendsList(user);
    friendReqSuggPanel2.updateRequestsList(user);
    friendReqSuggPanel2.updateSuggestionsList(user);
    userContentPanel1.updateStoriesList(user);
    userContentPanel1.updatePostsList(user);

    Profile profile = ProfileManagement.getInstance().getProfile(user.getUserId());
     coverPhotoLabel.setIcon(ImageHandler.rescaleImageIcon(profile.getCoverPhoto(), 285, 135));
     profilePhotoLabel.setIcon(ImageHandler.rescaleImageIcon(profile.getProfilePhoto(), 112, 112));
     
     
     friendsListModel = new DefaultListModel<>();
     requestsListModel = new DefaultListModel<>();
     suggestionsListModel = new DefaultListModel<>();
     storiesListModel = new DefaultListModel<>();
     postsListModel = new DefaultListModel<>();

            updateFriendsList();
            updateRequestsList();
            updateSuggestionsList();
            updateStoriesList();
            updatePostsList();
}


    public void updateFriendsList() {
        ArrayList<String> linerep = NewsFeed.fetchFriends(user);
       friendsListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            friendsListModel.addElement(linerep.get(i));
        }
        System.out.println("Friends List Data: " + linerep);
        friendsList.setModel(friendsListModel);
    }
    
     public void updateSuggestionsList() {
        ArrayList<String> linerep = FriendManagement.fetchFriendsSuggestions(user);
        suggestionsListModel.clear();
         for (String string : linerep) {
             suggestionsListModel.addElement(string);
         }
        suggestionsList.setModel(suggestionsListModel);
        System.out.println("Friends List Data: " + linerep);
    }

      public void updateRequestsList() {
        ArrayList<String> linerep = user.getLineRepOfFriendReq();
        requestsListModel.clear();
        
        for (int i = 0; i < linerep.size(); i++) {
            requestsListModel.addElement(linerep.get(i));
        }
        requestsList.setModel(requestsListModel);
        System.out.println("Friends List Data: " + linerep);
    }
     
      
      
            public void updateStoriesList() {
        ArrayList<String> linerep = NewsFeed.getLineRepresentationsStories(user);
        storiesListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            storiesListModel.addElement(linerep.get(i));

        }
        storiesList.setModel(storiesListModel);
    }

    public void updatePostsList() {
        ArrayList<String> linerep = NewsFeed.getLineRepresentationsPosts(user);
        postsListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            postsListModel.addElement(linerep.get(i));

        }
        postsList.setModel(postsListModel);

    }
      
      
      
      
      
      
      
      
    public static ProfileManagementPage getInstance(User user) {
        if (instance == null) {
            instance = new ProfileManagementPage(user);
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
        ProfileManagementPage pmp = ProfileManagementPage.getInstance(u);
        pmp.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        friendReqSuggPanel1 = new frontend.FriendReqSuggPanel();
        profileButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        friendsButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelinpm = new javax.swing.JPanel();
        userDisplayPanel1 = new frontend.UserDisplayPanel();
        BioTextbox = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        coverPhotoLabel = new javax.swing.JLabel();
        profilePhotoLabel = new javax.swing.JLabel();
        panelforuserpostsandstories = new javax.swing.JPanel();
        userContentPanel1 = new frontend.UserContentPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        storiesList = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        postsList = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        friendReqSuggPanel2 = new frontend.FriendReqSuggPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        friendsList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        suggestionsList = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        requestsList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        profileButton.setBackground(new java.awt.Color(0, 153, 255));
        profileButton.setForeground(new java.awt.Color(51, 153, 255));
        profileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_Profile_Icon.png"))); // NOI18N
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        refreshButton.setBackground(new java.awt.Color(51, 153, 255));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_result_refresh_button.png"))); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        friendsButton.setBackground(new java.awt.Color(0, 102, 255));
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

        javax.swing.GroupLayout friendReqSuggPanel1Layout = new javax.swing.GroupLayout(friendReqSuggPanel1);
        friendReqSuggPanel1.setLayout(friendReqSuggPanel1Layout);
        friendReqSuggPanel1Layout.setHorizontalGroup(
            friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friendReqSuggPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(friendsButton)
                .addGap(79, 79, 79)
                .addComponent(refreshButton)
                .addGap(249, 249, 249)
                .addComponent(profileButton)
                .addGap(314, 314, 314))
        );
        friendReqSuggPanel1Layout.setVerticalGroup(
            friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendReqSuggPanel1Layout.createSequentialGroup()
                .addGroup(friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friendReqSuggPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(friendReqSuggPanel1Layout.createSequentialGroup()
                        .addGroup(friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(friendReqSuggPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, friendReqSuggPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(refreshButton)
                                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(friendsButton))))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(friendReqSuggPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(480, 480, 480))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendReqSuggPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelinpm.setBackground(new java.awt.Color(204, 204, 255));

        BioTextbox.setText("Bio:");

        userNameLabel.setText("Username:");

        logoutButton.setText("LOGOUT");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        coverPhotoLabel.setText("CP");

        javax.swing.GroupLayout userDisplayPanel1Layout = new javax.swing.GroupLayout(userDisplayPanel1);
        userDisplayPanel1.setLayout(userDisplayPanel1Layout);
        userDisplayPanel1Layout.setHorizontalGroup(
            userDisplayPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userDisplayPanel1Layout.createSequentialGroup()
                .addGroup(userDisplayPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userDisplayPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(userDisplayPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BioTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(userDisplayPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(coverPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userDisplayPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(profilePhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        userDisplayPanel1Layout.setVerticalGroup(
            userDisplayPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userDisplayPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(coverPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profilePhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BioTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelinpmLayout = new javax.swing.GroupLayout(panelinpm);
        panelinpm.setLayout(panelinpmLayout);
        panelinpmLayout.setHorizontalGroup(
            panelinpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelinpmLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(userDisplayPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelinpmLayout.setVerticalGroup(
            panelinpmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelinpmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userDisplayPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelforuserpostsandstories.setBackground(new java.awt.Color(204, 204, 255));

        storiesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane4.setViewportView(storiesList);

        postsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane5.setViewportView(postsList);

        jLabel7.setText("Your posts");

        jLabel6.setText("Your stories");

        javax.swing.GroupLayout userContentPanel1Layout = new javax.swing.GroupLayout(userContentPanel1);
        userContentPanel1.setLayout(userContentPanel1Layout);
        userContentPanel1Layout.setHorizontalGroup(
            userContentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userContentPanel1Layout.createSequentialGroup()
                .addGroup(userContentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userContentPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel6))
                    .addGroup(userContentPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel7))
                    .addGroup(userContentPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(userContentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        userContentPanel1Layout.setVerticalGroup(
            userContentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userContentPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel7)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelforuserpostsandstoriesLayout = new javax.swing.GroupLayout(panelforuserpostsandstories);
        panelforuserpostsandstories.setLayout(panelforuserpostsandstoriesLayout);
        panelforuserpostsandstoriesLayout.setHorizontalGroup(
            panelforuserpostsandstoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelforuserpostsandstoriesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(userContentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelforuserpostsandstoriesLayout.setVerticalGroup(
            panelforuserpostsandstoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelforuserpostsandstoriesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(userContentPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        friendsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(friendsList);

        jLabel3.setText("Friends");

        jLabel4.setText("Friend Requests");

        suggestionsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane6.setViewportView(suggestionsList);

        requestsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane7.setViewportView(requestsList);

        jLabel5.setText("Friend Suggestions");

        javax.swing.GroupLayout friendReqSuggPanel2Layout = new javax.swing.GroupLayout(friendReqSuggPanel2);
        friendReqSuggPanel2.setLayout(friendReqSuggPanel2Layout);
        friendReqSuggPanel2Layout.setHorizontalGroup(
            friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friendReqSuggPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(friendReqSuggPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        friendReqSuggPanel2Layout.setVerticalGroup(
            friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendReqSuggPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendReqSuggPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendReqSuggPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jLabel8.setText("Settings");

        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Change CoverPhoto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Change Profile Picture");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Change Your Bio");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel8)
                .addGap(41, 41, 41)
                .addComponent(jButton1)
                .addGap(71, 71, 71)
                                .addComponent(jButton2)
                                .addGap(78, 78, 78)
                                .addComponent(jButton3)
                                .addGap(83, 83, 83)
                                .addComponent(jButton4)
                                .addContainerGap(225, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(panelinpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelforuserpostsandstories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelforuserpostsandstories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panelinpm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String newPassword = JOptionPane.showInputDialog(this, "Please enter your new Password:");
        if (newPassword == user.getPassword()) {
            JOptionPane.showMessageDialog(null, "Your new password can not be same as old password!");
        } else {
            user.setPassword(newPassword);
            JOptionPane.showMessageDialog(null, "Your password was changed successfully!");
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();

        if (file == null) {
            JOptionPane.showMessageDialog(this, "No file selected");
            return;
        }

        ProfileManagement.getInstance().getProfile(user.getUserId()).setCover(file.getAbsolutePath());
        Profile profile = ProfileManagement.getInstance().getProfile(user.getUserId());
        coverPhotoLabel.setIcon(ImageHandler.rescaleImageIcon(profile.getCoverPhoto(), 285, 135));

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();

        if (file == null) {
            JOptionPane.showMessageDialog(this, "No file selected");
            return;
        }

        ProfileManagement.getInstance().getProfile(user.getUserId()).setProfilePic(file.getAbsolutePath());
        Profile profile = ProfileManagement.getInstance().getProfile(user.getUserId());
        profilePhotoLabel.setIcon(ImageHandler.rescaleImageIcon(profile.getProfilePhoto(), 112, 112));
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String newBio;
        newBio = JOptionPane.showInputDialog(this, "Please enter your new Bio:");
        //.setBio(newBio);
        BioTextbox.setText(newBio);
        ProfileManagement.getInstance().getProfile(user.getUserId()).setBio(newBio);
    }                                        

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        this.openNewsFeedPage(user);
    }                                          

    private void friendsButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        this.openFriendManagementPage(user);
    }                                             

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        this.openProfileManagementPage(user);
    }                                             

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        this.openProfileManagementPage(user);
    }                                             

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        AccountManagement.signOut(user);
    }                                    

    private void suggestionsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_suggestionsListValueChanged
        // TODO add your handling code here:
         String selectedFriend = suggestionsList.getSelectedValue();
                    String[] token = selectedFriend.split(" ");
                    String usernameUser = user.getUsername();
                    Friend suggestedFriend = FriendManagement.getFriendSuggested(user, token[0]);
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
                        FriendRequests fr = new FriendRequests(user.getUsername(),user.getEmail(), user.getUserId(), suggestedFriend.getUserId());
                        DataBase.getInstance().addToGlobalFriendRequests(fr);
                        JOptionPane.showMessageDialog(null, "Friend request sent successfully");
                    } else if (choice == 1) {
                    }
    }//GEN-LAST:event_suggestionsListValueChanged

    private void requestsList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_requestsList1ValueChanged
        // TODO add your handling code here:
        String selectedFriend = requestsList.getSelectedValue();
                    String[] token = selectedFriend.split(" ");
                    String usernameUser = user.getUsername();
                    FriendRequests friendrequest = user.getFriendReq(token[0]);
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
                        FriendManagement.friendRequest(true, user, friendrequest, false);
                        updateRequestsList();  // Refresh the requests list
                        updateFriendsList();
                        JOptionPane.showMessageDialog(null, "Friend request accepted successfully");
                        
                    } else if (choice == 1) {
                        FriendManagement.friendRequest(false, user, friendrequest, true);
                        JOptionPane.showMessageDialog(null, "Friend request denied successfully");
                    }
    }//GEN-LAST:event_requestsList1ValueChanged

    private void friendsList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {                                          
        // TODO add your handling code here:
        
                    String selectedFriend = friendsList.getSelectedValue();
                    String[] token = selectedFriend.split(" ");
                    String usernameUser = user.getUsername();
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
                        FriendManagement.removeFriend(user, friend);
                        friendsListModel.removeElement(selectedFriend);
          
                        updateFriendsList();
                    } else if (choice == 1) {
                        FriendManagement.blockFriend(user, friend);
                        user.addBlockedFriends(friend);
                        friendsListModel.removeElement(selectedFriend);
                        updateFriendsList();
                        /*must update blocked*/
                        JOptionPane.showMessageDialog(null, "Friend removed successfully");
                    }
    }
    private void storiesListValueChanged(javax.swing.event.ListSelectionEvent evt) {
        // TODO add your handling code here:
       /*  
        String selectedstory = storiesList.getSelectedValue();
        String[] token = selectedstory.split(" ");
                    String usernameUser = user.getUsername();
                    String text
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
                        FriendManagement.removeFriend(user, friend);
                        friendsListModel.removeElement(selectedFriend);
          
                        updateFriendsList();
                    } else if (choice == 1) {
                        FriendManagement.blockFriend(user, friend);
                        user.addBlockedFriends(friend);
                        friendsListModel.removeElement(selectedFriend);
                        updateFriendsList();
                        /*must update blocked*/
                        
                    
    }

    private void postsListValueChanged(javax.swing.event.ListSelectionEvent evt) {                                       
        // TODO add your handling code here:
        int selectedIndex = postsList.getSelectedIndex();

                    System.out.println("User selected: " + selectedIndex);
                    /*ContentPreviewForFriendsFrame friendcontent= new ContentPreviewForFriendsFrame(selectedIndex, 1);
        */       
    }        

  

    // Variables declaration - do not modify                     
    private javax.swing.JLabel BioTextbox;
    private javax.swing.JLabel coverPhotoLabel;
    private frontend.FriendReqSuggPanel friendReqSuggPanel1;
    private frontend.FriendReqSuggPanel friendReqSuggPanel2;
    private javax.swing.JButton friendsButton;
    private javax.swing.JList<String> friendsList;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel panelforuserpostsandstories;
    private javax.swing.JPanel panelinpm;
    private javax.swing.JList<String> postsList;
    private javax.swing.JButton profileButton;
    private javax.swing.JLabel profilePhotoLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JList<String> requestsList;
    private javax.swing.JList<String> storiesList;
    private javax.swing.JList<String> suggestionsList;
    private frontend.UserContentPanel userContentPanel1;
    private frontend.UserDisplayPanel userDisplayPanel1;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration                   
}
