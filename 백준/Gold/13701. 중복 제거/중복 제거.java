import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		boolean[] check = new boolean[33_554_433];
		int[] arr = new int[5_000_001];
		
		int length = 0;
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			if (!check[a]) {
				sb.append(a + " ");
				check[a] = true;
			}
		}
		
		System.out.println(sb.toString());
		
	} // end of main	
	
} // end of class