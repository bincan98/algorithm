import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		for (int i = 0; i < (int) (N / A) + 1; i++) {
			for (int j = 0; j < (int) (N / B) + 1; j++) {
				for (int k = 0; k < (int) (N / C) + 1; k++) {
					if (A * i + B * j + C * k == N)
						answer = 1;
				}
			}
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class