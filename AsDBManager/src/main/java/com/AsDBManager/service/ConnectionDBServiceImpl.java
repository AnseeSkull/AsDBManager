package com.AsDBManager.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.AsDBManager.dao.ConnectionDBDao;

@Service("dbservice")
public class ConnectionDBServiceImpl implements ConnectionDBService{

	@Resource
	private ConnectionDBDao dbdao;

	@Override
	public List<String> findTable() {
		System.out.println("进入方法");
		List<String> tableName=dbdao.findTable();
		return tableName;
	}

	@Override
	public List<String> findTableColumns(String table) {
		ResultSet rs=dbdao.findTableColumns(table);
		List<String> columns=new ArrayList<String>();
		try {
			while(rs.next()) {
				columns.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columns;
	}

	
		
}
