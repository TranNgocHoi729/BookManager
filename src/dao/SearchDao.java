/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import model.Search;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author dell
 */
public class SearchDao {
    public static ArrayList<Search> selectAll()throws Exception{
        ArrayList<Search> listOfResult = new ArrayList<>();
        Connection connect = new DBContext().getConnection();
        
        String SQL = "select Books.title_id , Books.title , Publishers.pub_name , Authors.au_name , Books.notes from Books , Publishers, Authors , TitleAuthor where Books.title_id = TitleAuthor.title_id and Publishers.pub_id = Books.pub_id and TitleAuthor.au_id = Authors.au_id";
        PreparedStatement ps = connect.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String bookId = rs.getString("title_id");
            String bookName = rs.getString("title");
            String publisherName = rs.getString("pub_name");
            String author = rs.getString("au_name");
            String note = rs.getString("notes");
            Search s = new Search(bookId, bookName, publisherName, author, note);
            listOfResult.add(s);
            System.out.println(s.toString());
        }
        rs.close();
        ps.close();
        connect.close();
        return listOfResult;
    }
    
 
}
