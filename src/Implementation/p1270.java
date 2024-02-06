package Implementation;

import java.io.*;
import java.util.*;

//전쟁 - 땅따먹기
public class p1270 {
    //한 번호의 군대의 병사가 절반을 초과한다면 그 땅은 그 번호의 군대의 지배하에 놓인다.
    //전쟁이 한창중이면 -> 그 땅을 지배하는 군대의 번호가 없는 경우 "SYJKGW"
    static int n, m;
    static HashMap<Long, Integer> hashMap;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            hashMap = new HashMap<>();

            m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                long k = Long.parseLong(st.nextToken());
                if(hashMap.containsKey(k)){
                    hashMap.put(k, hashMap.get(k)+1);
                }
                else{
                    hashMap.put(k, 1);
                }
            }

            boolean flag = false;
            long num = 0;
            for (long key: hashMap.keySet()) {
                if(hashMap.get(key) > m/2){
                    flag = true;
                    num = key;
                    break;
                }
            }

            if(flag){
                sb.append(num+"\n");
            }
            else{
                sb.append("SYJKGW\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
