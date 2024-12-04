package day1;

import input.InputHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimilarityScore
{
	public static void main(String[] args)
	{
		List<String> inputs = InputHandler.readFromUrl("https://adventofcode.com/2024/day/1/input");
		Map<Integer, Integer> list1 = new HashMap<>();
		Map<Integer, Integer> list2 = new HashMap<>();
		for(String input : inputs) {
			String[] s = input.split("\s+");
			list1.put(Integer.parseInt(s[0]), list1.getOrDefault(Integer.parseInt(s[0]), 0) + 1);
			list2.put(Integer.parseInt(s[1]), list2.getOrDefault(Integer.parseInt(s[1]), 0) + 1);
		}
		int similarityScore = 0;
		for(Integer i : list1.keySet()) {
			if(list2.containsKey(i)) {
				similarityScore += i* list1.get(i) * list2.get(i);
			}
		}
		System.out.println(similarityScore);
	}
}
