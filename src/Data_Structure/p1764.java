package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//듣보잡
public class p1764 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        int count=0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            hashMap.put(name, 1);
        }
        List<String> keyList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(hashMap.containsKey(name)){
                keyList.add(name);
                count++;
            }
        }

        Collections.sort(keyList);
        for(String key: keyList){
            sb.append(key).append("\n");
        }
        System.out.println(count);
        System.out.print(sb);
    }
}
