/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDatabase;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kieut
 */
public class DBConnects {
    
    public static void main(String[] args) {
        String sever ="TUYENKIEU\\SQLEXPRESS";
        String user ="sa"; 
        String password = "140101";
        String database = "QL_BAN_HANG";
        int poss =1433;
        SQLServerDataSource db =new SQLServerDataSource();
        db.setUser(user);
        db.setServerName(sever);
        db.setPortNumber(poss);
        db.setPassword(password);
        db.setDatabaseName(database);
        try (Connection conn =db.getConnection()){
            System.out.println("Ket noi thanh coong");
            System.out.println(conn.getCatalog());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
