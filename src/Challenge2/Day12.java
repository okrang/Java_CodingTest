package Challenge2;

import java.io.*;
import java.util.*;

public class Day12 {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int l=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int count=0;
        Queue<Integer> bridgeq=new LinkedList<>();
        Queue<Integer> truckq=new LinkedList<>();
        //bridgeq.add(Integer.parseInt(st.nextToken()));
        for(int i=0;i<n;i++){
            truckq.add(Integer.parseInt(st.nextToken()));
        }
        int weight=0;
        for(int i=0;i<w;i++){
            bridgeq.add(0);
        }

        while(!bridgeq.isEmpty()){
            count++;
            weight-=bridgeq.poll();
            if(!truckq.isEmpty()){
                int truck=truckq.peek();
                if(truck+weight<=l){
                    weight+=truck;
                    bridgeq.add(truckq.poll());
                }else{
                    bridgeq.add(0);
                }

            }


        }


        System.out.println(count);
    }
}
