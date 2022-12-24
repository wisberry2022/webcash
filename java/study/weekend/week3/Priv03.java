package week3;

import java.util.*;

public class Priv03 {
	public static void main(String[] args) {
		Map<String, Integer> DataMap = new HashMap<>();
		
		DataMap.put("key1", 10);
		DataMap.put("key2", 11);
		DataMap.put("key3", 12);
		DataMap.put("key4", 13);
		DataMap.put("key5", 14);
		
		Set<String> keys = DataMap.keySet();
		Iterator<String> ite = keys.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
//		List<Integer> values = new ArrayList<Integer>(DataMap.values());
		Collection<Integer> values = DataMap.values();
		Iterator<Integer> vite = values.iterator();
		while(vite.hasNext()) {
			System.out.println(vite.next());
		}
		
		Collection<Integer> intSet = new ArrayList<Integer>(DataMap.values());
		System.out.println(intSet);
		
		Set<Map.Entry<String, Integer>> entries = DataMap.entrySet();
		Iterator<Map.Entry<String, Integer>> eIte = entries.iterator();
		while(eIte.hasNext()) {
			Map.Entry<String, Integer> entry = eIte.next();
			System.out.println(entry);
		}
		
		
	}
}
