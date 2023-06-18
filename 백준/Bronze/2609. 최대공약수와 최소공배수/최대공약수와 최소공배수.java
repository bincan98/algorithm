import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int GCD = gcd(Math.max(A, B), Math.min(A, B));
		
		System.out.println(GCD + " " + (A*B/GCD));
		
	} // end of main

	private static int gcd(int a, int b) {
		while (a % b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return b;
	} // end of gcd
} // end of class