import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, M, k;
	private static int[] arr;
	private static ArrayList<Integer>[] adjList;
	private static boolean[] visited;
	private static int result;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		adjList = new ArrayList[N+1]; 
		visited = new boolean[N+1];
		
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for (int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				result += bfs(i);
			}
		}
		
		if(result > k) System.out.println("Oh no");
		else System.out.println(result);
	} // end of main

	private static int bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		int min = arr[start];
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for (int vertex : adjList[current]) {
				if(!visited[vertex]) {
					queue.offer(vertex);
					visited[vertex] = true;
					min = Math.min(min, arr[vertex]);
				} // end of if
			} // end of for
		} // end of while
		
		return min;
	} // end of bfs
} // end of class