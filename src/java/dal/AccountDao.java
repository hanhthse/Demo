/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Acer
 */
public class AccountDao extends DBContext {

    public Account getAccount(String email, String password) {

        // ket noi voi database
        connection = getConnection();
        String sql = "SELECT [AccId]\n"
                + "      ,[Email]\n"
                + "      ,[FullName]\n"
                + "      ,[Password]\n"
                + "  FROM [dbo].[Accounts] where Email=? and Password=? COLLATE SQL_Latin1_General_CP1_CI_AS";

        try {
            //chuan bi cho cau lenh
            statement = connection.prepareStatement(sql);
            //xet gia tri
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                Account result = new Account(resultSet.getInt("AccId"), resultSet.getString("email"), resultSet.getString("FullName"), resultSet.getString("Password"));
                return result;
            }

        } catch (SQLException ex) {
            System.err.println("Error " + ex.getMessage() + " at DBContext method: getAccount() ");
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void update(Account account) {
        // ket noi voi database
        connection = getConnection();
        // co cau lenh de goi xuong database
        String sql = "UPDATE [dbo].[Accounts]\n"
                + "   SET [AccId] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[FullName] = ?\n"
                + "      ,[Password] = ?\n"
                + " WHERE [AccId] = ?";
        
        try {
            //chuan bi cho cau lenh
            statement = connection.prepareStatement(sql);
            //set data
            statement.setInt(1,account.getAccid());
            statement.setString(2, account.getEmail());
            statement.setString(3, account.getFullname());
            statement.setString(4, account.getPassword());
            statement.setInt(5, account.getAccid());
            //thuc thi cau lenh o tren => tra ve ket qua 
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error " + ex.getMessage() + " at DBContext method: update() ");
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
    }

}
