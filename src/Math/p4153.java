package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//직각삼각형
public class p4153 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        while (!(a==0&&b==0&&c==0)){
            if(a*a == b*b + c*c){
                System.out.println("right");
            }
            else if (b*b == a*a + c*c){
                System.out.println("right");
            }
            else if (c*c == a*a + b*b){
                System.out.println("right");
            }
            else{
                System.out.println("wrong");
            }
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }
}
