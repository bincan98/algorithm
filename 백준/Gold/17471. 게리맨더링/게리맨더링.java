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
	private static int N;
	private static int[] arr;
	private static ArrayList<Integer>[] adjList;
	private static boolean[] sungugoo;
	private static boolean[] visited;
	private static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		adjList = new ArrayList[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		} // 입력 완료
		
		sungugoo = new boolean[N+1];
		
		divide(1);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	} // end of main

	private static void divide(int index) {
		if(index == N+1) {
			int trueIndex = 0;
			int falseIndex = 0;
			for (int i = 1; i < N+1; i++) {
				if(sungugoo[i]) trueIndex = i;
				else falseIndex = i;
			}
			
			// true나 false 하나로 가득 찬 경우
			if(trueIndex==0 || falseIndex==0) return;
			
			visited = new boolean[N+1];
			int sum1 = bfs(trueIndex);
			for (int i = 1; i < N+1; i++) {
				sungugoo[i] = !sungugoo[i];
			}
			int sum2 = bfs(falseIndex);
			for (int i = 1; i < N+1; i++) {
				sungugoo[i] = !sungugoo[i];
			}
			
			boolean allTrue = true;
			for (int i = 1; i < N+1; i++) {
				if(!visited[i]) {
					allTrue = false;
					break;
				}
			}
			
			if(allTrue) {
				answer = Math.min(answer, Math.abs(sum1 - sum2));
			}
			
			return;
		}
		sungugoo[index] = true;
		divide(index+1);
		sungugoo[index] = false;
		divide(index+1);

	} // end of divide

	private static int bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.offer(start);
		visited[start] = true;
		int sum = arr[start];
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for (int vertex : adjList[current]) {
				if(!visited[vertex] && sungugoo[vertex]) {
					queue.offer(vertex);
					visited[vertex] = true;
					sum += arr[vertex];
				}
			}
		}
		
		return sum;
	} // end of bfs
} // end of class