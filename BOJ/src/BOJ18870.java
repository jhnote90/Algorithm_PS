import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18870 {
    static int N;
    static int[] X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        X = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            set.add(X[i]);
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            int idx = Collections.binarySearch(list, X[i]);
            sb.append(idx).append(" ");
        }
        System.out.println(sb);
    }
}
