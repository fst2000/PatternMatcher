
public class JoinPrinter implements Printer
{
    Printer printer;
    CharSequence join;
    boolean hasFirst;

    public JoinPrinter(Printer printer, CharSequence join)
    {
        this.printer = printer;
        this.join = join;
    }

    @Override
    public void print(CharSequence sequence)
    {
        if(hasFirst)
        {
            printer.print(join);
        }
        printer.print(sequence);
        hasFirst = true;
    }
}