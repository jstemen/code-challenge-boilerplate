/**
 * Once you've tested your code to your heart's desire, just copy and paste this whole file into Hacker Rank and submit it.
 */
import java.io.InputStream;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * An interface that supplies Standard In and Standard Out
 */
interface InAndOut {

    public InputStream getStdIn();

    public PrintStream getStdOut();

}

/**
 * Wrapper implantation that just passes StdIn and StdOut to caller
 */
class RealSystem implements InAndOut {
    public InputStream getStdIn() {
        return System.in;
    }

    public PrintStream getStdOut() {
        return System.out;
    }
}

/**
 * Class to house problem solving logic
 */
class Runner {
    private InAndOut inAndOut;

    public Runner(InAndOut inAndOut) {
        this.inAndOut = inAndOut;
    }

    //Change logic here to solve problem...
    public void run() {
        Scanner sc = new Scanner(inAndOut.getStdIn());
        int n = sc.nextInt();
        int reqSweet = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < n; i++) {
            Integer el = sc.nextInt();
            pq.add(el);
        }
        int steps = 0;
        boolean successful = false;
        while (pq.size() >= 2) {
            if (pq.peek() >= reqSweet) {
                break;
            } else {
                int min = pq.poll();
                int secMin = pq.poll();
                pq.add(min + 2 * secMin);
                steps++;
            }
        }
        if (pq.size() > 0 && pq.peek() >= reqSweet) {
            successful = true;
        }
        if (successful) {
            inAndOut.getStdOut().println(steps);
        } else {
            inAndOut.getStdOut().println(-1);
        }
    }
}

/**
 * When we execute in the Hacker Rank environment, we want to use the real Stdin and Stdout
 */
public class Solution {
    public static void main(String[] args) {
        InAndOut real = new RealSystem();
        Runner runner = new Runner(real);
        runner.run();
    }
}
