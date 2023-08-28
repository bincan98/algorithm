import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		recur(0, "");
	} // end of main

	private static void recur(int cur, String string) {
		if (string != "") {
			if (!check_prime(string)) { // 소수가 아니라면 돌아가기
				return;
			}
		}
		if (cur == N) {
			System.out.println(string);
			return;
		}
		for (int i = 1; i < 10; i++) {
			recur(cur + 1, string + i);
		}
	} // end of recur

	private static boolean check_prime(String string) {
		int a = Integer.parseInt(string);
		if (a == 1) {
			return false;
		}
		for (int i = 2; i < (int) Math.sqrt(a) + 1; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	} // end of check_prime
} // end of class