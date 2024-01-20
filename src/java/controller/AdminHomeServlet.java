/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Acer
 */
public class AdminHomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Khaibao accoutDao
        AccountDao dao = new AccountDao();
        //load du lieu tu DB
        List<Account> list = dao.getAll();
        // set du lieu trong request
        
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("loginedUser");
        
        request.setAttribute("listAccount", list);
        // chuyen sang jsp de hien thi
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        AccountDao dao = new AccountDao();
        switch (action) {
            case "update":
                Account acc = updateFunction(request, response, dao);
                request.setAttribute("account", acc);
                request.getRequestDispatcher("adminHome.jsp").forward(request, response);
                break;
            case "search":
                //get ve keyword
                String keyWord = request.getParameter("keyword");
                String property = request.getParameter("property");
                List<Account> listFound = dao.getByKeyWord(keyWord, property);
                request.setAttribute("listAccount", listFound);
                request.getRequestDispatcher("display.jsp").forward(request, response);
                break;
            case "delete":
                //get ve id muon xoa
                String id = request.getParameter("accid");
                //delete database
                System.out.println(id);
                dao.delete(id);

                response.sendRedirect("admin");
                break;
            case "add":
                //get ve infor
                String accid = request.getParameter("accid");
                String email = request.getParameter("email");
                String name = request.getParameter("fullname");
                String pwd = request.getParameter("password");
                dao.addAccount(accid, email, name, pwd);
                response.sendRedirect("admin");
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
