package String;

import java.util.*;
import java.io.*;
public class p27866 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        int n = Integer.parseInt(br.readLine());

        System.out.println(st.charAt(n-1));
    }
}
