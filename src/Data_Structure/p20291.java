package Data_Structure;

import java.util.*;
import java.io.*;

//파일 정리

public class p20291 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(),".");
            st.nextToken();
            String file_extension = st.nextToken();

            if(hashMap.containsKey(file_extension)){
                hashMap.put(file_extension, hashMap.get(file_extension)+1);
            }
            else{
                hashMap.put(file_extension, 1);
            }
        }

        //TreeMap에 Comparator를 생략하면 기본 Comparator가 동작함
        TreeMap<String, Integer> sortMap =new TreeMap<>(hashMap);
        sortMap.forEach((key, value)->{
            sb.append(key+" "+value).append("\n");
        });

        System.out.print(sb);
    }
}
