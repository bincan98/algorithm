import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	private static int n;
	private static int m;
	private static int[][] arr;
	private static int[][] subSum;
	private static int x1;
	private static int x2;
	private static int y1;
	private static int y2;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		subSum = new int[n+1][n+1];
		
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				subSum[i][j] = subSum[i-1][j] + subSum[i][j-1] - subSum[i-1][j-1] + arr[i][j];
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			sb.append(subSum[x2][y2] - subSum[x2][y1-1] - subSum[x1-1][y2] + subSum[x1-1][y1-1]).append("\n");
		}
		
		System.out.print(sb);
		
	} // end of main
} // end of class
