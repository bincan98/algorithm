import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int[] x;
	private static int[] y;
	private static int[] selected;
	private static boolean[] visited;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		x = new int[4];
		y = new int[4];
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		selected = new int[3];
		visited = new boolean[4];
		answer = Integer.MAX_VALUE;
		
		recur(0);
		System.out.println(answer);
		
	} // end of main

	private static void recur(int cur) {
		if (cur == 3) {
//			System.out.println(Arrays.toString(selected));
			int[] lst = new int[4];
			lst[0] = 0;
			for (int i = 0; i < 3; i++) {
				lst[i+1] = selected[i];
			}
//			System.out.println(Arrays.toString(lst));
			double result = 0;
			for (int i = 0; i < 3; i++) {
				result += Math.sqrt(Math.pow(x[lst[i]] - x[lst[i+1]], 2) + Math.pow(y[lst[i]] - y[lst[i+1]], 2));
			}
			answer = Math.min(answer, (int) result);
			return;
		}
		for (int i = 1; i < 4; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selected[cur] = i;
			recur(cur + 1);
			visited[i] = false;
		}
	} // end of recur
} // end of class