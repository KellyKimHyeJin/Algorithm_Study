package dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164_카드2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 큐 선언
        Queue<Integer> queue = new LinkedList<>();
        for(int i =1; i<=N; i++){ // 1부터 넣어야 됨
            queue.add(i);
        }
        while (queue.size() > 1){ // 사이즈 한 장 남을 때까지 반복하
            queue.poll(); // 한 장 버리기
            queue.add(queue.poll()); // 한 장 밑으로 넣기
        }
        System.out.println(queue.poll()); // 한 장 남은 거 출력해주기
    }
}
