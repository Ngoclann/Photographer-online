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
public class Share {
    private String icon, socialNetwork, URL;

    public Share() {
    }

    public Share(String icon, String socialNetwork, String URL) {
        this.icon = icon;
        this.socialNetwork = socialNetwork;
        this.URL = URL;
    }

    public String getIcon() throws Exception {
        DBContext db = new DBContext();
        return db.getImage()+ icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
}
