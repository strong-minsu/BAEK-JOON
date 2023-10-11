package String;

import java.io.*;
import java.util.*;

//DNA 비밀번호
public class p12891 {
    static int[] checkArray; //비밀번호 체크 배열
    static int[] currentArray; //현재 상태 체크 배열
    static int checkSecret;

    private static void Add(char c){
        //문자열 현재 배열에서 추가하는 경우
        //추가된 문자 증가 후 비밀번호 조건과 일치하는 경우 -> checkSecret증가
        switch (c){
            case 'A':
                currentArray[0]++;
                if(currentArray[0] == checkArray[0]){
                    checkSecret++;
                }
                break;
            case 'C':
                currentArray[1]++;
                if(currentArray[1] == checkArray[1]){
                    checkSecret++;
                }
                break;
            case 'G':
                currentArray[2]++;
                if(currentArray[2] == checkArray[2]){
                    checkSecret++;
                }
                break;
            case 'T':
                currentArray[3]++;
                if(currentArray[3] == checkArray[3]){
                    checkSecret++;
                }
                break;
        }
    }

    private static void Remove(char c){
        //문자열 현재 배열에서 제거하는 경우
        //현재 조건과 맞는 상태인데 제거하는 경우 -> checkSecret감소 후 제거
        switch (c){
            case 'A':
                if(currentArray[0] == checkArray[0]){
                    checkSecret--;
                }
                currentArray[0]--;
                break;
            case 'C':
                if(currentArray[1] == checkArray[1]){
                    checkSecret--;
                }
                currentArray[1]--;
                break;
            case 'G':
                if(currentArray[2] == checkArray[2]){
                    checkSecret--;
                }
                currentArray[2]--;
                break;
            case 'T':
                if(currentArray[3] == checkArray[3]){
                    checkSecret--;
                }
                currentArray[3]--;
                break;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count = 0;

        char [] DNA = new char[S];
        checkArray = new int [4];
        currentArray = new int[4];

        checkSecret = 0;
        st = new StringTokenizer(br.readLine());
        DNA = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArray[i] = Integer.parseInt(st.nextToken());

            //어떤 문자열 조건이 최소 0개 이상인 경우 무조건 통과 이므로 증가
            if(checkArray[i] == 0){
                checkSecret++;
            }
        }
        //초기 배열 검사
        for (int i = 0; i < P; i++) {
            Add(DNA[i]);
        }
        if(checkSecret == 4){
            count++;
        }

        //초기 배열 이후 슬라이딩 윈도우 처리
        for (int i = P; i < S; i++) {
            int j = i-P;
            Remove(DNA[j]);
            Add(DNA[i]);
            if(checkSecret == 4){
                count++;
            }
        }

        System.out.print(count);
    }
}
