package com.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // ✅ CHECK SESSION
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {

            String email = (String) session.getAttribute("user");

            res.setContentType("text/html");
            PrintWriter out = res.getWriter();

            out.println("<html><body style='text-align:center;margin-top:100px;'>");
            out.println("<h1>Hello There 👋</h1>");
            out.println("<h2>Welcome " + email + " to your Auth System Dashboard !!!</h2>");
            out.println("<a href='LogoutServlet'>Logout</a>");
            out.println("</body></html>");

        } else {
            // ❌ NOT LOGGED IN → redirect
            res.sendRedirect("login.html");
        }
    }
}