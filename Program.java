public class Program
{
    public static void main(String[] args)
    {
        CharSequencePrinter printer = new CharSequencePrinter(System.out);
        String input = "1,2,a,b,c";
        new SplitStream(input, ',').read(sequence ->
        {
            PatternMatcherStream[] patternMatchers = new PatternMatcherStream[]
            {
                new PatternMatcherStream(sequence, "\\d+", "int"),
                new PatternMatcherStream(sequence, "[a-zA-Z]+", "letter")
            };
            for (var p : patternMatchers)
            {
                p.read(printer::print);
            }
            printer.print(",");
        });
    }
}
