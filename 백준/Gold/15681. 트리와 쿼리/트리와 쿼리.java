import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, R, Q;
	private static ArrayList<Integer>[] adjList;
	private static boolean[] visited;
	private static int[] dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N+1];
		
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		} // 입력 완료
		
		visited = new boolean[N+1];
		dp = new int[N+1];
		dp[R] = dfs(R);
		
//		System.out.println(Arrays.toString(dp));
		
		for (int i = 0; i < Q; i++) {
			int query = Integer.parseInt(br.readLine());
			System.out.println(dp[query]);
		}
		
	} // end of main

	private static int dfs(int current) {
		visited[current] = true;
		
		
		int sum = 0;
		for (int vertex : adjList[current]) {
			if(!visited[vertex]) {
				sum += dfs(vertex);
			}
		}
		
		if(sum == 0) {
			dp[current] = 1;
		} else {
			dp[current] = sum + 1;
		}
		
		return dp[current];
		
	} // end of dfs
} // end of class