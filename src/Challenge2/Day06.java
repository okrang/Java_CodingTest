package Challenge2;
import java.io.*;
import java.util.*;
public class Day06 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] arr=new int[n][m];
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=arr[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0) continue;
                if(j==0&&i!=0){
                    dp[i][j]=dp[i-1][j]+arr[i][j];
                }else if(i==0&&j!=0){
                    dp[i][j]=dp[i][j-1]+arr[i][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+arr[i][j];
                }
            }
        }
        System.out.println(dp[n-1][m-1]);




    }
}
