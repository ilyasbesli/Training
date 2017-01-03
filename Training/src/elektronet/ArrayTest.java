package elektronet;

public class ArrayTest {

	public static void main(String[] args) {

		int[] a = { 1 };
		ArrayTest t = new ArrayTest();
		t.increment(a);
		System.out.println(a[a.length - 1]);
	}

	private void increment(int[] i) {
		i[i.length - 1]++;
	}
}
