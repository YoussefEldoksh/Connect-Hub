/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.AccountManagement;
import backend.DataBase;
import backend.User;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author malak
 */
public class SignUpWindow extends javax.swing.JFrame {
SignIn_Or_SignUp_Window parentWindow;
static SignUpWindow instance;

    /**
     * Creates new form SignUpWIndow
     */
    public SignUpWindow(SignIn_Or_SignUp_Window parentWindow) {
        initComponents();
        this.parentWindow=parentWindow;
    }

    public static SignUpWindow getInstance(SignIn_Or_SignUp_Window parentWindow) {
        if (instance == null) {
            instance = new SignUpWindow(parentWindow);
        }
        return instance;
    }
    
    public void openNewsFeedPage(User u) {
        this.setVisible(false);
        System.out.println("ana ahao");
        NewsFeedPage nfp = NewsFeedPage.getInstance(u);
        nfp.setVisible(true);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        EmailTextField = new javax.swing.JTextField();
        UsernameTextField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        SigninfromSignupButton = new javax.swing.JButton();
        SignUpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setForeground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel1.setText("Signup");

        jLabel2.setText("Email");

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        jLabel5.setText("Data of Birth");

        jLabel6.setText("Already have an account?");

        SigninfromSignupButton.setBackground(new java.awt.Color(255, 255, 153));
        SigninfromSignupButton.setText("Signin now");
        SigninfromSignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SigninfromSignupButtonActionPerformed(evt);
            }
        });

        SignUpButton.setBackground(new java.awt.Color(235, 207, 18));
        SignUpButton.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        SignUpButton.setForeground(new java.awt.Color(255, 255, 255));
        SignUpButton.setText("Signup");
        SignUpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SigninfromSignupButton)
                .addGap(68, 68, 68))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SignUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(EmailTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(UsernameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PasswordField, javax.swing.GroupLayout.Alignment.LEADING))))))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(UsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(SignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(SigninfromSignupButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
        // TODO add your handling code here:
        String email= EmailTextField.getText();
        String username= UsernameTextField.getText();
        String password = PasswordField.getText();
        
        String userID= "U4";  //(DataBase.getInstance().getUsers().size());
        System.out.println("Current number of users: " + DataBase.getInstance().getUsers().size());
        LocalDate dob= LocalDate.now();

        int n= AccountManagement.signUp(userID, email, username, password, dob, true);
        switch (n) {
        case 1:
            JOptionPane.showMessageDialog(this, "Incorrect Email Format. Please try again");
            break;
        case 2:
            JOptionPane.showMessageDialog(this, "Username already exists. Please choose another one");
            break;
        case 3:
            JOptionPane.showMessageDialog(this, "An account linked to this email already exists.");
            break;
        case 4:
            JOptionPane.showMessageDialog(this, "Your account was successfully created.\nWelcome at ConnectHub!");
            User u = AccountManagement.findUser(username);
            this.openNewsFeedPage(u);
            break;
        default:
            break;
    }
    }//GEN-LAST:event_SignUpButtonActionPerformed

    private void SigninfromSignupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SigninfromSignupButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        parentWindow.openSignInWindow();
    }//GEN-LAST:event_SigninfromSignupButtonActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JButton SigninfromSignupButton;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
