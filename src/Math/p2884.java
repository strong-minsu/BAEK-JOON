package Math;

import java.util.*;
import java.io.*;

//알람 시계
public class p2884 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(M<45){
            if(H==0){
                H = 23;
                M = 60-(45-M);
            }
            else{
                H = H-1;
                M = 60-(45-M);
            }
        }
        else{
            M = M-45;
        }

        System.out.print(H+" "+M);
    }
}
