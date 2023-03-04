package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//마인크래프트
public class p18111 {
    static int N, M, B;
    static int block[][];

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        block = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                block[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(block[i][j], min);
                max = Math.max(block[i][j], max);
            }
        }

        int answerHeight = -1;
        int answerTime = Integer.MAX_VALUE;

        //최소 층에서 최대 층까지 모든 경우 비교
        for(int i=min; i<=max; i++){
            int time = 0;
            int inventory = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int diff = block[j][k] - i;
                    if(diff > 0){ //제거하고 인벤토리에 넣어야함
                        inventory += Math.abs(diff);
                        time += (Math.abs(diff)*2);
                    }
                    else if (diff < 0){ //인벤토리에서 꺼내야함
                        inventory -= Math.abs(diff);
                        time += Math.abs(diff);
                    }
                }
            }
            if(inventory >= 0){ // 인벤토리 안에 값이 남거나 0일 경우만 통과
                if(time <= answerTime){ //시간은 같거나 작은 거로 해야함 (높이가 최대인 것을 구해야하기 때문)
                    answerTime = time;
                    answerHeight = i;
                }
            }
        }

        System.out.print(answerTime + " "+ answerHeight);
    }
}
