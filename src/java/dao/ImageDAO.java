/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Image;
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
public class ImageDAO {

    
    public ImageDAO() throws Exception {
        this.db = new DBContext();
    }
    
    DBContext db;

    public String getImageByGalleryID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "select top 1 image_url from image\n"
                    + "where gallery_id = ?";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while (rs.next()) {
                return db.getImage() + rs.getString(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, pr, conn);
        }
        return null;
    }
    
    public List<Image> getListImageWithPaging(int galleryID, int pageIndex, int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<Image> list = new ArrayList<>();
        try {
            String query = "select * from ( select ROW_NUMBER() over (order by id ASC)"
                    + " as rn , * from  image where gallery_id = ?) "
                    + "as b where rn between ((?*?) - ?)and (?*?)";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, galleryID);
            pr.setInt(2, pageSize);
            pr.setInt(3, pageIndex);
            pr.setInt(4, pageSize - 1);
            pr.setInt(5, pageSize);
            pr.setInt(6, pageIndex);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGallery_id(rs.getInt("gallery_id"));
                image.setImage_url(rs.getString("image_url"));
                list.add(image);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, pr, conn);
        }
        return list;
    }
    // get image by id

    public Image getImageByIDandGalleryID(int id, int galleryId) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * from image where id = ? and gallery_id = ?";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, id);
            pr.setInt(2, galleryId);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGallery_id(rs.getInt("gallery_id"));
                image.setImage_url(rs.getString("image_url"));
                return image;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, pr, conn);
        }
        return null;
    }

    public Image getImageGalleryByGalleryID(int galleryID) throws Exception {
        Connection conn = null;
        PreparedStatement pr = null;
        ResultSet rs = null;
        try {
            String query = "SELECT top 1 * from image where gallery_id = ?";
            conn = db.getConnection();
            pr = conn.prepareStatement(query);
            pr.setInt(1, galleryID);
            rs = pr.executeQuery();
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("ID"));
                image.setGallery_id(rs.getInt("gallery_id"));
                image.setImage_url(rs.getString("image_url"));
                return image;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        } finally {
            db.closeConnection(rs, pr, conn);
        }
        return null;
    }
}
