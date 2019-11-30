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
public class PublisherDAO {
    
    public void insertPD(String auID, String titleID, int ord) throws Exception {
        Connection conn = new DBContext().getConnection();
        String sql = "insert into TitleAuthor (au_id,title_id,au_ord)values (?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, auID);
        ps.setString(2, titleID);
        ps.setInt(3, ord);        
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
    
    public ArrayList<String> selectAllPublisher() throws Exception {
        ArrayList<String> listOfPub = new ArrayList<>();
        Connection conn = new DBContext().getConnection();
        String sql = "select pub_name from Publishers";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String name = rs.getString("pub_name");            
            listOfPub.add(name);
        }
        rs.close();
        ps.close();
        conn.close();
        return listOfPub;
    }
    
    public ArrayList<String> selectAllPublisherID() throws Exception {
        ArrayList<String> listOfPubId = new ArrayList<>();
        Connection conn = new DBContext().getConnection();
        String sql = "select pub_id from Publishers";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString("pub_id");            
            listOfPubId.add(id);
        }
        rs.close();
        ps.close();
        conn.close();
        return listOfPubId;
    }
    
    public String GetPubIDByName(String name) throws Exception {
        Connection conn = new DBContext().getConnection();
        String sql = "select pub_id, pub_name from Publishers";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            String id = rs.getString("pub_id");            
            String names = rs.getString("pub_name");
            if (name.equals(names)) {
                return id;
            }
        }
        rs.close();
        ps.close();
        conn.close();
        return null;
    }
}
