package codility.sorting;

import java.util.Arrays;

public class MaxProductOfThree {

	public static void main(String[] args) {
		MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
		int[] A = new int[6];
		A[0] = -3;
		A[1] = 1;
		A[2] = 2;
		A[3] = -2;
		A[4] = 5;
		A[5] = 6;
		System.out.println(maxProductOfThree.solution(A));
	}

	private int solution(int[] A) {

		if (A.length == 3)
			return A[0] * A[1] * A[2];
		else {
			Arrays.sort(A);
			// if first two number under zero
			int firstThree = A[0] * A[1] * A[A.length - 1];
			int lastThree = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
			return firstThree > lastThree ? firstThree : lastThree;
		}

	}

}
