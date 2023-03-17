package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//나머지
public class p3052 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d[] = new int[42];
        int count = 0;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            d[num%42] ++;
        }
        for(int i=0; i<d.length; i++){
            if(d[i]!=0){
                count++;
            }
        }
        System.out.print(count);
    }
}
