/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Acer
 */
public class Account {
    private int accid;
    private String email;
    private String fullname;
    private String password;

    public Account() {
    }

    public Account(int accid, String email, String fullname, String password) {
        this.accid = accid;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
    }

    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "accid=" + accid + ", email=" + email + ", fullname=" + fullname + ", password=" + password + '}';
    }
    
}
