package shah;
import java.io.*;
import java.util.*;

interface InAndOut{

    public InputStream getStdIn();
    public PrintStream getStdOut();

}
class RealSystem implements  InAndOut{
    public InputStream getStdIn() {
        return System.in;
    }

    public PrintStream getStdOut() {
        return System.out;
    }
}
class Runner{
    private InAndOut inAndOut;
    public Runner(InAndOut inAndOut){
       this.inAndOut = inAndOut;
    }
   public void run(){
       Scanner sc = new Scanner(inAndOut.getStdIn());
       int n = sc.nextInt();
       int reqSweet = sc.nextInt();
       PriorityQueue<Integer> pq = new PriorityQueue();
       for(int i=0; i< n-1; i++){
           Integer el = sc.nextInt();
           pq.add(el);
       }
       int steps =0;
       while(steps < pq.size()){
           if(pq.peek() >= reqSweet){
               break;
           }else{
               int min = pq.poll();
               int secMin = pq.poll();
               pq.add(min + 2*secMin);
               steps++;
           }
       }
       if(steps == pq.size()){
           inAndOut.getStdOut().println(-1);
       }else{
           inAndOut.getStdOut().println(steps);
       }
   }
}
public class Solution
{
    public static void main( String[] args )
    {
    }
}
