import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16947 {

    static int n;
    static boolean[] visited;
    static boolean[] finished;
    static int[] cycleEdge;
    static Set<Integer> circularSet;
    static List<List<Integer>> edges;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        finished = new boolean[n+1];
        cycleEdge = new int[2];
        circularSet = new HashSet<>();
        edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            edges.get(s).add(e);
            edges.get(e).add(s);
        }
        findCycle(1, 0);
        Arrays.fill(visited, false);
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(cycleEdge[0]);
        dfs(cycleEdge[0], path);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            sb.append(bfs(i)).append(" ");
        }
        System.out.println(sb);
    }

    private static int bfs(int num) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                if (circularSet.contains(poll)) {
                    return cnt;
                }
                for (int j : edges.get(poll)) {
                    if (!visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    private static void dfs(int num, LinkedList<Integer> path) {
        visited[num] = true;
        if (num == cycleEdge[1]) {
            circularSet = new HashSet<>(path);
            return;
        }
        for (int i : edges.get(num)) {
            if (num == cycleEdge[0] && i == cycleEdge[1]) {
                continue;
            }
            if (!visited[i]) {
                path.addLast(i);
                dfs(i, path);
                path.removeLast();
            }
        }
    }

    private static void findCycle(int num, int prev) {
        visited[num] = true;
        for (int i : edges.get(num)) {
            if (!visited[i]) {
                findCycle(i, num);
            } else {
                if (!finished[i] && (i != prev)) {
                    cycleEdge[0] = num;
                    cycleEdge[1] = i;
                }
            }
        }
        finished[num] = true;
    }
}
