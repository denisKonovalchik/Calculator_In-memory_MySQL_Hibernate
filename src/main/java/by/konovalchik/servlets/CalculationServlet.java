package by.konovalchik.servlets;

import by.konovalchik.dao.LogOperationsDAO;
import by.konovalchik.dao.LogOperationsDAOImp;
import by.konovalchik.entity.Operation;
import by.konovalchik.entity.User;
import by.konovalchik.services.Calculation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CalculationServlet", urlPatterns = "/calculation")
public class CalculationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LogOperationsDAO log = new LogOperationsDAOImp();

        User user =(User)req.getSession().getAttribute("user");
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");

        Operation result = Calculation.getResult(num1,num2,operation);
        log.saveOperation(result.getNum1(), result.getNum2(), result.getOperation(), result.getResult(), user);
        req.setAttribute("result", result.getResult());

        getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, resp);
    }
}