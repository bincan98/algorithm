import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int n;
	private static int m;
	private static int k;
	private static boolean[] selected;
	private static int[][] lst;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		lst = new int[m][k];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				lst[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력완료
		
		selected = new boolean[2 * n + 1];
		
		answer = 0;
		recur(0, 1);
		
		System.out.println(answer);
		
	} // end of main

	private static void recur(int cur, int nxt) {
		if (cur == n) {
			int result = 0;
			for (int i = 0; i < m; i++) { // 살펴볼 퀘스트 
				boolean possibleQuest = true;
				for (int j = 0; j < k; j++) { // 퀘스트의 스킬
					if (!selected[lst[i][j]]) {
						possibleQuest = false;
						break;
					}
				}
				if (possibleQuest) {
					result++;
				}
			}
			answer = Math.max(answer, result);
			return;
		}
		for (int i = nxt; i < 2 * n + 1; i++) {
			selected[i] = true;
			recur(cur + 1, i + 1);
			selected[i] = false;
		}
	} // end of recur
} // end of class