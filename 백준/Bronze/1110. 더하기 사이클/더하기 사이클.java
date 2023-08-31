import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		if (N / 10 < 1) {
			N *= 10;
		}
		int cycle = 0;
		int newN = N;
		while (true) {
			newN = (newN % 10 + (int) (newN / 10)) % 10 + (newN % 10) * 10;
			cycle++;
			if (newN == N) {
				break;
			}
		}
		
		System.out.println(cycle);
	} // end of main
} // end of class