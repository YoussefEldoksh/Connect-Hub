/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author malak
 */
public class ProfilesDataBase {
    
    
    private ArrayList<Profile> profiles;
    
    private static ProfilesDataBase instance = null;
    

    private ProfilesDataBase() {
        loadProfilesFile();
    }
        public static ProfilesDataBase getInstance() {
        if (instance == null) {
            instance = new ProfilesDataBase(); 
        }
        return instance;
    }
    
    
        public void loadProfilesFile()
    {

        this.profiles = FileManagement.loadFromProfilesJsonFile(); 
    }
    
         public  ArrayList<Profile> getProfiles() {
        return profiles;
    }
    public  void addProfile(Profile profile){
        profiles.add(profile);
        FileManagement.saveToProfilesJsonFile();
    }
    
    
}
