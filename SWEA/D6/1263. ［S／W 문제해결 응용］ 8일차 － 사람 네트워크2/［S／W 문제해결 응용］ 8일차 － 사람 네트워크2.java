import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static final int INF = 987654321;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int T;
	private static int N;
	private static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase < T+1; testCase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int ele = Integer.parseInt(st.nextToken());
					if(ele==1) arr[i][j] = 1;
					else arr[i][j] = INF;
				}
			} // 입력완료
			
			Floyd();
			
			int answer = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if(i == j) continue;
					sum += arr[i][j];
				}
				answer = Math.min(answer, sum);
			}
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	} // end of main

	private static void Floyd() {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(k==i) continue;
				for (int j = 0; j < N; j++) {
					if(k==j || j==i) continue;
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
	}
} // end of class