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
        friendsListModel = new DefaultListModel<>();
        requestsListModel = new DefaultListModel<>();
        suggestionsListModel = new DefaultListModel<>();
        storiesListModel = new DefaultListModel<>();
        postsListModel = new DefaultListModel<>();
//        friendReqSuggPanel2.updateFriendsList(user);
//        friendReqSuggPanel2.updateRequestsList(user);
//        friendReqSuggPanel2.updateSuggestionsList(user);
//            friendsList1 = new JList<>(friendsListModel);
//            requestsList1 = new JList<>(requestsListModel);
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
        friendsList1.setModel(friendsListModel);
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

     
     
     
     
     public void updateRequestsList() {
        ArrayList<String> linerep = user.getLineRepOfFriendReq();
        requestsListModel.clear();
        
        for (int i = 0; i < linerep.size(); i++) {
            requestsListModel.addElement(linerep.get(i));
        }
        requestsList1.setModel(requestsListModel);
        System.out.println("Friends List Data: " + linerep);
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
        friendsButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
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
        scrollPane1 = new java.awt.ScrollPane();
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
            .addGap(0, 816, Short.MAX_VALUE)
        );

        NewPostPanel.setBackground(new java.awt.Color(204, 204, 255));
        NewPostPanel.setDoubleBuffered(false);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout NewPostPanelLayout = new javax.swing.GroupLayout(NewPostPanel);
        NewPostPanel.setLayout(NewPostPanelLayout);
        NewPostPanelLayout.setHorizontalGroup(
            NewPostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPostPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(newPostPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        NewPostPanelLayout.setVerticalGroup(
            NewPostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewPostPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newPostPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel6.setText("Your Friends");

        friendsList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        friendsList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                friendsList1ValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(friendsList1);

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel7.setText("People You May Know");

        suggestionsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        suggestionsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                suggestionsListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(suggestionsList);

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel5.setText("Friend Requests");

        requestsList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        requestsList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                requestsList1ValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(requestsList1);

        javax.swing.GroupLayout friendReqSuggPanel2Layout = new javax.swing.GroupLayout(friendReqSuggPanel2);
        friendReqSuggPanel2.setLayout(friendReqSuggPanel2Layout);
        friendReqSuggPanel2Layout.setHorizontalGroup(
            friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(friendReqSuggPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(friendReqSuggPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(friendReqSuggPanel2Layout.createSequentialGroup()
                        .addGroup(friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(friendReqSuggPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(friendReqSuggPanel2Layout.createSequentialGroup()
                                .addGroup(friendReqSuggPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(friendReqSuggPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 649, Short.MAX_VALUE)
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
                        .addComponent(friendReqSuggPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))))
        );

        mainNewsPanel1.setBackground(new java.awt.Color(204, 204, 255));

        storiesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        storiesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                storiesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(storiesList);

        postsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        postsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                postsListValueChanged(evt);
            }
        });
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
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addContainerGap())
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
                        .addGap(0, 0, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FriendPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(NewPostPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainNewsPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(FeedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        SignIn_Or_SignUp_Window.getInstance().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

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
                        FriendRequests fr = new FriendRequests(user.getEmail(),user.getUsername(), user.getUserId(), suggestedFriend.getUserId());
                        FriendManagement.requestSent(fr, DataBase.getInstance().getUsers().get(DataBase.getInstance().getUsers().indexOf(AccountManagement.findUser(token[0]))));
                        JOptionPane.showMessageDialog(null, "Friend request sent successfully");
                    } else if (choice == 1) {
                    }
    }//GEN-LAST:event_suggestionsListValueChanged

    private void requestsList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_requestsList1ValueChanged
        // TODO add your handling code here:
                    String selectedFriend = requestsList1.getSelectedValue();
                    String usernameUser = user.getUsername();
                    FriendRequests friendrequest = user.getFriendReq(selectedFriend);
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

    private void friendsList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_friendsList1ValueChanged
        // TODO add your handling code here:
        
                    String selectedFriend = friendsList1.getSelectedValue();
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
                        friendsList1.setModel(friendsListModel);
          
                        updateFriendsList();
                    } else if (choice == 1) {
                        FriendManagement.blockFriend(user, friend);
                        user.addBlockedFriends(friend);
                        friendsListModel.removeElement(selectedFriend);
                        friendsList1.setModel(friendsListModel);
                        updateFriendsList();
                        /*must update blocked*/
                        JOptionPane.showMessageDialog(null, "Friend removed successfully");
                    }
    }//GEN-LAST:event_friendsList1ValueChanged

    private void storiesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_storiesListValueChanged
        // TODO add your handling code here:
         int selectedIndex = storiesList.getSelectedIndex();

                    System.out.println("User selected: " + selectedIndex);
                    ContentPreviewForFriendsFrame friendcontent= new ContentPreviewForFriendsFrame(selectedIndex, 2);
                
    }//GEN-LAST:event_storiesListValueChanged

    private void postsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_postsListValueChanged
        // TODO add your handling code here:
        int selectedIndex = postsList.getSelectedIndex();

                    System.out.println("User selected: " + selectedIndex);
                    ContentPreviewForFriendsFrame friendcontent= new ContentPreviewForFriendsFrame(selectedIndex, 1);
               
    }//GEN-LAST:event_postsListValueChanged

    
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
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JList<String> storiesList;
    private javax.swing.JList<String> suggestionsList;
    // End of variables declaration//GEN-END:variables
}
