package Sorting;

import java.util.Scanner;

public class 삽입정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        for(int num = 1; num<N; num++){
            for(int i= num; i>0; i--){
                // 차례차례 아래 index 원소들과 비교해주기
                if(A[i-1] > A[i]){
                    int temp = A[i-1];
                    A[i-1] = A[i];
                    A[i] = temp;
                }
            }
        }
    }
}
