import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890 {

    static int N;
    static int L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        int[] road = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                road[j] = map[i][j];
            }
            cnt += possible(road);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                road[j] = map[j][i];
            }
            cnt += possible(road);
        }
        System.out.println(cnt);
    }

    private static int possible(int[] road) {
        int prev = road[0];
        int cont = 1;
        int i = 1;
        while (i < N) {
            if (Math.abs(road[i] - prev) > 1) {
                return 0;
            }
            if (prev < road[i]) {
                if (cont >= L) {
                    prev = road[i];
                    cont = 1;
                } else {
                    return 0;
                }
            } else if (prev > road[i]) {
                if (i + L > N) {
                    return 0;
                }
                prev = road[i];
                cont = 1;
                for (int j = i + 1; j < i + L; j++) {
                    if (prev != road[j]) {
                        return 0;
                    }
                    prev = road[j];
                    cont++;
                }
                i = i + L - 1;
                cont = 0;
            } else {
                prev = road[i];
                cont++;
            }
            i++;
        }
        return 1;
    }
}
