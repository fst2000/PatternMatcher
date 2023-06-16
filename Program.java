public class Program
{
    public static void main(String[] args)
    {
        CharSequencePrinter printer = new StreamCharSequencePrinter(System.out);
        CharSequencePrinter joinPrinter = new JoinCharSequencePrinter(printer, ", ");
        String text = "1231, acaicic, a, 12, ful";
        String test = "this is test yo niga";
        Stream stream = reader -> reader.read(text);
        Stream removeStream = new RemoveCharStream(stream, ' ');
        Stream splitStream = new SplitStream(removeStream, ',');
        Stream matchStream = new DeafultCaseStream(
            new MatchStream(splitStream, 
                new AllCharsConditionReader(s -> joinPrinter.print("int"), c -> Character.isDigit(c)),
                new AllCharsConditionReader(s -> joinPrinter.print("letter"), c -> Character.isLetter(c))
            ), "none");
        removeStream.read(printer::print);
        printer.print("\n");
        matchStream.read(joinPrinter::print);
        printer.print("\n");
    }
}
