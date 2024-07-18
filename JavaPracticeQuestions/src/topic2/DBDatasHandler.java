package topic2;

import java.sql.Connection;

public interface DBDatasHandler {
	
	Connection getDBConnections();
	
	Object getData();
	
	boolean saveData();
	
	boolean updateData();
	
	boolean deleteData();

}
