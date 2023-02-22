package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//소수찾기
//제곱근 이용
//public class p1978 {
//    public static void main(String[] args)throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int count=0;
//
//        st = new StringTokenizer(br.readLine());
//
//        for (int i=0; i<N; i++){
//            boolean b = true;
//            int n = Integer.parseInt(st.nextToken());
//            if(n<2){
//                //1은 소수가 아님!
//                b = false;
//            }
//            for(int j=2; j<=Math.sqrt(n); j++){
//                if(n%j==0){
//                    b = false;
//                }
//            }
//            if(b){
//                count++;
//            }
//        }
//
//        System.out.print(count);
//    }
//}

//에라토스테네스의 체 이용방법
public class p1978 {
    static boolean number [] = new boolean[1001]; //boolean은 false로 초기화됨
    static void E (int n){
        //n을 제외한 배수를 지운다.
        int length = 1000/n;
        for(int i=2; i<=length; i++){
            number[n*i]= true;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int count=0;

        number[0] = true;
        number[1] = true;

        st = new StringTokenizer(br.readLine());

        for (int i = 2; i <= 1000; i++) {
            if (!number[i]) {
                E(i);
            }
        }

        for (int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(!number[n]){
                count++;
            }
        }

        System.out.print(count);
    }
}
