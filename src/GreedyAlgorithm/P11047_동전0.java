package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047_동전0 {
    public static void main(String[] args) throws IOException {
        // 반례 있는지 없는지 잘 확인하기 => Ai는 Ai-1의 배수이므로 반례X
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int count =0;
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        // 큰 값부터 0포함 범위 잘 생각하기
        for(int i=N-1; i>=0; i--){
            if(A[i]>K){
                continue;
            } else{
                count += K/A[i];
                K = K % A[i];
            }
        }
        System.out.println(count);
    }
}
