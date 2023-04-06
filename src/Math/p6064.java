package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//카잉 달력
public class p6064 {

    static int calendar(int M, int N, int x, int y) {
        int rotation = N-M;

        int temp = 0;

        //M과 N이 같은 경우
        if(rotation == 0){
            if(x == y){
                return y;
            }else{
                return -1;
            }
        }


        if(M%rotation != 0){
            temp = N;
        }
        else{
            temp = M/rotation;
        }

        int result = x; //x로 맞추고 시작
        for (int i=0; i<= temp+1; i++){
            if(x == y){
                result += i*M;
                return result;
            }

            x = rotate(N,x, rotation);
        }
        return -1;
    }

    static int rotate(int N, int x, int r){
        if(x - r <= 0){
            x -= r;
            x += N;
        }else {
            x -= r;
        }
        return x;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(M<N){
                sb.append(calendar(M, N, x, y)+"\n");
            }
            else{
                sb.append(calendar(N, M, y, x)+"\n");
            }
        }
        System.out.print(sb);
    }
}
