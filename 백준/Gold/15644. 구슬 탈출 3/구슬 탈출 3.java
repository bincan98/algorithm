import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int N, M, oriRedY, oriRedX, oriBlueY, oriBlueX, answer;
    private static char[][] lst;
    private static int[][][][] nextPosition;
    private static int[] nextRedPosition, nextBluePosition;
    private static int[] answerLst;

    public static void main(String[] args) throws IOException {

        int[][] dxy = new int[][] {{-1, 0, 0}, {0, 1, 1}, {1, 0, 2}, {0, -1, 3}};

        st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lst = new char[N][M];
        nextPosition = new int[N][M][4][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                lst[i][j] = s.charAt(j);
            }
        } // 입력 완료

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (lst[i][j] == 'R') {
                    oriRedY = i;
                    oriRedX = j;
                } else if (lst[i][j] == 'B') {
                    oriBlueY = i;
                    oriBlueX = j;
                }
                for (int[] nxt: dxy) {
                    for (int k = 0; k < Math.max(N, M); k++) {
                        int ny = i + nxt[0] * k;
                        int nx = j + nxt[1] * k;
                        if (ny < 0 || ny >= N || nx < 0 || nx >= M) break;
                        if (lst[ny][nx] == 'O') {
                            nextPosition[i][j][nxt[2]][0] = 20;
                            nextPosition[i][j][nxt[2]][1] = 20;
                            break;
                        } else if (lst[ny][nx] == 'R' || lst[ny][nx] == 'B' || lst[ny][nx] == '.') {
                            nextPosition[i][j][nxt[2]][0] = ny;
                            nextPosition[i][j][nxt[2]][1] = nx;
                        } else {
                            break;
                        }
                    }
                }
            }
        } // end of for i

        answer = 20;
        answerLst = new int[10];
        recur(0, new int[] {oriRedY, oriRedX}, new int[] {oriBlueY, oriBlueX}, new int[10]);

        if (answer != 20) {
            System.out.println(answer);
            for (int i = 0; i < answer; i++) {
                switch (answerLst[i]) {
                    case 0:
                        System.out.print("U");
                        break;
                    case 1:
                        System.out.print("R");
                        break;
                    case 2:
                        System.out.print("D");
                        break;
                    case 3:
                        System.out.print("L");
                        break;
                }
            }
        } else {
            System.out.println(-1);
        }
    } // end of main

    private static void recur(int cur, int[] redPosition, int[] bluePosition, int[] history) {
        if (cur == 10 || cur + 1 >= answer) return;
        nextRedPosition = new int[2];
        nextBluePosition = new int[2];
        for (int i = 0; i < 4; i++) {
            int[][] res = proc(i, redPosition, bluePosition);
            history[cur] = i;
            if (res[0][0] == 1) {
                if (answer > cur + 1) {
                    answer = cur + 1;
                    for (int j = 0; j < answer; j++) {
                        answerLst[j] = history[j];
                    }
                }
                return;
            } else if (res[0][0] == 2) {
                continue;
            } else {
                nextRedPosition = res[1];
                nextBluePosition = res[2];
            }
            recur(cur + 1, nextRedPosition, nextBluePosition, history);
        }
    } // end of recur

    private static int[][] proc(int d, int[] redPosition, int[] bluePosition) {
        int nextRedY = nextPosition[redPosition[0]][redPosition[1]][d][0];
        int nextRedX = nextPosition[redPosition[0]][redPosition[1]][d][1];
        int nextBlueY = nextPosition[bluePosition[0]][bluePosition[1]][d][0];
        int nextBlueX = nextPosition[bluePosition[0]][bluePosition[1]][d][1];
        if (nextBlueY == 20) {
            return new int[][] {{2}};
        } else if (nextRedY == 20) {
            return new int[][] {{1}};
        }
        if (nextRedY == nextBlueY && nextRedX == nextBlueX) {
            if (d == 0) {
                if (redPosition[0] > bluePosition[0])
                    nextRedY += 1;
                else
                    nextBlueY += 1;
            } else if (d == 1) {
                if (redPosition[1] > bluePosition[1])
                    nextBlueX -= 1;
                else
                    nextRedX -= 1;
            } else if (d == 2) {
                if (redPosition[0] > bluePosition[0])
                    nextBlueY -= 1;
                else
                    nextRedY -= 1;
            } else {
                if (redPosition[1] > bluePosition[1])
                    nextRedX += 1;
                else
                    nextBlueX += 1;
            }
        }
        return new int[][] {{0}, {nextRedY, nextRedX}, {nextBlueY, nextBlueX}};
    } // end of proc

} // end of class