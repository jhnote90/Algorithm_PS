import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11000 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s;
        int t;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            list.add(new int[]{s, t});
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        for (int[] c : list) {
            if (pq.isEmpty() || c[0] < pq.peek()) {
                pq.offer(c[1]);
                cnt++;
            } else {
                pq.poll();
                pq.offer(c[1]);
            }
        }
        System.out.println(cnt);
    }
}
