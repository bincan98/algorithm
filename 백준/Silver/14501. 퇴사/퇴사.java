import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int N;
	private static int[] Time, Price;
	private static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		Time = new int[N + 1];
		Price = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			Time[i] = Integer.parseInt(st.nextToken());
			Price[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료

		recur(1, 0);

		System.out.println(answer);

	} // end of main

	private static void recur(int current, int total) {
		if (current > N + 1)
			return;
		if (current == N + 1) {
			answer = Math.max(answer, total);
			return;
		}

		recur(current + 1, total);
		recur(current + Time[current], total + Price[current]);
	}
} // end of class