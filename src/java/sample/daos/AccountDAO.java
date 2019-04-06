/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.dtos.AccountDTO;
import sample.utils.DBUtil;

/**
 *
 * @author Mai Linh
 */
public class AccountDAO implements Serializable {

    Connection con;
    PreparedStatement stm;
    ResultSet rs;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        try {
            String sql = "Select Username, Password, Roles from tbl_Account Where Username = ? and Password = ?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                return role = rs.getString("Roles");
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public String getRole(String username) throws Exception {
        String role = "failed";
        try {
            String sql = "Select Roles from tbl_Account Where Username = ? ";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                return role = rs.getString("Roles");
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public boolean updateAccount(AccountDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "update tbl_account set Password = ?, Roles =? Where Username = ?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getPassword());
            stm.setString(2, dto.getRole());
            stm.setString(3, dto.getUsername());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public AccountDTO findByPrimaryKey(String id) throws Exception {
        AccountDTO dto = null;
        String username, password, role;
        try {
            String sql = "select Username, Password, Roles from  tbl_account WHere Username = ?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                username = rs.getString("Username");
                password = rs.getString("Password");
                role = rs.getString("Roles");
                dto = new AccountDTO(username, password, role);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean insertAccount(AccountDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into tbl_account(Username, Password , Roles) values(?,?,'user')";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getUsername());
            stm.setString(2, dto.getPassword());
            stm.setString(3, dto.getRole());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
