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
public class Books {
    private String title_id;
    private String title;
    private String pub_id;
    private String notes;
    private String username;

    public Books(String title_id, String title, String pub_id, String notes, String username) {
        this.title_id = title_id;
        this.title = title;
        this.pub_id = pub_id;
        this.notes = notes;
        this.username = username;
    }

    public String getTitle_id() {
        return title_id;
    }

    public String getTitle() {
        return title;
    }

    public String getPub_id() {
        return pub_id;
    }

    public String getNotes() {
        return notes;
    }

    public String getUsername() {
        return username;
    }
    
    
}
