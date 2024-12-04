package day1;

import input.InputHandler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class DistanceBetweenLists {
	public static void main(String[] args) throws IOException
	{
		List<String> inputs = InputHandler.readFromUrl("https://adventofcode.com/2024/day/1/input");
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(String input : inputs) {
			String[] s = input.split("\s+");
			list1.add(Integer.parseInt(s[0]));
			list2.add(Integer.parseInt(s[1]));
		}
		Collections.sort(list1);
		Collections.sort(list2);
		int distance = 0;
		for(int i = 0; i < list1.size(); i++) {
			distance += Math.abs(list1.get(i) - list2.get(i));
		}
		System.out.println(distance);
	}
}
