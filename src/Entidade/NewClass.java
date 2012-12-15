/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;


import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FM
 */
public class NewClass {
    public static void main(String[] args) {
        Connection connection = null;
        String userName = "root";
        String password = "ch4v31r0";
        // String url = "jdbc:mysql://supernet-8ac140.:3306/gcs";
        //  String url = "jdbc:mysql://usu-468c3826baf:3306/gcs";
        String url = "jdbc:mysql://localhost:3306/gcs";
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("erro " + e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("erro " + e);
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("conexao estabelecida fagner");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erro " + e);
        }
    }
}
