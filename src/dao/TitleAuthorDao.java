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

/**
 *
 * @author dell
 */
public class TitleAuthorDao {
  public static void insertTitleAu(String title_Id , String au_id, int au_ord)throws Exception{
        Connection conn = new DBContext().getConnection();
        String sql = "insert into titleAuthor (au_id,title_id,au_ord)values (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, au_id);
        ps.setString(2,title_Id );
        ps.setInt(3, au_ord);       
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
