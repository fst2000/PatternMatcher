public class Program
{
    public static void main(String[] args)
    {
        CharSequencePrinter printer = new StreamCharSequencePrinter(System.out);
        CharSequencePrinter joinPrinter = new JoinCharSequencePrinter(printer, ", ");
        String text = "1231, acaicic, a, 1, f";
        String test = "this is test yo";
        Stream stream = reader -> reader.read(test);
        Stream removeStream = new RemoveCharStream(stream, ' ');
        Stream splitStream = new SplitStream(removeStream, ',');
        Stream matchStream = new DeafultCaseStream(
            new MatchStream(splitStream, 
                new AllCharsConditionReader(s -> joinPrinter.print("int"), c -> Character.isDigit(c)),
                new AllCharsConditionReader(s -> joinPrinter.print("letter"), c -> Character.isLetter(c))
            ), "none");
        removeStream.read(printer::print);
        joinPrinter.print("\n");
    }
}
