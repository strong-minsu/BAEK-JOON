package Dynamic_Programming;

import java.util.*;
import java.io.*;

//평범한 배낭

public class p12865 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] wightTable = new int[K+1];

        for (int i = 0; i < N; i++) {
            //무게와 가치 받아옴
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //k~1이 될 때까지. 계산
            for (int j = K; j > 0 ; j--) {
                if(j+w <= K && wightTable[j]!=0){
                    wightTable[j+w] = Math.max(wightTable[j+w], wightTable[j] + v);
                }
            }
            //j가 0인 경우 따로 계산 해줌...
            if(w <= K){
                wightTable[w] = Math.max(wightTable[w], v);
            }
        }
        Integer[] result = Arrays.stream(wightTable).boxed().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());

        bw.write(result[0]+"\n");
        bw.flush();
        bw.close();
    }
}
