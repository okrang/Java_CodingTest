package Challenge2;

import java.io.*;
import java.util.*;

public class Day15 {
    static int n,m;
    static int [] arr;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left=0;
        int right=arr[n-1];
        int result=0;
        while(left<=right){
            int mid=(right+left)/2;

            if(binarySearch(mid)){
                result=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }

        }

        System.out.println(result);

    }
    public static boolean binarySearch(int mid){
        long sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]-mid>=0){
                sum+=arr[i]-mid;
            }
            if(sum>=m){
                return true;
            }
        }
        return false;

    }
}
