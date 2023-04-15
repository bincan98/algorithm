import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int n;
	private static int[] arr;
	private static boolean[] check;
	private static int element;
	private static int x;
	private static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		check = new boolean[1_000_001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			element = Integer.parseInt(st.nextToken());
			arr[i] = element;
			check[element] = true;
		} 
		x = Integer.parseInt(br.readLine());
		// 입력완료
		
		answer = 0;
		for (int i = 0; i < n; i++) {
			int a = x-arr[i];
			if(a >= 0 && a < 1_000_000) 
				if(check[a]) 
					answer++;				
		}
		
		System.out.println(answer/2);
		
	} // end of main
} // end of class