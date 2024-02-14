import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int n;
    private static int[][] lst, in_degree, distance;
    private static Queue<Integer> q;

    public static void main(String[] args) throws IOException {

        int[][] dxy = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        n = Integer.parseInt(br.readLine());
        lst = new int[n][n];
        in_degree = new int[n][n];
        distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                lst[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(in_degree[i], 0);
            Arrays.fill(distance[i], -1);
        }
        
        q = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int ny = i + dxy[k][0];
                    int nx = j + dxy[k][1];
                    if (0 <= ny && ny < n && 0 <= nx && nx < n) {
                        if (lst[i][j] > lst[ny][nx]) {
                            in_degree[i][j] += 1;
                        }
                    }
                }
                if (in_degree[i][j] == 0) {
                    q.offer(i);
                    q.offer(j);
                    distance[i][j] = 1;
                }
            }
        } // end of for i

        int answer = 1;
        while (!q.isEmpty()) {
            int curY = q.poll();
            int curX = q.poll();
            for (int k = 0; k < 4; k++) {
                int ny = curY + dxy[k][0];
                int nx = curX + dxy[k][1];
                if (0 <= ny && ny < n && 0 <= nx && nx < n) {
                    if (lst[ny][nx] > lst[curY][curX]) {
                        in_degree[ny][nx] -= 1;
                        if (in_degree[ny][nx] == 0) {
                            distance[ny][nx] = distance[curY][curX] + 1;
                            q.offer(ny);
                            q.offer(nx);
                            answer = Math.max(answer, distance[ny][nx]);
                        }
                    }
                }
            }
        } // end of while

        sb.append(answer);
        System.out.println(sb);
        
    } // end of main
} // end of class