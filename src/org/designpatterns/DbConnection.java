package org.designpatterns;

public class DbConnection {

    private static DbConnection dbConnection;

    private DbConnection(){
    }

    public DbConnection getInstance(){
        if(dbConnection == null){
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }
}
