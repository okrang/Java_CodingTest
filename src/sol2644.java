// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class sol2644 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean [] visit;
    static int count;
    static int p1;
    static int p2;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        p1=Integer.parseInt(st.nextToken());
        p2=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(br.readLine());
        graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        visit=new boolean[n+1];
        count=-1;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);

        }

        dfs(p1,0);
        System.out.println(count);


    }

    public static void dfs(int node,int tmpcount) {
        visit[node]=true;
        for(int i=0;i<graph.get(node).size();i++) {
            int next=graph.get(node).get(i);
            if(!visit[next]){
                if(next==p2){
                    tmpcount++;
                    count=tmpcount;
                   // return;
                }else{
                    dfs(next,tmpcount+1);

                }
            }

        }

    }
}