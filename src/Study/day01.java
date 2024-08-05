package Study;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;


public class day01 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int h=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int high=Math.max(h,w);
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(a>high || b>high){
                continue;
            }
            list.add(new int[]{a,b});
        }

        int MAX_VALUE=0;
        int k=list.size();
        for(int i=0;i<k-1;i++){
            int ai=list.get(i)[0];
            int bi=list.get(i)[1];

            for(int j=i+1;j<k;j++){
                int aj=list.get(j)[0];
                int bj=list.get(j)[1];
                //System.out.println(ai+" "+bi+" "+aj+" "+bj+" "+h+" "+w);
                if(2*h>=ai+aj&&w>=bi+bj){
                    MAX_VALUE=Math.max(ai*bi+aj*bj,MAX_VALUE);
                }else if(2*h>=ai+bj&&w>=bi+aj){
                    MAX_VALUE=Math.max(ai*bi+aj*bj,MAX_VALUE);
                }else if(2*h>=bi+aj&&w>=ai+bj){
                    MAX_VALUE=Math.max(ai*bi+aj*bj,MAX_VALUE);
                }else if(2*h>=bi+bj&&w>=ai+aj){
                    MAX_VALUE=Math.max(ai*bi+aj*bj,MAX_VALUE);
                }else if(h>=ai+aj&&2*w>=bi+bj){
                    MAX_VALUE=Math.max(ai*bi+aj*bj,MAX_VALUE);
                }else if(h>=ai+bj&&2*w>=bi+aj){
                    MAX_VALUE=Math.max(ai*bi+aj*bj,MAX_VALUE);
                }else if(h>=bi+aj&&2*w>=ai+bj){
                    MAX_VALUE=Math.max(ai*bi+aj*bj,MAX_VALUE);
                }else if(h>=bi+bj&&2*w>=ai+aj){
                    MAX_VALUE=Math.max(ai*bi+aj*bj,MAX_VALUE);
                }
            }
        }
        System.out.println(MAX_VALUE);


//        Collections.sort(list,new Comparator<int[]>(){
//            @Override
//            public int compare(int[] o1,int[] o2){
//                int o11=o1[0]*o1[1];
//                int o22=o2[0]*o2[1];
//                return o22-o11;
//            }
//        });

//        for(int i=0;i<list.size();i++){
//            System.out.println(Arrays.toString(list.get(i)));
//        }
    }
}
