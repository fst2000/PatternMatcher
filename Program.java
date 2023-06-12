public class Program
{
    public static void main(String[] args)
    {
        CharSequencePrinter printer = new StreamCharSequencePrinter(System.out);
        String text = "123";
        Stream stream = reader -> reader.read(text);
        Stream matchStream = new DeafultCaseStream(
            new MatchStream(stream, 
                new IntMatchStream(stream),
                new LetterMatchStream(stream)),
        "error");
        matchStream.read(printer::print);
        printer.print("\n");
    }
}
