package codility.stackAndQueues;

import java.util.Stack;

/**
 * 
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * 
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * 
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0,
 * as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * Complexity:
 * 
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 * 
 * 
 * @author ibesli
 *
 */
public class Brackets {

	public static void main(String[] args) {
		Brackets brackets = new Brackets();
		System.out.println(brackets.solution("{[()()]}{"));
	}

	public int solution(String S) {
		if (S == null || "".equals(S))
			return 1;

		Stack<Character> bracketStack = new Stack<>();
		for (char currentChar : S.toCharArray()) {
			switch (currentChar) {
			case ')':
				if (controlBracket(bracketStack, '(') == 0)
					return 0;
				break;
			case '}':
				if (controlBracket(bracketStack, '{') == 0)
					return 0;
				break;
			case ']':
				if (controlBracket(bracketStack, '[') == 0)
					return 0;
				break;
			default:
				bracketStack.push(currentChar);
				break;
			}
		}
		if (bracketStack.isEmpty())
			return 1;
		else
			return 0;
	}

	private int controlBracket(Stack<Character> bracketStack, char waitedBracket) {
		if (bracketStack.isEmpty())
			return 0;
		char prevChar = bracketStack.pop();
		if (prevChar == waitedBracket)
			return 1;
		else
			return 0;
	}
}
