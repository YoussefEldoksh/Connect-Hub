/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.AccountManagement;
import backend.Chat;
import backend.DataBase;
import backend.FileManagement;
import backend.Message;
import backend.ThreadForChat;
import backend.UserSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author malak
 */
public class ChatFrame extends javax.swing.JFrame {

    /**
     * Creates new form ChatFrame
     */
    public String chatName;
    public String chatStatus;
    public Chat chat = null;
    public ArrayList<String> loadedChats = new ArrayList<>();
    private LocalDateTime lastMessageTime = null;
    static ChatFrame instance = null;
     ThreadForChat t= new ThreadForChat();
    public  Thread tt = new Thread(t);
    public static ChatFrame getInstance() {
        if (instance == null) {
            instance = new ChatFrame();
        }
        return instance;
    }

    private ChatFrame() {
        initComponents();
        this.setTitle("Chats");
        tt.start();
    }

    public void setChatHeading() {
        chat_Panel1.setChat(chatName, chatStatus);
    }
    
    public void updateChatsList()
    {
        chat_Menu_Left1.showPeople();
    }


    public String getChatName() {
        return chatName;
    }

    public void loadMessages() {
        DataBase.getInstance().loadChatFile();
        if (chatName == null || chatName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "no chat selected");
        }
        
        
        UserSession.getCurrentUser().fillChats();
        Chat chat = UserSession.getCurrentUser().getSpecificChat(this.chatName);
        chat_Panel1.clearchat();
        System.out.println("check1");
        
        if (chat == null) {
            System.out.println("Chat is null in ChatFrame");
            chat = new Chat(UserSession.getCurrentUser().getUserId() + AccountManagement.findUserId(chatName), new ArrayList<>());
            this.chat = chat;
            DataBase.getInstance().addToGlobalChats(chat);
            UserSession.getCurrentUser().addChat(chat);
        } else {
            this.chat = chat;
            ArrayList<Message> newMessages = chat.getChatMessages();
             System.out.println("check2");
            for (Message message : newMessages) {
                displayMessage(message);
                lastMessageTime = message.getTimeSent();
                 System.out.println("check3");
            }
             System.out.println("check4");
        }
         System.out.println("check5");
    }

    private void displayMessage(Message message) {
       
        
        if (message.getRecieverId().equals(UserSession.getCurrentUser().getUserId())) {
            if (message.getMessage() != null) {
                chat_Panel1.setMessageLeft(message.getMessage(), message.getTimeSent().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                     System.out.println("check6");

            } else {
                chat_Panel1.setMessagesPicLeft(message.getImagePath(), message.getTimeSent().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                    System.out.println("check7");

            }
        } else {
            if (message.getMessage() != null) {
                chat_Panel1.setMessageRight(message.getMessage(), message.getTimeSent().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                    System.out.println("check8");

            
            } else {
                    System.out.println("check9");

                chat_Panel1.setMessagesPicRight(message.getImagePath(), message.getTimeSent().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            }
        }
    }


    /*
        System.out.println("ana abl ma clear el chat");
        chat_Panel1.clearchat();
        System.out.println("ana ba3d ma clear el chat");
        for (Message message : messages) {
            if (message.getRecieverId().equals(UserSession.getCurrentUser().getUserId())) {
                if (message.getMessage() != null) {
                    chat_Panel1.setMessageLeft(message.getMessage(), message.getTimeSent().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                } else {
                    chat_Panel1.setMessagesPicLeft(message.getImagePath(), message.getTimeSent().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                }

            } else {
                if (message.getMessage() != null) {
                    chat_Panel1.setMessageRight(message.getMessage(), message.getTimeSent().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                } else {
                    chat_Panel1.setMessagesPicRight(message.getImagePath(), message.getTimeSent().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                }
            }
        }
    }
     */
    public void addToLoadedChats(String name) {
        loadedChats.add(name);
    }

    public boolean isLoaded(String name) {
        if (loadedChats.contains(name)) {
            return true;
        }
        return false;
    }

    public void sortMessagesByDate() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        border = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chat_Menu_Left1 = new frontend.Chat_Menu_Left();
        jScrollPane2 = new javax.swing.JScrollPane();
        chat_Panel1 = new frontend.Chat_Panel();
        jScrollPane3 = new javax.swing.JScrollPane();
        chat_Menu_Right1 = new frontend.Chat_Menu_Right();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        border.setBackground(new java.awt.Color(219, 219, 252));
        border.setRequestFocusEnabled(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setViewportView(chat_Menu_Left1);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setViewportView(chat_Panel1);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setViewportView(chat_Menu_Right1);

        javax.swing.GroupLayout borderLayout = new javax.swing.GroupLayout(border);
        border.setLayout(borderLayout);
        borderLayout.setHorizontalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        borderLayout.setVerticalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderLayout.createSequentialGroup()
                .addGroup(borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(border, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel border;
    private frontend.Chat_Menu_Left chat_Menu_Left1;
    private frontend.Chat_Menu_Right chat_Menu_Right1;
    private frontend.Chat_Panel chat_Panel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
