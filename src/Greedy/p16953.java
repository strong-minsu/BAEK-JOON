package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//A -> B
public class p16953 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 1;
        boolean b = false;

        while (B > A){
            if(B % 2 == 0){
                B /= 2;
            }
            else{
                if(B % 10 == 1){
                    String s = Integer.toString(B);
                    s = s.substring(0, s.length()-1);
                    B = Integer.parseInt(s);
                }
                else{
                    break;
                }
            }
            count++;
            if(A == B){
                b = true;
                break;
            }
        }

        if(b){
            System.out.println(count);
        }
        else{
            System.out.println(-1);
        }

    }
}
