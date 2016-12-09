package com.myspring2.main;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.myspring2.bean.Person;

public class Test {
	public static void main(String[] args) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		File f = new File("myspring.xml");
//		System.out.println(f.exists());
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
		DocumentBuilder builder = factory.newDocumentBuilder();   
		Document doc = builder.parse(f);   
		NodeList beanList = doc.getElementsByTagName("myBean");
		System.out.println(beanList.getLength());
		for(int i=0;i<beanList.getLength();i++) {
			Node beanNode = beanList.item(i);
			Element beanTmp = (Element)beanNode;
//			System.out.println(beanTmp.getAttribute("id")+","+beanTmp.getAttribute("class"));
			String beanName = beanTmp.getAttribute("id");
			Object bean = Class.forName(beanTmp.getAttribute("class")).newInstance();
			
			NodeList propertyList = beanTmp.getElementsByTagName("myProperty");
			for(int j=0;j<propertyList.getLength();j++) {
				Node propertyNode = propertyList.item(j);
				Element propertyTmp = (Element)propertyNode;
				String propertyName = propertyTmp.getAttribute("name");
				String propertyValue = propertyTmp.getAttribute("value");
				Field field = bean.getClass().getDeclaredField(propertyName);
				field.setAccessible(true);
				field.set(bean, propertyValue);
				field.setAccessible(false);
			}
			map.put(beanName, bean);
		}
		
		Person p = (Person) map.get("person");
		System.out.println(p.getId()+","+p.getName()+","+p.getSex());
		System.out.println();
	}
}
