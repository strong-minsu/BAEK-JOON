package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//벌집
public class p2292 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int beeCount = 2; //벌집 방 count, N과 비교
        boolean b = true;
        int i=1; //멀어진 칸 수

        while (b){
            //1인 경우는 항상 1칸
            if(N==1){
                break;
            }

            //벌집은 중앙에서 한 칸 멀어질수록 (멀어진 칸 수=i)*6개의 크기를 갖게 된다.
            for(int j=1; j<=i*6; j++){
                if(beeCount==N){
                    b = false;
                    break;
                }
                beeCount++;
            }
            i++;
        }

        System.out.println(i);
    }
}
