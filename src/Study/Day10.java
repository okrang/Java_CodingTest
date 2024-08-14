package Study;
import java.io.*;
import java.util.*;
public class Day10 {
    static int n;
    static long m;
    static long sum;
    static int[] arr;
    static int MAX_INT;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        MAX_INT=0;
        sum=0L;
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            sum+=arr[i];
            MAX_INT=Math.max(MAX_INT,arr[i]);
        }
        m=Long.parseLong(br.readLine());

        if(sum<=m){
            System.out.println(MAX_INT);
        }else{
            int budget=BS(1,MAX_INT);
            System.out.println(budget);
        }


    }
    static int BS(int start, int end){

        while(start<=end){
            int mid=(start+end)/2;
            int result=0;
            for(int i=0;i<n;i++){
                if(arr[i]<=mid){
                    result+=arr[i];
                }else{
                    result+=mid;
                }

            }

            if(result<m){
                start=mid+1;
            }else if(result>m){
                end=mid-1;
            }else{
                return mid;
            }
        }

        return end;
    }
}
