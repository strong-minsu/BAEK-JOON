package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//한수
public class p1065 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        if(N <100){
            count = N;
        }
        else{
            int h, t, o;
            count = 99;
            for(int i=100;i<=N;i++) {
                h = i/100; //100의 자리
                t = (i%100)/10;//10의 자리
                o = i%10; //1의 자리
                if((h-t)==(t-o)){
                    //100자리와 10자리 수의 차 == 10자리 수와 1의 자리 수 차가 같은 경우
                    //등차수열 만족
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
