package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

//집합
public class p11723 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num=0;
            if(st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            if(str.equals("add")){
                hashSet.add(num);
            }
            else if(str.equals("remove")){
                if(hashSet.contains(num)){
                    hashSet.remove(num);
                }
            }
            else if(str.equals("check")){
                if(hashSet.contains(num)){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else if(str.equals("toggle")){
                if(hashSet.contains(num)){
                    hashSet.remove(num);
                }
                else{
                    hashSet.add(num);
                }
            }
            else if(str.equals("all")){
                hashSet.clear();
                for(int j=1; j<=20; j++){
                    hashSet.add(j);
                }
            }
            else if(str.equals("empty")){
                hashSet.clear();
            }
        }
        System.out.print(sb);
    }
}
