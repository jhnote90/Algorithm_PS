
public class Stealing {

	public static void main(String[] args) {
		int answer = 0;
		int[] money = new int[] {1, 2, 3, 1, 2, 5, 6, 2, 1, 7, 3, 9, 3 ,5};
		int n = money.length;
		int[] dp1 = new int[n-1];
		int[] dp2 = new int[n-2];
		dp1[0] = money[0];
		dp1[1] = Math.max(money[0], money[1]);
		dp2[0] = 0;
		if (n >= 4) {
			dp2[1] = money[1];
			if (n >= 5)
				dp2[2] = Math.max(money[1], money[2]);
		}
		for (int i=2; i<n-1; i++) {
			dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
		}
		for (int i=3; i<n-2; i++) {
			dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
		}
		answer = Math.max(dp1[n-2], dp2[n-3] + money[n-1]);
		System.out.println(answer);
	}

}
