/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import model.Books;
import dao.PublisherDAO;
import dao.AuthorDAO;

/**
 *
 * @author dell
 */
public class BookDAO {

    public static void insertBook(String titleId, String title, String pubID, String notes, String userName) throws Exception {
        Connection conn = new DBContext().getConnection();
        String sql = "insert into Books (title_id,title,pub_id,notes,username)values (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, titleId);
        ps.setString(2, title);
        ps.setString(3, pubID);
        ps.setString(4, notes);
        ps.setString(5, userName);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public ArrayList<Books> selectAllBook() throws Exception {
        ArrayList<Books> listOfBook = new ArrayList<>();
        Connection conn = new DBContext().getConnection();
        String sql = "select * from Books";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String titleID = rs.getString("title_id");
            String title = rs.getString("title");
            String pubID = rs.getString("pub_id");
            String notes = rs.getString("notes");
            String userName = rs.getString("username");
            listOfBook.add(new Books(titleID, title, pubID, notes, userName));
        }
        rs.close();
        ps.close();
        conn.close();
        return listOfBook;
    }

    public void delete(String code, String auID) throws Exception {
        Connection conn = new DBContext().getConnection();
        String sql = "delete from TitleAuthor where title_id like ? and au_id like ?";
        String sql2 = "delete from Books where title_id like ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps.setString(1, code);
        ps.setString(2, auID);
        ps2.setString(1, code);
        ps.executeUpdate();
        ps2.executeUpdate();
        JOptionPane.showMessageDialog(null, "complete");
        conn.close();
    }

    public void update(String titleID, String title, String author, String pubname, String note) throws Exception {
        PublisherDAO PD = new PublisherDAO();
        Connection conn = new DBContext().getConnection();
        String pubid = PD.GetPubIDByName(pubname);
        String auID = new AuthorDAO().getAuthorIDbyName(author);
        String sql1 = "UPDATE TitleAuthor SET au_id = ? where title_id like ?";
        String sql2 = "UPDATE Books SET title = ? , notes = ? ,pub_id = ?  where title_id like ?";
        PreparedStatement ps1 = conn.prepareStatement(sql1);
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps1.setString(1, auID);
        ps1.setString(2, titleID);
        ps2.setString(1, title);
        ps2.setString(2, note);
        ps2.setString(3, pubid);
        ps2.setString(4, titleID);
        ps1.executeUpdate();
        ps2.executeUpdate();
        conn.close();
        JOptionPane.showMessageDialog(null, "Update sucessfully !");
    }
}
