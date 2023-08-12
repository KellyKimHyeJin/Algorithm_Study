package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
    // 정렬을 먼저 해주기
    // N의 최대 범위가 15000이므로 O(nlogn) 정렬 사용해도 됨
    // 한 번 쓰면 없어짐 -> 양 끝에 포인트를 지정해서 투 포인터로 문제 접근
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int count =0;
        int start =0;
        int end = N-1;
        while(start < end){ // 두 포인터가 겹쳐지는 순간 모든 재료 선택
            if(A[start] + A[end] < M){
                start++; // 작으면 min을 올려주기
            } else if(A[start] + A[end] > M){
                end--; // 크면 max를 내려주기
            } else{
                count++; start++; end--;
            }
        }
        System.out.println(count);
    }
}
