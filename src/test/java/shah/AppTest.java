package shah;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AppTest {
    @Test
    public void testThatDefaultCaseWorks() {
        String input = "6 7\n1 2 3 9 10 12";
        FakeInAndOut fakeInAndOut = process(input);
        assertThat(fakeInAndOut.getOut(), equalTo("2\n"));
    }
    @Test
    public void testThatTrivalCaseWorks() {
        String input = "4 7\n10 10 22 193";
        FakeInAndOut fakeInAndOut = process(input);
        assertThat(fakeInAndOut.getOut(), equalTo("0\n"));
    }
    @Test
    public void testThatNoSolutionCaseWorks() {
        String input = "6 2000\n1 2 3 9 10 12";
        FakeInAndOut fakeInAndOut = process(input);
        assertThat(fakeInAndOut.getOut(), equalTo("-1\n"));
    }
    @Test
    public void testThatSolutionCaseWorks2() {
        String input = "6 105\n1 2 3 9 10 12";
        // 3 5 9 10 12
        //  9 10 12 13
        // 12 13 29
        // 29 38
        // 105

        FakeInAndOut fakeInAndOut = process(input);
        assertThat(fakeInAndOut.getOut(), equalTo("5\n"));
    }
    @Test
    public void testThatNoSolutionCaseWorks2() {
        String input = "6 106\n1 2 3 9 10 12";
        // 3 5 9 10 12
        //  9 10 12 13
        // 12 13 29
        // 29 38
        // 105

        FakeInAndOut fakeInAndOut = process(input);
        assertThat(fakeInAndOut.getOut(), equalTo("-1\n"));
    }
    @Test
    public void testThatSolutionCaseWorks() {
        String input = "6 65\n1 2 3 9 10 12";
        FakeInAndOut fakeInAndOut = process(input);
        assertThat(fakeInAndOut.getOut(), equalTo("5\n"));
    }
    @Test
    public void testThatShortCaseWorks() {
        String input = "1 65\n3";
        FakeInAndOut fakeInAndOut = process(input);
        assertThat(fakeInAndOut.getOut(), equalTo("-1\n"));
    }
    @Test
    public void testThatShortCase2Works() {
        String input = "1 3\n5";
        FakeInAndOut fakeInAndOut = process(input);
        assertThat(fakeInAndOut.getOut(), equalTo("0\n"));
    }

    private FakeInAndOut process(String input) {
        FakeInAndOut fakeInAndOut = new FakeInAndOut(input);
        Runner runner = new Runner(fakeInAndOut);
        runner.run();
        return fakeInAndOut;
    }
}
