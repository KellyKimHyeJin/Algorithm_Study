package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class P11279_최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num ==0){
                if(!queue.isEmpty()){
                    System.out.println(queue.poll());
                }else{
                    System.out.println('0');
                }
            } else{
                queue.add(num);
            }
        }
    }
}
