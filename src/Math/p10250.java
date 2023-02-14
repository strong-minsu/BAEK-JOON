package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ACM호텔
public class p10250 {
    public static void main(String[] agrs)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int H, W, N;

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int w = 0;
            int h = 0;
            int g = 0;

            for(int j=0; j<W+1; j++) {
                if(g==N) { //게스트 카운터와 입력된 게스트 숫자 맞는지 확인
                    w = j;
                    break;
                }
                for(int k=1; k<H+1; k++) {
                    g++; //게스트 카운터 증가
                    if(g==N) {//게스트 카운터와 입력된 게스트 숫자 맞는지 확인
                        h = k;
                        break;
                    }
                }
            }
            if(w<10) {
                System.out.print(h);
                System.out.print(0);
                System.out.println(w);
            }
            else {
                System.out.print(h);
                System.out.println(w);
            }

        }
    }
}
