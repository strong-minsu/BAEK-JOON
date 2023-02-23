package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//숫자 카드 2
public class p10816 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());

        int Narray[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            Narray[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Marray[] = new int[M];
        for (int i=0; i<M; i++){
            Marray[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<M; i++){
            map.put(Marray[i], 0);
        }

        for(int i=0; i<N; i++){
            if(map.containsKey(Narray[i])){
                map.put(Narray[i], map.get(Narray[i])+1 );
            }
        }
        for(int i=0; i<M; i++){
            sb.append(map.get(Marray[i])).append(" ");
        }
        System.out.print(sb);
    }
}
