/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.User;
import javax.swing.ImageIcon;
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
        this.signInToNews= signInToNews;
        this.signUpToNews= null;
        this.user= user;
    }

    public NewsFeedPage(SignUpWindow signInToNews, User user) {
        initComponents();
        this.signInToNews= null;
        this.signUpToNews= signInToNews;
        this.user= user;
    }
    
     public NewsFeedPage(User user) {
        initComponents();
        this.signInToNews= null;
        this.signUpToNews= null;
        this.user= user;
    }
     
    public static NewsFeedPage getInstance(SignInWindow signInToNews, User user) {
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
//        FriendManagementPage fmp = FriendManagementPage.getInstance(this, u);
//        fmp.setVisible(true);
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
        mainNewsPanel1 = new frontend.MainNewsPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        storiesList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        postsList = new javax.swing.JList<>();
        NewPostPanel = new javax.swing.JPanel();
        IconPanel = new javax.swing.JPanel();
        iconPanel1 = new frontend.IconPanel();
        friendsButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        FeedPanel = new javax.swing.JPanel();
        friendsNewsPanel1 = new frontend.FriendsNewsPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FriendPanel.setBackground(new java.awt.Color(204, 204, 255));

        mainNewsPanel1.setBackground(new java.awt.Color(204, 204, 255));

        storiesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(storiesList);

        postsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(postsList);

        javax.swing.GroupLayout mainNewsPanel1Layout = new javax.swing.GroupLayout(mainNewsPanel1);
        mainNewsPanel1.setLayout(mainNewsPanel1Layout);
        mainNewsPanel1Layout.setHorizontalGroup(
            mainNewsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainNewsPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(mainNewsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainNewsPanel1Layout.setVerticalGroup(
            mainNewsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainNewsPanel1Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FriendPanelLayout = new javax.swing.GroupLayout(FriendPanel);
        FriendPanel.setLayout(FriendPanelLayout);
        FriendPanelLayout.setHorizontalGroup(
            FriendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainNewsPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FriendPanelLayout.setVerticalGroup(
            FriendPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainNewsPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        NewPostPanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout NewPostPanelLayout = new javax.swing.GroupLayout(NewPostPanel);
        NewPostPanel.setLayout(NewPostPanelLayout);
        NewPostPanelLayout.setHorizontalGroup(
            NewPostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );
        NewPostPanelLayout.setVerticalGroup(
            NewPostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        IconPanel.setBackground(new java.awt.Color(255, 255, 255));

        iconPanel1.setBackground(new java.awt.Color(255, 255, 255));

        friendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsButtonActionPerformed(evt);
            }
        });

        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout iconPanel1Layout = new javax.swing.GroupLayout(iconPanel1);
        iconPanel1.setLayout(iconPanel1Layout);
        iconPanel1Layout.setHorizontalGroup(
            iconPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iconPanel1Layout.createSequentialGroup()
                .addGap(476, 476, 476)
                .addComponent(homeButton)
                .addGap(70, 70, 70)
                .addComponent(friendsButton)
                .addGap(90, 90, 90)
                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(profileButton)
                .addGap(17, 17, 17))
        );
        iconPanel1Layout.setVerticalGroup(
            iconPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iconPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(iconPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friendsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Connect Hub");

        javax.swing.GroupLayout IconPanelLayout = new javax.swing.GroupLayout(IconPanel);
        IconPanel.setLayout(IconPanelLayout);
        IconPanelLayout.setHorizontalGroup(
            IconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IconPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        IconPanelLayout.setVerticalGroup(
            IconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IconPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(IconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(IconPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(iconPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
        );

        FeedPanel.setBackground(new java.awt.Color(204, 204, 255));

        friendsNewsPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout friendsNewsPanel1Layout = new javax.swing.GroupLayout(friendsNewsPanel1);
        friendsNewsPanel1.setLayout(friendsNewsPanel1Layout);
        friendsNewsPanel1Layout.setHorizontalGroup(
            friendsNewsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );
        friendsNewsPanel1Layout.setVerticalGroup(
            friendsNewsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FeedPanelLayout = new javax.swing.GroupLayout(FeedPanel);
        FeedPanel.setLayout(FeedPanelLayout);
        FeedPanelLayout.setHorizontalGroup(
            FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(friendsNewsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FeedPanelLayout.setVerticalGroup(
            FeedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(friendsNewsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewPostPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FriendPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FeedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(IconPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewPostPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(FriendPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FeedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        this.openNewsFeedPage(user);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        this.openNewsFeedPage(user);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void friendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsButtonActionPerformed
        // TODO add your handling code here:
        this.openFriendManagementPage(user);
    }//GEN-LAST:event_friendsButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profileButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FeedPanel;
    private javax.swing.JPanel FriendPanel;
    private javax.swing.JPanel IconPanel;
    private javax.swing.JPanel NewPostPanel;
    private javax.swing.JButton friendsButton;
    private frontend.FriendsNewsPanel friendsNewsPanel1;
    private javax.swing.JButton homeButton;
    private frontend.IconPanel iconPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private frontend.MainNewsPanel mainNewsPanel1;
    private javax.swing.JList<String> postsList;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JList<String> storiesList;
    // End of variables declaration//GEN-END:variables
}
