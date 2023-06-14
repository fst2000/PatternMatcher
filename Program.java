public class Program
{
    public static void main(String[] args)
    {
        CharSequencePrinter printer = new JoinCharSequencePrinter(new StreamCharSequencePrinter(System.out), ", ");
        String text = "1231, acaicic, a, 1, f";
        Stream stream = reader -> reader.read(text);
        Stream removeStream = new RemoveCharStream(stream, ' ');
        Stream splitStream = new SplitStream(removeStream, ',');
        Stream matchStream = new DeafultCaseStream(
            new MatchStream(splitStream, 
                new AllCharsConditionReader(s -> printer.print("int"), c -> Character.isDigit(c)),
                new AllCharsConditionReader(s -> printer.print("letter"), c -> Character.isLetter(c))
            ), "none");
        matchStream.read(printer::print);
        printer.print("\n");
    }
}
