package Study;
import java.io.*;
import java.util.*;
public class Day23 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int k=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int [] votes=new int[101];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            int vote=Integer.parseInt(st.nextToken());

            if(list.size()<n){
                if(votes[vote]==0){
                    list.add(vote);
                }

                votes[vote]=votes[vote]+1;
                //System.out.println(vote+" "+votes[vote]);
            }else{

                int mincount=Integer.MAX_VALUE;
                int deleteStdnt=0;
                int idx=-1;
                boolean isContain=false;

                for(int j=0;j<n;j++){
                    int tmp=list.get(j);

                    if(votes[vote]>0){

                        votes[vote]=votes[vote]+1;
                        isContain=true;
                        break;
                    }

                    if(votes[tmp]<mincount){
                        mincount=votes[tmp];
                        idx=j;
                        deleteStdnt=tmp;
                    }
                }
                if(isContain==false){
                    list.remove(idx);
                    votes[deleteStdnt]=0;
                    votes[vote]=1;
                    list.add(vote);

                }



            }
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }
}
