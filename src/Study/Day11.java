package Study;
import java.util.*;
import java.io.*;

public class Day11 {
    static int n,m;
    static int [] arr;
    static int right;
    static int left;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        arr=new int[n];
        left=0;
        right=0;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            right+=arr[i];
            left=Math.max(left,arr[i]);

        }
        while(left<=right){
            int mid=(right+left)/2;
            int count=counting(mid);
            if(count>m){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(left);

    }
    static int counting(int mid){
        int count=0;
        int sum=0;
        count++;
        for(int i=0;i<n;i++){
            int temp=arr[i];
            if(temp+sum>mid){
                sum=temp;
                count++;
            }else{
                sum+=temp;
            }
        }
        return count;
    }
}
