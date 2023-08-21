import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N, M, X;
	private static ArrayList<int[]>[] adjList;
	private static int[] time;
	private static int[] dist;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		time = new int[N+1]; // 0번 인덱스는 안쓴다
		dist = new int[N+1]; // 0번 인덱스는 안쓴다
		
		adjList = new ArrayList[N+1];
		
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<int[]>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new int[] {to, weight});
		} // 입력 완료
		
		for (int i = 1; i < N+1; i++) {
			dijkstra(i);
			time[i] += dist[X];
			if (i == X) {
				for (int j = 1; j < N+1; j++) {
					time[j] += dist[j];
				}
			}
		}
//		System.out.println(Arrays.toString(time));
		Arrays.sort(time);
		System.out.println(time[N]);
		
		
		
	} // end of main

	private static void dijkstra(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		dist[start] = 0;
		pq.add(new int[] {start, dist[start]});
		
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if(dist[tmp[0]] != tmp[1]) continue;
			for (int[] vertex : adjList[tmp[0]]) {
				if(dist[vertex[0]] > dist[tmp[0]] + vertex[1]) {
					dist[vertex[0]] = dist[tmp[0]] + vertex[1];
					pq.add(new int[] {vertex[0], dist[vertex[0]]});
				}
			}
		}
		
	} // end of dijkstra
} // end of class