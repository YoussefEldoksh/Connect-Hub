/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.NewsFeed;
import backend.Posts;
import backend.Stories;
import backend.User;
import backend.UserSession;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author husse
 */
public class ContentPreviewForFriendsFrame extends javax.swing.JFrame {

    User user;
    /**
     * Creates new form ContentPreviewForFriendsFrame
     */
    public ContentPreviewForFriendsFrame(int selectedIndex, int type) {
        initComponents();
        friendContentLabel.setText(UserSession.getCurrentUser().getUsername()+ "'s recent updates");
        friendContentLabel.setFont(new Font("Arial", Font.BOLD, 30));
        friendContentLabel.setIcon(findPost(selectedIndex).getImage());
        friendContentLabel.setText(findPost(selectedIndex).getContent());
        friendContentLabel.setHorizontalTextPosition(JLabel.RIGHT);
        friendContentLabel.setVerticalTextPosition(JLabel.CENTER);
        friendContentLabel.setFont(new Font("Arial", Font.BOLD, 24));
    }
    
    public Posts findPost(int selectedIndex) {
        ArrayList<Posts> posts = NewsFeed.fetchPosts(user);
        Posts postChosen= posts.get(selectedIndex);
        return postChosen;
    }
    
    public void findStory(int selectedIndex) {
        ArrayList<Stories> stories = NewsFeed.fetchStories(user);
        Stories storyChosen= stories.get(selectedIndex);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        friendContentLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(friendContentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(friendContentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(574, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel friendContentLabel;
    // End of variables declaration//GEN-END:variables
}
