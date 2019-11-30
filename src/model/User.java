/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dell
 */
public class User {
    private String UserName;
    private String DisplayName;
    private String Password;
    private String Decription;

    public User(String UserName, String DisplayName, String Password, String Decription) {
        this.UserName = UserName;
        this.DisplayName = DisplayName;
        this.Password = Password;
        this.Decription = Decription;
    }

    public User(String UserName, String DisplayName, String Password) {
        this.UserName = UserName;
        this.DisplayName = DisplayName;
        this.Password = Password;
    }
    
    public String getUserName() {
        return UserName;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public String getPassword() {
        return Password;
    }

    public String getDecription() {
        return Decription;
    }
    
    
    
}
