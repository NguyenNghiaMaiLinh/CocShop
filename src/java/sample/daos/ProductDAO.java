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
import sample.dtos.ProductDTO;
import sample.utils.DBUtil;

/**
 *
 * @author Mai Linh
 */
public class ProductDAO implements Serializable {

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

    public List<ProductDTO> searchByName(String prodName) throws Exception {
        List<ProductDTO> result = null;
        String productID, productName, status, description, brand;
        int quantity;
        Float price;
        try {
            String sql = "Select ProductID, ProductName, Quantity, Status, Description, Brand, Price from tbl_Product Where ProductName like ?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + prodName + "%");
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                productID = rs.getString("ProductID");
                productName = rs.getString("ProductName");
                quantity = rs.getInt("Quantity");
                status = rs.getString("Status");
                description = rs.getString("Description");
                brand = rs.getString("Brand");
                price = rs.getFloat("Price");
                ProductDTO dto = new ProductDTO(productID, productName, quantity, status, description, brand, price);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<ProductDTO> searchFromStaff(String searchValue) throws Exception {
        List<ProductDTO> result = null;
        String productID, productName, status, description, brand;
        int quantity;
        Float price;
        try {
            String sql = "Select ProductID, ProductName, Quantity, Status, Description, Brand, Price from tbl_Product Where Description like ? or ProductName like ? or ProductID like ?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchValue + "%");
            stm.setString(2, "%" + searchValue + "%");
            stm.setString(3, "%" + searchValue + "%");
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                productID = rs.getString("ProductID");
                productName = rs.getString("ProductName");
                quantity = rs.getInt("Quantity");
                status = rs.getString("Status");
                description = rs.getString("Description");
                brand = rs.getString("Brand");
                price = rs.getFloat("Price");
                ProductDTO dto = new ProductDTO(productID, productName, quantity, status, description, brand, price);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteProduct(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "delete from tbl_product Where ProductID = ?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, id);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public ProductDTO findByPrimaryKey(String id) throws Exception {
        ProductDTO dto = null;
        String productID, productName, status, description, brand;
        int quantity;
        Float price;
        try {
            String sql = "Select ProductID, ProductName, Quantity, Status, Description, Brand, Price from tbl_Product Where productID=?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                productID = rs.getString("ProductID");
                productName = rs.getString("ProductName");
                quantity = rs.getInt("Quantity");
                status = rs.getString("Status");
                description = rs.getString("Description");
                brand = rs.getString("Brand");
                price = rs.getFloat("Price");
                dto = new ProductDTO(productID, productName, quantity, status, description, brand, price);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean updateProduct(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "update tbl_product set Price = ?, Quantity = ?, Status = ? where ProductID = ?";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setFloat(1, dto.getPrice());
            stm.setInt(2, dto.getQuantity());
            stm.setString(3, dto.getStatus());
            stm.setString(4, dto.getProductID());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean checkDuplicate(String username) throws Exception {
        boolean check = true;
        try {
            String sql = "Select ProductID from tbl_Product Where ProductID =?";
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

    public boolean insertProduct(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "insert into tbl_product (ProductID, ProductName, Description, Brand, Quantity, Price, Status) values(?,?,?,?,?,?,?)";
            con = DBUtil.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getProductID());
            stm.setString(2, dto.getProductName());
            stm.setString(3, dto.getDescription());
            stm.setString(4, dto.getBrand());
            stm.setInt(5, dto.getQuantity());
            stm.setFloat(6, dto.getPrice());
            stm.setString(7, dto.getStatus());
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
