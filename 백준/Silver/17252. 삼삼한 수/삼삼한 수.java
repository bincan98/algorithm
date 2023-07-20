import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int size;
	private static boolean[] selected;
	private static int[] lst;
	private static boolean possible;
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		lst = new int[20];
		
		for (int i = 0; i < 20; i++) {
			int temp = (int) Math.pow(3, i);
			if (temp <= N) {
				size = i + 1;
				lst[i] = temp;				
			}
		}
		
		selected = new boolean[size];
		possible = false;
		
		subset(0);
		
		System.out.println(N != 0 && possible ? "YES" : "NO");
		
	} // end of main

	private static void subset(int cur) {
		if (possible) {
			return;
		}
		if (cur == size) {
			int sum = 0;
			for (int i = 0; i < size; i++) {
				if (selected[i]) {
					sum += lst[i];
				}
			}
			if (sum == N) {
				possible = true;
			}
			return;
		}
		selected[cur] = true;
		subset(cur + 1);
		selected[cur] = false;
		subset(cur + 1);
	} // end of subset
} // end of class