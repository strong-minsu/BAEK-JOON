package Sorting;
import java.util.*;
import java.io.*;
import static java.util.Comparator.*;
//소트인사이드

public class p1427 {
    static Integer array[] ;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String string = st.nextToken();
        array = new Integer[string.length()];

        for(int i=0; i<string.length(); i++){
            int num  = string.charAt(i) -'0';
            array[i] = num;
        }
        Arrays.sort(array, Collections.reverseOrder());

        for(int i : array){
            System.out.print(i);
        }
    }
}
