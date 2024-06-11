import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

    	int antena = Integer.parseInt(br.readLine());
    	int eye = Integer.parseInt(br.readLine());
    	
    	if (3 <= antena && eye <= 4)
    		System.out.println("TroyMartian");
    	
    	if (antena <= 6 && 2 <= eye)
    		System.out.println("VladSaturnian");
    	
    	if (antena <= 2 && eye <= 3)
    		System.out.println("GraemeMercurian");
  
    } // end of main

} // end of class