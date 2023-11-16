import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static boolean[] selected;
	private static int[][] arr;
	private static int k;
	private static int n;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		selected = new boolean[n];
		
		answer = 0;
		recur(0);
		
		System.out.println(answer);
	} // end of main	

	private static void recur(int cur) {
		if (cur == n) {
			int total = 0;
			boolean[][] visited = new boolean[6][11];
			boolean impossible = false;
			
			for (int i = 0; i < n; i++) {
				if (!selected[i]) {
					continue;
				}
				if (arr[i][0] == 5) { // 금요일 수업은 빼기
					impossible = true;
					break;	
				}
				for (int j = arr[i][1]; j <= arr[i][2]; j++) {
					if (visited[arr[i][0]][j]) {
						impossible = true;
						break;
					}
				}
				if (impossible) {
					break;
				}
				for (int j = arr[i][1]; j <= arr[i][2]; j++) {
					visited[arr[i][0]][j] = true;
				}
				total += arr[i][2] - arr[i][1] + 1;
			}
			if (impossible) {
				return;
			}
			if (total == k) {
				answer++;
			}
			return;
		}
		selected[cur] = false;
		recur(cur + 1);
		selected[cur] = true;
		recur(cur + 1);
	}
	
} // end of class