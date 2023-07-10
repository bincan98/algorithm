import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 순열 기본 코드
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N;
	private static int M;
	private static int[] selected;
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		selected = new int[M];
		visited = new boolean[N+1];
		
		recur(0);
	} // end of main

	private static void recur(int cur) {
		if (cur == M) {
			for (int i : selected) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i < N+1; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selected[cur] = i;
			recur(cur + 1);
			visited[i] = false;
		}
	} // end of recur
} // end of class
