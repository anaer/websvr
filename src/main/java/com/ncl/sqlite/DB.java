package com.ncl.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class DB
{
	public String dbname="posidata.db";
	private String connectionUrl="jdbc:sqlite:";
	public Connection con=null;
	private Statement stmt=null;
	private PreparedStatement psm=null;
	private ResultSet rs=null;
	String path=null;

	public DB()
	{
		//path=this.getClass().getClassLoader().getResource("").getPath()+"/../db/posidata.db";
		//System.out.println(path);
		path="test123.db";
		connectionUrl+=path;
	}

	public boolean connect()
	{
		//String sql = "create table tbl1(name varchar(20), salary int, updatetime date);";
		String psql="insert into tbl1 values(?,?,datetime('now'))";// id,lat,lats,lng,lngs,time,speed
		try
		{
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection(connectionUrl);
			stmt=con.createStatement();
			//stmt.executeUpdate(sql);
			if(!isTableExists("tbl1")){
				createTable();
			}
			this.psm=con.prepareStatement(psql);
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	

	public void close()
	{
		if(rs!=null)
			try
			{
				rs.close();
			}
			catch(Exception e)
			{
			}
		if(stmt!=null)
			try
			{
				stmt.close();
			}
			catch(Exception e)
			{
			}
		if(psm!=null)
			try
			{
				psm.close();
			}
			catch(Exception e)
			{
			}
		if(con!=null)
			try
			{
				con.close();
			}
			catch(Exception e)
			{
			}
	}

	public synchronized int update(String sql) throws SQLException
	{
		return stmt.executeUpdate(sql);
	}
	
	public List<String> getName(String sql) throws SQLException{
		List<String> nameList = new ArrayList<String>();
		if(StringUtils.isBlank(sql)){
			sql ="select * from tbl1;";
		}
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) { 
			nameList.add(rs.getString("name"));
		}
		rs.close();
		return nameList;
	}

	public void insertV() throws SQLException{
		psm.setString(1, "1");
		psm.setInt(2, 1);
		psm.execute();
	}
	
	public Boolean isTableExists(String tableName) throws SQLException {
		String sql = "SELECT COUNT(*) FROM sqlite_master where type='table' and name='"+tableName+"'";
		rs = stmt.executeQuery(sql);
		int cnt = rs.getInt(1);
		return cnt > 0;
	}
	
	public void createTable() throws SQLException{
		String sql = "create table tbl1(name varchar(20), salary int, updatetime date);";
		stmt.executeUpdate(sql);
	}

}
