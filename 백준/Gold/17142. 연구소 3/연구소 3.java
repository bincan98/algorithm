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
	private static int[][] arr;
	private static int[][] virusLocation;
	private static int cnt;
	private static int[] numbers;
	private static int[][] arrCopy;
	private static int dy[] = {0,0,-1,1};
	private static int dx[] = {-1,1,0,0};
	private static int[][] distance;
	private static int answer;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		arrCopy = new int[N][N];
		virusLocation = new int[10][2];
		numbers = new int[M];

		cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int ele = Integer.parseInt(st.nextToken());
				if(ele == 2) {
					virusLocation[cnt][0] = i;
					virusLocation[cnt][1] = j;
					cnt++;
				}
				arr[i][j] = ele;
				
			}
		} // 입력 완료

		answer = Integer.MAX_VALUE;
		combi(0, 0);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	} // end of main

	private static void combi(int index, int k) {
		if(index == M) {
			// 맵 복사해두기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arrCopy[i][j] = arr[i][j];
				}
			}

			activate();
			
			calculate();
			return;
		}
		for (int i = k; i < cnt; i++) {
			numbers[index] = i;
			combi(index+1, i+1);
		}
	} // end of combi

	private static void calculate() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(distance[i][j] == -1 && arrCopy[i][j] != 1) return;
				if(arrCopy[i][j] != 2) max = Math.max(max, distance[i][j]);
			}
		}
		
		answer = Math.min(answer, max);
	} // end of calculate

	private static void activate() {

		Queue<Integer> queue = new ArrayDeque<>();
		distance = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], -1);			
		}

		for (int i = 0; i < M; i++) { 
			// 고른 바이러스 좌표 큐에 넣기
			queue.offer(virusLocation[numbers[i]][0]); // y좌표			
			queue.offer(virusLocation[numbers[i]][1]); // x좌표
			// distance로 visited 체크
			distance[virusLocation[numbers[i]][0]][virusLocation[numbers[i]][1]] = 0;
		} 

		while(!queue.isEmpty()) {
			int currentY = queue.poll();
			int currentX = queue.poll();
			for (int i = 0; i < 4; i++) {
				int ny = currentY + dy[i];
				int nx = currentX + dx[i];
				if(isVaild(ny,nx) && arrCopy[ny][nx] != 1) {
					if (distance[ny][nx] == -1) {
						queue.offer(ny);
						queue.offer(nx);
						distance[ny][nx] = distance[currentY][currentX] + 1;
					}
				}
			}

		}


	} // end of activate

	private static boolean isVaild(int y, int x) {
		return 0<=y && y<N && 0<=x && x<N;
	}
} // end of class