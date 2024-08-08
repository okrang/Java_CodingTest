package Study;
import java.io.*;
import java.util.*;
public class Day04 {
    static int k;
    static char [] arr;
    static long MAX_Long;
    static long MIN_Long;
    static boolean [] visited;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        k=Integer.parseInt(st.nextToken());
        arr=new char[k];
        MAX_Long=0;
        MIN_Long=Long.MAX_VALUE;
        visited=new boolean[10];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            arr[i]=st.nextToken().charAt(0);
        }
        for(int i=0;i<10;i++){
            visited[i]=true;
            dfs(i,i+"",1);
            Arrays.fill(visited,false);
        }
        String maxlong=MAX_Long+"";
        String minlong=MIN_Long+"";
        if(maxlong.length()==k){
            maxlong="0"+maxlong;
        }
        if(minlong.length()==k){
            minlong="0"+minlong;
        }
        System.out.println(maxlong);
        System.out.println(minlong);
    }
    public static void dfs(int a,String str, int count){
        if(count==k+1){
            MAX_Long=Math.max(MAX_Long,Long.parseLong(str));
            MIN_Long=Math.min(MIN_Long,Long.parseLong(str));
            return;
        }
        char ch=arr[count-1];
        for(int i=0;i<10;i++){
            if(visited[i]==false){
                if(ch=='>'&&a>i){
                    visited[i]=true;
                    dfs(i,str+i,count+1);
                    visited[i]=false;
                }else if(ch=='<'&&a<i){
                    visited[i]=true;
                    dfs(i,str+i,count+1);
                    visited[i]=false;
                }
            }

        }



    }
}
