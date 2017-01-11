package codility.prefixSums;

/**
 * GenomicRangeQuery
 * 
 * Find the minimal nucleotide from a range of sequence DNA. Programming
 * language: A DNA sequence can be represented as a string consisting of the
 * letters A, C, G and T, which correspond to the types of successive
 * nucleotides in the sequence. Each nucleotide has an impact factor, which is
 * an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3
 * and 4, respectively. You are going to answer several queries of the form:
 * What is the minimal impact factor of nucleotides contained in a particular
 * part of the given DNA sequence?
 * 
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1]
 * consisting of N characters. There are M queries, which are given in non-empty
 * arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M)
 * requires you to find the minimal impact factor of nucleotides contained in
 * the DNA sequence between positions P[K] and Q[K] (inclusive).
 * 
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 * 
 * P[0] = 2 Q[0] = 4 P[1] = 5 Q[1] = 5 P[2] = 0 Q[2] = 6 The answers to these M
 * = 3 queries are as follows:
 * 
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C
 * (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose
 * impact factor is 4, so the answer is 4. The part between positions 0 and 6
 * (the whole string) contains all nucleotides, in particular nucleotide A whose
 * impact factor is 1, so the answer is 1. Write a function:
 * 
 * class Solution { public int[] solution(String S, int[] P, int[] Q); } that,
 * given a non-empty zero-indexed string S consisting of N characters and two
 * non-empty zero-indexed arrays P and Q consisting of M integers, returns an
 * array consisting of M integers specifying the consecutive answers to all
 * queries.
 * 
 * The sequence should be returned as:
 * 
 * a Results structure (in C), or a vector of integers (in C++), or a Results
 * record (in Pascal), or an array of integers (in any other programming
 * language). For example, given the string S = CAGCCTA and arrays P, Q such
 * that:
 * 
 * P[0] = 2 Q[0] = 4 P[1] = 5 Q[1] = 5 P[2] = 0 Q[2] = 6 the function should
 * return the values [2, 4, 1], as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000]; M is an integer within the
 * range [1..50,000]; each element of arrays P, Q is an integer within the range
 * [0..N − 1]; P[K] ≤ Q[K], where 0 ≤ K < M; string S consists only of
 * upper-case English letters A, C, G, T. Complexity:
 * 
 * expected worst-case time complexity is O(N+M); expected worst-case space
 * complexity is O(N), beyond input storage (not counting the storage required
 * for input arguments). Elements of input arrays can be modified.
 * 
 * @author ibesli
 *
 */
public class GenomicRangeQuery {

	public static void main(String[] args) {
		// example of data
		String S = "CAGCCTA";
		int[] P = new int[] { 2, 5, 0 };
		int[] Q = new int[] { 4, 5, 6 };
		// call method
		(new GenomicRangeQuery()).solution2(S, P, Q);
	}

	public int[] solution(String S, int[] P, int[] Q) {
		String A = "A", C = "C", G = "G";
		// M : query number
		int M = P.length;
		// result array
		int[] resultArr = new int[M];
		// find minimum factor of Pair
		for (int i = 0; i < M; i++) {
			String subStr = S.substring(P[i], Q[i] + 1);
			if (subStr.contains(A))
				resultArr[i] = 1;
			else if (subStr.contains(C))
				resultArr[i] = 2;
			else if (subStr.contains(G))
				resultArr[i] = 3;
			// T = "T"
			else
				resultArr[i] = 4;
		}

		return resultArr;
	}

	public int[] solution2(String S, int[] P, int[] Q) {
		int[] A = new int[S.length() + 1];
		int[] C = new int[S.length() + 1];
		int[] G = new int[S.length() + 1];
		int[] T = new int[S.length() + 1];
		// M : query number
		int M = P.length;
		// result array
		int[] resultArr = new int[M];
		int sumOfA = 0, sumOfC = 0, sumOfG = 0, sumOfT = 0;
		for (int i = 1; i <= S.length(); i++) {
			char c = S.charAt(i - 1);
			if (c == 'A') {
				sumOfA++;
			} else if (c == 'C') {
				sumOfC++;
			} else if (c == 'G') {
				sumOfG++;
			} else {
				// T
				sumOfT++;
			}
			// assign value
			A[i] = sumOfA;
			C[i] = sumOfC;
			G[i] = sumOfG;
			T[i] = sumOfT;
		}
		for (int i = 0; i < M; i++) {
			int start = P[i];
			int end = Q[i] + 1;
			if (A[start] != A[end])
				resultArr[i] = 1;
			else if (C[start] != C[end])
				resultArr[i] = 2;
			else if (G[start] != G[end])
				resultArr[i] = 3;
			else
				resultArr[i] = 4;
		}

		return resultArr;
	}
}
