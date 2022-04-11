import java.util.Arrays;

public class KthNumber {

	public static void main(String[] args) {
		int[] array = new int[] {1,5,2,6,3,7,4};
		int[][] commands = new int[][] {{2,5,3},{4,4,1},{1,7,3}};
		int n = commands.length;
		int[] answer = new int[n];
		int m;
		for (int i=0; i<n; i++) {
			m = commands[i][1] - (commands[i][0] - 1);
			int[] temp = new int[m];
			int j = commands[i][0] - 1;
			for (int k=0; k<m; k++)
				temp[k] = array[j++];
			Arrays.sort(temp);
			answer[i] = temp[commands[i][2] - 1];
		}
		for (int i=0; i<n;i ++) {
			System.out.println(answer[i]);
		}
		
	}

}
