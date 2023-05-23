import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16235 {

    static int N;
    static int M;
    static int K;
    static int[] dr = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] A;
    static int[][] nutInfo;
    static int[][] addNutInfo;
    static List<List<Map<Integer, Integer>>> ground;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N+1][N+1];
        nutInfo = new int[N+1][N+1];
        addNutInfo = new int[N + 1][N + 1];
        ground = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nutInfo[i][j] = 5;
            }
        }
        for (int i = 0; i < N + 1; i++) {
            ground.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N + 1; j++) {
                ground.get(i).add(new HashMap<>());
            }
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Map<Integer, Integer> map = ground.get(x).get(y);
            if (map.containsKey(z)) {
                map.put(z, map.get(z) + 1);
            } else {
                map.put(z, 1);
            }
        }

        for (int i = 0; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    addNutInfo[j][k] = 0;
                }
            }
            spring();
            summer();
            fall();
            winter();
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                Map<Integer, Integer> map = ground.get(i).get(j);
                for (int age : map.keySet()) {
                    cnt += map.get(age);
                }
            }
        }
        System.out.println(cnt);
    }

    private static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nutInfo[i][j] += A[i][j];
            }
        }
    }

    private static void fall() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                Map<Integer, Integer> map = ground.get(i).get(j);
                for (int age : map.keySet()) {
                    if (age % 5 == 0) {
                        for (int k = 0; k < 8; k++) {
                            int r = i + dr[k];
                            int c = j + dc[k];
                            if (r < 1 || r > N || c < 1 || c > N) {
                                continue;
                            }
                            Map<Integer, Integer> adjMap = ground.get(r).get(c);
                            if (adjMap.containsKey(1)) {
                                adjMap.put(1, adjMap.get(1) + map.get(age));
                            } else {
                                adjMap.put(1, map.get(age));
                            }
                        }
                    }
                }
            }
        }
    }

    private static void summer() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nutInfo[i][j] += addNutInfo[i][j];
            }
        }
    }

    private static void spring() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                Map<Integer, Integer> map = ground.get(i).get(j);
                List<Integer> list = new ArrayList<>(map.keySet());
                Collections.sort(list);
                Map<Integer, Integer> addMap = new HashMap<>();
                for (int age : list) {
                    if (nutInfo[i][j] >= age) {
                        if (nutInfo[i][j] >= map.get(age) * age) {
                            nutInfo[i][j] -= map.get(age) * age;
                            addMap.put(age + 1, map.get(age));
                        } else {
                            int num = nutInfo[i][j] / age;
                            nutInfo[i][j] = nutInfo[i][j] % age;
                            addMap.put(age + 1, num);
                            addNutInfo[i][j] += (map.get(age) - num) * (age / 2);
                        }
                    } else {
                        addNutInfo[i][j] += map.get(age) * (age / 2);
                    }
                }
                ground.get(i).set(j, addMap);
            }
        }
    }
}
