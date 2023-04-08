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
	static StringBuilder sb = new StringBuilder();
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
		
		visited = new boolean[N+1]; // 방문체크
		dp = new int[N+1]; // dp 테이블
		dp[R] = dfs(R);
		
		for (int i = 0; i < Q; i++) {
			int query = Integer.parseInt(br.readLine());
			sb.append(dp[query]).append("\n");
		}

		System.out.println(sb.toString());
		
	} // end of main

	private static int dfs(int current) {
		visited[current] = true;
		
		
		int sum = 0;
		for (int vertex : adjList[current]) {
			if(!visited[vertex]) {
				sum += dfs(vertex);
			}
		}
		
		if(sum == 0) { // 리프 노드일때
			dp[current] = 1; 
		} else { // 리프노드가 아닐때
			dp[current] = sum + 1; // 자기 자신도 더해주기 위해서 1을 더해주기
		}
		
		return dp[current];
		
	} // end of dfs
} // end of class