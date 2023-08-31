import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
1 2 3 4 2 5 3 1 1 2
s
       e
1 < 5
3 < 5
6 > 5
5 == 5
	cnt++
	start++
9 > 5
7 > 5
inchiworm
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 입력 완료
		
		int cnt = 0;
		int start = 0;
		int end = 0;
		int sum = arr[start];
		
		while (true) {
			if (sum == m) { // 1.
				cnt++;
				end++; // end == n
				if (end == n) break;
				sum += arr[end]; 
			} else if (sum > m) { // 2.
				sum -= arr[start];
				start++;
			} else { // 3.
				end++;
				if (end == n) break;
				sum += arr[end]; 
			}
		}
		
		System.out.println(cnt);
		
	}
}