package com.myspring2.extra;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void hashMapTest1() {
		System.out.println("hashaMap的第一个练习=============");
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("abc", 10);
		System.out.println(map.get("abc"));
		map.put("abc",20);
		System.out.println(map.get("abc"));
	}
	public static void hashMapTest2() {
		System.out.println("hashaMap的第二个练习=============");
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<10;i++) {
			map.put(""+(char)(i+65), (int)(1+Math.random()*(10-1+1)));
		}
		Set<Entry<String, Integer>> entrySet =  map.entrySet();
		Iterator<Entry<String, Integer>> it = entrySet.iterator();
		while(it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
	}
	public static void main(String[] args) {
		MapTest.hashMapTest2();
	}
}
