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
	private static int N, M, cnt, answer;
	private static int[][] arr, virusLocation, distance;
	private static int[] numbers;
	private static int dy[] = {0,0,-1,1};
	private static int dx[] = {-1,1,0,0};

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 연구소 저장할 행렬
		arr = new int[N][N];
		// 모든 바이러스 위치 저장할 배열 [0]:y좌표, [1]:x좌표
		virusLocation = new int[10][2];
		// 조합으로 고른 바이러스의 인덱스 저장할 배열
		numbers = new int[M];

		// 바이러스 개수
		cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int ele = Integer.parseInt(st.nextToken());
				if(ele == 2) { // 바이러스 라면 배열에 저장하고 cnt 올리기
					virusLocation[cnt][0] = i;
					virusLocation[cnt][1] = j;
					cnt++;
				}
				arr[i][j] = ele;
				
			}
		} // 입력 완료

		answer = Integer.MAX_VALUE;
		// 조합 뽑기
		combi(0, 0);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	} // end of main

	private static void combi(int index, int k) {
		if(index == M) { // 조합 완성되었다면

			// 바이러스 활성화 시켜서 퍼뜨리기
			activate();
			
			// 최소시간 계산하기
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
				if(distance[i][j] == -1 && arr[i][j] != 1) return; // 만약 벽이 아닌데 탐색되지 못한곳이 있다면 계산 종료
				if(arr[i][j] != 2) max = Math.max(max, distance[i][j]);
			}
		}
		
		answer = Math.min(answer, max);
	} // end of calculate

	private static void activate() {

		Queue<Integer> queue = new ArrayDeque<>();
		// 최소시간 저장할 행렬
		distance = new int[N][N];
		
		// 행렬의 초기값은 -1로
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
				if(isVaild(ny,nx) && arr[ny][nx] != 1) { // 행렬의 범위안에 포함되고 벽이 아니라면
					if (distance[ny][nx] == -1) { // distance로 visited 체크하고 
						queue.offer(ny);
						queue.offer(nx);
						// 최소시간 추가하기
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