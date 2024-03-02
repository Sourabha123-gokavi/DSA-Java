import java.util.*;
public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[]={1,2,5,10,20,50,100,200,500,1000,2000};
        Arrays.sort(coins,Comparator.reverseOrder());
        ArrayList<Integer> ans=new ArrayList<>();
        int CountCoins=0;
        int Amount=590;
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=Amount){
                while(coins[i]<=Amount){
                    CountCoins++;
                    ans.add(coins[i]);
                    Amount-=coins[i];
                }
            }
        }
        System.out.println("The minium number of coins ="+CountCoins);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
    }
}
