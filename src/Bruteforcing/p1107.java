package Bruteforcing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//리모컨
public class p1107 {
    static boolean broken[];
    static int remoteControl(int N) {
        int min = Math.abs(N - 100);

        // 0부터 1000000까지 모든 채널을 돌면서 N으로 가장 적은 버튼을 눌러 이동할 수 있는 채널을 찾는다.
        // M의 최대값이 500000이므로 6자리수 중 최대 값인 999999까지 검사한다.
        for (int i = 0; i < 1000000; i++) {
            int channel = i;
            int len = possible(channel);
            // len 변수: c로 숫자버튼만을 이용해서 이동이 가능한지, 가능하다면 몇 번의 버튼을 누르는지 구하는 변수
            if (len > 0) {
                int press = Math.abs(channel - N);
                // press: 숫자버튼으로 n에 최대한 인접하게 이동한후 +또는 -를 몇 번 눌러야 하는지 구하는 변수
                min = Math.min(min, len+press);
            }
        }
        return min;
    }
    static int possible(int channel){
        //버튼만 눌러서 가능한지
        if(channel == 0){
            if(broken[0]){
                return 0;
            }
            else return 1;
        }
        int len = 0;
        while (channel>0){
            if (broken[channel % 10]){
                return  0;
            }
            len += 1;
            channel /= 10;
        }
        return len;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        if(M>0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        if(N==100){
            System.out.print(0);
        }
        else{
            System.out.print(remoteControl(N));
        }

    }
}
