
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * An implementation of InAndOut that lets us send whatever we want to StdIn and check to see what we get on StdOut
 */
public class FakeInAndOut implements InAndOut {
    private final String fakeInStr;
    private final PrintStream printStream;
    private final ByteArrayOutputStream baos;

    public FakeInAndOut(String fakeIn) {
        this.fakeInStr = fakeIn;
        baos = new ByteArrayOutputStream();
        printStream = new PrintStream(baos);

    }

    public InputStream getStdIn() {
        InputStream stream = new ByteArrayInputStream(fakeInStr.getBytes(StandardCharsets.UTF_8));
        return stream;
    }

    public PrintStream getStdOut() {
        return printStream;
    }

    public String getOut() {
        try {
            return baos.toString("UTF8"); // e.g. ISO-8859-1
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
