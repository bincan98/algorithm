import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, M, D;
	private static int[] numbers;
	private static int[][] arr, arrCopy;
	static int[] dy = { 0, -1, 0 };
	static int[] dx = { -1, 0, 1 };
	private static int result;
	private static int answer;

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

		numbers = new int[3];
		combi(0, 0);
		
		System.out.println(answer);
	} // end of main

	private static void combi(int index, int start) {
		if (index == 3) {
			// 새로운 배열에 맵 복사하기
			arrCopy = new int[N][M];
			for (int i = 0; i < N; i++) {
				System.arraycopy(arr[i], 0, arrCopy[i], 0, arr[i].length);
			}
			result = 0;
			while (check()) {
				attack();
				down();
			}
			answer = Math.max(answer, result);
			return;
		}
		for (int i = start; i < M; i++) {
			numbers[index] = i;
			combi(index + 1, i + 1);
		}
	} // end of combi

	private static void attack() {
		int[][] targets = new int[3][2];
		for (int i = 0; i < 3; i++) {
			targets[i] = bfs(N-1, numbers[i]);
		}
		for (int i = 0; i < 3; i++) {
			if(targets[i][0] == -1) continue;
			else {
				result += arrCopy[targets[i][0]][targets[i][1]];
				arrCopy[targets[i][0]][targets[i][1]] = 0;
			}			
		}
	} // end of attack

	private static int[] bfs(int startY, int startX) {

		int[] targetArr = new int[2];
		targetArr[0] = -1;
		targetArr[1] = -1;

		Queue<Integer> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];

		queue.offer(startY);
		queue.offer(startX);
		visited[startY][startX] = true;

		if (arrCopy[startY][startX] == 1) {
			targetArr[0] = startY;
			targetArr[1] = startX;
			return targetArr;
		}

		int count = 1;
		while (true) {
			count++;
			if(count > D) break;
			int s = queue.size()/2;
			for (int i = 0; i < s; i++) {
				int currentY = queue.poll();
				int currentX = queue.poll();
				for (int j = 0; j < 3; j++) {
					int ny = currentY + dy[j];
					int nx = currentX + dx[j];
					if (isValid(ny, nx) && !visited[ny][nx]) {
						if (arrCopy[ny][nx] == 1) {
							targetArr[0] = ny;
							targetArr[1] = nx;
							return targetArr;
						} else {
							queue.offer(ny);
							queue.offer(nx);
							visited[ny][nx] = true;
						}
					}
				}
			}
		} // end of while
		return targetArr;

	} // end of bfs


	private static boolean isValid(int y, int x) {
		return 0<=y && y<N && 0<=x && x<M;
	} // end of isValid

	private static void down() {
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				arrCopy[i + 1][j] = arrCopy[i][j];
			}
		}
		for (int i = 0; i < M; i++) {
			arrCopy[0][i] = 0;
		}
	} // end of down

	private static boolean check() {
		boolean ch = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arrCopy[i][j] == 1) {
					ch = true;
					break;
				}
			}
		}
		return ch;
	} // end of check
} // end of class