package Implementation;

import java.io.*;
import java.util.*;

//번데기
public class p15721 {
    static int A,T, pupa;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        pupa = Integer.parseInt(br.readLine());

        int n = 2;
        int pupaB = 0;
        int pupaD = 0;

        int answer=0; //전체 B, D 모두 포함해서 전체 중 % A 해야함

        Loop1:
        while (true){
            for (int i = 0; i < 4; i++) {
                if(i % 2 == 0){
                    //뻔
                    pupaB++;
                    if(pupaB == T && pupa == 0){
                        answer = (pupaB+pupaD -1) % A;
                        break Loop1;
                    }
                }
                else{
                    //데기
                    pupaD++;
                    if(pupaD == T && pupa == 1){
                        answer = (pupaB+pupaD -1) % A;
                        break Loop1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                //뻔
                pupaB++;
                if(pupaB == T && pupa == 0){
                    answer = (pupaB+pupaD -1) % A;
                    break Loop1;
                }
            }

            for (int i = 0; i < n; i++) {
                //데기
                pupaD++;
                if(pupaD == T && pupa == 1){
                    answer = (pupaB+pupaD -1) % A;
                    break Loop1;
                }
            }

            n++;
        }

        System.out.print(answer);
    }
}
