package codility.prefixSums;

public class PassingCars {

	public static void main(String[] args) {
		int[] A = new int[5];
		A[0] = 0;
		A[1] = 1;
		A[2] = 0;
		A[3] = 1;
		A[4] = 1;
		System.out.println(passCars(A));
	}

	private static int passCars(int[] A) {

		int west = 0, passCars = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			int currentStatus = A[i];
			if (currentStatus == 1) {
				west++;
			} else {
				passCars += west;
			}
		}
		if (passCars > 1000000000)
			return -1;
		return passCars;
	}

}
