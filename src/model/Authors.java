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
public class Authors {
    private String  au_id;
    private String au_name;
    private String au_address;

    public Authors(String au_id, String au_name, String au_address) {
        this.au_id = au_id;
        this.au_name = au_name;
        this.au_address = au_address;
    }

    public String getAu_id() {
        return au_id;
    }

    public String getAu_name() {
        return au_name;
    }

    public String getAu_address() {
        return au_address;
    }
    
}
