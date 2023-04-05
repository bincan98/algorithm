import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int R, C;
	private static char[][] arr;
	private static int goseumY, goseumX;
	static int[] dy = {0,0,-1,1};
	static int[] dx = {-1,1,0,0};
	private static Queue<Integer> waterQueue;
	private static int targetY, targetX;
	private static int[][] distance;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		waterQueue = new ArrayDeque<>();
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
				if(s.charAt(j) == 'S') {
					goseumY = i;
					goseumX = j;
				} else if(s.charAt(j) == '*') {
					waterQueue.offer(i);
					waterQueue.offer(j);
				} else if(s.charAt(j) == 'D') {
					targetY = i;
					targetX = j;
				}
			}
		} // 입력 완료
		
		bfs(goseumY, goseumX);
		
		System.out.println(distance[targetY][targetX] == 0 ? "KAKTUS" : distance[targetY][targetX]);
		
	} // end of main

	private static void bfs(int startY, int startX) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		distance = new int[R][C];
		
		queue.offer(startY);
		queue.offer(startX);
		visited[startY][startX] = true;
		
		while (!queue.isEmpty()) {
			int size = queue.size()/2;
			hongsu();
			
			while(size-- > 0) {
				int currentY = queue.poll();
				int currentX = queue.poll();
				
				if(arr[currentY][currentX] == 'D') return;
				
				for (int i = 0; i < 4; i++) {
					int ny = currentY + dy[i];
					int nx = currentX + dx[i];
					if(isValid(ny, nx) && arr[ny][nx] != 'X' && arr[ny][nx] != '*') {
						if(!visited[ny][nx]) {
							queue.offer(ny);
							queue.offer(nx);
							visited[ny][nx] = true;
							distance[ny][nx] = distance[currentY][currentX] + 1;
						}
					}
				}
			}
		}
		
	} // end of bfs

	private static void hongsu() {
		int size = waterQueue.size()/2;
		
		while(size-- > 0) {
			int currentY = waterQueue.poll();
			int currentX = waterQueue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = currentY + dy[i];
				int nx = currentX + dx[i];
				if(isValid(ny, nx) && arr[ny][nx] != 'D' 
						&& arr[ny][nx] != '*' && arr[ny][nx] != 'X') {
					waterQueue.offer(ny);
					waterQueue.offer(nx);
					arr[ny][nx] = '*';
				}
			}
		}
	} // end of hongsu
	
	private static boolean isValid(int y, int x) {
		return 0<=y && y<R && 0<=x && x<C;
	}
} // end of class