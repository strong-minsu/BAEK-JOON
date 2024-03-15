package Data_Structure;

import java.io.*;
import java.util.*;

//비슷한 단어
public class p2179 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());

        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if(!arr.contains(s)){
                arr.add(s);
            }
        }

        int a = 0, b = 0;
        int result = 0;

        for (int i = 0; i < n-1; i++) {
            String s1 = arr.get(i);
            for (int j = i+1; j < n; j++) {
                String s2 = arr.get(j);

                int count  = 0;
                int lenS = (s1.length() > s2.length() ? s2.length() : s1.length());

                for (int k = 0; k < lenS; k++) {
                    if(s1.charAt(k) != s2.charAt(k))break;
                    count++;
                }
                if(result < count){
                    result = count;
                    //a와 b 인덱스 값을 저장함
                    a = i;
                    b = j;
                }
            }
        }

        bw.write(arr.get(a)+"\n");
        bw.write(arr.get(b)+"");
        bw.flush();
        bw.close();
    }
}
