package day2;

import input.InputHandler;

import java.util.Arrays;
import java.util.List;

public class SafeReports
{
	public static void main(String[] args)
	{
		List<String> inputs = InputHandler.readFromUrl("https://adventofcode.com/2024/day/2/input");
		int safeLevels = 0;
		for(String input: inputs) {
			Integer[] values = Arrays.stream(input.split("\s+")).map(Integer::parseInt).toArray(Integer[]::new);
			if(isSafe(values)) safeLevels++;
		}
		System.out.println(safeLevels);
	}

	public static boolean isSafe(Integer[] values) {
		boolean isIncreasing = values[0] < values[1];
		int current = values[0];
		boolean isSafe = true;
		for(int i = 1; i < values.length; i++) {
			if(isIncreasing) {
				if(values[i] < current) {
					isSafe = false;
					break;
				}
				else if(!(values[i]-current >= 1 && values[i] - current <=3)) {
					isSafe = false;
					break;
				}
			} else {
				if(values[i] > current) {
					isSafe = false;
					break;
				}
				else if(!(current-values[i] >= 1 && current - values[i] <=3)) {
					isSafe = false;
					break;
				}
			}
			current = values[i];
		}
		return isSafe;
	}
}
