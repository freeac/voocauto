package com.vooc.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.vooc.Utils.GetPropertiesFile;

public class MySQLDB {
	public static Connection conn = null;
	public static ResultSet rs = null;
	public static Statement st;

	public static void ConnectToMySQLDB() {
		com.mysql.cj.jdbc.Driver driver;
		try {
			driver = new com.mysql.cj.jdbc.Driver();
			conn = driver.connect(GetPropertiesFile.GetContentPropFile("ConnStr"), null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ExecuteSqlQuery(String query) {
		ConnectToMySQLDB();
		try {
			st = conn.createStatement();
			st.executeQuery(query);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ExecuteAnySqlQuery(String query) {
		ConnectToMySQLDB();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean CheckRecordIsExist(String query) {
		boolean flg = true;
		ExecuteAnySqlQuery(query);
		try {
			flg = rs.first();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flg;
	}

	public static String GetDataOfFirstRecordFromDB(String query, String colLabel) {
		ExecuteAnySqlQuery(query);
		String data = "";
		try {
			if (rs.first()) {
				data = rs.getObject(colLabel).toString();
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	public static ArrayList<String> GetDataRecordFromDB(String query, String colLabel) {
		ExecuteAnySqlQuery(query);
		ArrayList<String> list = new ArrayList<String>();
		try {
			if (rs.first()) {
				rs.beforeFirst();
				while (rs.next()) {
					list.add(rs.getObject(colLabel).toString());
				}
			} else {
				return null;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static Map<String, ArrayList<String>> GetDataOfMoreColFromDB(String query, String[] moreCol) {
		ExecuteAnySqlQuery(query);
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		try {
			if (rs.first()) {
				rs.beforeFirst();
				for (String col : moreCol) {
					ArrayList<String> list = new ArrayList<String>();
					while (rs.next()) {
						list.add(rs.getObject(col).toString());
					}
					map.put(col, list);
					rs.beforeFirst();
				}
			} else {
				return null;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
