package Sorting;

import java.util.Scanner;

public class 병합정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i=0; i< N; i++){
            A[i] = sc.nextInt();
        }
        mergeSort(A);
    }

    public static void mergeSort(int[] A){
        mergeSort(A, 0, A.length-1);
    }

    public static void mergeSort(int[] A, int start, int end){
        // 원소가 두 개 이상일 때 나누고 합치고 반복
        if(start < end){
            // 2개로 분할
            int mid = (start + end)/2;
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            // 병합
            merge(A, start, mid, end);
        }
    }

    public static void merge(int[] A, int start, int mid, int end){
        int[] temp = A.clone();
        // part1 : 왼쪽 그룹 시작 인덱스
        // part2 : 오른쪽 그룹 시작 인덱스
        // index : 정렬된 값을 병합된 배열의 어떤 위치에 넣어야 하는지
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        // 한 쪽 그룹이 끝까지 갈 때까지 하기
        while(part1 <= mid && part2 <= end){
            // 둘 중 작은 값을 배열에 넣어주고 해당 파트 인덱스(part1, part2)를 하나 올려주기
            if(temp[part1] <= temp[part2]){
                A[index++] = temp[part1++];
            } else{
                A[index++] = temp[part2++];
            }
        }

        // 왼쪽 그룹의 원소가 남는 경우만 처리
        // 오른쪽 그룹의 원소가 남는 경우는 따로 처리하지 않아도 됨
        // => 두 번째 그룹 내에서는 정렬되어 있는데 배열을 복사했으므로 앞에만 원소들 덮어 씌워주고 뒤에는 그대로 하면 됨
        for(int i=0; i<mid-part1; i++){
            A[index+i] = temp[part1+i];
        }
    }
}
