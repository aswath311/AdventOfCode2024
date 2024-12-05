package day4;

import input.InputHandler;

import java.util.List;

public class WordSearch
{
	static List<Integer[]> directions = List.of(new Integer[]{1,0}, new Integer[]{0,1}, new Integer[]{-1,0}, new Integer[]{0,-1},
		new Integer[]{1,1}, new Integer[]{-1,-1}, new Integer[]{1,-1}, new Integer[]{-1,1});

	public static void main(String[] args)
	{
		List<String> inputList = InputHandler.readFromUrl("https://adventofcode.com/2024/day/4/input");
		Character[][] inputMatrix = new Character[inputList.size()][inputList.get(0).length()];
		for(int i = 0; i < inputList.size(); i++)
		{
			String input = inputList.get(i);
			for(int j = 0; j < input.length(); j++)
			{
				inputMatrix[i][j] = input.charAt(j);
			}
		}
		System.out.println(wordCount(inputMatrix, "XMAS"));
	}

	public static int wordCount(Character[][] inputMatrix, String word)
	{
		int count = 0;
		int rows = inputMatrix.length;
		int cols = inputMatrix[0].length;
		int wordLength = word.length();
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				if(inputMatrix[i][j] == word.charAt(0))
				{
					for(Integer[] direction: directions)
					{
						if(wordCountUntilMatch(inputMatrix, i, j, direction[0], direction[1], word, 0, wordLength))
						{
							count++;
						}
					}
				}
			}
		}
		return count;
	}


	public static boolean wordCountUntilMatch(Character[][] inputMatrix, int row, int column, int rowIncrement, int colIncrement, String word, int index, int wordLength)
	{
		if(index == wordLength)
		{
			return true;
		}
		if(row < 0 || row >= inputMatrix.length || column < 0 || column >= inputMatrix[0].length || inputMatrix[row][column] != word.charAt(index))
		{
			return false;
		}
		return wordCountUntilMatch(inputMatrix, row + rowIncrement, column + colIncrement, rowIncrement, colIncrement, word, index + 1, wordLength);
	}
}
