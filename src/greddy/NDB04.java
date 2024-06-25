package greddy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class NDB04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
       // String st=br.readLine();
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int target=1;
        for(int i=0;i<n;i++){
            int now=arr[i];
            if(now<=target){
                target+=now;
            }else{
                break;
            }
        }
        System.out.println(target);



    }
}
