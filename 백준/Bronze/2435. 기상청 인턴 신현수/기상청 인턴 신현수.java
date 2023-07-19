import java.util.Scanner;

public class Main {
	static Scanner sc;
	static int n;
	static int k;
	static int arr[];
	// 온도의 합을 저장할 배열
	static int result[];
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		// 입력받기
		sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		//입력 받은 대로 선언
		arr = new int[n];
		result = new int[n-k+1];
		
		// 온도의 수열 입력 받기
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 연속적인 온도의 합 저장
		for (int i = 0; i < n-k+1; i++) {
			for (int j = 0; j < k; j++) {
				result[i] += arr[i+j];
			}
		}
		
		// max 찾기
		for (int i = 0; i < result.length; i++) {
			max = Math.max(max, result[i]);
		}
		
		// 출력
		System.out.println(max);
		
	} // end of main
} // end of class