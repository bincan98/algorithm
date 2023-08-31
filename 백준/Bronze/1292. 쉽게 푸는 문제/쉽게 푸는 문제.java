import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int[] lst = new int[1001];
		
		int index = 1;
		for (int i = 1; i < 1001; i++) {
			if (index > 1000) {
				break;
			}
			for (int j = 0; j < i; j++) {
				if (index > 1000) {
					break;
				}
				lst[index++] = i;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		for (int i = A; i <= B; i++) {
			answer += lst[i];
		}
		
		System.out.println(answer);
	} // end of main
} // end of class