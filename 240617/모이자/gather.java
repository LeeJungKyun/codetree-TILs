import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += (Math.abs(j - i) * arr[j]);
            }
            min = Math.min(sum,min);
        }
        System.out.println(min);
    }
}