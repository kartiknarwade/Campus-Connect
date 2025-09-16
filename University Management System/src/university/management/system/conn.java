package university.management.system;

import java.sql.*;

public class conn {
    public Connection c;
    public Statement s;

    public conn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to your phpMyAdmin MySQL database
            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ums", // ✅ Correct URL
                    "root",                            // ✅ Your MySQL username
                    ""                                 // ✅ Your MySQL password (if any)
            );

            s = c.createStatement();
            System.out.println("✅ Database connected successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
