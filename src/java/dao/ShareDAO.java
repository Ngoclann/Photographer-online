/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Share;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ngọc Lan
 */
public class ShareDAO {

    public List<Share> getShare() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Share> list = new ArrayList<>();
        try {
            String query = "select * from Share";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Share share = new Share(rs.getString("icon"),
                        rs.getString("socialNetwork"),
                        rs.getString("URL"));
                list.add(share);
            }
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            new DBContext().closeConnection(rs, ps, connection);
        }
        return null;
    }
}
