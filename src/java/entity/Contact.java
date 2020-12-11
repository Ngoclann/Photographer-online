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
public class Contact {

    private String telephone;
    private String email;
    
    private String about;
    private String address;
    private String city;
    private String country;

    private String image_main;
    

    public Contact() {
    }

    public String getImage_main() throws Exception {
        DBContext db = new DBContext();
        return db.getImage() + image_main;
    }

    public void setImage_main(String image_main) {
        this.image_main = image_main;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
