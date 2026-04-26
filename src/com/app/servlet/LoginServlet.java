package com.app.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            Connection conn = DBConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM users WHERE email=? AND password=?"
            );

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                // ✅ CREATE SESSION
                HttpSession session = req.getSession();
                session.setAttribute("user", email);

                // ✅ REDIRECT TO DASHBOARD SERVLET
                res.sendRedirect("DashboardServlet");

            } else {
                res.getWriter().println("Invalid credentials");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}