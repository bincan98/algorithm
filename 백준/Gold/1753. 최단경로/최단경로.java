import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int V, E, start;
	private static int[] distance;
	private static boolean[] visited;
	private static ArrayList<int[]>[] adjList;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[V+1];
		distance = new int[V+1];
		visited = new boolean[V+1];
		
		for (int i = 0; i < V+1; i++) {
			adjList[i] = new ArrayList<int[]>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			adjList[Integer.parseInt(st.nextToken())].add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		} // 입력완료
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		int min, current;
		for (int c = 0; c < V; c++) {
			
			// step1
			current = -1;
			min = Integer.MAX_VALUE;
			
			for (int i = 1; i < V+1; i++) {
				if(!visited[i] && min > distance[i]) {
					min = distance[i];
					current = i;
				}
			}
			
			if(current == -1) break;
			visited[current] = true;
			
			// step2
			for (int[] vertex : adjList[current]) {
				if(!visited[vertex[0]] && distance[vertex[0]] > min + vertex[1]) {
					distance[vertex[0]] = min + vertex[1];
				}
			}
			
		}
		
		
		for (int i = 1; i < V+1; i++) {
			sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
		}
		System.out.print(sb.toString());
	} // end of main
} // end of class