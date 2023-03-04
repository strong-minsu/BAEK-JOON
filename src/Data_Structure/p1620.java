package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//나는야 포켓몬 마스터 이다솜
public class p1620 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> pokemon1 = new HashMap<>();
        HashMap<String, Integer> pokemon2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            pokemon1.put(i, str);
            pokemon2.put(str, i);
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.charAt(0) >= 65){
                //포켓몬 이름으로 찾는 경우
                sb.append(pokemon2.get(str)).append("\n");
            }
            else{
                //포켓몬 번호로 찾는 경우
                int num = Integer.parseInt(str);
                sb.append(pokemon1.get(num)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
