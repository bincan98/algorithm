import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		for (int i = 0; i <= K; i++) {
			int n = N - i;
			int m = M - (K - i);
			int result = Math.min((int) (n / 2), m);
			answer = Math.max(answer, result);
		}
		
		System.out.println(answer);
	} 
}