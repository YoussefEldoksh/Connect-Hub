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
    public ContentPreviewForFriendsFrame(int selectedIndex, int contentType, User user) {
        initComponents();
        this.user = user;
        
      
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        
        if (contentType == 1) {
            displayPost(selectedIndex);
        }
        if (contentType == 2) {
            displayStory(selectedIndex);
        }
    }
    
     private void displayPost(int selectedIndex) {
        ArrayList<Posts> posts = NewsFeed.fetchPosts(user);
        if (selectedIndex >= 0 && selectedIndex < posts.size()) {
            Posts post = posts.get(selectedIndex);
            titleLabel.setText("Post by " + user.getUsername());
            titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
            contentLabel.setText(post.getContent());
            contentLabel.setIcon(post.getImage());
            contentLabel.setHorizontalTextPosition(JLabel.RIGHT);
            contentLabel.setVerticalTextPosition(JLabel.CENTER);
        } else {
            contentLabel.setText("Invalid post selection.");
        }
    }
  
    private void displayStory(int selectedIndex) {
         ArrayList<Stories> stories = NewsFeed.fetchStories(user);
        if (selectedIndex >= 0 && selectedIndex < stories.size()) {
            Stories story = stories.get(selectedIndex);
            titleLabel.setText("Story by " + user.getUsername());
            titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
            contentLabel.setHorizontalTextPosition(JLabel.RIGHT);
            contentLabel.setVerticalTextPosition(JLabel.CENTER);
            contentLabel.setText(story.getContent());
            contentLabel.setIcon(story.getImage());
        } else {
            contentLabel.setText("Invalid post selection.");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        contentLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(63, Short.MAX_VALUE)
                    .addComponent(contentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(57, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(574, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(155, Short.MAX_VALUE)
                    .addComponent(contentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(121, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contentLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
