package other;

public class ComputeAdjacentPair {

	public static void main(String[] args) {

		ComputeAdjacentPair pair = new ComputeAdjacentPair();
		int[] A = new int[8];
		A[0] = 0;
		A[1] = 3;
		A[2] = 3;
		A[3] = 7;
		A[4] = 5;
		A[5] = 3;
		A[6] = 11;
		A[7] = 1;
		System.out.println(pair.solution(A));

		A = new int[3];
		A[0] = 3;
		A[1] = 3;
		A[2] = 3;

		System.out.println(pair.solution(A));

		A = new int[8];
		A[0] = 0;
		A[1] = -3;
		A[2] = -3;
		A[3] = -7;
		A[4] = -5;
		A[5] = -3;
		A[6] = -11;
		A[7] = -1;
		System.out.println(pair.solution(A));
	}

	public int solution(int[] A) {
		// last largest biggest index difference
		int largestIndex = -1;
		for (int i = 0; i < A.length; i++) {
			// every value must have maximum two pair, one bigger one smaller
			int bigger = A[i], smaller = A[i], biggerIndex = -1, smallerIndex = -1;
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] == A[j]) {
					continue;
				} else if (A[j] > A[i]) {
					if (bigger == A[i] || A[j] < bigger) {
						bigger = A[j];
						biggerIndex = j;
					}
				} else if (A[j] < A[i]) {
					if (smaller == A[i] || A[j] > smaller) {
						smaller = A[j];
						smallerIndex = j;
					}
				}
			}
			// check which one bigger than largestBigDifferenceIndex
			if (smallerIndex != -1 && Math.abs(i - smallerIndex) > largestIndex)
				largestIndex = Math.abs(i - smallerIndex);
			if (biggerIndex != -1 && Math.abs(i - biggerIndex) > largestIndex)
				largestIndex = Math.abs(i - biggerIndex);
		}
		return largestIndex;
	}

}
