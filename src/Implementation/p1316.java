package Implementation;
// 그룹 단어 체커
import java.io.*;
import java.util.*;

public class p1316 {
    static int N;
    static int count;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        N = Integer.parseInt(s);
        count = 0;

        for(int i=0; i<N; i++){
            int[] c = new int [26];
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            boolean b = true;
            for(int j=0; j<s.length(); j++){
                char ch = s.charAt(j);
                int n = ch-'0';
                n = n-49;
//                System.out.print(n);
//                System.out.print(" ");
                if(j == 0){
                    c[n] =1;
                }
                else{
                    if(c[n]==0){
                        c[n]=1;
                    }
                    else{
                        if(ch != s.charAt(j-1)){
                            b = false;
                            break;
                        }
                    }
                }
            }
            if(b) {
                count++;
            }
        }
        System.out.print(count);
    }
}
