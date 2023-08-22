import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sol15655 {
    static int n,m;
    static int [] arr;
    static int [] result;
    static StringBuilder sb;
    static boolean [] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n];
        sb=new StringBuilder();
        visit=new boolean[n];
        result=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        back(0,0);

        System.out.print(sb);


    }
    public static void back(int depth,int start){
        if(depth==m){
            for(int i=0;i<m;i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            //sb.delete(sb.length()-2,sb.length());
            return;
        }
        for(int i=start;i<n;i++){
            if(visit[i]==false){
                visit[i]=true;
                result[depth]=arr[i];
                back(depth+1,i);
                visit[i]=false;

            }


        }
    }


}