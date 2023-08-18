package Sorting;

import java.util.Scanner;

public class 퀵정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        quickSort(A);
    }
    public static void quickSort(int[] A){
        quickSort(A, 0, A.length -1);
    }

    public static void quickSort(int[] A, int start, int end){
        // 가장 왼쪽 값을 pivot으로 지정
        int pivot = start;
        int lo = start + 1;
        int hi = end;

        while(lo <= hi){
            // pivot보다 큰 값 만날 때까지
            while(lo <= end && A[lo] <= A[pivot]){
                lo++;
            }
            // pivot보다 작은 값 만날 때까지
            while(start < hi && A[pivot] <= A[hi]){
                hi--;
            }
            // 엇갈리면 pivot과 교체
            // 두 개로 나누는게 끝나면 엇갈 -> 한 칸 더 움직이니까
            if(lo > hi){
                int temp = A[pivot];
                A[pivot] = A[hi];
                A[hi] = temp;
            } else{ // 엇갈리지 않으면 lo와 hi를 교체
                int temp = A[lo];
                A[lo] = A[hi];
                A[hi] = temp;
            }
        }
        // hi와 pivot과 바꾸었으므로 다음과 같이 구간 나누기
        quickSort(A, start, hi-1);
        quickSort(A, hi+1, end);
    }

}
