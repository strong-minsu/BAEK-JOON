package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//돌게임
public class p9655 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N%2 == 0){
            System.out.print("CY");
        }
        else{
            System.out.print("SK");
        }
    }
}
