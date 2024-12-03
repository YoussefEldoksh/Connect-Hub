
package backend;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;


public class Profile {
    private ImageIcon coverPhoto;
    private String coverPath;
    private ImageIcon profilePhoto;
    private String profilePicPath;
    private String bio;
    private String password;
    private final User user;
    //content array: private ArrayList<Content>content;
    public Profile(String cover,String profilePhoto,String bio,User user){
       coverPath=cover;
       this.profilePicPath=profilePhoto;
       this.bio=bio;
       this.user=user;
       this.password=user.getPassword();
       setCoverPhoto(coverPath);
       setProfilePhoto(profilePicPath);
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
    
    public void setCoverPhoto(ImageIcon cover){
        this.coverPhoto=cover;
    }
    
    public void setCoverPath(String cover){
        this.coverPath=cover;
    }
    
    public void setCoverPhoto(String cover){
        File cov=new File(cover);//path for cover pic
        this.coverPhoto=new ImageIcon(cov.getAbsolutePath());
    }
    
    public void setProfilePhoto(ImageIcon profilePhoto){
        this.profilePhoto=profilePhoto;
    }
    
    public void setProfilePicPath(String profilePic){
        this.profilePicPath=profilePic;
    }
    
    public void setProfilePhoto(String profilePic){
        File pp=new File(profilePic);//path for profile pic
        this.profilePhoto=new ImageIcon(pp.getAbsolutePath());
    }
    
    public void setBio(String bio){
        this.bio=bio;
    }
    
    public void setPassword(String password){
        user.setPassword(password);
    }
    
    
}
