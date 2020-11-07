package com.celsoaquino.application;

import com.celsoaquino.model.dao.DaoFactory;
import com.celsoaquino.model.dao.SellerDao;
import com.celsoaquino.model.entities.Department;
import com.celsoaquino.model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {

        Department obj = new Department(1, "Books");
        System.out.println(obj);

        Seller seller = new Seller(1, "Celso", "celso@gmail.com", new Date(), 3000.0, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);
    }
}
