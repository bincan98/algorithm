import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] lst = new int[N];
		int[] dp_lis = new int[N];
		int[] prev = new int[N];
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lst[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		for (int i = 0; i < N; i++) {
			dp_lis[i] = 1;
			prev[i] = i;
			for (int j = 0; j < i; j++) {
				if (lst[j] < lst[i] && dp_lis[i] < dp_lis[j] + 1) {
					dp_lis[i] = dp_lis[j] + 1;
					prev[i] = j;
				}
			}
		}
		
		int answer = -1;
		int index = -1;
		ArrayList<Integer> answer_lst = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			if (answer <= dp_lis[i]) {
				answer = dp_lis[i];
				index = i;
			}
		}
		
		answer_lst.add(lst[index]);
		while (prev[index] != index) {
			index = prev[index];
			answer_lst.add(lst[index]);
		}
		
		Collections.sort(answer_lst);
		
		System.out.println(answer);
		for (int i = 0; i < answer_lst.size(); i++) {
			System.out.print(answer_lst.get(i) + " ");
		}
		
	} // end of main
} // end of class