package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//블로그2
public class p20365 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String blog = br.readLine();
        StringTokenizer st1 = new StringTokenizer(blog, "B");
        StringTokenizer st2 = new StringTokenizer(blog, "R");
        int blue =  st1.countTokens();
        int red = st2.countTokens();

        int count = 0;

        if(blue>red){
            count = 1+ red;
        }
        else{
            count = 1+ blue;
        }

        System.out.print(count);
    }
}
