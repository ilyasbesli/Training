package elektronet;

public class Divide {

	public static void main(String[] args) {
		try {
			int i = 4 / 0;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("C");
		} finally {
			System.out.println("F");
		}

	}

}
