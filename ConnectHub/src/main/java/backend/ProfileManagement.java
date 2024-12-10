/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/*import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import org.json.JSONArray;
import org.json.JSONObject;*/


public class ProfileManagement {
    //private ArrayList<Profile> profiles;//Hahsmap with key=userId to the profile of the user
    
    private static ProfileManagement instance=null;
    
    private ProfileManagement(){//using singleton design pattern
        
       // profiles=DataBase.getProfiles();
    }
    
    public static ProfileManagement getInstance(){//in order to return a single object only
        if(instance==null){
            instance= new ProfileManagement();
        }
        return instance;
    }
    
    public void addProfile(Profile profile){
        ProfilesDataBase.getInstance().addProfile(profile);
    }
    
    public Profile getProfile(String userid){
        for(Profile profile:ProfilesDataBase.getInstance().getProfiles()){
            if(profile.getUserId().equals(userid)){
                return profile;
            }
        }
        return null;
    }
    
    
    
    /*private void loadProfiles(){
        String json;
        try {
            json=new String(Files.readAllBytes(Paths.get("profiles.json")));//reads the json file
        } catch (IOException ex) {
            System.out.println("File doesn't exist.");
            return;
        }
        JSONArray profilesArray=new JSONArray(json);//creates an array of all the profiles in the file
        DateTimeFormatter formatter=DateTimeFormatter.ISO_DATE;
        for(int i=0;i<profilesArray.length();i++){//stores the profiles in the Hashmap
            JSONObject profileJSON = profilesArray.getJSONObject(i);
            String userId=profileJSON.getString("userId");
            String bio=profileJSON.getString("bio");
            String cover=profileJSON.getString("cover");
            String profilePic=profileJSON.getString("profile picture");
            // must change the image file to class image before adding to map
            //File cov=new File(cover);//path for cover pic
            //ImageIcon coverPicture=new ImageIcon(cov.getAbsolutePath());
            //File pp=new File(profilePic);//path for profile pic
            //ImageIcon profilePicture=new ImageIcon(pp.getAbsolutePath());
            User user1=null;
            for(User user:users){
                if(userId.equals(user.getUserId())){
                    user1=user;//get the user with the userId in profiles
                    break;
                }
            }
            if(user1==null){
                System.out.println("User doesn't exist.");
                return;
            }
            profiles.put(userId, new Profile(cover,profilePic,bio,user1));
        }
    }
    
    public static void saveProfiles(){
        JSONArray profilesArray=new JSONArray();
        profiles=new HashMap<>();
        //profiles.put("U123", new Profile("c123htt","c456htt","This is my bio!",new User("23","32","32","dw",LocalDate.now(),true)));
        //profiles.put("U1256", new Profile("c123htt","c456htt","This is not my bio!",new User("23","32","32","dw",LocalDate.now(),true)));
        profiles.forEach((userId,profile) -> {
            JSONObject j=new JSONObject();
            j.put("userId", userId);
            j.put("bio", profile.getBio());
            j.put("cover", profile.getCoverPath());
            j.put("profile picture", profile.getProfilePicPath());
            profilesArray.put(j);
        });
        try{
                Files.write(Paths.get("profiles.json"), profilesArray.toString(4).getBytes());
            }
        catch(IOException e){
            System.out.println("File doesn't exist");
        }
    }
    
    /*public static void main(String []args){
        saveProfiles();
    }*/
    
    
}
