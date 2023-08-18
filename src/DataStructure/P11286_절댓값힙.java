package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0){
                plus.add(num);
            }else if(num < 0){
                minus.add(num);
            }else{
                if (plus.isEmpty() && minus.isEmpty()){
                    System.out.println('0');
                } else if(minus.isEmpty()){
                    System.out.println(plus.poll());
                } else if (plus.isEmpty()){
                    System.out.println(minus.poll());
                } else{
                    if(plus.peek() >= -1*(minus.peek())){
                        System.out.println(minus.poll());
                    } else {
                        System.out.println(plus.poll());
                    }
                }
            }
        }

    }
}