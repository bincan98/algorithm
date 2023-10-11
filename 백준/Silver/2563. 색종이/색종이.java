import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);
  // 기본 도화지
  static boolean[][] arr = new boolean[101][101];
  // 입력 받을 t, a, b
  private static int t;
  private static int a;
  private static int b;
  // 색종이가 붙은 검은 영역
  private static int cnt;

  public static void main(String[] args) {

    t = sc.nextInt();
    // testcase만큼 반복
    for (int i = 0; i < t; i++) {
      a = sc.nextInt();
      b = sc.nextInt();

      // 입력받은 a와 b 에서 +10만큼의 영역 채우기
      for (int j = a; j < a + 10; j++) {
        for (int j2 = b; j2 < b + 10; j2++) {
          arr[j][j2] = true;
        }
      }

    } // end of for i testcase
    
    // 채운 영역 파악하고 출력하기
    for (int i = 1; i < 101; i++) {
      for (int j = 1; j < 101; j++) {
        if (arr[i][j] == true)
          cnt++;
      }
    }
    System.out.println(cnt);
  } // end of main
} // end of class