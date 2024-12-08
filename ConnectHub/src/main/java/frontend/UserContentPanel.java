/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.ImageHandler;
import backend.NewsFeed;
import backend.Profile;
import backend.User;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author husse
 */
public class UserContentPanel extends javax.swing.JPanel {


    
    private DefaultListModel<String> storiesListModel;
    private DefaultListModel<String> postsListModel;
    User user;
    /**
     * Creates new form UserContentPanel
     */
    public UserContentPanel() {
        initComponents();storiesListModel = new DefaultListModel<>();
        postsListModel = new DefaultListModel<>();

        // Set the JList models to DefaultListModel
        storiesList = new JList<>(storiesListModel);
        postsList = new JList<>(postsListModel);
        storiesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { 
                    int selectedIndex = postsList.getSelectedIndex();

                    System.out.println("User selected: " + selectedIndex);
                }
            }
        }
        );
        
        postsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { 
                    int selectedIndex = postsList.getSelectedIndex();

                    System.out.println("User selected: " + selectedIndex);
                }
            }
        }
        );
        
        
        
    }
    
    
    public void updateStoriesList(User u) {
        ArrayList<String> linerep = NewsFeed.getLineRepresentationsStories(u);
        storiesListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            storiesListModel.addElement(linerep.get(i));

        }
        storiesList.setModel(storiesListModel);
        this.user = u;
    }

    public void updatePostsList(User u) {
        ArrayList<String> linerep = NewsFeed.getLineRepresentationsPosts(u);
        postsListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            postsListModel.addElement(linerep.get(i));

        }
        postsList.setModel(postsListModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        storiesList = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        postsList = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        storiesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane4.setViewportView(storiesList);

        postsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane5.setViewportView(postsList);

        jLabel7.setText("Your posts");

        jLabel6.setText("Your stories");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel7))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel7)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> postsList;
    private javax.swing.JList<String> storiesList;
    // End of variables declaration//GEN-END:variables
}
