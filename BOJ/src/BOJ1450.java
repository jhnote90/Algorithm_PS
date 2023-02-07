import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1450 {

    static int n;
    static int c;
    static long[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        weight = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Long.parseLong(st.nextToken());
        }
        int cnt = 0;
        List<Long> lSum = new ArrayList<>();
        List<Long> rSum = new ArrayList<>();
        comb(-1, n / 2 - 1, 0L, lSum);
        comb(n / 2 - 1, n - 1, 0L, rSum);
        Collections.sort(rSum);
        for (long l : lSum) {
            cnt += LowerBound(rSum, c - l) + 1;
        }
        System.out.println(cnt);
    }

    private static int LowerBound(List<Long> sumList, long l) {
        int lowerBound = -1;
        int start = 0;
        int end = sumList.size() - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (sumList.get(mid) > l) {
                end = mid - 1;
            } else {
                lowerBound = mid;
                start = mid + 1;
            }
        }
        return lowerBound;
    }

    private static void comb(int x, int end, long sum, List<Long> sumList) {
        sumList.add(sum);
        for (int i = x + 1; i <= end; i++) {
            comb(i, end, sum + weight[i], sumList);
        }
    }
}
