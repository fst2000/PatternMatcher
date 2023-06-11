public class JoinCharSequencePrinter implements CharSequencePrinter
{
    CharSequencePrinter printer;
    CharSequence joinSequence;
    boolean hadFirst;
    public JoinCharSequencePrinter(CharSequencePrinter printer, CharSequence joinSequence)
    {
        this.printer = printer;
        this.joinSequence = joinSequence;
    }
    @Override
    public void print(CharSequence sequence)
    {
        if(hadFirst)printer.print(joinSequence);
        printer.print(sequence);
        hadFirst = true;
    }
    
}
