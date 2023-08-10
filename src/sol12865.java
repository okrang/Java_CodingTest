import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class sol12865 {
    static int [] graphw;
    static int [] graphv;

    public static void main(String[] args) throws IOException {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        graphw=new int[n+1];
        graphv=new int[n+1];
        int [][] dp=new int[n+1][k+1];

        for(int i=0;i<n+1;i++){
            st=new StringTokenizer(br.readLine());
            graphw[i]=Integer.parseInt(st.nextToken());
            graphv[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<k+1;k++){
                if(j-graphw[i]>=0){
                    dp[i][j]=Math.max(dp[i-1][j],graphv[i]+dp[i-1][j-graphw[i]]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }

            }
        }


        System.out.println(dp[n][k]);



    }

}