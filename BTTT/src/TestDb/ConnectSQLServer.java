package TestDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectSQLServer {

    private Connection con = null;

    public ConnectSQLServer() {
        String url = "net.sourceforge.jtds.jdbc.Driver";
        String dbUrl = "jdbc:jtds:sqlserver://Thanhtai:1433/HTQLSV";
        /*try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://Thanhtai:1433/HTQLSV";
            con = DriverManager.getConnection(dbUrl);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KetNoiSQL.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try {
        	Class.forName(url);
            con = DriverManager.getConnection(dbUrl);
		} catch (Exception e) {
			System.out.println(e);
		}
    }

    public ResultSet getResultSet(String tableName) throws SQLException {
        ResultSet rs = null;
        Statement stmt = con.createStatement();
        String sql = "select * from " + tableName;
        rs = stmt.executeQuery(sql);
        return rs;
    }

    public void Close() throws Exception {
        con.close();
    }

    public static void main(String[] args) {
      ConnectSQLServer kn = new ConnectSQLServer();
        try {
            ResultSet rs= kn.getResultSet("SinhVien");//Table Name
            while(rs.next())
            {
            	if(rs.getString("GioiTinh").equals("Nam")) {
                System.out.println(rs.getString("HoLot") +" "+rs.getString("Ten"));
            	}//Field Name
            }
            kn.Close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
