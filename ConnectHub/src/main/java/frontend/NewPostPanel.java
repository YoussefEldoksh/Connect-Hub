/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.Content;
import backend.DataBase;
import backend.FileManagement;
import backend.Posts;
import backend.Stories;
import backend.User;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author malak
 */
public class NewPostPanel extends javax.swing.JPanel {

    private static int contentIDnum=0;
    ArrayList<Content> contents= new ArrayList<>();
        
    /**
     * Creates new form NewPostFeedPanel
     */
    public NewPostPanel() {
        initComponents();
    }

    public void addContent(int contentType, int choiceChosen, String userId) {
        int choice = choiceChosen;
        String text= null;
        Image image=null;
        ImageIcon imageIcon= null;
        JFileChooser jfc = new JFileChooser();
        File file= null;
        
        if (choice == 0) {
            text = JOptionPane.showInputDialog(this, "Please enter your story's text", "Add Story");
            ImagePreviewFrame ipf = new ImagePreviewFrame(null, text);
            ipf.setVisible(true);
        } else if (choice == 1) {
            text = JOptionPane.showInputDialog(this, "Please enter your story's text", "Add Story");
            jfc.setDialogTitle("Select an Image File");
            jfc.showOpenDialog(this);
            file = jfc.getSelectedFile();
            try {
                image = ImageIO.read(file);
                imageIcon = new ImageIcon(image.getScaledInstance(350, 350, Image.SCALE_SMOOTH));
                ImagePreviewFrame ipf = new ImagePreviewFrame(imageIcon, text);
                ipf.setVisible(true);
            } catch (IOException e) {
                // Handle the exception if the image cannot be loaded
                JOptionPane.showMessageDialog(null, "Failed to load the image: " + e.getMessage());
            }
        }
        
        if (contentType == 1) {
                Posts post = new Posts("P" + (contentIDnum++), userId, text, imageIcon, file.getPath());
                contents.add(post);
                DataBase.getInstance().addToGlobalPosts(post);
            } else if (contentType == 2) {
                Stories story = new Stories("S" + (contentIDnum++), userId, text, imageIcon, file.getPath());
                contents.add(story);
                DataBase.getInstance().addTOGlobalStories(story);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
