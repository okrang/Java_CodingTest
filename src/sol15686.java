
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
import java.io.*;
public class sol15686 {
    static int n,m;
    static int graph[][];
    static int min=Integer.MAX_VALUE;
    static ArrayList<Node> chickenList=new ArrayList<>();
    static ArrayList<Node> houseList=new ArrayList<>();
    static boolean [] chickenVisited;

    public static void main(String[] args) throws IOException{
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st=new StringTokenizer(st.nextToken());
            for(int j=0;j<n;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==1) houseList.add(new Node(i,j));
                if(graph[i][j]==2) chickenList.add(new Node(i,j));
            }
        }
        chickenVisited=new boolean[chickenList.size()];
        backtracking(0,0);






    }
    public static void backtracking(int count,int idx){
            if(count==m){
                int total=0;
                for(int i=0;i<houseList.size();i++){
                    int sum=Integer.MAX_VALUE;
                    for(int j=0;j<chickenList.size();j++){
                        if(chickenVisited[j]==true){
                            int dist=Math.abs(houseList.get(i).x-chickenList.get(j).x)+
                                    Math.abs(houseList.get(i).y-chickenList.get(j).y);
                            sum=Math.min(sum,dist);

                        }
                    }
                    total+=sum;
                }
                min=Math.min(total,min);
                return;
            }
            for(int i=idx;i< chickenList.size();i++){
                if(chickenVisited[i]==false){
                    chickenVisited[i]=true;
                    backtracking(count+1,i+1);
                    chickenVisited[i]=false;
                }
            }
    }
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }

    }
}