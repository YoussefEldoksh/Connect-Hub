/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.AccountManagement;
import backend.NewsFeed;
import backend.Stories;
import backend.User;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author malak
 */
public class NewsFeedPage extends javax.swing.JFrame {

    private static NewsFeedPage instance;
    private final SignInWindow signInToNews;
    private final SignUpWindow signUpToNews;
    private final User user;
    
    /**
     * Creates new form NewsFeedPage
     */
    public NewsFeedPage(SignInWindow signInToNews, User user) {
        initComponents();
        this.signInToNews = signInToNews;
        this.signUpToNews = null;
        this.user = user;

        mainNewsPanel1.updateStoriesList(user);
        mainNewsPanel1.updatePostsList(user);
        
        friendReqSuggPanel2.updateFriendsList(user);
        friendReqSuggPanel2.updateRequestsList(user);
        friendReqSuggPanel2.updateSuggestionsList(user);
    }

    
    public NewsFeedPage(SignUpWindow signInToNews, User user) {
        initComponents();
        this.signInToNews = null;
        this.signUpToNews = signInToNews;
        this.user = user;

        mainNewsPanel1.updateStoriesList(user);
        mainNewsPanel1.updatePostsList(user);
        
        friendReqSuggPanel2.updateFriendsList(user);
        friendReqSuggPanel2.updateRequestsList(user);
        friendReqSuggPanel2.updateSuggestionsList(user);
    }
    

    private NewsFeedPage(User user) {
        initComponents();
        this.signInToNews = null;
        this.signUpToNews = null;
        this.user = user;
        mainNewsPanel1.updateStoriesList(user);
        mainNewsPanel1.updatePostsList(user);

        friendReqSuggPanel2.updateFriendsList(user);
        friendReqSuggPanel2.updateRequestsList(user);
        friendReqSuggPanel2.updateSuggestionsList(user);
    }

