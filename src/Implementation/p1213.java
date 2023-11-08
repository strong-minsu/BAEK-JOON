package Implementation;

import java.util.*;
import java.io.*;

public class p1213 {
    static  HashMap<Character, Integer> hashMap;
    static List<Character> keyList;
    static StringBuilder sb;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String st = br.readLine();
        hashMap = new HashMap<>();

        for (int i = 0; i < st.length(); i++) {
            Character c = st.charAt(i);
            if(!hashMap.containsKey(c)){
                hashMap.put(c, 1);
            }
            else{
                hashMap.put(c, hashMap.get(c)+1);
            }
        }

        int countOdd = 0;
        char middle = ' ';
        for(char k: hashMap.keySet()){
            if(hashMap.get(k)%2 == 1){
                middle = k;
                countOdd++;
            }
            if(countOdd>1){
                break;
            }
        }

        if(middle != ' '){
            hashMap.put(middle, hashMap.get(middle)-1);
        }

        String input="";
        for (char key:
             hashMap.keySet()) {
            for (int i = 0; i < hashMap.get(key); i++) {
                input += Character.toString(key);
            }
        }
        char[] array = input.toCharArray();
        Arrays.sort(array);

        if(countOdd > 1){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        else{
            if(countOdd == 0){
                palindrome("", array);
            }
            else{
                palindrome(Character.toString(middle),array);
            }
            System.out.print(sb);
        }
    }

    private static void palindrome(String s, char[] array){
        sb.append(s);
        for (int i = array.length-1; i >=0 ; i = i-2) {
            sb.insert(0, array[i]).append(array[i]);
        }
    }
}
