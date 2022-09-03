import java.sql.*;
import java.io.*;
public class MysqlConn {
    static final String DB_URL = "jdbc:mysql://localhost/javaproject";
    static final String USER = "root";
    static final String PASS = "12345";
    static final String QUERY = "SELECT * FROM login";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();)
           {
            // Extract data from result set
            String sql = "UPDATE login " +
                    "SET userID = 30 WHERE userID = '100'";
            stmt.executeUpdate(sql);
               ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("userID: " + rs.getInt("userID"));
                System.out.println("password: " +rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
