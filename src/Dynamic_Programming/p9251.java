package Dynamic_Programming;

import java.util.*;
import java.io.*;

//LCS
public class p9251 {
    static int[][] LSC;
    static String str1;
    static String str2;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        LSC = new int[str1.length()+1][str2.length()+1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    LSC[i][j] = LSC[i-1][j-1] + 1;
                }
                else{
                    LSC[i][j] = Math.max(LSC[i-1][j], LSC[i][j-1]);
                }
            }
        }

        System.out.print(LSC[str1.length()][str2.length()]);

    }
}
