package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[3][N+1];
            int[][] D = new int[3][N+1];
            for(int j=1; j<=2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=1; k<=N; k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            D[1][1] = sticker[1][1];
            D[2][1] = sticker[2][1];
            for(int j=2; j<=N; j++){
                D[1][j] = Math.max(D[2][j-1], D[2][j-2]) + sticker[1][j];
                D[2][j] = Math.max(D[1][j-1], D[1][j-2]) + sticker[2][j];
            }
            System.out.println(Math.max(D[1][N], D[2][N]));
        }
    }
}
