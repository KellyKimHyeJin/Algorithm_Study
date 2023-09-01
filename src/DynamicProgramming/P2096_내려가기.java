package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N+1][4];
        int[][] DMax = new int[N+1][4];
        int[][] DMin = new int[N+1][4];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DMax[1][1] = A[1][1];
        DMax[1][2] = A[1][2];
        DMax[1][3] = A[1][3];
        DMin[1][1] = A[1][1];
        DMin[1][2] = A[1][2];
        DMin[1][3] = A[1][3];
        for(int i=2; i<=N; i++){
            DMax[i][1] = Math.max(DMax[i-1][1], DMax[i-1][2]) + A[i][1];
            DMax[i][2] = Math.max(Math.max(DMax[i-1][1], DMax[i-1][2]) , DMax[i-1][3]) + A[i][2];
            DMax[i][3] = Math.max(DMax[i-1][2], DMax[i-1][3]) + A[i][3];
            DMin[i][1] = Math.min(DMin[i-1][1], DMin[i-1][2]) + A[i][1];
            DMin[i][2] = Math.min(Math.min(DMin[i-1][1], DMin[i-1][2]) , DMin[i-1][3]) + A[i][2];
            DMin[i][3] = Math.min(DMin[i-1][2], DMin[i-1][3]) + A[i][3];
        }
        System.out.print(Math.max(Math.max(DMax[N][1], DMax[N][2]),DMax[N][3]) + " ");
        System.out.print(Math.min(Math.min(DMin[N][1], DMin[N][2]),DMin[N][3]));
    }
}
