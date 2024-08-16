package Study;

import java.io.*;
import java.util.*;

public class Day12 {
    static int n;
    static long m,sum,MAX_INT;
    static long []arr;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Long.parseLong(st.nextToken());
        sum=0;
        arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(br.readLine());
            sum+=arr[i];
        }
        Arrays.sort(arr);
        MAX_INT=arr[n-1];
        long restindex;
        long idx=m%n;
        if(idx==0){
            restindex=0L;
        }else{
            restindex=arr[(int)idx-1];
        }

        long right=(m/n)*MAX_INT+restindex;
        long left=(m/n)*arr[0]+restindex;

        while(left<=right){
            long mid=(left+right)/2;
            long count=counting(mid);
            if(count<m){
                left=mid+1;

            }else{
                right=mid-1;
            }
//            System.out.println(left);
//            System.out.println(right);
//            System.out.println(count);
        }

        System.out.println(left);
    }
    public static long counting(long mid){
        long count=0;

        for(int i=0;i<n;i++){
            long temp=arr[i];
            count+=mid/temp;
        }
     return count;
    }
}
