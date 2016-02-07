
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AppTest {
    @Test
    public void testThatDefaultCaseWorks() {
        FakeInAndOut fakeInAndOut = process("6 7","1 2 3 9 10 12");
        assertThat(fakeInAndOut.getOut(), equalTo("2\n"));
    }
    @Test
    public void testThatTrivalCaseWorks() {
        FakeInAndOut fakeInAndOut = process("4 7","10 10 22 193");
        assertThat(fakeInAndOut.getOut(), equalTo("0\n"));
    }
    @Test
    public void testThatNoSolutionCaseWorks() {
        FakeInAndOut fakeInAndOut = process("6 2000","1 2 3 9 10 12");
        assertThat(fakeInAndOut.getOut(), equalTo("-1\n"));
    }
    @Test
    public void testThatSolutionCaseWorks2() {
        FakeInAndOut fakeInAndOut = process("6 105","1 2 3 9 10 12");
        // 3 5 9 10 12
        //  9 10 12 13
        // 12 13 29
        // 29 38
        // 105
        assertThat(fakeInAndOut.getOut(), equalTo("5\n"));
    }
    @Test
    public void testThatNoSolutionCaseWorks2() {
        FakeInAndOut fakeInAndOut = process("6 106","1 2 3 9 10 12");
        assertThat(fakeInAndOut.getOut(), equalTo("-1\n"));
    }
    @Test
    public void testThatSolutionCaseWorks() {
        FakeInAndOut fakeInAndOut = process("6 65","1 2 3 9 10 12");
        assertThat(fakeInAndOut.getOut(), equalTo("5\n"));
    }
    @Test
    public void testThatShortCaseWorks() {
        FakeInAndOut fakeInAndOut = process("1 65","3");
        assertThat(fakeInAndOut.getOut(), equalTo("-1\n"));
    }
    @Test
    public void testThatShortCase2Works() {
        FakeInAndOut fakeInAndOut = process("1 3","5");
        assertThat(fakeInAndOut.getOut(), equalTo("0\n"));
    }

    /**
     * Runs our solver with the specified input and returns the output
     * @param lines - Strings that is sent to solver over StdIn ( joined with newline)
     * @return - What our solver prints to StdOut
     */
    private FakeInAndOut process(String... lines) {

        StringBuilder sb = new StringBuilder();
        for(String line : lines){
           sb.append(line);
           sb.append("\n");
        }

        FakeInAndOut fakeInAndOut = new FakeInAndOut(sb.toString());
        Runner runner = new Runner(fakeInAndOut);
        runner.run();
        return fakeInAndOut;
    }
}
