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
public class TitleAuthor {
    private String  au_id;
    private String title_id;
    private String au_ord;

    public TitleAuthor(String au_id, String title_id, String au_ord) {
        this.au_id = au_id;
        this.title_id = title_id;
        this.au_ord = au_ord;
    }

    public String getAu_id() {
        return au_id;
    }

    public String getTitle_id() {
        return title_id;
    }

    public String getAu_ord() {
        return au_ord;
    }
    
    
}
