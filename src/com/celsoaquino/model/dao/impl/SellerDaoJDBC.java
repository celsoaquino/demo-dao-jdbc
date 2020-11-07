package com.celsoaquino.model.dao.impl;

import com.celsoaquino.db.DB;
import com.celsoaquino.db.DbException;
import com.celsoaquino.model.dao.SellerDao;
import com.celsoaquino.model.entities.Department;
import com.celsoaquino.model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;
    
    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.departmentid = department.id "
                    + "WHERE seller.id = ?"
            );

            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Department dep = new Department();
                dep.setId(rs.getInt("departmentid"));
                dep.setName(rs.getString("DepName"));
                Seller obj = new Seller();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setEmail(rs.getString("email"));
                obj.setBaseSalary(rs.getDouble("basesalary"));
                obj.setBirthDate(rs.getDate("birthdate"));
                obj.setDepartment(dep);
                System.out.println(obj.getEmail());
                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
