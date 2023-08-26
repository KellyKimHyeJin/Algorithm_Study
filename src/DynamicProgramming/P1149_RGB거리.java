package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] D = new int[1001][3];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + R;
            D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + G;
            D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + B;
        }
        System.out.println(Math.min(D[N][0], Math.min(D[N][1], D[N][2])));
    }
}
