package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1874_스택수열{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int A[] = new int[N];
        for(int i =0; i<N; i++){
            A[i]=Integer.parseInt(bf.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        Boolean result = true;
        StringBuffer st = new StringBuffer();
        // 가변한 문자열을 처리하기 위한 클래스
        // String은 객체가 재생성되는데에 반해 새로운 문자열을 추가하거나 변경하게 되면 기존의 객체로 추가 및 변경이 됨
        // N값이 나왔을 때 이전과 이후로 나누기 num변수를 만들어서 세주기
        for(int i=0; i<N; i++){
            int now = A[i];
            if(now >= num){
                while(now >= num){
                    stack.push(num++);
                    st.append("+\n");
                }
                stack.pop();
                st.append("-\n");
            }else{ // now < num
                int n = stack.pop();
                if(n != now){
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    st.append("-\n");
                }
            }
        }
        if(result){
            System.out.println(st.toString());
        }

    }
}
