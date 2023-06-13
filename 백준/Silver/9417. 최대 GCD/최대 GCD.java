import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

모든 두수의 쌍이므로 조합

M이 100이하이므로 최대 100C2이므로 4950

N이 100이므로 495,000

gcd 구하기는 거의 상수 시간이라했으니까 완전탐색 가능할듯

**/
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int[] arr;
	private static int idx;
	private static int[] numbers;
	private static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		// 정수 M개 받은 배열 몇개인지 모르므로 최대 100개까지 선언해둠
		arr = new int[100];
		
		for (int i = 0; i < N; i++) {
			// answer를 최솟값으로 초기화
			answer = (int) -Math.pow(2, 31);
			
			st = new StringTokenizer(br.readLine());
			// 입력완료
			
			// 인덱스이자 현재 테케에서 원소의 개수가 몇개인지 알려줌(M)
			idx = 0;
			while (st.hasMoreTokens()) { // token이 없을때까지
				// arr에 하나씪 넣어주기
				arr[idx++] = Integer.parseInt(st.nextToken()); 
			}
			
			// 조합 저장할 배열
			numbers = new int[2];
			// 조합 시작
			combi(0, 0);
			
			System.out.println(answer);
		}
	} // end of main

	private static void combi(int index, int current) { // 조합 기본코드
		if (index == 2) { // 조합 완성시
			// gcd를 answer에 넣어보기
			answer = Math.max(answer, gcd(Math.max(numbers[0], numbers[1]), Math.min(numbers[0], numbers[1])));
			return;
		}
		for (int i = current; i < idx; i++) {
			numbers[index] = arr[i];
			combi(index+1, i+1);
		}
	} // end of combi

	private static int gcd(int a, int b) { // gcd 기본코드
		while (a % b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return b;
	} // end of gcd
	
} // end of class