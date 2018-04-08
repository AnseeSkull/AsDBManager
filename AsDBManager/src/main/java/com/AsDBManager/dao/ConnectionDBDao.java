package com.AsDBManager.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import com.AsDBManager.util.MyMapperDao;
@MyMapperDao
public interface ConnectionDBDao {

	List<String> findTable();
	ResultSet findTableColumns(String table);
}
