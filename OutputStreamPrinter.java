import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputStreamPrinter implements Printer
{
    PrintWriter writer;
    public OutputStreamPrinter(OutputStream stream)
    {
        writer = new PrintWriter(stream);

    }
    public void print(CharSequence sequence)
    {
        for(int i = 0; i < sequence.length(); i++)
        {
            writer.print(sequence.charAt(i));
        }
        writer.flush();
    }
}
