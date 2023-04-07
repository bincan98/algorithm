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
	private static int N, answer;
	private static boolean[] sungugoo, visited;
	private static int[] arr;
	private static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1]; // 구역의 인구를 저장할 배열
		adjList = new ArrayList[N+1]; // 인접 리스트
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 인구 저장하기
			adjList[i] = new ArrayList<>(); // 동시에 인접리스트 선언
		}
		
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				// 인접리스틑 입력 받기
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		} // 입력 완료
		
		// true와 false로 두 선거구를 나눌 배열
		sungugoo = new boolean[N+1];
		
		// answer 초기화
		answer = Integer.MAX_VALUE;
		// 선거구 나누기
		divide(1);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	} // end of main

	private static void divide(int index) {
		if(index == N+1) { // 부분집합이 완성되면
			
			int trueIndex = 0;
			int falseIndex = 0;
			// true인 선거구, false인 선거구 중 구역하나씩을 뽑기 
			for (int i = 1; i < N+1; i++) {
				if(sungugoo[i]) trueIndex = i;
				else falseIndex = i;
			}
			
			// true나 false 하나로 가득 찬 경우 선거구가 두개가 아닌 것이므로 리턴
			if(trueIndex==0 || falseIndex==0) return;
			
			// 방문 체크 (선거구가 덜어져있는지 체크하기 위해 사용)
			visited = new boolean[N+1];
			// true인 선거구를 방문하며 인구수 모두 모으기
			int sum1 = bfs(trueIndex);
			// 선거구 뒤집기 (bfs가 true인 선거구 찾기에 맞춰져 있으므로)
			for (int i = 1; i < N+1; i++) {
				sungugoo[i] = !sungugoo[i];
			}
			// true인 선거구(원래 false)를 방문하며 인구수 모두 모으기 
			int sum2 = bfs(falseIndex);
			// 선거구 뒤집기 (다음 부분집합이 꼬이지 않기 위해 원상복구)
			for (int i = 1; i < N+1; i++) {
				sungugoo[i] = !sungugoo[i];
			}
			
			boolean allTrue = true;
			for (int i = 1; i < N+1; i++) {
				if(!visited[i]) { // 만약 방문하지 못한곳이 있다면
					allTrue = false; // 기억하기
					break;
				}
			}
			
			if(allTrue) { // 모두 방문했다면 
				// answer에 두 선거구 인구 빼준 값 넣기
				answer = Math.min(answer, Math.abs(sum1 - sum2));
			}
			
			return;
		}
		// 부분집합 코드
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