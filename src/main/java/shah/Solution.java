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
       boolean successful = false;
       while(steps < pq.size()){
           if(pq.peek() >= reqSweet){
               successful = true;
               break;
           }else{
               int min = pq.poll();
               int secMin = pq.poll();
               pq.add(min + 2*secMin);
               steps++;
           }
       }
       if(successful){
           inAndOut.getStdOut().println(steps);
       }else{
           inAndOut.getStdOut().println(-1);
       }
   }
}
public class Solution
{
    public static void main( String[] args )
    {
    }
}
