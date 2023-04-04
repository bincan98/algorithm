import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int T, N, M;
	private static ArrayList<Integer>[] adjList;
	private static ArrayList<Integer>[] adjListReverse;
	private static boolean[] visited;
	private static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			// 인접 리스트
			adjList = new ArrayList[N+1];
			// 인접 리스트 (그래프를 뒤집어서) 
			adjListReverse = new ArrayList[N+1];
			
			for (int i = 0; i < N+1; i++) {
				adjList[i] = new ArrayList<Integer>();
				adjListReverse[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
				adjListReverse[to].add(from);
			}
			
			answer = 0;
			for (int i = 1; i < N+1; i++) {
				visited = new boolean[N+1];
				// 그래프를 탐색해서 visited 채우기
				bfs(i, adjList, visited);
				// 뒤집은 그래프도 탐색해서 채우기
				bfs(i, adjListReverse, visited);
				
				// visited가 다 차있는지 탐색
				boolean isNot = false;
				for (int j = 1; j < N+1; j++) {
					if(!visited[j]) {
						isNot = true;
						break;
					}
				}
				
				if(!isNot) answer++;
			}
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
			
			
		} // end of testCase
		
		System.out.println(sb.toString());
	} // end of main

	private static void bfs(int start, ArrayList<Integer>[] adj, boolean[] v) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(start);
		v[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for (int vertex : adj[current]) {
				if(!v[vertex]) {
					queue.offer(vertex);
					v[vertex] = true;
				}
			}
		}
		
	} // end of bfs
	
} // end of class