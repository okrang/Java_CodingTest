import java.util.*;
import java.io.*;
public class sol15654 {
    static int n,m;
    static int [] result;
    static int [] ints;
    static boolean [] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        ints=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            ints[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ints);
        result=new int[m];
        visit=new boolean[n];
        back(0);



    }
    public static void back(int depth){
        if(depth==m){
            for(int i=0;i<m;i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0;i<n;i++){
            if(visit[i]==false){
             visit[i]=true;
             result[depth]=ints[i];
             back(depth+1);
             visit[i]=false;
            }

        }
    }


}