package day3;

import input.InputHandler;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Multiplication
{
	public static void main(String[] args)
	{
		List<String> inputList = InputHandler.readFromUrl("https://adventofcode.com/2024/day/3/input");

		int productSum = 0;
		for(String input : inputList)
		{
			productSum += computeProductSum(input);
		}
		System.out.println(productSum);
	}

	public static int computeProductSum(String input) {
		String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
		Pattern pattern = Pattern.compile(regex);
		int productSum = 0;
		Matcher matcher = pattern.matcher(input);
		while(matcher.find())
		{
			String match = matcher.group();
			String[] numbers = match.substring(4, match.length() - 1).split(",");
			int num1 = Integer.parseInt(numbers[0]);
			int num2 = Integer.parseInt(numbers[1]);
			int result = num1 * num2;
			productSum += result;
		}
		return productSum;
	}
}
