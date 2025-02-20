/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.Account;
import java.awt.Color;

/**
 *
 * @author malak
 */
public class Chat_Item_People extends javax.swing.JPanel {

    /**
     * Creates new form Item_People
     */
    private String name;
    static boolean selected = false;

    public Chat_Item_People(String name) {
        initComponents();
        friendName.setText(name);
        this.name = name;
    }

    public Chat_Item_People() {
        initComponents();

    }

    private void init() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Image_Label = new javax.swing.JLabel();
        friendName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(220, 220, 220));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        Image_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_DefaultPhoto.jpg"))); // NOI18N

        friendName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        friendName.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Image_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(friendName, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(friendName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Image_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if (ChatFrame.getInstance().isLoaded(friendName.getText())) {
            ChatFrame.getInstance().chatName = friendName.getText();
            boolean status = backend.AccountManagement.findUser(name).getStatus();
            if (status) {
                ChatFrame.getInstance().chatStatus = "Online";
            } else {
                ChatFrame.getInstance().chatStatus = "Offline";
            }
            ChatFrame.getInstance().setChatHeading();
            ChatFrame.getInstance().loadMessages();
            return;
        } else {
            ChatFrame.getInstance().addToLoadedChats(friendName.getText());
        }
        ChatFrame.getInstance().chatName = friendName.getText();

        System.out.println(friendName.getText());
        boolean status = backend.AccountManagement.findUser(name).getStatus();
        if (status) {
            ChatFrame.getInstance().chatStatus = "Online";
        } else {
            ChatFrame.getInstance().chatStatus = "Offline";
        }

        ChatFrame.getInstance().setChatHeading();
        ChatFrame.getInstance().loadMessages();
    }//GEN-LAST:event_formMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        setBackground(new Color(238, 226, 245));
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
        setBackground(new Color(220, 220, 220));
    }//GEN-LAST:event_formMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Image_Label;
    private javax.swing.JLabel friendName;
    // End of variables declaration//GEN-END:variables
}
