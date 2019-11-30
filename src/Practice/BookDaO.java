/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author dell
 */
public class BookDaO {
    // select all
    public List<Book> selectAll() throws Exception{
        String sql = "select * from books";
        List<Book> listB = executeQuery(sql);
        return listB;
        
    }        

    
    private List<Book> executeQuery(String sql)throws Exception{
        Connection conn = new DBContext().getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Book> b = new Vector<>();
        while(rs.next()){
            String titleID = rs.getString("titleID");
            String title = rs.getString("title");
            String pub_id = rs.getString("pub_id");
            String note = rs.getString("notes");
            String username = rs.getString("username");
            b.add(new Book(titleID, title, pub_id, note, username));
        }
        rs.close();
        return b;
    }
    // select by name
}
