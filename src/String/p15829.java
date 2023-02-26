package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Hashing
public class p15829 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long result=0;
        long pow = 1;
        for(int i=0; i<L; i++){
            char c = str.charAt(i);
            int alpha = c - 96 ;
            result += alpha*pow;
            pow = (pow * 31)%1234567891;
        }
        System.out.print(result%1234567891);
    }
}
