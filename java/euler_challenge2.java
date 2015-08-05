public class problem2 {
	public static void main(String args[]) {
		int i;
		int sum = 0;
		int term3 = 1;
		int term2 = 1;
		int term1 = 1;
		while (term3 < 4000000) {
			if (term3 % 2 == 0)
				sum += term3;
			term3 = term2 + term1;
			term1 = term2;
			term2 = term3;
		}
		System.out.println(sum);
	}
}