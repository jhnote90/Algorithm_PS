import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12015 {

    static int n;
    static int[] A;
    static List<Integer> lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        lis = new ArrayList<>();
        lis.add(A[0]);
        for (int i = 1; i < n; i++) {
            int size = lis.size();
            if (A[i] > lis.get(size - 1)) {
                lis.add(A[i]);
            } else {
                int j = binarySearch(0, size - 1, A[i]);
                lis.set(j, A[i]);
            }
        }
        System.out.println(lis.size());
    }

    public static int binarySearch(int start, int end, int num) {
        int lowerBound = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (lis.get(mid) < num) {
                start = mid + 1;
            } else {
                lowerBound = mid;
                end = mid - 1;
            }
        }
        return lowerBound;
    }
}
