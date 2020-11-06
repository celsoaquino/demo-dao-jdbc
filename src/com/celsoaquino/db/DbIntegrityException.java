package com.celsoaquino.db;

public class DbIntegrityException  extends RuntimeException{

    public DbIntegrityException(String s) {
        super(s);
    }
}
