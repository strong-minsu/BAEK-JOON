package Bruteforcing;

import java.util.*;
import java.io.*;

// 가장 가까운 세 사람의 심리적 거리

public class p20529 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine()," ");

            //비둘기 집 원리로
            //mbti가 전부 다른 16명 + 전부 다른 16명 ->에서 아무 mbti 1명만 들어와도 최소 거리가 0이 된다.
            if(N > 32){
                bw.write(0+"\n");
                continue;
            }

            String []MBTI = new String[N];
            for (int j = 0; j < N; j++) {
                MBTI[j] = st.nextToken();
            }

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    for (int l = k+1; l < N; l++) {
                        int count = 0;
                        //mbti 4자리 비교
                        for (int m = 0; m < 4; m++) {
                            if(MBTI[j].charAt(m) != MBTI[k].charAt(m)){
                                count++;
                            }
                            if(MBTI[j].charAt(m) != MBTI[l].charAt(m)){
                                count++;
                            }
                            if(MBTI[k].charAt(m) != MBTI[l].charAt(m)){
                                count++;
                            }
                        }
                        min = Math.min(min, count);
                        if(min==0){
                            break;
                        }
                    }
                }
            }
            bw.write(min+"\n");
        }
        bw.flush();
        bw.close();
    }

}
