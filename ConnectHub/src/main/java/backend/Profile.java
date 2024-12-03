
package backend;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Profile {
    private Image coverPhoto;
    private ImageIcon profilePhoto;
    private String bio;
    private String password;
    private User user;
    //content array
    public Profile(Image cover,ImageIcon profilePhoto,String bio,User user){
       coverPhoto=cover;
       this.profilePhoto=profilePhoto;
       this.bio=bio;
       this.user=user;
       this.password=user.getPassword();
    }
    
    public Image getCoverPhoto(){
        return coverPhoto;
    }
    
    public ImageIcon getProfilePhoto(){
        return profilePhoto;
    }
    
    public String getBio(){
        return bio;
    }
    
    public User getUser(){
        return user;
    }
    
    public String getUserId(){
        return user.getUserId();
    }
    
    public void setCoverPhoto(Image cover){
        this.coverPhoto=cover;
    }
    
    public void setProfilePhoto(ImageIcon profilePhoto){
        this.profilePhoto=profilePhoto;
    }
    public void setBio(String bio){
        this.bio=bio;
    }
    
    public void setPassword(String password){
        user.setPassword(password);
    }
    
    
}
