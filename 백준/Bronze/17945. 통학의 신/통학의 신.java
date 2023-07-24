
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// A와 B 입력받기
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] arr = new int[2];
		int size = 0;
		
		// 가능한 경우 모두 탐색
		for (int i = -2000; i <= 2000; i++) {
			if (i*i + 2*a*i + b == 0) {
				arr[size++] = i; // 식이 맞다면 배열에 넣고 size를 1 증가
				if (size == 2) break; // 두 근을 모두 찾으면 탐색 중단
			}
		}
		
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	} // end of main
} // end of class
