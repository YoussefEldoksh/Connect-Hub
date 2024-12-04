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
        User user = new User("U122", "Ahmed@gmail.com", "Ahmed", "test122", LocalDate.now(), true);
        ArrayList<User> users = new ArrayList<>();
        //users.add(user);
        Friend friend = new Friend("khaled@gmail.com", "khaled", "U188");
        user.addFriends(friend);
        AccountManagement manager = new AccountManagement();
       manager.signUp("U162", "Tamer@gmail.com", "Ahmed", "test142", LocalDate.now(), true);
       System.out.println("Users list size: " + users.size());
        
    }
}
