import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    // 가능한 후보 3차원 배열로 선언
    boolean[][][] arr = new boolean[10][10][10];

    // 0이 들어가거나 중복된 숫자가 있다면 후보에서 제거
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        for (int j2 = 0; j2 < 10; j2++) {
          if ((i == 0) || (j == 0) || (j2 == 0) || (i == j) || (j == j2) || (i == j2)) {
            arr[i][j][j2] = false;
          } else {
            arr[i][j][j2] = true;
          }
        } // end of j2
      } // end of for j
    } // end of for i

    int N = sc.nextInt();

    for (int i = 0; i < N; i++) {
      // 질문한 수, strike, ball 입력
      String answer = sc.next();
      int inputStrike = sc.nextInt();
      int inputBall = sc.nextInt();

      char[] a = answer.toCharArray();
      int first = Integer.parseInt(a[0]+"");
      int second = Integer.parseInt(a[1]+"");
      int third = Integer.parseInt(a[2]+"");
      //System.out.println(Arrays.toString(a));

      
      for (int j1 = 1; j1 < 10; j1++) {
        for (int j2 = 1; j2 < 10; j2++) {
          for (int j3 = 1; j3 < 10; j3++) {
            if (arr[j1][j2][j3]) { // arr[j1][j2][j3]가 true라면 strike, ball 구하기

              int strike = 0;
              int ball = 0;

              if (first == j1)
                strike++;
              else if ((first == j2) || (first == j3))
                ball++;
              
              if (second == j2)
                strike++;
              else if ((second == j1) || (second == j3))
                ball++;
              
              if (third == j3)
                strike++;
              else if ((third == j1) || (third == j2))
                ball++;
              
              if ((strike != inputStrike) || (ball != inputBall)) 
                arr[j1][j2][j3] = false;
            }
          } // end of for j3
        } // end of for j2
      } // end of for j1
      
      

    } // end of for i (N반복)

    // true인 후보 세기
    int count = 0;
    for (int j1 = 1; j1 < 10; j1++) {
      for (int j2 = 1; j2 < 10; j2++) {
        for (int j3 = 1; j3 < 10; j3++) {
          if (arr[j1][j2][j3])
            count++;
        } // end of for j3
      } // end of for j2
    } // end of for j1

    System.out.println(count);
  } // end of main
} // end of class