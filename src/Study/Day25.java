package Study;
import java.io.*;
import java.util.*;
class Node{
    int x;
    ArrayList<Integer> yList;
    public Node(int x, int y){
        this.x=x;
        yList=new ArrayList<>();
        yList.add(y);
    }
    public void addY(int y){
        yList.add(y);
    }
    public ArrayList<Integer> getY(){
        return this.yList;
    }
}
public class Day25 {

    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        Node[] nodes=new Node[n+1];
        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            if(nodes[x]==null){
                Node node=new Node(x,y);
                nodes[x]=node;
            }else{
                nodes[x].addY(y);
            }

            if(nodes[y]==null){
                Node node=new Node(y,x);
                nodes[y]=node;
            }else{
                nodes[y].addY(x);
            }
        }
//        for(int i=0;i<nodes[6].getY().size();i++){
//            System.out.println(nodes[6].getY().get(i));
//        }
        int [] result=new int[n+1];
        Queue<Integer> q=new LinkedList<>();

        q.add(1);
        result[1]=-1;
        while(!q.isEmpty()){
            int x=q.poll();
            //System.out.println(x);
            Node node=nodes[x];
            //System.out.println(node.x);
            ArrayList<Integer> list=node.getY();
            for(int i=0;i<list.size();i++){
              //  System.out.println(list.get(i));
                if(result[list.get(i)]==0) {
                    q.add(list.get(i));
                    result[list.get(i)] = node.x;
                }
            }


        }
        for(int i=2;i<n+1;i++){
            System.out.println(result[i]);
        }
    }

}
