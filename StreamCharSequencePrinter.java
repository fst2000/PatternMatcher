import java.io.PrintStream;

public class StreamCharSequencePrinter implements CharSequencePrinter
{
    PrintStream stream;

    public StreamCharSequencePrinter(PrintStream stream)
    {
        this.stream = stream;
    }
    public void print(CharSequence sequence)
    {
        int length = sequence.length();
        for(int i = 0; i < length; i++)
        {
            stream.print(sequence.charAt(i));
        }
    }
}
