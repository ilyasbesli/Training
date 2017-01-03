package elektronet;

import java.util.HashSet;
import java.util.Set;

public class NumPairs {

	public static void main(String[] args) {
		int[] a = { 1, 3, 0, 7, 2, 5, 4, 7, 2, 9, 1, };
		long k = 4;

		String pairStr = "";
		Set<Long> pairSet = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] == k) {
					if (a[i] > a[j])
						pairStr = a[j] + "" + a[i];
					else
						pairStr = a[i] + "" + a[j];
					pairSet.add(Long.parseLong(pairStr));
				}
			}
		}
	}

}
