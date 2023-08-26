package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1003_피보나치함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] D0 = new int[41];
            int[] D1 = new int[41];
            D0[0] = 1;
            D0[1] = 0;
            D0[2] = 1;
            D1[0] = 0;
            D1[1] = 1;
            D1[2] = 1;
            for(int j=3; j<=N; j++){
                D0[j] = D0[j-1] + D0[j-2];
                D1[j] = D1[j-1] + D1[j-2];
            }
            System.out.println(D0[N] + " " + D1[N]);
        }
    }
}
