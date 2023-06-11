public class Program
{
    public static void main(String[] args)
    {
        Printer printer = new JoinPrinter(new OutputStreamPrinter(System.out), new CharSequenceText(" "));
        String input = "1, 2, a, b, \"text\" [10,[5,6],11,\"hello, world\"], c";
        // expected output : int int name name string [ int [ int int ] int string ] name

        TextCondition number = new SymbolTextCondition(Character::isDigit);
        TextCondition letter = new SymbolTextCondition(Character::isLetter);
        TextCondition string = new EqualsTextCondition(new SymbolText('\"'));
        char[] separators = new char[] { ',', ' ', '[', ']' };
        char[] remove = new char[] { ',', ' ' };
        
        TextMap map =
            new SingleOrDefaultTextMap(
                new MultipleTextMap(
                    new ConditionTextMap(
                        new SymbolTextCondition(new PluralSymbolCondition(separators)),
                        text -> new SingleTextStream(text)),
                    new ConditionTextMap(number, text -> new SingleTextStream(new CharSequenceText("int"))),
                    new ConditionTextMap(letter, text -> new SingleTextStream(new CharSequenceText("name")))),
                new CharSequenceText("error"));

        new ScopeTextStream(
            new SplitTextStream(new CharSequenceText(input), '\"'),
            string,
            string,
            text -> new SingleTextStream(new CharSequenceText("string")),
            text ->
            {
                return new MapTextStream(
                    new FilterTextStream(
                        new MultipleSplitTextStream(text, separators),
                        new NotTextCondition(new SymbolTextCondition(new PluralSymbolCondition(remove)))),
                    map);
            }).read(printer::print);
    }
}