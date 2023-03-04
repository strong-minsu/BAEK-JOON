package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//팩토리얼 0의 개수
public class p1676 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count5=0;
        for(int i=1; i<=N; i++){
            if((i%5==0)){
                int number=i;
                while(number%5==0){
                    count5++;
                    number = number/5;
                }
            }
        }

        int result = count5;

        System.out.print(result);
    }
}
