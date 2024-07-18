package com.example.spring_restapi.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring_restapi.utils.UtilMethods;

@Component
public class DBActions {
	private DBConnection db;

	@Autowired
	public DBActions(DBConnection db) {
		this.db = db;
	}

	public List<LinkedHashMap<String, Object>> get(String query) {
	
		List<LinkedHashMap<String, Object>> list = new ArrayList<>();
		try {

			Connection con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			int columnCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				LinkedHashMap<String, Object> map = new LinkedHashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					map.put(rs.getMetaData().getColumnName(i), rs.getString(i));
				}
				list.add(map);
			}
			rs.close();
			stmt.close();
			con.close();
			db.closeConnection(con);
		} catch (SQLException e) {
			System.out.println(e);
		}

		return list;
	}

	public boolean execute(String query) {
		// TODO Auto-generated method stub

		try {

			Connection con = db.getConnection();
			PreparedStatement stmt = con.prepareStatement(query);
			int result = stmt.executeUpdate();
			if (result == 1) {
				System.out.println("sql action succes!!");
				return true;
			}
			stmt.close();
			db.closeConnection(con);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean executeBatch(String query, List<?> objects) throws Exception {
		PreparedStatement stmt = null;
		boolean result = false;
		int cnt;
		try {
			Connection con = db.getConnection();
			stmt = con.prepareStatement(query);

			for (Object obj : objects) {
				Field[] fields = obj.getClass().getDeclaredFields();
				cnt = 0;
				for (Field field : fields) {
					field.setAccessible(true);
					if (field.get(obj) != null) {
						cnt++;
						stmt.setString(cnt, (String) field.get(obj));
					}
				}
				stmt.addBatch();

			}

			int[] batchResult = stmt.executeBatch();

			// Check the batch result
			for (int count : batchResult) {
				if (count == Statement.EXECUTE_FAILED) {
					result = false;
					break;
				}
			}
			stmt.close();
			db.closeConnection(con);
			result = true; // Assuming all batches were executed successfully
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean insert(String query, Object obj) {
		PreparedStatement stmt = null;
		boolean result = false;
		int cnt = 0;
		try {
			Connection con = db.getConnection();
			stmt = con.prepareStatement(query);
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				Class<?> fieldClass = field.getType();
				if (!fieldClass.isPrimitive() && !UtilMethods.isWrapperType(field.getType())) {
					Object nestedObject=field.get(obj);
					Field[] nestedFields = fieldClass.getDeclaredFields();
					for (Field nestedField : nestedFields) {
						nestedField.setAccessible(true);
						cnt++;
						stmt.setString(cnt, (String) nestedField.get(nestedObject));
					}
				} else {
					if (field.get(obj) != null) {
						cnt++;
						stmt.setString(cnt, (String) field.get(obj));
					}
				}
			}
			int res = stmt.executeUpdate();
			if (res == 1) {
				System.out.println("sql action succes!!");
				return true;
			}
			stmt.close();
			db.closeConnection(con);

		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

}
