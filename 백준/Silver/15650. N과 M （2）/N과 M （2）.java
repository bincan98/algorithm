import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 조합 기본 코드
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int M;
	private static int[] selected;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		selected = new int[M];
		
		recur(0, 1);
		
		System.out.println(sb.toString());
	} // end of main

	private static void recur(int cur, int start) {
		if (cur == M) {
			for (int i : selected) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N+1; i++) {
			selected[cur] = i;
			recur(cur + 1, i + 1);
		}
	} // end of recur
} // end of class