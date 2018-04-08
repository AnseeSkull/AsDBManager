package com.AsDBManager.service;

import java.util.List;

public interface ConnectionDBService {

	List<String> findTable();
	List<String> findTableColumns(String table);
}
