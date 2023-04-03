import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int t, n;
	private static int[][] arr;
	private static boolean[][] isPossible;
	private static boolean[] visited;
	private static boolean answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		t = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < t; testCase++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+2][2];
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			} // 입력 완료

			isPossible = new boolean[n+2][n+2];

			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < n+2; j++) {
					if(i==j) continue;
					if (Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]) <= 1000) {
						isPossible[i][j] = true;
					} 
				}
			}

			answer = false;
			bfs(0);

			sb.append(answer ? "happy" : "sad").append("\n");
		}

		System.out.println(sb.toString());

	} // end of main

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited = new boolean[n+2];

		queue.offer(start);
		visited[start] = true;

		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(current == n+1) {
				answer = true;
				return;
			}
			for (int i = 0; i < n+2; i++) {
				if(isPossible[current][i]) {
					if(!visited[i]) {
						queue.offer(i);
						visited[i] = true;
					}
				}
			}
		}

	}
} // end of class