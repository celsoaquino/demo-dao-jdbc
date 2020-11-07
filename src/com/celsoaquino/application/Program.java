package com.celsoaquino.application;

import com.celsoaquino.model.dao.DaoFactory;
import com.celsoaquino.model.dao.SellerDao;
import com.celsoaquino.model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(2);
        System.out.println(seller);
    }
}
