/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author pc castle
 */
public class GroupSession {
    
    static Group group;
    
    public GroupSession(Group group) {
       this.group = group;
    }
    
    public static Group getCurrentGroup()
    {
        return group;
    }
    
    public static void setCurrentGroup(Group group)
    {
        GroupSession.group= group;
    }
}
