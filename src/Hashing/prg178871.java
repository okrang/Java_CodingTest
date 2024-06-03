package Hashing;
import java.util.*;
public class prg178871 {

    class Solution {
        public String[] solution(String[] players, String[] callings) {
            String[] answer = {};
            answer=new String[players.length];
            Map<String,Integer> map=new HashMap<>();
            Map<Integer,String>map2=new HashMap<>();
            for(int i=0;i<players.length;i++){
                map.put(players[i],i);
                map2.put(i,players[i]);
            }
            for(int i=0;i<callings.length;i++){
                int order=map.get(callings[i]);
                String reverse=map2.get(order-1);
                map.put(callings[i],order-1);
                map.put(reverse,order);
                map2.put(order,reverse);
                map2.put(order-1,callings[i]);
            }
            List<Integer> keyset=new ArrayList<>(map2.keySet());
            Collections.sort(keyset);
            for(int i=0;i<keyset.size();i++){
                answer[i]=map2.get(keyset.get(i));
            }
            return answer;
        }
    }
}
