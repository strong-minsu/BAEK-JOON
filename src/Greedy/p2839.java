package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//설탕 배달
public class p2839 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count=0;

        while (true){
            if(N%5 == 0){
                count += N/5;
                break;
            }
            if(N < 3){
                count = -1;
                break;
            }
            N -= 3;
            count++;
        }
        System.out.print(count);
    }
}
