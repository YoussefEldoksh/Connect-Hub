/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import backend.Account;
import backend.AccountManagement;
import backend.DataBase;
import backend.FileManagement;
import backend.Message;
import backend.Message_Builder;
import backend.UserSession;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.json.JSONPointer;

/**
 *
 * @author malak
 */
public class Chat_Panel extends javax.swing.JPanel {

    /**
     * Creates new form Chat
     */
    public Chat_Panel() {
        initComponents();
        chatHeading.setLayout(new MigLayout("wrap"));
        incomingMessage.setLayout(new MigLayout("fillx"));
        outBoundMessage.setLayout(new MigLayout("fillx"));
        messagesDisplayPanel.setLayout(new MigLayout("fillx"));
        init();
    }

    public void init() {
        chatHeading.setLayout(new MigLayout());
        incomingMessage.setLayout(new MigLayout("fillx"));
        outBoundMessage.setLayout(new MigLayout("fillx"));
        messagesDisplayPanel.setLayout(new MigLayout("fillx"));
        setChat();
    }

    public void init(String name, String status) {
        chatHeading.setLayout(new MigLayout());
        incomingMessage.setLayout(new MigLayout("fillx"));
        outBoundMessage.setLayout(new MigLayout("fillx"));
        setChat(name, status);

    }

    public void setChat() {
        chatHeading.removeAll();
        chatHeading.add(new Chat_Heading("", ""), "wrap");
        chatHeading.revalidate();
        chatHeading.repaint();
    }

    public void setChat(String name, String status) {
        chatHeading.removeAll();
        chatHeading.add(new Chat_Heading(name, status), "wrap");
        chatHeading.revalidate();
        chatHeading.repaint();
    }

    public void setMessageLeft(String message, String date) {
        messagesDisplayPanel.add(new Chat_Message(message, date), "wrap");
        messagesDisplayPanel.revalidate();
        messagesDisplayPanel.repaint();
    }

    public void setMessageRight(String message, String date) {
        messagesDisplayPanel.add(new Chat_Message(message, date), "wrap, al right");
        messagesDisplayPanel.revalidate();
        messagesDisplayPanel.repaint();
    }

    public void setMessagesPicRight(String imagePath, String date)
    {
        messagesDisplayPanel.add(new Chat_Message_Photo(new ImageIcon(imagePath),date),"wrap, al right");
        messagesDisplayPanel.revalidate();
        messagesDisplayPanel.repaint();
    }
    
        public void setMessagesPicLeft(String imagePath, String date)
    {
        messagesDisplayPanel.add(new Chat_Message_Photo(new ImageIcon(imagePath),date),"wrap");
        messagesDisplayPanel.revalidate();
        messagesDisplayPanel.repaint();
    }
    
    
    
    
    public void clearchat() {
        messagesDisplayPanel.removeAll();
        messagesDisplayPanel.revalidate();
        messagesDisplayPanel.repaint();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        messagesDisplayPanel = new javax.swing.JPanel();
        incomingMessage = new javax.swing.JLayeredPane();
        outBoundMessage = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        attachPhotoButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        chatHeading = new javax.swing.JLayeredPane();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(204, 204, 255));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        messagesDisplayPanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout incomingMessageLayout = new javax.swing.GroupLayout(incomingMessage);
        incomingMessage.setLayout(incomingMessageLayout);
        incomingMessageLayout.setHorizontalGroup(
            incomingMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );
        incomingMessageLayout.setVerticalGroup(
            incomingMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout outBoundMessageLayout = new javax.swing.GroupLayout(outBoundMessage);
        outBoundMessage.setLayout(outBoundMessageLayout);
        outBoundMessageLayout.setHorizontalGroup(
            outBoundMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );
        outBoundMessageLayout.setVerticalGroup(
            outBoundMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout messagesDisplayPanelLayout = new javax.swing.GroupLayout(messagesDisplayPanel);
        messagesDisplayPanel.setLayout(messagesDisplayPanelLayout);
        messagesDisplayPanelLayout.setHorizontalGroup(
            messagesDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagesDisplayPanelLayout.createSequentialGroup()
                .addComponent(incomingMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(outBoundMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        messagesDisplayPanelLayout.setVerticalGroup(
            messagesDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagesDisplayPanelLayout.createSequentialGroup()
                .addGroup(messagesDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(messagesDisplayPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(incomingMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(messagesDisplayPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(outBoundMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 244, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(messagesDisplayPanel);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        attachPhotoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_ADDimages.png"))); // NOI18N
        attachPhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachPhotoButtonActionPerformed(evt);
            }
        });

        sendButton.setBackground(new java.awt.Color(204, 204, 255));
        sendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/result_pngtree-send-icon-image_1130542.jpg"))); // NOI18N
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(attachPhotoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attachPhotoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout chatHeadingLayout = new javax.swing.GroupLayout(chatHeading);
        chatHeading.setLayout(chatHeadingLayout);
        chatHeadingLayout.setHorizontalGroup(
            chatHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        chatHeadingLayout.setVerticalGroup(
            chatHeadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(chatHeading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(chatHeading)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void attachPhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachPhotoButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();

        if (file == null) {
            JOptionPane.showMessageDialog(this, "No file selected");
            return;
        }
        System.out.println(file.getPath());
        
        Message_Builder message = new Message_Builder();
        message.setImagePath(file.getAbsolutePath())
                .setSenderId(UserSession.getCurrentUser().getUserId())
                .setMessage("")
                .setRecieverId(AccountManagement.findUserId(ChatFrame.getInstance().chatName))
                .setTimeSent(LocalDateTime.now());
        Message newMessage = message.build();
        
        
            ChatFrame.getInstance().chat.AddChatMessages(newMessage);
            System.out.println(ChatFrame.getInstance().chat.getChatId());
            System.out.println(ChatFrame.getInstance().chat.getChatMessages());
            DataBase.getInstance().addChatMessage(ChatFrame.getInstance().chat.getChatId(), newMessage);
        
            
        ImageIcon image = new ImageIcon(file.getPath());
        messagesDisplayPanel.add(new Chat_Message_Photo(image,newMessage.getTimeSent().format(DateTimeFormatter.ofPattern("HH:mm:ss a"))),"wrap, al right"); 

    }//GEN-LAST:event_attachPhotoButtonActionPerformed

    private synchronized void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        if (!jTextArea1.getText().trim().isEmpty()) {
            setMessageRight(jTextArea1.getText(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss a")));
            backend.Message_Builder builder = new Message_Builder();

            builder.setTimeSent(LocalDateTime.now())
                    .setMessage(jTextArea1.getText())
                    .setSenderId(UserSession.getCurrentUser().getUserId())
                    .setRecieverId(AccountManagement.findUserId(ChatFrame.getInstance().chatName));

            Message message = builder.build();

            ChatFrame.getInstance().chat.AddChatMessages(message);
            System.out.println(ChatFrame.getInstance().chat.getChatId());
            System.out.println(ChatFrame.getInstance().chat.getChatMessages());
            DataBase.getInstance().addChatMessage(ChatFrame.getInstance().chat.getChatId(), message);

            FileManagement.saveToChats();
           
            jTextArea1.setText("");

        } else {
            jTextArea1.setText("");
        }


    }//GEN-LAST:event_sendButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attachPhotoButton;
    private javax.swing.JLayeredPane chatHeading;
    private javax.swing.JLayeredPane incomingMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel messagesDisplayPanel;
    private javax.swing.JLayeredPane outBoundMessage;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}
