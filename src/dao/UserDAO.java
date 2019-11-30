/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.util.ArrayList;
import model.User;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dell
 */
public class UserDAO {
    public ArrayList<User> selectAllUser()throws Exception{
        ArrayList<User> listOfUser = new ArrayList<>();
        Connection conn = new DBContext().getConnection();
        String sql = "select UserName , Password , DisplayName from Users ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String userName = rs.getString("UserName");
            String Password = rs.getString("Password");
            String DisplayName = rs.getString("DisplayName");
            User u = new User(userName, DisplayName, Password);
            listOfUser.add(u);
        }
        rs.close();
        ps.close();
        conn.close();
        return listOfUser;
    }
}
