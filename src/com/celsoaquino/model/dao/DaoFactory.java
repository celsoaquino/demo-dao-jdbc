package com.celsoaquino.model.dao;

import com.celsoaquino.db.DB;
import com.celsoaquino.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDaoJDBC createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }
}
