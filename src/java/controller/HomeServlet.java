/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContactDAO;
import dao.GalleryDAO;
import dao.ShareDAO;
import entity.Gallery;
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
public class HomeServlet extends HttpServlet {

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
            List<Share> share = shareDAO.getShare();
            request.setAttribute("share", share);

            GalleryDAO galleryDB = new GalleryDAO();
            ContactDAO contactDB = new ContactDAO();
            int pageSize = 3;
            String pageIndex = request.getParameter("index");
            int index = 0;
            //check index page
            if (pageIndex != null) {
                try {
                    index = Integer.parseInt(pageIndex);
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "This page is invalid!!");
                }
            } else {
                index = 1;
            }
            //count total result 
            int totalRecord = galleryDB.count();
            if (totalRecord <= 0) {
                request.setAttribute("error", "No result!!");
            }
            int maxPage = totalRecord / pageSize;
            if ((totalRecord % pageSize) != 0) {
                maxPage++;
            }
            //get list gallery with paging 
            List<Gallery> digitalList = galleryDB.getListGalleryWithPaging(index, pageSize);
            request.setAttribute("listGallery", digitalList);
            request.setAttribute("index", index);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("totalRecord", totalRecord);
            //get top 3 gallery
            request.setAttribute("top3", galleryDB.getTop3Gallery());
            //get contact infor
            request.setAttribute("contact", contactDB.getContact());
            request.setAttribute("active", "0");
            request.getRequestDispatcher("HomePage.jsp").forward(request, response);
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
