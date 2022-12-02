import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testConnect {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
//        ds.setUser("sa");
//        ds.setPassword("123");
//        ds.setServerName("ADMIN\\SQLEXPRESS");
//        ds.setPortNumber(1433);
//        ds.setDatabaseName("qlbd_4797");
//        ds.setEncrypt(false);


        //Connect use URL =======> localhost:1433 or port = 1433
        ds.setURL("jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;" +
                "databaseName=qlbd_4797;user = sa; password = 123;"+
                "encrypt = false");

        try(Connection  conn = ds.getConnection()){
            System.out.println("check connect");

            Statement stmt = conn.createStatement();
            // query SQL ===========
            ResultSet rs = stmt.executeQuery("select * from dbo.CAUTHU");
            while(rs.next()){
                System.out.println(
                        rs.getInt("MACT") + " " +
                        rs.getString(2) + "- " +
                        rs.getString(3));
            }

            conn.close();

        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }
}
