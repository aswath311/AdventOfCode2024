package day3;

import input.InputHandler;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiplicationWithDoInstructions
{
	public static void main(String[] args)
	{
		List<String> inputList = InputHandler.readFromUrl("https://adventofcode.com/2024/day/3/input");
		boolean isDoInstruction = true;
		int productSum = 0;
		String doDontRegex = "(do\\(\\))|(don't\\(\\))";
		Pattern pattern = Pattern.compile(doDontRegex);
		for(String input: inputList) {
			StringBuilder sb = new StringBuilder();
			while(input.length()>0) {
				if(isDoInstruction) {
					if(input.contains("don't()")) {
						sb.append(input.substring(0, input.indexOf("don't()")));
						input = input.substring(input.indexOf("don't()") + 7);
						isDoInstruction = false;
					} else {
						sb.append(input);
						input = "";
					}
				}
				else {
					if(input.contains("do()")) {
						input = input.substring(input.indexOf("do()") + 4);
						isDoInstruction = true;
					} else {
						input = "";
					}
				}
			}
			productSum += Multiplication.computeProductSum(sb.toString());
		}
		System.out.println(productSum);
	}
}
