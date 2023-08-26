package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9461_파도반수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            long[] D = new long[101];
            D[1] = 1;
            D[2] = 1;
            D[3] = 1;
            for(int j=4; j<=N; j++){
                D[j] = D[j-2] + D[j-3];
            }
            System.out.println(D[N]);
        }
    }
}
