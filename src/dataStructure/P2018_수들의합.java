package dataStructure;

import java.util.Scanner;

public class P2018_수들의합 {
    public static void main(String[] args) {
        // N의 최댓값이 매우 큼 -> O(n)의 시간복잡도를 가진 알고리즘을 사용 => 투포인터
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1; // 자기자신 하나로 이루어진 경우의 수 미리 저장
        int start = 1;
        int end = 1;
        int sum = 1;
        while(end !=N){
            if(sum==N) {
                count++;
                end++; // 순서 잘 고려하기
                sum = sum + end;
            } else if(sum> N){
                sum = sum - start;
                start++;
            } else{
                end++;
                sum = sum + end;
            }
        }
        System.out.println(count);
    }
}
