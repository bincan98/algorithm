import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, M;
	private static int[][] arr;
	private static int[][] arrCopy;
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	private static int ny;
	private static int nx;
	private static int cnt;
	private static int max;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		arrCopy = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료
		
		// 조합을 이용해서 벽세우기
		comb(0, 0);
		
		System.out.println(max);
		
	} // end of main

	private static void comb(int index, int start) {
		// 벽을 다 세웠으면
		if(index==3) {
			virus(); // 바이러스 퍼뜨리고
			cal(); // 안전 영역 계산하기
			return;
		}
		
		for (int i = start; i < N*M; i++) {
			int y = i / M;
			int x = i % M;
			if(arr[y][x] != 0) continue;
			arr[y][x] = 1;
			comb(index+1, i+1);
			arr[y][x] = 0;
		}
	}

	private static void virus() {
		
		for (int i = 0; i < N; i++) {
			System.arraycopy(arr[i], 0, arrCopy[i], 0, arr[i].length);			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arrCopy[i][j] == 2) bfs(i, j);
			}
		}
		
	} // end of virus
	
	private static void cal() {
		// 안전영역 계산해서 주기
		cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arrCopy[i][j] == 0) cnt++;
			}
		}
		max = Math.max(max, cnt);
	} // end of cal

	private static void bfs(int startY, int startX) {
		Queue<Integer> queue = new ArrayDeque<Integer>(); 
		
		queue.offer(startY);
		queue.offer(startX);
		
		int currentY = 0;
		int currentX = 0;
		while(!queue.isEmpty()) {
			currentY = queue.poll();
			currentX = queue.poll();
			arrCopy[currentY][currentX] = 3;
			
			for (int i = 0; i < 4; i++) {
				ny = currentY + dy[i];
				nx = currentX + dx[i];
				if(isValid(ny,nx) && arrCopy[ny][nx] == 0) {
					queue.offer(ny);
					queue.offer(nx);
				}
				
			}
		} // end of while
		
	} // end of bfs

	private static boolean isValid(int y, int x) {
		return 0<=y && y<N && 0<=x && x<M;
	} // end of isValid
} // end of class