    private static NewsFeedPage getInstance(SignInWindow signInToNews, User user) {
        if (instance == null) {
            instance = new NewsFeedPage(signInToNews, user);
        }
        return instance;
    }


 
    public static NewsFeedPage getInstance(SignUpWindow signUpToNews, User user) {

        if (instance == null) {
            instance = new NewsFeedPage(signUpToNews, user);
        }
        return instance;
    }

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
        ProfileManagementPage pmp = ProfileManagementPage.getInstance(u);
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
        NewPostPanel = new javax.swing.JPanel();
        newPostPanel1 = new frontend.NewPostPanel();
        addStoryButton = new javax.swing.JButton();
        addPostButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        IconPanel = new javax.swing.JPanel();
        friendReqSuggPanel1 = new frontend.FriendReqSuggPanel();
        profileButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        friendsButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FeedPanel = new javax.swing.JPanel();
        friendReqSuggPanel2 = new frontend.FriendReqSuggPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        friendsList1 = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        suggestionsList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        requestsList1 = new javax.swing.JList<>();
        mainNewsPanel1 = new frontend.MainNewsPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        storiesList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        postsList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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
            .addGap(0, 812, Short.MAX_VALUE)
        );

        NewPostPanel.setBackground(new java.awt.Color(204, 204, 255));

        addStoryButton.setText("add story");
        addStoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStoryButtonActionPerformed(evt);
            }
        });

        addPostButton.setText("add post");
        addPostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPostButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("LOGOUT");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newPostPanel1Layout = new javax.swing.GroupLayout(newPostPanel1);
        newPostPanel1.setLayout(newPostPanel1Layout);
        newPostPanel1Layout.setHorizontalGroup(
            newPostPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newPostPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(newPostPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutButton)
                    .addComponent(addStoryButton)
                    .addComponent(addPostButton))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        newPostPanel1Layout.setVerticalGroup(
            newPostPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newPostPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(addStoryButton)
                .addGap(18, 18, 18)
                .addComponent(addPostButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout NewPostPanelLayout = new javax.swing.GroupLayout(NewPostPanel);
        NewPostPanel.setLayout(NewPostPanelLayout);
        NewPostPanelLayout.setHorizontalGroup(
            NewPostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPostPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(newPostPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        NewPostPanelLayout.setVerticalGroup(
            NewPostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPostPanelLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(newPostPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        IconPanel.setBackground(new java.awt.Color(255, 255, 255));

        profileButton.setText("your profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        refreshButton.setText("refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        friendsButton.setText("friends");
        friendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsButtonActionPerformed(evt);
            }
        });

        homeButton.setText("home");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                .addComponent(homeButton)
                .addGap(62, 62, 62)
                .addComponent(friendsButton)
                .addGap(63, 63, 63)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        friendReqSuggPanel1Layout.setVerticalGroup(
            friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, friendReqSuggPanel1Layout.createSequentialGroup()
                .addGroup(friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(friendReqSuggPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, friendReqSuggPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(friendReqSuggPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(homeButton)
                                .addComponent(friendsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshButton))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout IconPanelLayout = new javax.swing.GroupLayout(IconPanel);
        IconPanel.setLayout(IconPanelLayout);
        IconPanelLayout.setHorizontalGroup(
            IconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IconPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(friendReqSuggPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        IconPanelLayout.setVerticalGroup(
            IconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IconPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendReqSuggPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        FeedPanel.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel6.setText("Your Friends");

        friendsList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        friendsList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane4.setViewportView(friendsList1);

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel7.setText("People You May Know");

        suggestionsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        suggestionsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(suggestionsList);

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel5.setText("Friend Requests");

        requestsList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        requestsList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane5.setViewportView(requestsList1);

        javax.swing.GroupLayout friendReqSuggPanel2Layout = new javax.swing.GroupLayout(friendReqSuggPanel2);
        friendReqSuggPanel2.setLayout(friendReqSuggPanel2Layout);
        friendReqSuggPanel2Layout.setHorizontalGroup(
            friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendReqSuggPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(friendReqSuggPanel2Layout.createSequentialGroup()
                        .addGroup(friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(friendReqSuggPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        friendReqSuggPanel2Layout.setVerticalGroup(
            friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendReqSuggPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FeedPanelLayout = new javax.swing.GroupLayout(FeedPanel);
        FeedPanel.setLayout(FeedPanelLayout);
        FeedPanelLayout.setHorizontalGroup(
            FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FeedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendReqSuggPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FeedPanelLayout.setVerticalGroup(
            FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FeedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(friendReqSuggPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainNewsPanel1.setBackground(new java.awt.Color(204, 204, 255));

        storiesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        storiesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(storiesList);

        postsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        postsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(postsList);

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel2.setText("Stories:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel3.setText("Posts:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Check  all your friends' updates here!");

        javax.swing.GroupLayout mainNewsPanel1Layout = new javax.swing.GroupLayout(mainNewsPanel1);
        mainNewsPanel1.setLayout(mainNewsPanel1Layout);
        mainNewsPanel1Layout.setHorizontalGroup(
            mainNewsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainNewsPanel1Layout.createSequentialGroup()
                .addGroup(mainNewsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainNewsPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2))
                    .addGroup(mainNewsPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4))
                    .addGroup(mainNewsPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(mainNewsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainNewsPanel1Layout.setVerticalGroup(
            mainNewsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainNewsPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IconPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewPostPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(mainNewsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FriendPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FeedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(FeedPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FriendPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NewPostPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(mainNewsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStoryButtonActionPerformed
        // TODO add your handling code here:
        int content=2;
        String[] options = {"Text Only", "Text and Picture"};
        int choice = JOptionPane.showOptionDialog(
            this,
            "Choose how you want to add your story:",
            "Add Story",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]
        );

        newPostPanel1.addContent(content, choice, user.getUserId());
    }//GEN-LAST:event_addStoryButtonActionPerformed

    private void addPostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPostButtonActionPerformed
        // TODO add your handling code here:
         int content=1;
        String[] options = {"Text Only", "Text and Picture"};
        int choice = JOptionPane.showOptionDialog(
            this,
            "Choose how you want to add your story:",
            "Add Story",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]
        );
        newPostPanel1.addContent(content, choice, user.getUserId());
    }//GEN-LAST:event_addPostButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
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

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        AccountManagement.signOut(user);
    }//GEN-LAST:event_logoutButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FeedPanel;
    private javax.swing.JPanel FriendPanel;
    private javax.swing.JPanel IconPanel;
    private javax.swing.JPanel NewPostPanel;
    private javax.swing.JButton addPostButton;
    private javax.swing.JButton addStoryButton;
    private frontend.FriendReqSuggPanel friendReqSuggPanel1;
    private frontend.FriendReqSuggPanel friendReqSuggPanel2;
    private javax.swing.JButton friendsButton;
    private javax.swing.JList<String> friendsList1;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton logoutButton;
    private frontend.MainNewsPanel mainNewsPanel1;
    private frontend.NewPostPanel newPostPanel1;
    private javax.swing.JList<String> postsList;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JList<String> requestsList1;
    private javax.swing.JList<String> storiesList;
    private javax.swing.JList<String> suggestionsList;
    // End of variables declaration//GEN-END:variables
}
