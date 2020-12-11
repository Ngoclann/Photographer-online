/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Gallery;
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
public class GalleryDAO {

    public GalleryDAO() throws Exception {
        this.db = new DBContext();
    }
    DBContext db;
    
    // get latest news
    public List<Gallery> getTop3Gallery() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Gallery> listGallery = new ArrayList<>();
        try {
            String query = "SELECT top 3 * from gallery";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            while (rs.next()) {
                Gallery gallery = new Gallery();
                gallery.setID(rs.getInt("ID"));
                gallery.setTitle(rs.getString("title"));
                gallery.setDescription(rs.getString("description"));
                gallery.setName(rs.getString("name"));
                listGallery.add(gallery);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, pr, conn);
        }
        return listGallery;
    }
    
    public Gallery getGalleryByID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 * from gallery where ID = ?";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while (rs.next()) {
                Gallery gallery = new Gallery();
                gallery.setID(rs.getInt("ID"));
                gallery.setTitle(rs.getString("title"));
                gallery.setDescription(rs.getString("description"));
                gallery.setName(rs.getString("name"));
                return gallery;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, pr, conn);
        }
        return null;
    }
    
    // count number of gallery
    public int count() throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) from gallery";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            rs = pr.executeQuery();
            int cout = 0;
            while (rs.next()) {
                cout = rs.getInt(1);
            }
            return cout;
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, pr, conn);
        }
    }
    
    public List<Gallery> getListGalleryWithPaging(int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Gallery> list = new ArrayList<>();
        try {
            String query = "select * from ( select ROW_NUMBER() over (order by id ASC) as rn , * from  gallery )"
                    + "as b where rn between ((?*?) - ?)and (?*?)";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, pageSize);
            pr.setInt(2, pageIndex);
            pr.setInt(3, pageSize - 1);
            pr.setInt(4, pageSize);
            pr.setInt(5, pageIndex);
            rs = pr.executeQuery();
            while (rs.next()) {
                Gallery gallery = new Gallery();
                gallery.setID(rs.getInt("ID"));
                gallery.setTitle(rs.getString("title"));
                gallery.setDescription(rs.getString("description"));
                gallery.setName(rs.getString("name"));
                list.add(gallery);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, pr, conn);
        }
        return list;
    }
    
    // count number image of gallery
    public int countImage(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT count(*) from image where gallery_id = ?";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            rs = pr.executeQuery();
            int cout = 0;
            while (rs.next()) {
                cout = rs.getInt(1);
            }
            return cout;
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, pr, conn);
        }
    }
}
