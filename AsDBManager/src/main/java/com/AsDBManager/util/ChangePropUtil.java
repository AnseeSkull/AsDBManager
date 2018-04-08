package com.AsDBManager.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class ChangePropUtil {

	 //����ΪҪ�޸ĵ��ļ�·��  �Լ�Ҫ�޸ĵ�������������ֵ  
    public static Boolean updatePro(String driverName,String url,String username,String password){
    	ClassPathResource classPathResource = new ClassPathResource("db.properties");
        Properties prop = new Properties();// ���Լ��϶���   
        try {  
            prop.load(new FileInputStream(classPathResource.getFile()));// �������ļ���װ�ص�Properties������    
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
        // �ļ������   
        try {  
            FileOutputStream fos = new FileOutputStream(classPathResource.getFile());   
            // ��Properties���ϱ��浽����   
            prop.store(fos,null);
            fos.close();// �ر���   
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
