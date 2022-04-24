package com.saveforgreen.datastructures.pattern.p8.dfs;

import java.util.HashMap;
import java.util.Map;

public class FlattenDictionary {

	static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
		HashMap<String, String> output = new HashMap<>();
		// your code goes here
		// Map.Entry<String, Object> entry : dict.entrySet()
		flattenDictHelper(dict, output, "");
		return output;
	}

	static void flattenDictHelper(Map<String, Object> entryMap, Map<String, String> output, String prefix) {

		for (Map.Entry<String, Object> entry : entryMap.entrySet()) {
			Object entryVal = entry.getValue();
			if (entryVal instanceof Map) {
				if (entry.getKey() != null && !entry.getKey().trim().equals("")) {
					flattenDictHelper((Map<String, Object>) entryVal, output,
							(!prefix.equals("") ? prefix + "." + entry.getKey() : entry.getKey()));
				} else {
					output.put(prefix, entryVal.toString());
				}

			} else {
				if (entry.getKey() != null && !entry.getKey().trim().equals("")) {
					output.put((!prefix.equals("") ? prefix + "." + entry.getKey() : entry.getKey()),
							entryVal.toString());
				} else {
					output.put(prefix, entryVal.toString());
				}

			}
		}
	}

	public static void main(String[] args) {
		HashMap<String, Object> input = new HashMap<>();
		input.put("key1", "1");
		HashMap<String, Object> key2 = new HashMap<>();
		key2.put("a", "2");
		key2.put("b", "3");
		HashMap<String, Object> c = new HashMap<>();
		c.put("d", "4");
		HashMap<String, Object> e = new HashMap<>();
		e.put("", "1");
		c.put("e", e);
		key2.put("c", c);
		input.put("key2", key2);
		// input.put();

		System.out.println(flattenDictionary(input));
	}

}
/*
 * dict = { "Key1" : "1", "Key2" : { "a" : "2", "b" : "3", "c" : { "d" : "3",
 * "e" : { "" : "1" } } } } { ""
 *
 * }
 *
 */