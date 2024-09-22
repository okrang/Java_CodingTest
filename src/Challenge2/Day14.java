package Challenge2;

import java.io.*;
import java.util.*;

public class Day14 {
    public static int[] points;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        points=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            points[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points);
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int result=binarySearch(start,end);


            System.out.println(result);
        }

    }
    public static int binarySearch(int start, int end){
        int left=0;
        int right=points.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(points[mid]<start){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        int startidx=left;

        left=0;
        right=points.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(points[mid]<=end){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        int endidx=right;
        //System.out.println(startidx+" "+endidx);
        return endidx-startidx+1;



    }
}
