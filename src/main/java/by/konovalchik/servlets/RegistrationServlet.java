package by.konovalchik.servlets;


import by.konovalchik.dao.UsersDAO;
import by.konovalchik.dao.UsersDAOImp;
import by.konovalchik.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersDAO daoUser = new UsersDAOImp();

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = new User(name, login, password);

        if(!daoUser.getUsers().contains(user)){
            daoUser.addUser(user);
            resp.sendRedirect(req.getContextPath() + "/main");
        }else{
            resp.sendRedirect(req.getContextPath() + "/main");
        }
    }
}