public class Program
{
    public static void main(String[] args)
    {
        CharSequencePrinter printer = new JoinCharSequencePrinter(new StreamCharSequencePrinter(System.out), ", ");
        String text = "1231, acaicic";
        Stream stream = reader -> reader.read(text);
        Stream removeStream = new RemoveCharStream(stream, ' ');
        Stream splitStream = new SplitStream(removeStream, ',');
        Stream matchStream = new DeafultCaseStream(
            new MatchStream(splitStream, 
                new IntMatchStream(splitStream),
                new LetterMatchStream(splitStream)),
        "error");
        matchStream.read(printer::print);
        printer.print("\n");
    }
}
