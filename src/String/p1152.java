package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//단어의 개수
public class p1152 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        System.out.print(st.countTokens());
    }
}
