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
import model.User;
import model.Authors;
/**
 *
 * @author dell
 */
public class AuthorDAO {
    public ArrayList<Authors> selectAllAuthor()throws Exception{
        ArrayList<Authors> listOfAu = new ArrayList<>();
        Connection conn = new DBContext().getConnection();
        String sql = "select * from Authors";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String auID = rs.getString("au_id");
            String name = rs.getString("au_name");                      
            String auAddress = rs.getString("au_address");
            Authors A = new Authors(auID, name, auAddress);
            listOfAu.add(A);
        }
        rs.close();
        ps.close();
        conn.close();
        return listOfAu;
    }
    
    public String getAuthorIDbyName(String name) throws Exception{
        Connection conn = new DBContext().getConnection();
        String sql = "select au_id,au_name from Authors";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String nameOF = rs.getString("au_name");            
            String idOf = rs.getString("au_id");
            if(nameOF.equals(name)){
                return idOf;
            }
        }
        rs.close();
        ps.close();
        conn.close();
        return null;
    }
}
