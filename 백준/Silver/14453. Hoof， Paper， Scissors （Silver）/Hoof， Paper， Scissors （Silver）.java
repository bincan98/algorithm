import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
Hoof 는 가위를 이긴다

가위는 보를 이긴다

보는 hoof를 이긴다

비기기도 가능

모든 경우를 하면 오래걸릴듯

H, 보, 가위 3개만 내면서 몇번 이길 수 있는지
prefix_win_sum 과 suffix_win_sum 으로 누적해두자
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		char[] arr = new char[N+1];
		
		for (int i = 1; i < N+1; i++) {
			arr[i] = br.readLine().charAt(0);
		} // 입력 완료
		
		// 앞부터 누적승 저장할 배열 (양쪽에 패딩 주기)
		int[] prefix_win_H = new int[N+2];
		int[] prefix_win_S = new int[N+2];
		int[] prefix_win_P = new int[N+2];
		
		// 뒤부터 누적승 저장할 배열
		int[] suffix_win_H = new int[N+2];
		int[] suffix_win_S = new int[N+2];
		int[] suffix_win_P = new int[N+2];
		
		// 앞부터 누적승 구하기
		for (int i = 1; i < N+1; i++) {
			prefix_win_H[i] = prefix_win_H[i-1];
			prefix_win_S[i] = prefix_win_S[i-1];
			prefix_win_P[i] = prefix_win_P[i-1];
			if (arr[i] == 'H') {
				prefix_win_P[i]++;
			} else if (arr[i] == 'S') {
				prefix_win_H[i]++;
			} else {
				prefix_win_S[i]++;
			}
		}
		
		// 뒤부터 누적승 구하기
		for (int i = N; i > 0; i--) {
			suffix_win_H[i] = suffix_win_H[i+1];
			suffix_win_S[i] = suffix_win_S[i+1];
			suffix_win_P[i] = suffix_win_P[i+1];
			if (arr[i] == 'H') {
				suffix_win_P[i]++;
			} else if (arr[i] == 'S') {
				suffix_win_H[i]++;
			} else {
				suffix_win_S[i]++;
			}
		}
		
		int max = 0;
		
		// 제스처를 한번도 바꾸지 않고 내는 경우
		max = Math.max(max, prefix_win_H[N]);
		max = Math.max(max, prefix_win_S[N]);
		max = Math.max(max, prefix_win_P[N]);
		
		// 제스처를 바꾸는 경우
		for (int i = 1; i < N+1; i++) {
			// Hoof를 내다가 바꾸는 경우
			max = Math.max(max, prefix_win_H[i] + suffix_win_S[i+1]);
			max = Math.max(max, prefix_win_H[i] + suffix_win_P[i+1]);
			// 가위를 내다가 바꾸는 경우
			max = Math.max(max, prefix_win_S[i] + suffix_win_H[i+1]);
			max = Math.max(max, prefix_win_S[i] + suffix_win_P[i+1]);
			// 보를 내다가 바꾸는 경우
			max = Math.max(max, prefix_win_P[i] + suffix_win_H[i+1]);
			max = Math.max(max, prefix_win_P[i] + suffix_win_S[i+1]);
		}
		
		System.out.println(max);
	} // end of main
} // end of class