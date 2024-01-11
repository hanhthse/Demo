/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Acer
 */
public class AdminHomeServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        AccountDao dao = new AccountDao();
        switch(action){
            case "update":
                Account acc = updateFunction(request,response, dao);
                request.setAttribute("account",acc);
                request.getRequestDispatcher("adminHome.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
                
    }

    private Account updateFunction(HttpServletRequest request, HttpServletResponse response, AccountDao dao) {
        //get information
        int accid = Integer.parseInt(request.getParameter("accid"));
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        Account account = new Account(accid, email, fullname, password);
        dao.update(account);
        return account;
    }


}
