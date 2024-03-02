import java.util.*;
public class Chocoloa{
    public static void main(String[] args) {
        Integer costHor[]={2,1,3,1,4};
        Integer costVer[]={4,1,2};
        int n=4;
        int m=6;
        // sort the array in reverse order
        Arrays.sort(costHor,Collections.reverseOrder());
        Arrays.sort(costVer,Collections.reverseOrder());
        // 2 pointer approach
        int h=0,v=0;
        int hp=1,vp=1;
        int cost=0;
        while(h<costHor.length && v<costVer.length){
            // horizontal cut
            if(costHor[h]>=costVer[v]){
                cost=cost+vp*(costHor[h]);
                h++;
                hp++;
            }
            // vertical cut
            else{
                cost=cost+hp*(costVer[v]);
                v++;
                vp++;
            }
        }
        while(h<costHor.length){
            cost=cost+vp*(costHor[h]);
            h++;
            hp++;
        }
        while(v<costVer.length){
            cost=cost+hp*(costVer[v]);
            v++;
            vp++;
        }
        System.out.println("The minium cost ="+cost);
    }
}