import java.util.Arrays;

public class GymSuit {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = new int[] {3, 4};
		int[] reserve = new int[] {4, 5};
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		for (int i=0; i<reserve.length; i++) {
			for (int j=0; j<lost.length; j++) {
				if (lost[j] > reserve[i]+1)
					break;
				if (lost[j] == reserve[i]-1) {
					if (j+1 != lost.length && lost[j+1] == reserve[i])
						continue;
					lost[j] = 0;
					break;
				}
				if (lost[j] == reserve[i]) {
					lost[j] = 0;
					break;
				}
				if (lost[j] == reserve[i]+1) {
					if (i+1 != reserve.length && reserve[i+1] == lost[j])
						break;
					lost[j] = 0;
					break;
				}
			}
		}
		int cnt = 0;
		for (int i=0; i<lost.length; i++) {
			if (lost[i] > 0)
				cnt++;
		}
		System.out.println(n-cnt);

	}

}
