package implement;

public class pg258721_kakaointern {
    import java.util.*;
    class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;
            //주고받은 선물 2차원 배열 정리
            int giftchange[][]=new int[friends.length][friends.length];
            //선물 지수
            int giftsum[]=new int[friends.length];
            int giftcount=gifts.length;
            //사람수
            int fcount=friends.length;
            //주고받은 횟수
            for(int i=0;i<giftcount;i++){
                String tmp=gifts[i];
                String[] tmps=tmp.split(" ");
                int from=Arrays.asList(friends).indexOf(tmps[0]);
                int to=Arrays.asList(friends).indexOf(tmps[1]);
                giftchange[from][to]++;
            }
            //선물지수
            for(int i=0;i<giftsum.length;i++){
                int give=0;
                for(int j=0;j<giftsum.length;j++){
                    give+=giftchange[i][j];
                }
                int receive=0;
                for(int j=0;j<giftsum.length;j++){
                    receive+=giftchange[j][i];
                }
                giftsum[i]=give-receive;
            }
            //System.out.println(Arrays.toString(giftsum));
            int []giftnext=new int[fcount];
            for(int i=0;i<fcount;i++){
                for(int j=i+1;j<fcount;j++){

                    //System.out.println(giftcount);
                    if(giftchange[i][j]>giftchange[j][i]){
                        giftnext[i]++;
                    }else if(giftchange[i][j]<giftchange[j][i]){
                        giftnext[j]++;
                    }else{
                        if(giftsum[i]>giftsum[j]){
                            giftnext[i]++;
                        }else if(giftsum[i]<giftsum[j]){
                            giftnext[j]++;
                        }
                    }
                }
            }
            //System.out.println(Arrays.toString(giftnext));
            for(int i=0;i<fcount;i++){
                if(giftnext[i]>answer){
                    answer=giftnext[i];
                }
            }



            return answer;
        }
    }
}
