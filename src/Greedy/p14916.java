package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//거스름돈
public class p14916 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count=0;

        while(n>0) {
            if(n%5 == 0) {
                //5로 나눠지는 경우 (몫 만큼 동전 증가시킨 후 반복문 종료)
                count += n/5;
                break;
            }
            else{
                //나눠지지 않을 경우 (2원 감소후 동전 증가)
                n -= 2;
                count++;
            }
        }
        if(n<0) {
            // 2, 5 동전으로 거슬러 줄 수 없는 경우
            count = -1;
        }
        System.out.print(count);
    }
}
