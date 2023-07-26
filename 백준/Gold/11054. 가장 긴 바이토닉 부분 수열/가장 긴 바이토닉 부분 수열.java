import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] lst = new int[N];
		int[] dp_lis = new int[N];
		int[] dp_lis_rev = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lst[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		for (int i = 0; i < N; i++) {
			dp_lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (lst[j] < lst[i] && dp_lis[i] < dp_lis[j] + 1) {
					dp_lis[i] = dp_lis[j] + 1;
				}
			}
		}
		
		for (int i = N - 1; i >= 0; i--) {
			dp_lis_rev[i] = 1;
			for (int j = N - 1; j > i; j--) {
				if (lst[j] < lst[i] && dp_lis_rev[i] < dp_lis_rev[j] + 1) {
					dp_lis_rev[i] = dp_lis_rev[j] + 1;
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp_lis[i] + dp_lis_rev[i] - 1);
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class