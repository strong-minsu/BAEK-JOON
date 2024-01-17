package Greedy;

import java.io.*;
import java.util.*;

//DNA
public class p1969 {
    static int N,M;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String [] DNAs = new String[N];

        for (int i = 0; i < N; i++) {
            DNAs[i] = br.readLine();
        }

        int hammingDistance = 0;
        for (int i = 0; i < M; i++) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int j = 0; j < N; j++) {
                char dna = DNAs[j].charAt(i);
                if(hashMap.containsKey(dna)){
                    hashMap.put(dna, hashMap.get(dna)+1);
                }
                else{
                    hashMap.put(dna, 1);
                }
            }
            List<Character> keSet = new ArrayList<>(hashMap.keySet());
            Collections.sort(keSet);

            char c='A';
            int count = Integer.MIN_VALUE;
            for (char key : keSet){
                if(hashMap.get(key) > count){
                    count = hashMap.get(key);
                    c = key;
                }
            }
            hammingDistance = hammingDistance + (N-count);
            sb.append(c);
        }
        sb.append("\n").append(hammingDistance);
        System.out.print(sb);
    }
}
