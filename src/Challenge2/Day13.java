package Challenge2;
import java.util.*;
import java.io.*;
public class Day13 {
    public static int n,m;
    public static int[] arr;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        arr=new int[m];
        for(int i=0;i<m;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int left=1;
        int right=n;
        int result=0;
        while(left<=right){
            int mid=(left+right)/2;
            //System.out.println(mid);
            if(binarySearch(mid)){
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        System.out.println(result);
    }
    public static boolean binarySearch(int mid){
        int point=0;
        for(int i=0;i<m;i++){
           // System.out.println(arr[i]);
            if(point+mid>=arr[i]){
                point=arr[i]+mid;
            }else{
                return false;
            }
        }
        //System.out.println(mid+" "+point);
        if(point<n){
            return false;
        }
        return true;

    }
}
