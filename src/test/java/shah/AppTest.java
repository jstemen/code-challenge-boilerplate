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
    public void testThatNoSolutionCaseWorks() {
        String input = "6 2000\n1 2 3 9 10 12";
        FakeInAndOut fakeInAndOut = process(input);
        assertThat(fakeInAndOut.getOut(), equalTo("-1\n"));
    }
    @Test
    public void testThatNoSolutionCaseWorks2() {
        String input = "6 12\n1 2 3 9 10 12";
        FakeInAndOut fakeInAndOut = process(input);
        assertThat(fakeInAndOut.getOut(), equalTo("-1\n"));
    }
    @Test
    public void testThatSolutionCaseWorks() {
        String input = "6 10\n1 2 3 9 10 12";
        FakeInAndOut fakeInAndOut = process(input);
        assertThat(fakeInAndOut.getOut(), equalTo("-1\n"));
    }

    private FakeInAndOut process(String input) {
        FakeInAndOut fakeInAndOut = new FakeInAndOut(input);
        Runner runner = new Runner(fakeInAndOut);
        runner.run();
        return fakeInAndOut;
    }
}
