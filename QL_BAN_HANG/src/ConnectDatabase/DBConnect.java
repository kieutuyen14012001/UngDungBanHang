/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectDatabase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

public class DBConnect {
    static Connection connection;
    
    // Kết nối vào SQLServer.
  // (Sử dụng thư viện điều khiển JTDS)
  public static Connection getSQLServerConnection_JTDS() throws SQLException,
          ClassNotFoundException {
      String hostName = "TUYENKIEU";
      String sqlInstanceName = "SQLEXPRESS";
      String database = "QL_BAN_HANG";
      String userName = "sa";
      String password = "140101";
 
      return getSQLServerConnection_JTDS(hostName, sqlInstanceName, database,
              userName, password);
  }
 
 
  // Trường hợp sử dụng SQLServer.
  // Và thư viện JTDS.
  private static Connection getSQLServerConnection_JTDS(String hostName,
          String sqlInstanceName, String database, String userName,
          String password) throws ClassNotFoundException, SQLException {
      // Khai báo class Driver cho DB SQLServer
      // Việc này cần thiết với Java 5
      // Java6 tự động tìm kiếm Driver thích hợp.
      // Nếu bạn dùng Java > 5, thì ko cần dòng này cũng được.
      //Class.forName("net.sourceforge.jtds.jdbc.Driver");
 
      // Cấu trúc URL Connection dành cho SQLServer
      // Ví dụ:
      // jdbc:jtds:sqlserver://localhost:1433/simplehr;instance=SQLEXPRESS
      String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/"
              + database + ";instance=" + sqlInstanceName;
 
      Connection conn = DriverManager.getConnection(connectionURL, userName,
              password);
      return conn;
  }
    // Phương thức Querry Dữ liệu
    public  ResultSet Query_Db(String sql)throws ClassNotFoundException,
             SQLException{

        ResultSet rs = null;
        // Lấy ra đối tượng Connection kết nối vào DB.
        connection = getSQLServerConnection_JTDS();

         // Tạo đối tượng Statement.
         Statement statement = connection.createStatement();

         // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
         rs = statement.executeQuery(sql);

        return rs;
    }
    
    public void ExecuteQuery(String sql) throws SQLException, ClassNotFoundException{
        Statement stmt = null;
        // Lấy ra đối tượng Connection kết nối vào DB.
        connection = getSQLServerConnection_JTDS();
        stmt = connection.createStatement();
        stmt.execute(sql);
    } 
    
    public boolean Kiem_Tra_Trung(String table, String colum, String ip) throws ClassNotFoundException,
             SQLException{
        
        ResultSet rs = null;
        // Lấy ra đối tượng Connection kết nối vào DB.
        connection = getSQLServerConnection_JTDS();

         // Tạo đối tượng Statement.
         Statement statement = connection.createStatement();

         // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
         rs = statement.executeQuery("select COUNT(*) from "+table+" Where "+colum+" = '"+ip+"'");
         int num=0;
         while(rs.next()){
             num= (Integer)rs.getInt(1);
         }
         if(num > 0){
             return true;
         }else{
        return false;
         }
    }
  
    public  void closeConnection()throws ClassNotFoundException,
             SQLException{
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
