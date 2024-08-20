package Study;

import java.io.*;
import java.util.*;

public class Day16 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(br.readLine());
        boolean [][] hori=new boolean[n+1][m+1];
        boolean [][] verti=new boolean[n+1][m+1];
        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()) ;
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            if(a==c){
                verti[a][Math.max(b,d)]=true;
            }else if(b==d){
                hori[Math.max(a,c)][b]=true;
            }
//            System.out.println(Math.max(a,c));
//            System.out.println(verti[a][Math.max(b,d)]);
//
//            System.out.println(hori[Math.max(a,c)][b]);
        }
        long[][] dp=new long[n+1][m+1];

        for(int i=1;i<n+1;i++){
            if(hori[i][0]==false){
                dp[i][0]=1;
            }else{
                break;
            }
        }

        for(int i=1;i<m+1;i++){
            if(verti[0][i]==false){
                dp[0][i]=1;
            }else{
                break;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){

                if(hori[i][j]==true&&verti[i][j]==true){
                    dp[i][j]=0;
                }else if(verti[i][j]==true){
                    dp[i][j]=dp[i-1][j];
                }else if(hori[i][j]==true){
                    dp[i][j]=dp[i][j-1];
                }else{
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
//        for(int i=0;i<n+1;i++){
//            for(int j=0;j<m+1;j++){
//                System.out.print(dp[i][j]+" ");
//
//            }
//            System.out.println();
//
//        }

//        System.out.println(n);
//        System.out.println(m);
        System.out.println(dp[n][m]);

    }
}
