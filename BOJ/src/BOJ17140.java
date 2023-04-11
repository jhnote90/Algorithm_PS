import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17140 {

    static int r;
    static int c;
    static int k;
    static int t;
    static int mr;
    static int mc;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        t = 0;
        mr = 3;
        mc = 3;
        A = new int[100][100];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (A[r - 1][c - 1] == k) {
            System.out.println(t);
            return;
        }
        t++;
        while (t <= 100) {
            int max = 0;
            if (mr >= mc) {
                //행에 대해 정렬, mc 갱신
                for (int i = 0; i < mr; i++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < mc; j++) {
                        if (A[i][j] == 0) {
                            continue;
                        }
                        if (map.containsKey(A[i][j])) {
                            map.put(A[i][j], map.get(A[i][j]) + 1);
                        } else {
                            map.put(A[i][j], 1);
                        }
                    }
                    List<Integer> list = sort(map);
                    int num = 0;
                    for (int j = 0; j < 100; j++) {
                        if (j == Math.max(mc, list.size())) {
                            break;
                        }
                        if (j >= list.size()) {
                            A[i][j] = 0;
                        } else {
                            A[i][j] = list.get(j);
                            num++;
                        }
                    }
                    max = Math.max(max, num);
                }
                mc = max;
            } else {
                //열에 대해 정렬, mr 갱신
                for (int i = 0; i < mc; i++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < mr; j++) {
                        if (A[j][i] == 0) {
                            continue;
                        }
                        if (map.containsKey(A[j][i])) {
                            map.put(A[j][i], map.get(A[j][i]) + 1);
                        } else {
                            map.put(A[j][i], 1);
                        }
                    }
                    List<Integer> list = sort(map);
                    int num = 0;
                    for (int j = 0; j < 100; j++) {
                        if (j == Math.max(mr, list.size())) {
                            break;
                        }
                        if (j >= list.size()) {
                            A[j][i] = 0;
                        } else {
                            A[j][i] = list.get(j);
                            num++;
                        }
                    }
                    max = Math.max(max, num);
                }
                mr = max;
            }
            if (A[r - 1][c - 1] == k) {
                break;
            }
            t++;
        }
        if (t <= 100) {
            System.out.println(t);
        } else {
            System.out.println(-1);
        }
    }

    private static List<Integer> sort(Map<Integer, Integer> map) {
        List<int[]> arrList = new ArrayList<>();
        for (int i : map.keySet()) {
            arrList.add(new int[]{i, map.get(i)});
        }
        Collections.sort(arrList, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        List<Integer> list = new ArrayList<>();
        for (int[] arr : arrList) {
            list.add(arr[0]);
            list.add(arr[1]);
        }
        return list;
    }
}
