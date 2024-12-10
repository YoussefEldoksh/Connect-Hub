/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.ImageHandler;
import backend.Profile;
import backend.User;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author malak
 */
public class ProfileManagement extends javax.swing.JFrame {

    /**
     * Creates new form ProfileManagement
     */
    User user;
    private static ProfileManagement instance;
    
    private ProfileManagement(User user) {
        initComponents();
        this.user = user;
        userNameLabel.setText("UserName: " + user.getUsername());
        
        
        Profile profile = backend.ProfileManagement.getInstance().getProfile(user.getUserId());
     coverPhotoLabel.setIcon(ImageHandler.rescaleImageIcon(profile.getCoverPhoto(), 285, 135));
     profilePhotoLabel.setIcon(ImageHandler.rescaleImageIcon(profile.getProfilePhoto(), 112, 112));
    
        
        
        
    }
    public static ProfileManagement getInstance(User user) {
        if (instance == null) {
            instance = new ProfileManagement(user);
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
    
    public void openProfileManagement(User u) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        friendsButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        changePassButton = new javax.swing.JButton();
        ChangeCoverButton = new javax.swing.JButton();
        profilePicButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        userContentPanel1 = new frontend.UserContentPanel();
        jPanel2 = new javax.swing.JPanel();
        coverPhotoLabel = new javax.swing.JLabel();
        profilePhotoLabel = new javax.swing.JLabel();
        BioTextbox = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Connect Hub");

        homeButton.setBackground(new java.awt.Color(51, 153, 255));
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_home-button.png"))); // NOI18N
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        friendsButton.setBackground(new java.awt.Color(0, 102, 255));
        friendsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_group.png"))); // NOI18N
        friendsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsButtonActionPerformed(evt);
            }
        });

        refreshButton.setBackground(new java.awt.Color(51, 153, 255));
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_result_refresh_button.png"))); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        profileButton.setBackground(new java.awt.Color(0, 153, 255));
        profileButton.setForeground(new java.awt.Color(51, 153, 255));
        profileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_Profile_Icon.png"))); // NOI18N
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(friendsButton)
                .addGap(59, 59, 59)
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(profileButton)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(friendsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel8.setText("Settings");

        changePassButton.setText("Change Password");
        changePassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassButtonActionPerformed(evt);
            }
        });

        ChangeCoverButton.setText("Change CoverPhoto");
        ChangeCoverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeCoverButtonActionPerformed(evt);
            }
        });

        profilePicButton.setText("Change Profile Picture");
        profilePicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilePicButtonActionPerformed(evt);
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
                            .addComponent(ChangeCoverButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changePassButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profilePicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel8)
                .addGap(41, 41, 41)
                .addComponent(changePassButton)
                .addGap(71, 71, 71)
                .addComponent(ChangeCoverButton)
                .addGap(78, 78, 78)
                .addComponent(profilePicButton)
                .addGap(83, 83, 83)
                .addComponent(jButton4)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        coverPhotoLabel.setText("CP");

        BioTextbox.setText("Bio:");

        userNameLabel.setText("Username:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BioTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(coverPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(profilePhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(coverPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profilePhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BioTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 131, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userContentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userContentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        this.openNewsFeedPage(user);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void friendsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendsButtonActionPerformed
        // TODO add your handling code here:
      this.openFriendManagementPage(user);

    }//GEN-LAST:event_friendsButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
       this.openProfileManagement(user);

    }//GEN-LAST:event_refreshButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        // TODO add your handling code here:
    this.openProfileManagement(user);

    }//GEN-LAST:event_profileButtonActionPerformed

    private void changePassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassButtonActionPerformed
        // TODO add your handling code here:
               String newPassword = JOptionPane.showInputDialog(this, "Please enter your new Password:");
                       
        if (newPassword == user.getPassword()) {
            JOptionPane.showMessageDialog(null, "Your new password can not be same as old password!");
        } else {
            user.setPassword(newPassword);
            JOptionPane.showMessageDialog(null, "Your password was changed successfully!");
        }

    }//GEN-LAST:event_changePassButtonActionPerformed

    private void ChangeCoverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeCoverButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();

        if (file == null) {
            JOptionPane.showMessageDialog(this, "No file selected");
            return;
        }

        backend.ProfileManagement.getInstance().getProfile(user.getUserId()).setCover(file.getAbsolutePath());
        Profile profile = backend.ProfileManagement.getInstance().getProfile(user.getUserId());
       // coverPhotoLabel.setIcon(ImageHandler.rescaleImageIcon(profile.getCoverPhoto(), 285, 135));

    }//GEN-LAST:event_ChangeCoverButtonActionPerformed

    private void profilePicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilePicButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();

        if (file == null) {
            JOptionPane.showMessageDialog(this, "No file selected");
            return;
        }

        backend.ProfileManagement.getInstance().getProfile(user.getUserId()).setProfilePic(file.getAbsolutePath());
        Profile profile = backend.ProfileManagement.getInstance().getProfile(user.getUserId());
       // profilePhotoLabel.setIcon(ImageHandler.rescaleImageIcon(profile.getProfilePhoto(), 112, 112));

    }//GEN-LAST:event_profilePicButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         String newBio;
        newBio = JOptionPane.showInputDialog(this, "Please enter your new Bio:");
        //.setBio(newBio);
        BioTextbox.setText( "Bio: "+newBio);
        backend.ProfileManagement.getInstance().getProfile(user.getUserId()).setBio(newBio);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BioTextbox;
    private javax.swing.JButton ChangeCoverButton;
    private javax.swing.JButton changePassButton;
    private javax.swing.JLabel coverPhotoLabel;
    private javax.swing.JButton friendsButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton profileButton;
    private javax.swing.JLabel profilePhotoLabel;
    private javax.swing.JButton profilePicButton;
    private javax.swing.JButton refreshButton;
    private frontend.UserContentPanel userContentPanel1;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
