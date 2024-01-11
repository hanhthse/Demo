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
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDao dao = new AccountDao();
        String email = request.getParameter("txtemail");
        String password = request.getParameter("txtpassword");
        Account account = new Account();
        account = dao.getAccount(email,password);
        if(account!=null){
                request.setAttribute("account",account);
                request.getRequestDispatcher("adminHome.jsp").forward(request, response);
            }else{
                response.sendRedirect("error.html");
            }
    }

   

}
