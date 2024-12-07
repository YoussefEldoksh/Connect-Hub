/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.NewsFeed;
import backend.Stories;
import backend.User;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author malak
 */
public class MainNewsPanel extends javax.swing.JPanel {
    private JList<String> storiesList;
    private JList<String> postsList;
    
    private DefaultListModel<String> storiesListModel;
    private DefaultListModel<String> postsListModel;
    User user;
   
    /**
     * Creates new form MainNewsPanel
     */
    public MainNewsPanel() {
        initComponents();
        storiesListModel = new DefaultListModel<>();
        postsListModel = new DefaultListModel<>();

        // Set the JList models to DefaultListModel
        storiesList = new JList<>(storiesListModel);
        postsList = new JList<>(postsListModel);
        
        
        postsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { 
                    int selectedIndex = postsList.getSelectedIndex();

                    System.out.println("User selected: " + selectedIndex);
                    ContentPreviewForFriendsFrame friendcontent= new ContentPreviewForFriendsFrame(selectedIndex, 1);
                }
            }
        }
        );
        
        storiesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = storiesList.getSelectedIndex();

                    System.out.println("User selected: " + selectedIndex);
                    ContentPreviewForFriendsFrame friendcontent= new ContentPreviewForFriendsFrame(selectedIndex, 2);
                }
            }
        }
        );
    }
    
    public void updateStoriesList(User u) {
        this.user= user;
        ArrayList<String> linerep = NewsFeed.getLineRepresentationsStories(u);
        storiesListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            storiesListModel.addElement(linerep.get(i));

        }
    }

    public void updatePostsList(User u) {
        this.user =user;
        ArrayList<String> linerep = NewsFeed.getLineRepresentationsPosts(u);
        postsListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            postsListModel.addElement(linerep.get(i));

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
