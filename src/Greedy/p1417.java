package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//국회의원 선거
public class p1417 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        if(N == 1){
            System.out.print(0);
        }

        else{
            int count=0;
            //다솜이 제외하고 나머지 사람들의 투표수
            int []vot = new int[N-1];
            for(int i=0; i<N-1; i++) {
                vot[i] = Integer.parseInt(br.readLine());
            }

            while(true) {
                //계속 정렬해줌
                Arrays.sort(vot);

                boolean flag = true; //사람을 매수할 필요가 없으면 if문 이후에도 true
                int last = vot.length-1; //배열에서 가장 큰 수의 인덱스

                //사람 매수
                if(dasom <= vot[vot.length-1]) {
                    dasom ++;
                    vot[last]--;
                    count++;
                    flag = false;
                }
                //다솜이 더 이상 사람을 매수하지 않으면 while문 종료
                if(flag) {
                    break;
                }
            }
            System.out.print(count);
        }
    }
}
