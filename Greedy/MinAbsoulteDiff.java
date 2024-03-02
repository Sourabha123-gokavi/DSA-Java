import java.util.*;
public class MinAbsoulteDiff {
    public static void main(String[] args) {
        int A[]={1,2,5,4,3};
        int B[]={3,4,5,1,2};
        Arrays.sort(A);
        Arrays.sort(B);
        int MinDiff=0;
        for(int i=0;i<A.length;i++){
            MinDiff+=Math.abs(A[i]-B[i]);
        }
        System.out.println("The min Absoulte difference is =>"+MinDiff);
    }
}
