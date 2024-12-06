/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connecthub;

import backend.AccountManagement;
import backend.Friend;
import backend.User;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author malak
 */
public class ConnectHub {
        public static void main(String[] args) {
        //users.add(user);
        AccountManagement manager = new AccountManagement();
       manager.signUp("U162", "Tamer@gmail.com", "Ahmed", "test142", LocalDate.now(), true);
        
    }
}
