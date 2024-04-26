import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int V;
	private static int from;
	private static int to;
	private static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()); 
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for (int i = 0; i <= N; i++) {
			Collections.sort(adjList[i]);
		}
		
		dfs(V, new boolean[N+1]);
		sb.append("\n");
		bfs(V);
		
		System.out.println(sb.toString());
		
	} // end of main

	private static void bfs(int start) {
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		int current = 0;
		while(!queue.isEmpty()) {
			current = queue.poll();
			sb.append(current).append(" ");
			
			for (int vertex : adjList[current]) {
				if(!visited[vertex]) {
					queue.offer(vertex);
					visited[vertex] = true;
				}
			}
		}
		
	}

	private static void dfs(int current, boolean[] visited) {
		
		visited[current] = true;
		sb.append(current).append(" ");
		
		for (int vertex : adjList[current]) {
			if(!visited[vertex]) {
				dfs(vertex, visited);
			}
		}
	}
} // end of class
