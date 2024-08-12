package Study;
import java.io.*;
import java.util.*;
public class Day08 {
    static boolean[][][] visited;
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        visited=new boolean[a+1][b+1][c+1];
        ArrayList<Integer> arr=new ArrayList<>();
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,c});
        while(!q.isEmpty()){
            int[] w=q.poll();
            int a1=w[0];
            int b1=w[1];
            int c1=w[2];
            //System.out.println(a1+" "+b1+" "+c1);
            if(visited[a1][b1][c1]==true) continue;
            visited[a1][b1][c1]=true;
            if(a1==0){
                arr.add(c1);
            }

            if(a1!=0){
                int tmpab=Math.min(a1,b-b1);
                q.add(new int[]{a1-tmpab,b1+tmpab,c1});
                int tmpac=Math.min(a1,c-c1);
                q.add(new int[]{a1-tmpac,b1,c1+tmpac});

            }
            if(b1!=0){
                int tmpba=Math.min(b1,a-a1);
                q.add(new int[]{a1+tmpba,b1-tmpba,c1});
                int tmpbc=Math.min(b1,c-c1);
                q.add(new int[]{a1,b1-tmpbc,c1+tmpbc});

            }
            if(c1!=0){
                int tmpca=Math.min(a-a1,c1);
                q.add(new int[]{a1+tmpca,b1,c1-tmpca});
                int tmpcb=Math.min(b-b1,c1);
                q.add(new int[]{a1,b1+tmpcb,c1-tmpcb});

            }
        }
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
}
