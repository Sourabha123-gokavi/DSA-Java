import java.util.HashSet;

public class Union_intersection {
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        HashSet<Integer>set=new HashSet<>();
        // add elements in the set from the array 1
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        // checking the elements if present or not
        int count=0;
        for(int i=0;i<arr2.length;i++){
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }
        System.out.println("The number of elements in the intersection of two array are "+count);

        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        System.out.println("The number of elements in the union of the two array are "+set.size());

    }
}
