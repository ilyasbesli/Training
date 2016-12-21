package codility.prefixSums;

public class MinAvgTwoSlice {

	public static void main(String[] args) {
		int[] A = new int[] { 4, 2, 2, 5, 1, 5, 8 };
		System.out.println(test(A));
	}

	private static int test(int[] A) {
		// write your code in Java SE 8
		float minAverage = Float.MAX_VALUE, currentAverage;
		int startPoint = 0;
		for (int i = 0; i < A.length - 1; i++) {
			currentAverage = (A[i] + A[i + 1]) / 2;
			if (A.length > i + 2 && currentAverage > A[i + 2]) {
				currentAverage = (currentAverage * 2 + A[i + 2]) / 3;
			}
			if (currentAverage < minAverage) {
				startPoint = i;
				minAverage = currentAverage;
			}
		}
		return startPoint;
	}

}
