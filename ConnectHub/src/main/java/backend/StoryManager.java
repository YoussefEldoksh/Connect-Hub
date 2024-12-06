/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author dell
 */
public class StoryManager {
    private ArrayList<Stories> stories;
    private ScheduledExecutorService scheduler;

    public StoryManager() {
        //a scheduled executor service
        scheduler = Executors.newScheduledThreadPool(1);
        startExpirationCheck();
    }

   private void startExpirationCheck() {
        scheduler.scheduleAtFixedRate(() -> {
            try {
                // Check for expired stories and update the list
                StoryExpirationChecker checker = new StoryExpirationChecker(stories);
                checker.run();
            } catch (Exception e) {
                e.printStackTrace(); 
            }
        }, 0, 2, TimeUnit.SECONDS); // Check every 2 seconds
    }

    public void shutdown() {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
        }
    }
}
