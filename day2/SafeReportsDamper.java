package day2;

import input.InputHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SafeReportsDamper
{
	public static void main(String[] args)
	{
		List<String> inputs = InputHandler.readFromUrl("https://adventofcode.com/2024/day/2/input");
		int safeLevels = 0;
		for(String report : inputs) {
			Integer[] values = Arrays.stream(report.split("\s+")).map(Integer::parseInt).toArray(Integer[]::new);
			if(SafeReports.isSafe(values)) {
				safeLevels++;
				continue;
			}
			for(int i = 0; i < values.length; i++)
			{
				Integer[] left = Arrays.copyOfRange(values, 0, i);
				Integer[] right = Arrays.copyOfRange(values, i+1, values.length);
				Integer[] combined = new Integer[left.length + right.length];
				System.arraycopy(left, 0, combined, 0, left.length);
				System.arraycopy(right, 0, combined, left.length, right.length);
				if(SafeReports.isSafe(combined)) {
					safeLevels++;
					break;
				}
			}

		}
		System.out.println(safeLevels);
	}
}
