/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.Content;
import backend.ContentFactory;
import backend.DataBase;
import backend.Group;
import backend.GroupsDataBase;
import backend.Posts;
import backend.Stories;
import backend.User;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author pc castle
 */

public class groupPostsPanel extends javax.swing.JPanel {


    private DefaultListModel<String> groupPostsListModel = new DefaultListModel<>();
    boolean groupPostsListUpdate = false;
    private static int contentIDnum=0;
    ArrayList<Posts> posts= new ArrayList<>();
    User user;
    Group g;
    /**
     * Creates new form groupPostsPanel
     */
    public groupPostsPanel() {
        initComponents();
    }
public void addContent(int contentType, String userId) {
        String text= null;
        Image image=null;
        ImageIcon imageIcon= null;
 
        File file= null;
        
            text = JOptionPane.showInputDialog(this, "Please enter your post's text");
            JFileChooser jfc = new JFileChooser();
            
            jfc.setDialogTitle("Select an Image File");

            jfc.showOpenDialog(this);
            file = jfc.getSelectedFile();
            if(file == null)
            {
                return;
            }
            try {
                image = ImageIO.read(file);
                imageIcon = new ImageIcon(image.getScaledInstance(350, 350, Image.SCALE_SMOOTH));
                
            } catch (IOException e) {
                // Handles the exception if the image cannot be loaded
                JOptionPane.showMessageDialog(null, "Failed to load the image: " + e.getMessage());
            }
                Posts post= (Posts)ContentFactory.createContent("post", ("C" + (contentIDnum++)) , userId, text == null? " ":text);
                
                ContentPreviewForGroups cpg = new ContentPreviewForGroups(post, contentType,user);
                cpg.setVisible(true);

                if(file!=null){
                post.setImagePath(file.getPath());
                post.setImage(imageIcon);
                }
                posts.add(post);
                g.addGroupPosts(post);
                GroupsDataBase.getInstance().addToGlobalGroupsPosts(post);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        groupPostsList = new javax.swing.JList<>();
        AddPostButton = new javax.swing.JButton();

        groupPostsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        groupPostsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        groupPostsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                groupPostsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(groupPostsList);

        AddPostButton.setText("Add Post");
        AddPostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPostButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddPostButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddPostButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void groupPostsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_groupPostsListValueChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_groupPostsListValueChanged

    private void AddPostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPostButtonActionPerformed
        int content = 1; 
    String[] options = {"Text Only", "Text and Picture"};
    int choice = JOptionPane.showOptionDialog(
        null, 
        "Choose how you want to add your post:", 
        "Post Options", 
        JOptionPane.DEFAULT_OPTION, 
        JOptionPane.INFORMATION_MESSAGE, 
        null, // No custom icon
        options, 
        options[0] 
    );
    
    if (choice == 0){
        content = 1; // Text Only
    } else if (choice == 1) {
        content = 2; // Text and Picture
    } else {
        JOptionPane.showMessageDialog(
            null, 
            "No option selected. Please try again.", 
            "Error", 
            JOptionPane.ERROR_MESSAGE
        );
        return; // Exit the method if no valid option is chosen
    }

    addContent(content, user.getUserId());
    }//GEN-LAST:event_AddPostButtonActionPerformed

    public void deleteContent(boolean Yes_Or_No, Posts p)
    {
    //if(Yes_Or_No = true)
       // p.deleteFromGroups(p.getContentID());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPostButton;
    private javax.swing.JList<String> groupPostsList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
