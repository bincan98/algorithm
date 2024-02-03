import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        long n = Long.parseLong(st.nextToken());

        long[] x = new long[(int) n];
        long [] y = new long[(int) n];
        long a = 0;
        long result = 0;
        long xsum = 0;
        long ysum = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());

        }
        Arrays.sort(x);
        Arrays.sort(y);

        if(n%2 == 0){
            a = n/2 -1;
            for(int i=0; i<n; i++){
                xsum += Math.abs(x[i]-x[(int) a]);
                ysum += Math.abs(y[i]-y[(int) a]);

            }
            result = xsum+ysum;
            System.out.println(result);
        } else{
            a = n / 2 ;
            for(int i=0; i<n; i++){
                xsum += Math.abs(x[i]-x[(int) a]);
                ysum += Math.abs(y[i]-y[(int) a]);

            }
            result = xsum+ysum;
            System.out.println(result);
        }




    }
}