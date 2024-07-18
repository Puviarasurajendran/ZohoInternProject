package topic2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDB implements DBDatasHandler {

	private String url;
	private String username; 
	private String passwd;
	
	public MySQLDB(String url, String uname, String pwd) {
		this.url=url;
		this.username=uname;
		this.passwd=pwd;
		}
	
	@Override
	public Connection getDBConnections() {
		Connection con=null;
		try {
			con= DriverManager.getConnection(url, username, passwd);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeDBConncetion(Connection con) {
		try {
			if(con!=null) {
				con.close();
			}
		}
		catch(Exception e) {
			
		}
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteData() {
		// TODO Auto-generated method stub
		return false;
	}

}
