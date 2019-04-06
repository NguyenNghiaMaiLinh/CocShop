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
import java.util.ArrayList;
import java.util.List;
import sample.dtos.CustomerDetailDTO;
import sample.utils.DBUtil;

/**
 *
 * @author Mai Linh
 */
public class CustomerDetailDAO implements Serializable {

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

    public List<CustomerDetailDTO> getListAccount(String name) throws Exception {
        List<CustomerDetailDTO> result = null;
        String username, lastName, middleName, firstName, address, phone;
        String password, roles;
        try {
            String sql = "select a.Username, LastName, MiddleName, FirstName, Password, Address, Phone, Roles from tbl_customer c inner join tbl_account a on c.Username = a.Username WHere c.FirstName like ?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + name + "%");
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("Username");
                lastName = rs.getString("LastName");
                middleName = rs.getString("MiddleName");
                firstName = rs.getString("FirstName");
                password = rs.getString("Password");
                address = rs.getString("Address");
                phone = rs.getString("Phone");
                roles = rs.getString("Roles");
                CustomerDetailDTO dto = new CustomerDetailDTO(username, lastName, middleName, firstName, address, phone, password, roles);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

}
