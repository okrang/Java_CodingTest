package Study;
import java.io.*;
import java.util.*;
public class Day09 {
    static int[] arrb;
    static long c;
    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int k=0;k<t;k++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int[] arra=new int[n];
            arrb=new int[m];
            c=0L;
            st=new StringTokenizer(br.readLine());

            for(int i=0;i<n;i++){
                arra[i]=Integer.parseInt(st.nextToken());
            }
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++){
                arrb[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrb);
            for(int i=0;i<n;i++){
              //  System.out.println(arra[i]);
                binarySearch(arra[i],0,m-1);
            }


            System.out.println(c);

        }
    }
    public static void binarySearch(int target, int start, int end){
        if(start>end){
            if(start==arrb.length){
                c+=arrb[end];
                return;
            }
            if(end<0){
                c+=arrb[0];
                return;
            }

            if(Math.abs(arrb[start]-target)>=Math.abs(arrb[end]-target)){
                c+=arrb[end];
                return;
            }else{
                c+=arrb[start];
                return;

            }
        }
        int mid=(start+end)/2;
        if(target>arrb[mid]){
         //   System.out.println("small"+arrb[mid]);
            binarySearch(target,mid+1,end);
        }else if(target<arrb[mid]){
           // System.out.println(arrb[mid]);

            binarySearch(target,start,mid-1);
        }else{
            c+=arrb[mid];
        }

    }
}
