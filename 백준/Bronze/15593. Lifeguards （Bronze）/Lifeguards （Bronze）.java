import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		int[] timeTable = new int[1001];
		int[][] lifguards = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			lifguards[i][0] = A;
			lifguards[i][1] = B;
			for (int j = A; j < B; j++) {
				timeTable[j]++;
			}
		}
		
		int total = 0;
		for (int i = 0; i < 1001; i++) {
			if (timeTable[i] > 0)
				total++;
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int result = total;
			int a = lifguards[i][0];
			int b = lifguards[i][1];
			for (int j = a; j < b; j++) {
				if (timeTable[j] == 1)
					result--;
			}
			answer = Math.max(answer, result);
		}
		
		System.out.println(answer);
		
	} // end of main
} // end of class