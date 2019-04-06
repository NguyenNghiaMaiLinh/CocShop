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
import sample.dtos.CustomerDTO;
import sample.utils.DBUtil;

/**
 *
 * @author Mai Linh
 */
public class CustomerDAO implements Serializable {

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

    public String getName(String username) throws Exception {
        String check = "failed";
        try {
            String sql = "Select FirstName from tbl_Customer Where Username =?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                return check = rs.getString("FirstName");
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteAccount(String username) throws Exception {
        boolean check = false;
        try {
            String sql = "delete from tbl_account Where Username = ?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteCustomer(String username) throws Exception {
        boolean check = false;
        try {
            String sql = "delete from tbl_customer Where Username = ?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insertCustomer(CustomerDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into tbl_customer(Username, LastName, MiddleName, FirstName, Address, Phone) values(?,?,?,?,?,?)";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getUsername());
            stm.setString(2, dto.getLastName());
            stm.setString(3, dto.getMiddleName());
            stm.setString(4, dto.getFirstName());
            stm.setString(5, dto.getAddress());
            stm.setString(6, dto.getPhone());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean checkDuplicate(String username) throws Exception {
        boolean check = true;
        try {
            String sql = "Select Username from tbl_Customer Where Username =?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, username);
            rs = stm.executeQuery();
            if (rs.next()) {
                check = false;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}
