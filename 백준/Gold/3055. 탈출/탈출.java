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
		
		// 맵 입력받을 배열
		arr = new char[R][C];
		// 물의 좌표 넣을 큐 (물의 좌표가 여러개일 수 있음)
		waterQueue = new ArrayDeque<>();
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s.charAt(j);
				if(s.charAt(j) == 'S') { // 고슴도치 위치 찾았다면
					// 변수에 넣기
					goseumY = i;
					goseumX = j;
				} else if(s.charAt(j) == '*') { // 물의 위치 찾았다면
					// 큐에 넣어주기
					waterQueue.offer(i);
					waterQueue.offer(j);
				} else if(s.charAt(j) == 'D') { // 목적지 찾았다면
					// 변수에 넣기
					targetY = i;
					targetX = j;
				}
			}
		} // 입력 완료
		
		bfs(goseumY, goseumX);
		
		System.out.println(distance[targetY][targetX] == 0 ? "KAKTUS" : distance[targetY][targetX]);
		
	} // end of main

	private static void bfs(int startY, int startX) {
		Queue<Integer> queue = new ArrayDeque<>(); // bfs에 쓸 큐
		boolean[][] visited = new boolean[R][C]; // 방문 체크
		distance = new int[R][C]; // 최소시간 저장할 배열 
		
		queue.offer(startY);
		queue.offer(startX);
		visited[startY][startX] = true;
		
		while (!queue.isEmpty()) {
			int size = queue.size()/2; // 두개씩 넣고 두개씩 빼므로 size 2로 나누기
			hongsu(); // 홍수 먼저 일으키기
			
			while(size-- > 0) {
				int currentY = queue.poll();
				int currentX = queue.poll();
				
				// 목적지에 닿았다면 bfs 끝내기
				if(arr[currentY][currentX] == 'D') return;
				
				for (int i = 0; i < 4; i++) {
					int ny = currentY + dy[i];
					int nx = currentX + dx[i];
					// 1.맵을 넘어서지 않고  2.바위가 아니고  3.물이 있는곳이 아니고
					if(isValid(ny, nx) && arr[ny][nx] != 'X' && arr[ny][nx] != '*') {
						// 아직 방문하지 않은 곳이라면
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
		int size = waterQueue.size()/2; // 두개씩 넣고 두개씩 빼므로 size 2로 나누기
		
		while(size-- > 0) {
			int currentY = waterQueue.poll();
			int currentX = waterQueue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = currentY + dy[i];
				int nx = currentX + dx[i];
				// 1.맵을 넘어서지 않고  2.목적지가 아니고  3.물이 있는곳이 아니고  4.바위가 아니라면
				if(isValid(ny, nx) && arr[ny][nx] != 'D' 
						&& arr[ny][nx] != '*' && arr[ny][nx] != 'X') {
					waterQueue.offer(ny);
					waterQueue.offer(nx);
					arr[ny][nx] = '*'; // 물로 만들기
				}
			}
		}
	} // end of hongsu
	
	private static boolean isValid(int y, int x) {
		return 0<=y && y<R && 0<=x && x<C;
	}
} // end of class