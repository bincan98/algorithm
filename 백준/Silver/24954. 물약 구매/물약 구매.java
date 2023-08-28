import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N;
	private static int[] lst;
	private static int[][][] discountInfo;
	private static boolean[] visited;
	private static int[] selected;
	private static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		lst = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			lst[i] = Integer.parseInt(st.nextToken());
		}
		
		discountInfo = new int[N+1][N][2];
		
		for (int i = 1; i < N+1; i++) {
			int pi = Integer.parseInt(br.readLine());
			for (int j = 0; j < pi; j++) {
				st = new StringTokenizer(br.readLine());
				discountInfo[i][j][0] = Integer.parseInt(st.nextToken());
				discountInfo[i][j][1] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완료
		
		visited = new boolean[N+1];
		selected = new int[N];
		
		answer = Integer.MAX_VALUE;
		recur(0, 0, lst);
		
		System.out.println(answer);
	} // end of main

	private static void recur(int cur, int total, int[] arr) {
		if (total > answer) {
			return;
		}
		if (cur == N) {
			answer = Math.min(answer, total);
			return;
		}
		for (int i = 1; i < N+1; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selected[cur] = i;
			recur(cur + 1, total + arr[i], disco(arr, cur));
			visited[i] = false;
		}
	}

	private static int[] disco(int[] arr, int cur) {
		int[] newArr = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			newArr[i] = arr[i];
		}
		for (int[] dis : discountInfo[selected[cur]]) {
			newArr[dis[0]] -= dis[1];
			if (newArr[dis[0]] <= 0) {
				newArr[dis[0]] = 1;
			}
		}
		return newArr;
	}
} // end of class