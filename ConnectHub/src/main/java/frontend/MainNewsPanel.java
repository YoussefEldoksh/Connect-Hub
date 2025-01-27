/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.NewsFeed;
import backend.Stories;
import backend.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
//    private JList<String> storiesList;
//    private JList<String> postsList;
//    

    private DefaultListModel<String> postsListModel= new DefaultListModel<>();
    private DefaultListModel<String> storiesListModel = new DefaultListModel<>();

    boolean storiesListUpdate = false;
    boolean postsListUpdate = false;
    User user;
   
    /**
     * Creates new form MainNewsPanel
     */
    public MainNewsPanel() {
        initComponents();


        // Set the JList models to DefaultListModel

        
                postsList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) { 
                   if(!postsListUpdate){ 
                    int selectedindix = postsList.getSelectedIndex();
                   // ContentPreviewForFriendsFrame friendcontent= new ContentPreviewForFriendsFrame(selectedindix,1,user);
                    //friendcontent.setVisible(true);
                }}

            }
        }
        );

        storiesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {

                   if(!storiesListUpdate){
                    String selectedIndex = storiesList.getSelectedValue();
                    int selectedindix = storiesList.getSelectedIndex();
                    String token[] = selectedIndex.split(" ");

                    System.out.println("User selected: " + token[0]);
                       
//                    ContentPreviewForFriendsFrame friendcontent= new ContentPreviewForFriendsFrame(selectedindix, 2,user);
                    
          //          friendcontent.setVisible(true);
                    
                   }

            }
        }}
        );
    }

    public void updateStoriesList(User u) {
        storiesListUpdate = true;
        this.user = u;
        ArrayList<String> linerep = NewsFeed.getLineRepresentationsAllStories(u);
        storiesListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            storiesListModel.addElement(linerep.get(i));
        }
        storiesList.setModel(storiesListModel);
        storiesListUpdate = false;
        System.out.println("Stories: " + linerep);
    }

    public void updatePostsList(User u) {
        this.user = u;
        postsListUpdate = true;
        ArrayList<String> linerep = NewsFeed.getLineRepresentationsAllPosts(u);
        postsListModel.clear();

        for (int i = 0; i < linerep.size(); i++) {
            postsListModel.addElement(linerep.get(i));

        }
        postsList.setModel(postsListModel);
        postsListUpdate = false;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        storiesList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        postsList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Check  all your friends' updates here!");

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

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel2.setText("Stories:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel3.setText("Posts:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> postsList;
    private javax.swing.JList<String> storiesList;
    // End of variables declaration//GEN-END:variables
}
