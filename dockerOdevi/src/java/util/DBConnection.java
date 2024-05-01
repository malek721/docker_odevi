package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBConnection {

    public Connection conn() {
        Connection db = null;
        if (db == null) {
            try {
                Class.forName("org.postgresql.Driver");
                db = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "malek2002");
                return db;
            } catch (ClassNotFoundException | SQLException x) {
                System.out.println(x.getMessage());
            }
        }
        return db;

    }

}
