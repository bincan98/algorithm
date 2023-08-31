import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for (int i = 2; i < N+1; i++) {
			answer += ((int) (N / i) - 1) * i;
			answer %= 1_000_000;
		}
		
		System.out.println(answer % 1_000_000);
	}
}