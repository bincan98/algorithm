import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	private static int min;
	private static int[][][] dist;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
//		min = Integer.MAX_VALUE;
//		visited[0][0] = true;
//		dfs(0, 0, 1, false);
//		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		
		bfs(0,0);
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		int min = Math.min(dist[N-1][M-1][0], dist[N-1][M-1][1]);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		
		
		
	} // end of main

	private static void bfs(int startY, int startX) {
		Queue<Integer> queue = new ArrayDeque<>();
		dist = new int[N][M][2]; //[0]은 벽 안부수고 이동한 거리 // [1]은 벽부수고 이동한 거리 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dist[i][j], Integer.MAX_VALUE);
			}
		}
		
		queue.offer(startY);
		queue.offer(startX);
		queue.offer(0);
		dist[startY][startX][0] = 1;
		
		int currentY, currentX, des;
		while(!queue.isEmpty()) {
			currentY = queue.poll();
			currentX = queue.poll();
			des = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = currentY + dy[i];
				int nx = currentX + dx[i];
				if(isValid(ny,nx) && dist[ny][nx][des] == Integer.MAX_VALUE) {
					if(map[ny][nx] == 0) {
						queue.offer(ny);
						queue.offer(nx);
						queue.offer(des);
						if(des == 0) { 
							dist[ny][nx][0] = dist[currentY][currentX][0] + 1;
						} else { // des == 1 
							dist[ny][nx][1] = dist[currentY][currentX][1] + 1;
						}
					} else if (map[ny][nx] == 1) {
						if(des == 1) continue;
						queue.offer(ny);
						queue.offer(nx);
						queue.offer(1);
						dist[ny][nx][1] = dist[currentY][currentX][0] + 1;
					}
				}
			} // end of for i
		} // end of while
	} // end of bfs

	private static boolean isValid(int y, int x) {
		return 0<=y && y<N && 0<=x && x<M;
	} // end of isValid
} // end of class