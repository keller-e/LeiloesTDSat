package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

    Connection conn;

    public Connection conectar() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11", "root", "Admin@123");
            System.out.println("Conexão realizada");

            return conn;

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar no banco: " + ex.getMessage());
            return null;
        }
    }

    public void desconctar() {

        try {
            conn.close();

        } catch (SQLException ex) {
            //VAZIO
        }
    }
}
