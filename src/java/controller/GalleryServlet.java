/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContactDAO;
import dao.GalleryDAO;
import dao.ImageDAO;
import dao.ShareDAO;
import entity.Image;
import entity.Share;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ngọc Lan
 */
public class GalleryServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ShareDAO shareDAO = new ShareDAO();
            List<Share> share  = shareDAO.getShare();
            request.setAttribute("share", share);
            
            GalleryDAO galleryDB = new GalleryDAO();
            ContactDAO contactDB = new ContactDAO();
            ImageDAO imageDB = new ImageDAO();
            String galleryID = request.getParameter("galleryID");
            String imgID = request.getParameter("imgID");
            
            boolean invalid = true;
            boolean indexValid = true;
            
            int gallery = 0;
            //check gallery id
            try {
                if (galleryID != null) {
                    gallery = Integer.parseInt(galleryID);

                } else {
                    // set default gallery id
                    gallery = 1;
                }
            } catch (NumberFormatException e) {
                request.setAttribute("error", "This gallery is invalid!!");
                invalid = false;
            }
            if (invalid == true) {
                int pageSize = 8;

                //count total result 
                int totalRecord = galleryDB.countImage(gallery);
                if (totalRecord <= 0) {
                    request.setAttribute("error", "No image in gallery!!");
                }
                int maxPage = totalRecord / pageSize;
                if ((totalRecord % pageSize) != 0) {
                    maxPage++;
                }

                //get top 1 image of gallery
                int image = 0;

                String pageIndex = request.getParameter("index");
                int index = 0;

                //check index page
                try {
                    if (pageIndex != null) {
                        index = Integer.parseInt(pageIndex);
                    } else {
                        index = 1;
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "This page is invalid!!");
                    indexValid = false;
                }

                if (indexValid == true && index > 0 && index <= maxPage) {
                    //check image id valid
                    try {
                        if (imgID != null) {
                            image = Integer.parseInt(imgID);
                        } else {
                            // set default image id
                            image = imageDB.getImageGalleryByGalleryID(gallery).getId();
                        }
                    } catch (Exception e) {
                        request.setAttribute("error", "This image not found!!");
                    }
                    // check image in gallery or not
                    if (imageDB.getImageByIDandGalleryID(image, gallery) != null) {
                        request.setAttribute("top1Gallery", imageDB.getImageByIDandGalleryID(image, gallery));
                    }else{
                        request.setAttribute("error", "This image not found!!");
                    }
                } else {
                    request.setAttribute("error", "This page is invalid!!");
                }

                try {
                    //get list image with paging 
                    List<Image> imagelList = imageDB.getListImageWithPaging(gallery, index, pageSize);
                    request.setAttribute("listImage", imagelList);

                } catch (Exception ex) {
                    request.setAttribute("error", "This gallery is invalid!!");
                }
                request.setAttribute("index", index);
                request.setAttribute("maxPage", maxPage);
                request.setAttribute("galleryID", gallery);
                request.setAttribute("totalRecord", totalRecord);
                request.setAttribute("gallery", galleryDB.getGalleryByID(gallery));
            }
            //get top 3 gallery
//            request.setAttribute("top3", galleryDB.getTop3Gallery());
            //get contact infor
            request.setAttribute("contact", contactDB.getContact());
            request.setAttribute("active", galleryID);
            request.getRequestDispatcher("Gallery.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
