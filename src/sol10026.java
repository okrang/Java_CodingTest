// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class sol10026 {
    static int n;
    static String graph[][];
    static boolean rbvisit[][];
    static boolean visit[][];
    static int rbcount;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        graph=new String[n][n];
        for(int i=0;i<n;i++){
            String str=br.readLine();
            graph[i]=str.split("");
        }
        rbvisit=new boolean[n][n];
        visit=new boolean[n][n];
        count=0;
        rbcount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    dfs(i,j,graph[i][j]);
                    count++;
                }
                if(!rbvisit[i][j]){
                    rbdfs(i,j,graph[i][j]);
                    rbcount++;

                }
            }
        }

        System.out.println(count);
        System.out.println(rbcount);



    }
    public static void rbdfs(int i,int j,String color){
        int[] ci={0,1,0,-1};
        int[] cj={1,0,-1,0};
        rbvisit[i][j]=true;
        for(int a=0;a<4;a++){
            int di=i+ci[a];
            int dj=j+cj[a];
            if(di>=0&&dj>=0&&di<n&&dj<n){
                if(color.equals("B")){
                    if(rbvisit[di][dj]==false&&graph[di][dj].equals(color)){
                        rbdfs(di,dj,color);
                    }

                }else{
                    if(rbvisit[di][dj]==false&&!graph[di][dj].equals("B")){
                        rbdfs(di,dj,color);
                    }
                }

            }
        }
    }
    public static void dfs(int i,int j,String color){
        int[] ci={0,1,0,-1};
        int[] cj={1,0,-1,0};
        visit[i][j]=true;
        for(int a=0;a<4;a++){
            int di=i+ci[a];
            int dj=j+cj[a];
            if(di>=0&&dj>=0&&di<n&&dj<n){
                if(visit[di][dj]==false&&graph[di][dj].equals(color)){
                    dfs(di,dj,color);
                }

            }
        }

    }
}