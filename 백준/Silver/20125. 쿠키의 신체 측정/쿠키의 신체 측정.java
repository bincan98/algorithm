import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		int head_r = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == '*')
					head_r = i;
			}
			if (head_r != -1) 
				break;
		}
		
		char pre_char = '_';
		int left_end = -1;
		int right_end = -1;
		for (int i = 0; i < N; i++) {
			if (arr[head_r + 1][i] != pre_char) {
				if (arr[head_r + 1][i] == '*') {
					left_end = i;
				} else {
					right_end = i - 1;
				}
				pre_char = arr[head_r + 1][i];
			}
		}
		
		if (right_end == -1) {
			right_end = N - 1;
		}
		
		int waist_index = -1;
		for (int i = 0; i < N; i++) {
			if (arr[head_r + 2][i] == '*') {
				waist_index = i;
			}
		}
		
		sb.append(head_r + 2 + " ");
		sb.append(waist_index + 1 + "\n");
		
		sb.append(waist_index - left_end + " ");
		sb.append(right_end - waist_index + " ");
		
		int waist_length = -2;
		for (int i = 0; i < N; i++) {
			if (arr[i][waist_index] == '*') {
				waist_length += 1;
			}
		}
		
		int left_leg_length = -1;
		for (int i = 0; i < N; i++) {
			if (arr[i][waist_index - 1] == '*') {
				left_leg_length += 1;
			}
		}
		
		int right_leg_length = -1;
		for (int i = 0; i < N; i++) {
			if (arr[i][waist_index + 1] == '*') {
				right_leg_length += 1;
			}
		}
		
		sb.append(waist_length + " ");
		sb.append(left_leg_length + " ");
		sb.append(right_leg_length + " ");
		
		System.out.println(sb.toString());
		
	} // end of main	
	
} // end of class