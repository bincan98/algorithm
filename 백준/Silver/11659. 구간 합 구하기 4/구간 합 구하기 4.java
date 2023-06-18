import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static int[] arr;
	static int[] subSum;
	static int i;
	static int j;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		subSum = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		subSum[1] = arr[1]; 
		for (int i = 2; i <= n; i++) {
			subSum[i] = subSum[i-1] + arr[i];
		}
		
		for (int k = 0; k < m; k++) {
			
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			sb.append(i == j ? arr[i] : subSum[j] - subSum[i-1]).append("\n");
		}
		System.out.print(sb.toString());
		
	} // end of main
} // end of class
