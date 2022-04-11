import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1261Dijkstra {
	static int N, M;
	static int[][] maze;
	static int[][] cost;
	static boolean[][] visited;
	static int[] dr = new int[] {1, 0, -1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	
	static class Room implements Comparable<Room> {
		int row;
		int col;
		int broke;
		
		public Room(int row, int col, int broke) {
			this.row = row;
			this.col = col;
			this.broke = broke;
		}
		
		@Override
		public int compareTo(Room o) {
			return broke - o.broke;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		cost = new int[N][M];
		visited = new boolean[N][M];
		String str;
		for (int i=0; i<N; i++) {
			str = br.readLine();
			for (int j=0; j<M; j++) {
				maze[i][j] = str.charAt(j) - '0';
				cost[i][j] = N * M;
			}
		}
		int min = bfs(0, 0);
		System.out.println(min);
	}
	
	public static int bfs(int r, int c) {
		PriorityQueue<Room> pq = new PriorityQueue<>();
		cost[r][c] = 0;
		pq.offer(new Room(r, c, 0));
		Room room;
		int row, col;
		while(!pq.isEmpty()) {
			room = pq.poll();
			if (room.row == N-1 && room.col == M-1)
				return room.broke;
			if (visited[room.row][room.col])
				continue;
			visited[room.row][room.col] = true;
			for (int i=0; i<4; i++) {
				row = room.row + dr[i];
				col = room.col + dc[i];
				if (row<0 || row>=N || col<0 || col>=M)
					continue;
				if (maze[row][col] == 1) {
					if (room.broke + 1 < cost[row][col]) {
						cost[row][col] = room.broke + 1;
						pq.offer(new Room(row, col, room.broke+1));
					}
				}
				else {
					if (room.broke < cost[row][col]) {
						cost[row][col] = room.broke;
						pq.offer(new Room(row, col, room.broke));
					}
				}
			}
		}
		return -1;
	}

}
