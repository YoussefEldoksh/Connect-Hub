
package backend;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import javax.swing.ImageIcon;


public class Profile {
    private ImageIcon coverPhoto;
    private String coverPath;
    private ImageIcon profilePhoto;
    private String profilePicPath;
    private String bio;
    private String password;
    private final User user;
    
    public Profile(String cover,String profilePhoto,String bio,User user){
       //coverPath=cover;
       //this.profilePicPath=profilePhoto;
       this.bio=bio;
       this.user=user;
       this.password=user.getPassword();
       if(profilePhoto==null){
         
        profilePicPath = "/Images/DefaultPhoto.jpg"; // Correct path to default photo
        this.profilePhoto = new ImageIcon(getClass().getResource("/Images/DefaultPhoto.jpg"));           
        }
       else {
           profilePicPath = profilePhoto;
           this.profilePhoto = new ImageIcon(getClass().getResource(profilePicPath));
       }
       
       if(cover==null){
        coverPath = "/Images/background.jpg"; // Correct path to default cover photo
        this.coverPhoto = new ImageIcon(getClass().getResource("/Images/background.jpg")); 
       }       
       else {
           coverPath = cover;
           this.coverPhoto = new ImageIcon(getClass().getResource(coverPath));
       }
    }
    


    public ImageIcon getCoverPhoto(){
        return coverPhoto;
    }
    
    public ImageIcon getProfilePhoto(){
        return profilePhoto;
    }
    
    public String getBio(){
        return bio;
    }
    
    public String getCoverPath(){
        return coverPath;
    }
    public String getProfilePicPath(){
        return profilePicPath;
    }
    
    public User getUser(){
        return user;
    }
    
    public String getUserId(){
        return user.getUserId();
    }
    
    /*public void setCoverPhoto(ImageIcon cover){
        this.coverPhoto=cover;
    }*/
    
    public void setCover(String cover){
        coverPath="Images/"+Paths.get(cover).getFileName().toString();//the path is the images file in the project
        this.coverPhoto=ImageHandler.saveImage(cover);
    }
    
    /*public void setCoverPhoto(String cover){
        File cov=new File(cover);//path for cover pic
        
        this.coverPhoto=new ImageIcon(cov.getAbsolutePath());
    }*/
    
    /*public void setProfilePhoto(ImageIcon profilePhoto){
        this.profilePhoto=profilePhoto;
    }*/
    
    public void setProfilePic(String profilePic){
        profilePicPath="/Images/"+Paths.get(profilePic).getFileName().toString();
        this.profilePhoto=ImageHandler.saveImage(profilePic);
    }
    
    /*public void setProfilePhoto(String profilePic){
        File pp=new File(profilePic);//path for profile pic
        
        this.profilePhoto=new ImageIcon(pp.getAbsolutePath());
    }*/
    
    public void setBio(String bio){
        this.bio=bio;
    }
    
    public void setPassword(String password){
        user.setPassword(password);
    }
    
    
}
