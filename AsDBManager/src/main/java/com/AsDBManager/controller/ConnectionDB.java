package com.AsDBManager.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AsDBManager.service.ConnectionDBService;
import com.AsDBManager.util.ChangePropUtil;

@Controller
@RequestMapping
public class ConnectionDB {

	@Resource
	private ConnectionDBService dbservice;
	
	@RequestMapping("/db.do")
	public String toDB() {
		System.out.println("×ªÏòÒ³Ãæ");
		return "db";
	}
	
	@RequestMapping("/todb.do")
	public String connectionDB(String dbip,String dbname,String username,String password,ModelMap model) {
		ChangePropUtil.updatePro("com.mysql.jdbc.Driver", "jdbc:mysql://"+dbip+":3306/"+dbname, username, password);
		List<String> tableNames=dbservice.findTable();
		model.addAttribute("tableName", tableNames);
		return "db";
	}
	
	/*@RequestMapping("/todb.do")
	public String connectionDB(ModelMap model) {
		ChangePropUtil.updatePro("com.mysql.jdbc.Driver", "jdbc:mysql://"+dbip+":3306/"+dbname, username, password);
		List<String> tableNames=dbservice.findTable();
		model.addAttribute("tableName", tableNames);
		return "db";
	}*/
	
	
}
