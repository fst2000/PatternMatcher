import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputStreamPrinter implements Printer
{
    PrintWriter writer;
    public OutputStreamPrinter(OutputStream stream)
    {
        writer = new PrintWriter(stream);

    }
    public void print(Text text)
    {
        for(int i = 0; i < text.length(); i++)
        {
            writer.print(text.at(i));
        }
        writer.flush();
    }
}
