package com.AsDBManager.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class ChangePropUtil {

	 //参数为要修改的文件路径  以及要修改的属性名和属性值  
    public static Boolean updatePro(String driverName,String url,String username,String password){
    	ClassPathResource classPathResource = new ClassPathResource("db.properties");
        Properties prop = new Properties();// 属性集合对象   
        try {  
            prop.load(new FileInputStream(classPathResource.getFile()));// 将属性文件流装载到Properties对象中    
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
            return false;  
        } catch (IOException e) {  
            e.printStackTrace();  
            return false;  
        }  
        prop.setProperty("driverName",driverName );  
        prop.setProperty("dburl",url );
        prop.setProperty("dbusername",username );  
        prop.setProperty("dbpassword",password );  
        // 文件输出流   
        try {  
            FileOutputStream fos = new FileOutputStream(classPathResource.getFile());   
            // 将Properties集合保存到流中   
            prop.store(fos,null);
            fos.close();// 关闭流   
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            return false;  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            return false;  
        }  
        System.out.println("driverName:"+prop.getProperty("driverName")+",url:"+prop.getProperty("dburl")+",password=" + prop.getProperty("dbpassword") + prop.getProperty("maxActive"));   
        return true;  
    }  
}
