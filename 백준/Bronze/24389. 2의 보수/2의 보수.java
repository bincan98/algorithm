import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] binary = new int[32];
		int[] rev_binary = new int[32];
		
		int i = 0;
		while (N != 0) {
			if (N % 2 == 1) {
				binary[i] = 1;
			}
			N /= 2;
			i++;
		}
		
		for (int j = 0; j < 32; j++) {
			if (binary[j] == 1)
				rev_binary[j] = 0;
			else 
				rev_binary[j] = 1;
		}
		
		int sum = 1;
		for (int j = 0; j < rev_binary.length; j++) {
			if (sum + rev_binary[j] >= 2) {
				rev_binary[j] = 0;
				sum = 1;
			} else {
				rev_binary[j] += sum;
				break;
			}
		}
		
		int answer = 0;
		for (int j = 0; j < rev_binary.length; j++) {
			if (binary[j] != rev_binary[j]) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}