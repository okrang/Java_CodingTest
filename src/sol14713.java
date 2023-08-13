// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class sol14713 {
    public static void main(String[] args) throws IOException{
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Queue<String>> qarr=new ArrayList<>();
        StringTokenizer st;
        int birdword=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            Queue<String> q=new LinkedList<>();
            while(st.hasMoreTokens()){
               q.offer(st.nextToken());
               birdword++;

            }

            qarr.add(q);

        }
        Queue<String> sentences=new LinkedList<String>();
        st=new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            sentences.offer(st.nextToken());
        }
        boolean poss=true;


        String str;
        int wordcount= sentences.size();

        if(wordcount!=birdword){
            System.out.println("Impossible");
            return;
        }

        for(int i=0;i<wordcount;i++){
            str=sentences.poll();


            for(int j=0;j<qarr.size();j++){
                if(str.equals(qarr.get(j).peek())){
                    qarr.get(j).poll();
                    if(qarr.get(j).size()==0){
                        qarr.remove(j);
                    }
                    if(j!=qarr.size()-1){
                        break;
                    }

                }else{
                    if(j==qarr.size()-1){
                        poss=false;
                        break;
                    }
                }


            }



            if(poss==false){
                break;
            }

        }


        if(poss==true){
            System.out.println("Possible");
        }else{
            System.out.println("Impossible");

        }










    }
}