package web.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DBHelper {
	public static final String url = "jdbc:mysql://192.168.8.254:3306/thjk_testing";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "zhangqiang";
	public static final String password = "123456";
	public Connection conn = null;
	public PreparedStatement pst = null;

	public DBHelper(String sql) {
		try {
			Class.forName(name);
			conn = DriverManager.getConnection(url, user, password);
			pst = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
