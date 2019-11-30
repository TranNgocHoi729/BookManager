/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import dao.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListModel;
import model.User;
import model.*;
 
/**
 *
 * @author dell
 */
public class Control {

    SearchDao SD = new SearchDao();
    ArrayList<Search> searchResult;
    PublisherDAO pubDao = new PublisherDAO();
    BookDAO BD = new BookDAO();
    AuthorDAO auDao = new AuthorDAO();

    public ArrayList<Search> displayResult(String key, int type) throws Exception {
        searchResult = SD.selectAll();
        System.out.println("Real Type : " + type);
        switch (type) {
            case 0:
                return searchByID(key, searchResult);
            case 1:
                return searchByTitle(key, searchResult);
            case 2:
                return searchByPublisher(key, searchResult);
            case 3:
                return searchByAuthor(key, searchResult);
            default:
                return searchByNote(key, searchResult);
        }
    }

    private ArrayList<Search> searchByID(String ID, ArrayList<Search> S) {
        ArrayList<Search> result = new ArrayList<>();
        for (Search s : S) {
            if (s.getBookId().contains(ID)) {
                result.add(s);
            }
        }
        return result;
    }

    private ArrayList<Search> searchByTitle(String title, ArrayList<Search> S) {
        ArrayList<Search> result = new ArrayList<>();
        for (Search s : S) {
            if (s.getBookTitle().contains(title)) {
                result.add(s);
            }
        }
        return result;
    }

    private ArrayList<Search> searchByPublisher(String publisher, ArrayList<Search> S) {
        ArrayList<Search> result = new ArrayList<>();
        for (Search s : S) {
            if (s.getPublisherName().contains(publisher)) {
                result.add(s);
            }
        }
        return result;
    }

    private ArrayList<Search> searchByAuthor(String name, ArrayList<Search> S) {
        ArrayList<Search> result = new ArrayList<>();
        for (Search s : S) {
            if (s.getAuthorName().contains(name)) {
                result.add(s);
            }
        }
        return result;
    }

    private ArrayList<Search> searchByNote(String note, ArrayList<Search> S) {
        ArrayList<Search> result = new ArrayList<>();
        for (Search s : S) {
            if (s.getNote().contains(note)) {
                result.add(s);
            }
        }
        return result;
    }

    private String realPass(char[] x) {
        String pass = "";
        for (int i = 0; i < x.length; i++) {
            pass += x[i];
        }
        return pass;
    }

    public boolean LogIn(String userName, char[] pass) throws Exception {
        String password = realPass(pass);
        UserDAO uDAO = new UserDAO();
        ArrayList<User> userList = uDAO.selectAllUser();
        for (User u : userList) {
            if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String userName, char[] pass) throws Exception {
        String password = realPass(pass);
        UserDAO uDAO = new UserDAO();
        ArrayList<User> userList = uDAO.selectAllUser();
        for (User u : userList) {
            if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<String> getAllAuthor() throws Exception {
        AuthorDAO auDAO = new AuthorDAO();
        ArrayList<Authors> x = auDAO.selectAllAuthor();
        ArrayList<String> result = new ArrayList<>();
        for(Authors a : x){
            result.add(a.getAu_name());
        }
        return result;
    }

    public ArrayList<String> getAllPublisher() throws Exception {
        PublisherDAO pubDAO = new PublisherDAO();
        return pubDAO.selectAllPublisher();
    }

    public void addBook(String titleId, String title, String pub_name, String notes, String userName, ListModel<String> listAu) throws Exception {
        String pubID = pubDao.GetPubIDByName(pub_name);
        BookDAO.insertBook(titleId, title, pubID, notes, userName);
        addTitleAuthor(titleId, listAu);
    }
    
    private void addTitleAuthor(String titleId,ListModel<String> listAu) throws Exception{
        for (int i = 0; i < listAu.getSize(); i++) {
            String auId = auDao.getAuthorIDbyName(listAu.getElementAt(i));
            pubDao.insertPD(auId, titleId, i+1);
        }
    }
   
    public boolean checkExistBook(String ID) throws Exception{
        ArrayList<Books> listBook = BD.selectAllBook();
        for(Books b : listBook){
            if(b.getTitle_id().equalsIgnoreCase(ID)){
                return false;
            }
        }
        return true;
    }
    
    
    
   public void deleteBooks(String code , String auName) throws Exception{
       String auID = auDao.getAuthorIDbyName(auName);
       BD.delete(code, auID);
   }
   
   public void update(String titleID, String title, String author, String pubID, String note) throws Exception{
       BD.update(titleID, title, author, pubID, note);
       
   }
 
}
