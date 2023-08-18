package DataStructure;

import java.util.Scanner;

public class P11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N이라는 값을 입력을 받음 int형이니까 이렇게 받음
        int N = sc.nextInt();
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for(char c: cNum){
            // 문자를 숫자로 아스키코드로 변환해줄 때 48을 빼주거나 '0'을 뺴주기
            sum += c - '0';
        }
        System.out.println(sum);
    }
}