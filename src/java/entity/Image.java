/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import context.DBContext;

/**
 *
 * @author Ngọc Lan
 */
public class Image {

    private int id;
    private int gallery_id;
    private String image_url;

    public Image() {
    }

    public Image(int id, int gallery_id, String image_url) {
        this.id = id;
        this.gallery_id = gallery_id;
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGallery_id() {
        return gallery_id;
    }

    public void setGallery_id(int gallery_id) {
        this.gallery_id = gallery_id;
    }

    public String getImage_url() throws Exception {
        DBContext db = new DBContext();
        return db.getImage()+image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    
    
}
