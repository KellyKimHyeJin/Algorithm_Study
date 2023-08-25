package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        // -가 최대한 커야 수가 작아짐
        // - 기준으로 split해준 이후에 + 기준으로 split해주기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        int result = 0;
        for(int i=0; i<str.length; i++){
            int sum = 0;
            sum = Sum(str[i]);
            if(i==0){
                result += sum;
            }else{
                result -= sum;
            }
        }
        System.out.println(result);
    }
    public static int Sum(String str){
        int sum = 0;
        String[] s = str.split("[+]");
        for(int i=0; i<s.length; i++){
            sum += Integer.parseInt(s[i]);
        }
        return sum;
    }
}
