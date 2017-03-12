package hackerrank.tutorials.daysofcode30;

import java.util.Scanner;

/**
 * Day 11: 2D Arrays
 * 
 * @author ibesli
 *
 *         Objective Today, we're building on our knowledge of Arrays by adding
 *         another dimension. Check out the Tutorial tab for learning materials
 *         and an instructional video!
 * 
 *         Context Given a 2D Array, :
 * 
 *         1 1 1 0 0 0 0 1 0 0 0 0 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 *         0 We define an hourglass in to be a subset of values with indices
 *         falling in this pattern in 's graphical representation:
 * 
 *         a b c d e f g There are hourglasses in , and an hourglass sum is the
 *         sum of an hourglass' values.
 * 
 *         Task Calculate the hourglass sum for every hourglass in , then print
 *         the maximum hourglass sum.
 * 
 *         Input Format
 * 
 *         There are lines of input, where each line contains space-separated
 *         integers describing 2D Array ; every value in will be in the
 *         inclusive range of to .
 * 
 *         Constraints
 * 
 *         Output Format
 * 
 *         Print the largest (maximum) hourglass sum found in .
 * 
 *         Sample Input
 * 
 *         1 1 1 0 0 0 0 1 0 0 0 0 1 1 1 0 0 0 0 0 2 4 4 0 0 0 0 2 0 0 0 0 1 2 4
 *         0 Sample Output
 * 
 *         19 Explanation
 * 
 *         contains the following hourglasses:
 * 
 *         1 1 1 1 1 0 1 0 0 0 0 0 1 0 0 0 1 1 1 1 1 0 1 0 0 0 0 0
 * 
 *         0 1 0 1 0 0 0 0 0 0 0 0 1 1 0 0 0 0 2 0 2 4 2 4 4 4 4 0
 * 
 *         1 1 1 1 1 0 1 0 0 0 0 0 0 2 4 4 0 0 0 0 0 2 0 2 0 2 0 0
 * 
 *         0 0 2 0 2 4 2 4 4 4 4 0 0 0 2 0 0 0 1 0 1 2 1 2 4 2 4 0
 * 
 *         The hourglass with the maximum sum () is:
 * 
 *         2 4 4 2 1 2 4
 */
public class Day112DArrays {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		int maxSum = Integer.MIN_VALUE, currentSum;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				currentSum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
						+ arr[i + 2][j + 1] + arr[i + 2][j + 2];
				maxSum = Math.max(maxSum, currentSum);
			}
		}
		System.out.print(maxSum);
	}

}