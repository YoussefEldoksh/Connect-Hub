/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import frontend.ChatFrame;

/**
 *
 * @author pc castle
 */
public class ThreadForChat implements Runnable {
    private volatile boolean running = true;

public void stopThread() {
    running = false;
}
@Override
public void run() {
    while (running) {
        try {
            Thread.sleep(500); // Poll every 500ms
            ChatFrame chatFrame = ChatFrame.getInstance();
            if (chatFrame.getChatName() != null && !chatFrame.getChatName().trim().isEmpty()) {
                chatFrame.loadMessages();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e);
            Thread.currentThread().interrupt();
        }
    }
}
}
