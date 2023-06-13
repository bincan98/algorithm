import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	private static int[] arr;
	private static int[] numbers;
	private static int sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		arr = new int[10];
		numbers = new int[7];
		
    for (int i = 1; i <= 9; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
		
    combi(0, 1);
    System.out.print(sb.toString());
		
	} // end of main

	private static void combi(int cnt, int start) {
    if (cnt == 7) {
			sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += numbers[i];
			}
			if(sum == 100) {
				for (int i = 0; i < 7; i++) {
					sb.append(numbers[i]).append("\n");
				}
			}
			return;
		}
		for (int i = start; i <= 9; i++) {
			numbers[cnt] = arr[i];
			combi(cnt+1, i+1);
		}
	}
} // end of class