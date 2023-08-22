import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] lst = new int[N];
		Arrays.fill(lst, K);
		
		boolean con = true;
		int idx = 0;
		int day = 0;
		while (con) {
			day++;
			for (int i = idx; i < idx + A; i++) {
				lst[i % N] += B;
			}
			for (int i = 0; i < N; i++) {
				lst[i] -= 1;
				if (lst[i] <= 0) {
					con = false;
					break;
				}
			}
			idx = (idx + A) % N;
		}
		
		System.out.println(day);
		
	} // end of main
} // end of class