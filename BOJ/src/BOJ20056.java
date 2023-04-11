import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20056 {

    static int N;
    static int M;
    static int K;
    static int[] dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q.offer(new int[]{r, c, m, s, d});
        }
        int cmd = 0;

        while (cmd < K) {
            int qSize = q.size();
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int i = 0; i < qSize; i++) {
                int[] fb = q.poll();
                fb[0] = (fb[0] + dr[fb[4]] * fb[3] + N * fb[3]) % N;
                fb[1] = (fb[1] + dc[fb[4]] * fb[3] + N * fb[3]) % N;
                int num = fb[0] * N + fb[1];
                if (map.containsKey(num)) {
                    List<int[]> list = map.get(num);
                    list.add(fb);
                } else {
                    map.put(num, new ArrayList<>());
                    map.get(num).add(fb);
                }
            }
            for (int key : map.keySet()) {
                List<int[]> list = map.get(key);
                int r = key / N;
                int c = key % N;
                if (list.size() > 1) {
                    int dir = list.get(0)[4] % 2;
                    boolean dirCheck = true;
                    int mSum = 0;
                    int sSum = 0;
                    for (int[] fb : list) {
                        mSum += fb[2];
                        sSum += fb[3];
                        if (fb[4] % 2 != dir) {
                            dirCheck = false;
                        }
                    }
                    int m = mSum / 5;
                    int s = sSum / list.size();
                    if (m > 0) {
                        if (dirCheck) {
                            q.offer(new int[]{r, c, m, s, 0});
                            q.offer(new int[]{r, c, m, s, 2});
                            q.offer(new int[]{r, c, m, s, 4});
                            q.offer(new int[]{r, c, m, s, 6});
                        } else {
                            q.offer(new int[]{r, c, m, s, 1});
                            q.offer(new int[]{r, c, m, s, 3});
                            q.offer(new int[]{r, c, m, s, 5});
                            q.offer(new int[]{r, c, m, s, 7});
                        }
                    }
                } else {
                    q.offer(list.get(0));
                }
            }
            cmd++;
        }
        int sum = 0;
        while (!q.isEmpty()) {
            int[] fb = q.poll();
            sum += fb[2];
        }
        System.out.println(sum);
    }


}
