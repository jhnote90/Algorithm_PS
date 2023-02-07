import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] wires = new int[n][2];
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wires, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] dp = new int[n][2];
        int max = 0;
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            max = 0;
            for (int j=0; j<i; j++) {
                if (wires[j][1] < wires[i][1] && max < dp[j][1]) {
                    max = dp[j][1];
                }
            }
            dp[i][1] = 1 + max;
        }
        System.out.println(n - Math.max(dp[n - 1][0], dp[n - 1][1]));
    }
}
