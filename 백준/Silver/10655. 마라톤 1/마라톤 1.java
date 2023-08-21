import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] x = new int[N];
		int[] y = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		int total = 0;
		for (int i = 0; i < N-1; i++) {
			total += Math.abs(x[i] - x[i+1]) + Math.abs(y[i] - y[i+1]);
		}
		
		int result = 0;
		int answer = total;
		for (int i = 1; i < N-1; i++) {
			result = total;
			result -= Math.abs(x[i-1] - x[i]) + Math.abs(y[i-1] - y[i]);
			result -= Math.abs(x[i] - x[i+1]) + Math.abs(y[i] - y[i+1]);
			result += Math.abs(x[i-1] - x[i+1]) + Math.abs(y[i-1] - y[i+1]);
			answer = Math.min(answer, result);
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class