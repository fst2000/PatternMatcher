
public class JoinPrinter implements Printer
{
    Printer printer;
    Text join;
    boolean hasFirst;

    public JoinPrinter(Printer printer, Text join)
    {
        this.printer = printer;
        this.join = join;
    }

    @Override
    public void print(Text text)
    {
        if(hasFirst)
        {
            printer.print(join);
        }
        printer.print(text);
        hasFirst = true;
    }
}