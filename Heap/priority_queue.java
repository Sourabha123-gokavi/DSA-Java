import java.util.Comparator;
import java.util.PriorityQueue;
public class priority_queue {

    // priority queue for the objects
    static class Student implements Comparable <Student>{
        String name;
        int roll;
        Student(String name,int roll){
            this.name=name;
            this.roll=roll;
        }
        @Override
        public int compareTo(Student s2){
            return this.roll-s2.roll;
        }
    }




    public static void main(String[] args) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        PriorityQueue<Integer>pqr=new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(4);
        pq.add(1);
        pq.add(6);
        pq.add(2);

        pqr.add(4);
        pqr.add(1);
        pqr.add(6);
        pqr.add(2);
        while(!pq.isEmpty() && !pqr.isEmpty()){
            System.out.println(" min prior ->"+" "+pq.peek()+"max prior ->"+pqr.peek());
            pq.remove();
            pqr.remove();
        }


        PriorityQueue<Student>pqs=new PriorityQueue<>();
        pqs.add(new Student("Sourabha", 27));
        pqs.add(new Student("M.S.Dhoni", 7));
        pqs.add(new Student("Virat", 18));
        pqs.add(new Student("Shubmann", 77));
        pqs.add(new Student("Rohit", 45));

        while(!pqs.isEmpty() ){
            System.out.println(pqs.peek().name);
            pqs.remove(); 
        }
    }
}
