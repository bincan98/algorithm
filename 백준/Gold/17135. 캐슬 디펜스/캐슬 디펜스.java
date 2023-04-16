import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, M, D, result, answer;
	private static int[] numbers;
	private static int[][] arr, arrCopy;
	static int[] dy = { 0, -1, 0 };
	static int[] dx = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력완료

		// 궁수 위치를 저장할 배열
		numbers = new int[3];
		// 궁수 위치를 조합으로 구해주기
		combi(0, 0);
		
		System.out.println(answer);
	} // end of main

	private static void combi(int index, int start) {
		if (index == 3) { // 조합 완성
			// 새로운 배열에 맵 복사하기
			arrCopy = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(arr[i], 0, arrCopy[i], 0, arr[i].length);
			}
			// 이번 조합에서 잡을 수 있는 적의 수 초기화
			result = 0;
			while (check()) { // 현재 맵에 적이 있는지 확인하기
				attack(); // 공격하기
				down(); // 적 내려오기
			}
			// answer에 이번 조합에서의 제거한 수 넣어보기
			answer = Math.max(answer, result);
			return;
		}
		for (int i = start; i < M; i++) {
			numbers[index] = i;
			combi(index + 1, i + 1);
		}
	} // end of combi

	private static void attack() {
		// 이번 공격에서 제거할 적의 좌표들을 저장할 배열
		int[][] targets = new int[3][2];
		for (int i = 0; i < 3; i++) {
			// 적의 좌표 구해오기
			targets[i] = bfs(N-1, numbers[i]);
		}
		// 구해온 좌표들 처리하기
		for (int i = 0; i < 3; i++) {
			// 적을 구해지 못했다면 다음 좌표 살피기
			if(targets[i][0] == -1) continue;
			else {
				// result에 이번 좌표의값 넣기
				result += arrCopy[targets[i][0]][targets[i][1]];
				// 적을 제거했으므로 좌표 값 0으로 만들기
				arrCopy[targets[i][0]][targets[i][1]] = 0;
			}			
		}
	} // end of attack

	private static int[] bfs(int startY, int startX) {
		// 반환할 적의 좌표 배열 생성하고 초기값 넣기
		int[] targetArr = new int[2];
		targetArr[0] = -1;
		targetArr[1] = -1;

		Queue<Integer> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];

		queue.offer(startY);
		queue.offer(startX);
		visited[startY][startX] = true;

		if (arrCopy[startY][startX] == 1) {	// 이미 적이 있다면 
			targetArr[0] = startY; // 배열에 값 넣기
			targetArr[1] = startX;
			return targetArr; // 바로 리턴하기
		}

		int count = 1; // D와 비교할 궁수의 위치에서 좌표까지의 거리
		while (true) {
			count++;
			if(count > D) break; // 거리가 벗어났다면 나가기
			int s = queue.size()/2; // count를 쓰기위한 큐의 사이즈(큐에 두개씩 넣고 빼므로 2로 나누기) 
			for (int i = 0; i < s; i++) {
				int currentY = queue.poll();
				int currentX = queue.poll();
				for (int j = 0; j < 3; j++) {
					// 왼쪽부터 살피도록 dy, dx를 선언하기
					int ny = currentY + dy[j];
					int nx = currentX + dx[j];
					if (isValid(ny, nx) && !visited[ny][nx]) {
						if (arrCopy[ny][nx] == 1) { // 적을 발견했다면
							targetArr[0] = ny; // 배열에 값 넣기
							targetArr[1] = nx;
							// 바로 리턴하기
							return targetArr;
						} else { // 적이 없다면
							queue.offer(ny); // 큐에 넣어주고 방문체크하기
							queue.offer(nx);
							visited[ny][nx] = true;
						}
					}
				}
			}
		} // end of while
		
		return targetArr;

	} // end of bfs

	// 범위 체크
	private static boolean isValid(int y, int x) {
		return 0<=y && y<N && 0<=x && x<M;
	} // end of isValid

	private static void down() { // 적 하나씩 내리기
		for (int i = N - 2; i >= 0; i--) { // 아래부터 시작
			for (int j = 0; j < M; j++) {
				// 한칸 위에서 적들을 내려오게 하기 
				arrCopy[i + 1][j] = arrCopy[i][j];
			}
		}
		// 첫줄은 0으로 초기화
		for (int i = 0; i < M; i++) {
			arrCopy[0][i] = 0;
		}
	} // end of down

	private static boolean check() { // 적이 맵에 있는지 체크
		boolean ch = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arrCopy[i][j] == 1) { // 적이 있다면 true로 변경
					ch = true;
					break;
				}
			}
		}
		return ch;
	} // end of check
} // end of class