package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p9375 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String clothes = st.nextToken();
                if(hashMap.containsKey(clothes)){
                    hashMap.put(clothes, hashMap.get(clothes)+1);
                }
                else{
                    hashMap.put(clothes, 2);
                }
            }

            int result = 1;

            for(String key : hashMap.keySet()){
                result *= hashMap.get(key);
            }

            sb.append(result-1).append("\n");
            hashMap.clear();
        }
        System.out.print(sb);
    }
}
