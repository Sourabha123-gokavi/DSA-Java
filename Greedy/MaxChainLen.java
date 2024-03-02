import java.util.*;
public class MaxChainLen {
    public static void main(String[] args) {

        // Time complexity is going to be the O(n*log(n)) because sorting is used
        int pair[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
        // sort the array based on 2nd value
        Arrays.sort(pair,Comparator.comparingDouble(o->o[1]));
        int ChainLen=1;
        int LastEnd=pair[0][1];
        for(int i=1;i<pair.length;i++){
            if(LastEnd<pair[i][0]){
                ChainLen++;
                LastEnd=pair[i][1];
            }
        }
        System.out.println("The maximum chain length is =>"+ChainLen);
    }

}
