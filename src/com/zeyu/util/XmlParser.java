package com.zeyu.util;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class XmlParser {
	public static String getStatus(String filename) throws DocumentException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File(filename));
		Element root = doc.getRootElement();
		return root.getText();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, DocumentException{
		
	}

	public static boolean setStatus(String state,String filename) throws DocumentException {
		// TODO Auto-generated method stub
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File(filename));
		Element root = doc.getRootElement();
		System.out.println(state);
		root.setText(state);
		try {
			XMLWriter output = new XMLWriter(new FileWriter(
					new File(filename))); //file换成你自己的xml文件
			output.write(doc);
			output.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
}