import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 반복하지않는수 배열 만들기
    int[] arr = new int[1000000];
    // 배열 인덱스
    int cnt = 0;
    // 반복하지 않는 수
    int number = 0;
    // 반복체크용 배열
    boolean[] numbers = new boolean[10];
    boolean isRepeat;
    int i;
    int j;
    // 배열 채우기
    while (cnt < 1000000) {
      isRepeat = false;
      // 1부터 시작
      number++;
      i = number;
      // 반복체크 배열 초기화
      for (int k = 0; k < 10; k++) {
        numbers[k] = false;
      }
      // 반복체크
      while (i > 0) {
        j = i % 10;
        i /= 10;
        if (numbers[j] == true) {
          isRepeat = true;
          break;
        }
        numbers[j] = true;
      } // end of 반복체크 while
      // 반복한다면 다음 수로..
      if (isRepeat) { 
        continue;
      }
      arr[cnt] = number;
      cnt++;
    } // end of arr input while
    
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    while (n != 0) {
      // 배열에서 바로 출력
      System.out.println(arr[n - 1]);
      n = sc.nextInt();
    } // end of input while
  } // end of main
} // end of class
