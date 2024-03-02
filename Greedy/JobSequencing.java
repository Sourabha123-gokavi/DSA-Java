import java.util.*;
public class JobSequencing {
    static class Job{
        int id;
        int deadline;
        int profit;
        public Job(int i,int d,int p){
            id=i;
            deadline=d;
            profit=p;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
        
        // creating the arraylist of own created class
        ArrayList<Job>jobs=new ArrayList<>();
        for(int i=0;i<jobInfo.length;i++){
            jobs.add(new Job(i,jobInfo[i][0],jobInfo[i][1]));
        }
        // now sorting the arraylist using lambda function
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);
        //obj2.profit-obj1.profit    =>this will sort the in descending order

        ArrayList<Integer> seq=new ArrayList<>();
        int time=0;

        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadline>time){
                seq.add(curr.id);
                time++;
            }
        }
        System.out.println("Max jobs that can be runned are = "+time);
        for(int i=0;i<seq.size();i++){
            System.out.print((char)(seq.get(i)+'A')+" ");
        }

    }
}
