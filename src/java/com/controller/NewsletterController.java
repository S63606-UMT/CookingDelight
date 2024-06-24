/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;
import com.dao.NewsletterDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author saifu
 */
@WebServlet("/newsletter")
public class NewsletterController extends HttpServlet {
    
    private static final String INDEX = "index.jsp";
    private static final String ABOUT = "about.jsp";
    private NewsletterDao dao;
    
    public NewsletterController() throws ClassNotFoundException {
        super();
        dao = new NewsletterDao();
    }
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewsletterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewsletterController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "subscribe":
                    subscribe(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX);
                    dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void subscribe(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");
        if (dao.insertEmail(email)) {
            // Set success message
            request.setAttribute("msg", "Successfully subscribed to the newsletter.");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(ABOUT);
            dispatcher.forward(request, response);
        } else {
            // Set success message
            request.setAttribute("msg", "Error: Failed to subscribe to the newsletter.");

            RequestDispatcher dispatcher = request.getRequestDispatcher(ABOUT);
            dispatcher.forward(request, response);
        }
        
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
